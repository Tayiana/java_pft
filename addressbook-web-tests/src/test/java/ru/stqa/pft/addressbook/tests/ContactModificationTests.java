package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupContacts;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ContactModificationTests extends TestBase{

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().GroupContact();
    if (! app.contact().isThereTheContact()) {
      app.contact().create( new GroupContacts().withFirstname("Name").withMiddlename("Name middle").withLastname("NameLast").withNick("Nick").withCompany("MyCompany").withAddress("My Street").withPhone("+79067777777").withEmail("email@mail.ru)")); }
  }

  @Test
  public void testContactModification() {
    Set<GroupContacts> before = app.contact().all();
    GroupContacts modifiedContact = before.iterator().next();
    GroupContacts contact = new GroupContacts().withId(modifiedContact.getId()).withFirstname("Name").withMiddlename("Name middle").withLastname("NameLast").withNick("Nick").withCompany("MyCompany").withAddress("My Street").withPhone("+79067777777").withEmail("email@mail.ru)");
    app.contact().modify(contact);
    Set<GroupContacts> after = app.contact().all();
    Assert.assertEquals(after.size(), before.size() );

    before.remove(modifiedContact);
    before.add(contact);
    Assert.assertEquals(before,after);
    }

  }
