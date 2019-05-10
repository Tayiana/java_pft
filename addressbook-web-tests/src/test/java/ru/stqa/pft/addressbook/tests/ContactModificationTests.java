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
 if (app.db().contacts().size() == 0 ) {
    app.goTo().GroupContact();
    app.contact().create( new GroupContacts().withFirstname("Name").withMiddlename("Name middle").withLastname("NameLast").withNick("Ленин").withCompany("КПСС").withAddress("Москва, Красная площадь, 3").withHomephone("+79067777777").withMobilphone("(7925)5656569").withWorkphone("56-89-985").withEmail("email@mail.ru").withEmail2("second@mail.ru").withEmail3("last@mail.ru")); }
  }

  @Test
  public void testContactModification() {
    Contacts before = app.db().contacts();
    GroupContacts modifiedContact = before.iterator().next();
    GroupContacts contacts = new GroupContacts().withId(modifiedContact.getId()).withFirstname("Name").withMiddlename("Name middle").withLastname("NameLast").withNick("Ленин").withCompany("КПСС").withAddress("Москва, Красная площадь, 3").withHomephone("+79067777777").withMobilphone("(7925)5656569").withWorkphone("56-89-985").withEmail("email@mail.ru").withEmail2("second@mail.ru").withEmail3("last@mail.ru");
    app.contact().modify(contacts);
    /*assertThat(app.contact().getContactCount(), equalTo(before.size())); */
    Contacts after = app.db().contacts();
    /* assertThat(after, equalTo(before.without(modifiedContact).withAdded(contacts))); */
    }

  }
