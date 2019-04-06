package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupContacts;

public class ContactModificationTests extends TestBase{

  @Test
  public void testContactModification() {
    app.getNavigationHelper().gotoGroupPage();
    app.getContactHelper().gotoPageHome();
    app.getContactHelper().selectId();
    app.getContactHelper().editContact();
    app.getContactHelper().fillContactForm( new GroupContacts("Name", "Name middle", "Name Last", "Nick", "MyCompany", "My Street", "+79067777777", "email@mail.ru"));
    app.getContactHelper().updateContact();
  }
}
