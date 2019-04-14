package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupContacts;

import java.util.List;

public class ContactModificationTests extends TestBase{

  @Test
  public void testContactModification() {
    app.getNavigationHelper().gotoGroupContact();
    if (! app.getContactHelper().isThereTheContact()) {
      app.getContactHelper().createContact( new GroupContacts("Name", "Name middle", "Name Last", "Nick", "MyCompany", "My Street", "+79067777777", "email@mail.ru")); }
    List<GroupContacts> before = app.getContactHelper().getContactList();
    app.getContactHelper().selectContact(before.size() - 1);
    app.getContactHelper().editContact();
    app.getContactHelper().fillContactForm( new GroupContacts("Name", "Name middle", "Name Last", "Nick", "MyCompany", "My Street", "+79067777777", "email@mail.ru"));
    app.getContactHelper().saveContact();
    app.getContactHelper().gotoHome();
    List<GroupContacts> after = app.getContactHelper().getContactList();

    Assert.assertEquals(after.size(), before.size() );
  }
}
