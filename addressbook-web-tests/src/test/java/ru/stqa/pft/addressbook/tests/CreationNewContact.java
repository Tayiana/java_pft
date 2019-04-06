package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.*;

import ru.stqa.pft.addressbook.model.GroupContacts;

public class CreationNewContact extends TestBase {


  @Test
  public void testCreationNewContact() throws Exception {
    app.getContactHelper().gotoAddNew();
    app.getContactHelper().fillContactForm( new GroupContacts("Name", "Name middle", "Name Last", "Nick", "MyCompany", "My Street", "+79067777777", "email@mail.ru"));
    app.getContactHelper().gotoHome();

  }

}
