package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;

import ru.stqa.pft.addressbook.model.GroupContacts;

import java.util.HashSet;
import java.util.List;

public class CreationNewContact extends TestBase {

  @Test(enabled = false)
  public void testCreationNewContact() throws Exception {
    app.goTo().GroupContact();
    List<GroupContacts> before = app.contact().list();
    GroupContacts contact = new GroupContacts("Name", null, "NameLast", null, null, null, null, null);
    app.contact().create(contact);
    List<GroupContacts> after = app.contact().list();
    Assert.assertEquals(after.size(), before.size() + 1);


    int max = 0;
    for (GroupContacts g : after) {
      if (g.getId() > max) {
        max = g.getId();
      }
    }
    contact.setId(max);
    before.add(contact);
    Assert.assertEquals(new HashSet<Object>(before),new HashSet<Object>(after));
  }
}
