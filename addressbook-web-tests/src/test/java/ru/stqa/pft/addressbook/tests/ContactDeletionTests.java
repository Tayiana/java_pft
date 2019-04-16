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
    app.goTo().GroupContact();
    if (! app.contact().isThereTheContact()) {
      app.contact().create( new GroupContacts("Name", "Name middle", "Name Last", "Nick", "MyCompany", "My Street", "+79067777777", "email@mail.ru")); }
  }

  @Test
  public void testContactDeletion() {
    List<GroupContacts> before = app.contact().list();
    int index = before.size() - 1;
    app.contact().selectContact(index);
        acceptNextAlert = true;

        app.contact().deleteContact();
    app.contact().alertdelete();
    app.contact().gotoHome();
        List<GroupContacts> after = app.contact().list();
    Assert.assertEquals(after.size(), index);

    before.remove(index);
    Assert.assertEquals(before, after);

  }

}
