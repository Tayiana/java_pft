package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupContacts;




public class ContactPhoneTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().GroupContact();
    if (! app.contact().isThereTheContact()) {
      app.contact().create( new GroupContacts().withFirstname("Name").withMiddlename("Name middle").withLastname("NameLast").withNick("Nick").withCompany("MyCompany").withAddress("My Street").withHomephone("+79067777777").withEmail("email@mail.ru)")); }
  }


  @Test
  public void testComparisonOfInformationPhons() {
    app.goTo().GroupContact();
    Contacts before = app.contact().all();
    GroupContacts contact = app.contact().all().iterator().next();
    GroupContacts InfoFromEditForm = app.contact().infoFromEditForm(contact);


  }
}
