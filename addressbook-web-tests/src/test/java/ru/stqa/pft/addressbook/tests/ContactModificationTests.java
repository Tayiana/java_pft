package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupContacts;

public class ContactModificationTests extends TestBase{

  @Test
  public void testContactModification() {
    app.getNavigationHelper().gotoGroupContact();
    if (! app.getContactHelper().isThereTheContact()) {
      app.getContactHelper().createContact( new GroupContacts("Name", "Name middle", "Name Last", "Nick", "MyCompany", "My Street", "+79067777777", "email@mail.ru")); }
    int before = app.getContactHelper().getContactCount();
    app.getContactHelper().selectContact();
    app.getContactHelper().editContact();
    app.getContactHelper().fillContactForm( new GroupContacts("Name", "Name middle", "Name Last", "Nick", "MyCompany", "My Street", "+79067777777", "email@mail.ru"));
    app.getContactHelper().saveContact();
    app.getContactHelper().gotoHome();
    int after = app.getContactHelper().getContactCount();
    Assert.assertEquals(after, before );
  }
}
