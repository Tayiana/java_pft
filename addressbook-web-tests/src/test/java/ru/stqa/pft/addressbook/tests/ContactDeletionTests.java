package ru.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupContacts;


import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactDeletionTests extends TestBase {


  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().GroupContact();
    if (app.contact().all().size() ==0){
      app.contact().create( new GroupContacts().withFirstname("Name").withMiddlename("Name middle").withLastname("NameLast").withNick("Ленин").withCompany("КПСС").withAddress("Москва, Красная площадь, 3").withHomephone("+79067777777").withMobilphone("(7925)5656569").withWorkphone("56-89-985").withEmail("email@mail.ru").withEmail2("second@mail.ru").withEmail3("last@mail.ru")); }
  }


  @Test
  public void testContactDeletion() {
    Contacts before = app.contact().all();
    GroupContacts deleteContact = before.iterator().next();
    app.contact().deleteContact(deleteContact);
    app.contact().gotoHome();
    assertThat(app.contact().getContactCount(), equalTo(before.size() -1));
    Contacts after = app.contact().all();
    assertThat(after, CoreMatchers.equalTo(before.without(deleteContact)));
    }

}

