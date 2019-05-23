package ru.stqa.pft.addressbook.tests;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;

import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupContacts;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;


public class AddContactToGroupTest extends TestBase {


  @BeforeMethod
  public void ensurePreconditions() {
    if (app.db().contacts().size() == 0) {
      app.goTo().GroupContact();
      app.contact().create(new GroupContacts().withFirstname("Name").withMiddlename("Name middle").withLastname("NameLast").withNick("Ленин").withCompany("КПСС").withAddress("Москва, Красная площадь, 3").withHomephone("+79067777777").withMobilphone("(7925)5656569").withWorkphone("56-89-985").withEmail("email@mail.ru").withEmail2("second@mail.ru").withEmail3("last@mail.ru"));
    }

    if (app.db().groups().size() ==0) {
      app.goTo().GroupPage();
      app.group().create(new GroupData().withName("test1").withFooter("some text").withHeader("any text")); }
  }

  @Test
  public void testAddContactToGroup() {
    //нужно получить весь список контактов на странице
    Contacts contacts = app.db().contacts();
    //нужно получить весь список групп в выпадающем списке
    Groups groups = app.db().groups();
    app.goTo().GroupContact();
    GroupContacts newContacts = new GroupContacts().inGroup(groups.iterator().next());
    app.contact().addToGroup(newContacts);

    }



    //проверяем в БД, добавлен ли уже первый контакт в первую в списке группу


    // если контакт не добавлен еще в группу, то добавляем его, и переходим к проверке добавился ли он
   // app.contact().clickAddTo();

    //если контакт добавлен, добавляем его в следующую

    //если контакт добавлен во все группы, то выбираем другой контакт

    //если другого контакта нет, то создаем его и переходим в начало и добавляем в группу

    //проверяем, что контакт добавился в группу через БД



    /*
    app.contact().addToGroup(contact, group);
    app.contact().selectContactById(contact.getId());
     app.contact().clickAddTo();

      app.contact().chooseContact(); */

    /* app.contact().goToGroupPage(contact.getId()); */

  }
