package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;

import ru.stqa.pft.addressbook.model.GroupContacts;

public class CreationNewContact extends TestBase {


  @Test
  public void testCreationNewContact() throws Exception {
    app.getNavigationHelper().gotoGroupContact();
    int before = app.getContactHelper().getContactCount();
    app.getContactHelper().createContact(new GroupContacts("Name", "Name middle", "Name Last", "Nick", "MyCompany", "My Street", "+79067777777", "email@mail.ru"));
    int after = app.getContactHelper().getContactCount();
    Assert.assertEquals(after, before + 1);
  }
}
