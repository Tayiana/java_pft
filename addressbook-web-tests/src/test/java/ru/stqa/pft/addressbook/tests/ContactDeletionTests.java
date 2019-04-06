package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

public class ContactDeletionTests extends TestBase {

  @Test
  public void testContactDeletion() {
    app.getNavigationHelper().gotoGroupPage();
    app.getContactHelper().gotoHome();
    app.getContactHelper().selectContact();
    app.getContactHelper().clicDelete();
    app.getContactHelper().clicOk();
  }
}
