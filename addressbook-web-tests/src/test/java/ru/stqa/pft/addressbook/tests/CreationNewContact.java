package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;

import ru.stqa.pft.addressbook.model.GroupContacts;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class CreationNewContact extends TestBase {

  @Test
  public void testCreationNewContact() throws Exception {
    app.goTo().GroupContact();
    List<GroupContacts> before = app.contact().list();
    GroupContacts contact = new GroupContacts("Name", "Name middle", "NameLast", "Nick", "MyCompany", "My Street", "+79067777777", "email@mail.ru");
    app.contact().create(contact);
    List<GroupContacts> after = app.contact().list();
    Assert.assertEquals(after.size(), before.size() + 1);

    contact.setId(after.stream().max(Comparator.comparingInt(GroupContacts::getId)).get().getId());
    before.add(contact);

    Assert.assertEquals(new HashSet<Object>(before),new HashSet<Object>(after));
  }
}
