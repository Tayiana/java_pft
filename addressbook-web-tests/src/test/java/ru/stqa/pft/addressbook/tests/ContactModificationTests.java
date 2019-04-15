package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupContacts;

import java.util.HashSet;
import java.util.List;

public class ContactModificationTests extends TestBase{

  @Test(enabled = false)
  public void testContactModification() {
    app.getNavigationHelper().gotoGroupContact();
    if (! app.getContactHelper().isThereTheContact()) {
      app.getContactHelper().createContact( new GroupContacts("Name", "Name middle", "Name Last", "Nick", "MyCompany", "My Street", "+79067777777", "email@mail.ru")); }
    List<GroupContacts> before = app.getContactHelper().getContactList();
    app.getContactHelper().selectContact(before.size() - 1);
    app.getContactHelper().editContact();
    GroupContacts contact = new GroupContacts(before.get(before.size() - 1).getId(), "Name", "Name middle", "Name Last", "Nick", "MyCompany", "My Street", "+79067777777", "email@mail.ru");
    app.getContactHelper().fillContactForm(contact);
    app.getContactHelper().saveContact();
    app.getContactHelper().gotoHome();
    List<GroupContacts> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size() );

    before.remove(before.size() -1);
    before.add(contact);
    Assert.assertEquals(new HashSet<Object>(before),new HashSet<Object>(after));
    }
}
