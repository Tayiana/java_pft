package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupContacts;

import java.util.List;
import java.util.Set;


public class ContactDeletionTests extends TestBase {


  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().GroupContact();
    if (! app.contact().isThereTheContact()) {
      app.contact().create( new GroupContacts().withFirstname("Name").withMiddlename("Name middle").withLastname("NameLast").withNick("Nick").withCompany("MyCompany").withAddress("My Street").withPhone("+79067777777").withEmail("email@mail.ru)")); }
  }

  @Test
  public void testContactDeletion() {
    Set<GroupContacts> before = app.contact().all();
    GroupContacts deleteContact = before.iterator().next();
    app.contact().deleteContact(deleteContact);
    app.contact().gotoHome();
        Set<GroupContacts> after = app.contact().all();
    Assert.assertEquals(after.size(), before.size() - 1);

    before.remove(deleteContact);
    Assert.assertEquals(before, after);

  }

}
