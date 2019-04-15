package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupContacts;

import java.util.List;


public class ContactDeletionTests extends TestBase {
  public boolean acceptNextAlert = true;

  @BeforeMethod
  public void ensurePreconditions() {
    app.getNavigationHelper().gotoGroupContact();
    if (! app.getContactHelper().isThereTheContact()) {
      app.getContactHelper().createContact( new GroupContacts("Name", "Name middle", "Name Last", "Nick", "MyCompany", "My Street", "+79067777777", "email@mail.ru")); }
  }

  @Test(enabled = false)
  public void testContactDeletion() {
    List<GroupContacts> before = app.getContactHelper().getContactList();
    app.getContactHelper().selectContact(before.size() - 1);
        acceptNextAlert = true;
    app.getContactHelper().deleteContact();
    app.getContactHelper().alertdelete();
    app.getContactHelper().gotoHome();
        List<GroupContacts> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size() - 1);

    before.remove(before.size() - 1);
    Assert.assertEquals(before, after);

  }

}
