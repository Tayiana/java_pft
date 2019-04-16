package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupContacts;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class ContactModificationTests extends TestBase{

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().GroupContact();
    if (! app.contact().isThereTheContact()) {
      app.contact().create( new GroupContacts("Name", "Name middle", "Name Last", "Nick", "MyCompany", "My Street", "+79067777777", "email@mail.ru")); }
  }

  @Test
  public void testContactModification() {
    List<GroupContacts> before = app.contact().list();
    int index = before.size() - 1;
    GroupContacts contact = new GroupContacts(before.get(index).getId(), "Name", "Name middle", "Name Last", "Nick", "MyCompany", "My Street", "+79067777777", "email@mail.ru");
    app.contact().modify(index, contact);
    List<GroupContacts> after = app.contact().list();
    Assert.assertEquals(after.size(), before.size() );


    before.remove(index);
    before.add(contact);
    Comparator<? super GroupContacts> byId = Comparator.comparingInt(GroupContacts::getId);
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(new HashSet<Object>(before),new HashSet<Object>(after));
    }

  }
