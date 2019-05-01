package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupContacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactModificationTests extends TestBase{

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().GroupContact();
    if (! app.contact().isThereTheContact()) {
      app.contact().create( new GroupContacts().withFirstname("Name").withMiddlename("Name middle").withLastname("NameLast").withNick("Nick").withCompany("MyCompany").withAddress("My Street").withHomephone("+79067777777").withEmail("email@mail.ru)")); }
  }

  @Test
  public void testContactModification() {
    Contacts before = app.contact().all();
    GroupContacts modifiedContact = before.iterator().next();
    GroupContacts contact = new GroupContacts().withId(modifiedContact.getId()).withFirstname("Name").withMiddlename("Name middle").withLastname("NameLast").withNick("Nick").withCompany("MyCompany").withAddress("My Street").withHomephone("+79067777777").withEmail("email@mail.ru)");
    app.contact().modify(contact);
    assertThat(app.contact().getContactCount(), equalTo(before.size()));
    Contacts after = app.contact().all();
    assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact)));
    }

  }
