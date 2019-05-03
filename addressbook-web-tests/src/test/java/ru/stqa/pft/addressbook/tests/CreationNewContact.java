package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupContacts;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class CreationNewContact extends TestBase {


  @DataProvider
  public Iterator<Object[]> validContacts() throws IOException {
    List<Object[]> list = new ArrayList<Object[]>();
    BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contacts.csv")));
    String line = reader.readLine();
    while (line != null) {
      String[] split = line.split(";");
      list.add(new Object[]{new GroupContacts().withFirstname(split[0]).withMiddlename(split[1]).withLastname(split[2]).withNick(split[3]).withCompany(split[4]).withAddress(split[5]).withHomephone(split[6]).withMobilphone(split[7]).withWorkphone(split[8]).withEmail(split[9]).withEmail2(split[10]).withEmail3(split[11])});
      line = reader.readLine();
    }
    return list.iterator();
  }

  @Test (dataProvider = "validContacts")
  public void testCreationNewContact(GroupContacts contact)  {
    app.goTo().GroupContact();
    Contacts before = app.contact().all();
    app.contact().create(contact);
    assertThat(app.contact().getContactCount(), equalTo(before.size()+1));
    Contacts after = app.contact().all();
    assertThat(after, equalTo
            (before.withAdded(contact.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
  }

  /*  @Test (dataProvider = "validGroups")
    public void testGroupCreation(GroupData group) {
    app.goTo().GroupPage();
    Groups before = app.group().all();
    app.group().create(group);
    assertThat(app.group().count(), equalTo(before.size()+1));
    Groups after = app.group().all();
    assertThat(after, equalTo(
            before.withAdded(group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
  }*/


  /*@Test
  public void testCreationNewContact(GroupContacts contact)  {
    app.goTo().GroupContact();
    Contacts before = app.contact().all();
    File photo = new File("src/test/resources/picture.jpg");
    GroupContacts contact = new GroupContacts().withFirstname("Name").withMiddlename("Name middle").withLastname("NameLast").withNick("Ленин").withPhoto(photo).withCompany("КПСС").withAddress("Москва, Красная площадь, 3").withHomephone("+79067777777").withMobilphone("(7925)5656569").withWorkphone("56-89-985").withEmail("email@mail.ru").withEmail2("second@mail.ru").withEmail3("last@mail.ru");
    app.contact().create(contact);
    assertThat(app.contact().getContactCount(), equalTo(before.size()+1));
    Contacts after = app.contact().all();
    assertThat(after, equalTo
            (before.withAdded(contact.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
  } */

  @Test (enabled = false)
  public void CurrentDir(){
    File currentDir = new File(".");
    System.out.println(currentDir.getAbsolutePath());
    File photo = new File("src/test/resources/picture.jpg");
    System.out.println(photo.getAbsolutePath());
    System.out.println(photo.exists());
  }
}
