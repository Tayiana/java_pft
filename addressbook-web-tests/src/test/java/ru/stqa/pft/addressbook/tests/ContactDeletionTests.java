package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;


public class ContactDeletionTests extends TestBase {
  public boolean acceptNextAlert = true;

  @Test
  public void testContactDeletion() {
    app.getNavigationHelper().gotoGroupPage();
    app.getContactHelper().gotoHome();
    app.getContactHelper().selectContact();
    acceptNextAlert = true;
    app.getContactHelper().deleteContact();
    app.getContactHelper().alertdelete();
  }

}
