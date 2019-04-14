package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;

import ru.stqa.pft.addressbook.model.GroupContacts;

import java.util.List;

public class CreationNewContact extends TestBase {

  @Test
  public void testCreationNewContact() throws Exception {
    app.getNavigationHelper().gotoGroupContact();
    List<GroupContacts> before = app.getContactHelper().getContactList();
    app.getContactHelper().createContact(new GroupContacts("Name", null, "NameLast", null, null, null, null, null));
    List<GroupContacts> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size() + 1);
  }
}
