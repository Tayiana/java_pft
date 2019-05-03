package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupContacts;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;


public class ContactPhoneTests extends TestBase {

/*  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().GroupContact();
    if (! app.contact().isThereTheContact()) {
      app.contact().create( new GroupContacts().withFirstname("Name").withMiddlename("Name middle").withLastname("NameLast").withNick("Ленин").withCompany("КПСС").withAddress("Москва, Красная площадь, 3").withHomephone("+79067777777").withMobilphone("(7925)5656569").withWorkphone("56-89-985").withEmail("email@mail.ru").withEmail2("second@mail.ru").withEmail3("last@mail.ru")); }
  }*/


  @Test
  public void testComparisonOfInformationPhons() {
    app.goTo().GroupContact();
    GroupContacts contact = app.contact().all2().iterator().next();
    GroupContacts contactInfoFromEditForm = app.contact().infoFromEditForm(contact);

    assertThat(contact.getAddress(),equalTo(contactInfoFromEditForm.getAddress()));
    assertThat(contact.getAllPhones(),equalTo(mergePhones(contactInfoFromEditForm)));
    assertThat(contact.getAllEmails(),equalTo(mergeEmails(contactInfoFromEditForm)));

  }

  private String mergePhones(GroupContacts contact) {
    return Arrays.asList(contact.getHome(), contact.getMobile(), contact.getWork())
            .stream().filter((s) -> ! s.equals(""))
            .map(ContactPhoneTests::cleaned)
            .collect(Collectors.joining("\n"));
  }

  public static String cleaned(String phone) {
    return phone.replaceAll("\\s", "").replaceAll("[-()]","");
  }

  private String mergeEmails(GroupContacts contact) {
    return Arrays.asList(contact.getEmail(), contact.getEmail2(), contact.getEmail3()).
            stream().filter((s) -> ! s.equals(""))
            .collect(Collectors.joining("\n"));
  }
}
