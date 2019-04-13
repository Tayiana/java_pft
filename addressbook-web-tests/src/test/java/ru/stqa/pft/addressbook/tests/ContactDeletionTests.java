package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupContacts;


public class ContactDeletionTests extends TestBase {
  public boolean acceptNextAlert = true;

  @Test
  public void testContactDeletion() {
    app.getNavigationHelper().gotoGroupContact();
    if (! app.getContactHelper().isThereTheContact()) {
      app.getContactHelper().createContact( new GroupContacts("Name", "Name middle", "Name Last", "Nick", "MyCompany", "My Street", "+79067777777", "email@mail.ru")); }
    int before = app.getContactHelper().getContactCount();
    app.getContactHelper().selectContact();
    acceptNextAlert = true;
    app.getContactHelper().deleteContact();
    app.getContactHelper().alertdelete();
    app.getContactHelper().gotoHome();
    int after = app.getContactHelper().getContactCount();
    Assert.assertEquals(after, before - 1);
  }

}
