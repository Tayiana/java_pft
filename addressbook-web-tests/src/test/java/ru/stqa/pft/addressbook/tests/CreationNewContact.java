package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.GroupContacts;
import java.util.Set;

public class CreationNewContact extends TestBase {

  @Test
  public void testCreationNewContact() throws Exception {
    app.goTo().GroupContact();
    Set<GroupContacts> before = app.contact().all();
    GroupContacts contact = new GroupContacts().withFirstname("Name").withMiddlename("Name middle").withLastname("NameLast").withNick("Nick").withCompany("MyCompany").withAddress("My Street").withPhone("+79067777777").withEmail("email@mail.ru)");
    app.contact().create(contact);
    Set<GroupContacts> after = app.contact().all();
    Assert.assertEquals(after.size(), before.size() + 1);

    contact.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt());
    before.add(contact);
    Assert.assertEquals(before,after);
  }
}
