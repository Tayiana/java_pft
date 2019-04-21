package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupContacts;

import java.util.List;


public class ContactHelper extends HelperBase {

  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void fillContactForm(GroupContacts groupContacts) {
    typecontact(By.name("firstname"), groupContacts.getFirstname());
    typecontact(By.name("middlename"), groupContacts.getMiddlename());
    typecontact(By.name("lastname"), groupContacts.getLastname());
    typecontact(By.name("nickname"), groupContacts.getNick());
    typecontact(By.name("company"), groupContacts.getCompany());
    typecontact(By.name("address"), groupContacts.getAddress());
    typecontact(By.name("home"), groupContacts.getPhone());
    typecontact(By.name("email"), groupContacts.getEmail());

   }

  public void gotoAddNew() {
    click(By.linkText("add new"));
  }


  public void selectContactById(int id) {
    wd.findElement(By.cssSelector("input[value ='" + id + "']")).click();
   }


  public void editContact() {
   click(By.xpath("//img[@alt='Edit']"));
  }

    public void gotoHome() {
    click(By.linkText("home"));
  }

  public void saveContact() {
    click(By.xpath("(//input[@name='update'])[2]"));
  }


    public boolean acceptNextAlert = true;

  public void deleteContact(GroupContacts contact) {
    selectContactById(contact.getId());
    click(By.xpath("//input[@value='Delete']"));
    acceptNextAlert = true;
    contactCache = null;
    wd.switchTo().alert().accept();
  }


  public void create(GroupContacts contacts) {
    gotoAddNew();
    fillContactForm(contacts);
    clickEnter();
    contactCache = null;
    gotoHome();
  }

  public boolean isThereTheContact() {
   return isElementPresent(By.name("selected[]"));
  }

  public void clickEnter() {
    click(By.xpath("(//input[@name='submit'])[2]"));
  }

  public int getContactCount() {
    return wd.findElements(By.name("selected[]")).size();
  }

  private Contacts contactCache = null;

  public Contacts all() {
    if (contactCache != null) {
      return new Contacts(contactCache);
    }
    contactCache = new Contacts();
    List<WebElement> elements = wd.findElements(By.name("entry"));
    for (WebElement element : elements) {
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      String name = element.findElement(By.xpath("./td[3]")).getText();
      String lastname = element.findElement(By.xpath("./td[2]")).getText();
      contactCache.add(new GroupContacts().withId(id).withFirstname("Name").withMiddlename("Name middle").withLastname("NameLast").withNick("Nick").withCompany("MyCompany").withAddress("My Street").withPhone("+79067777777").withEmail("email@mail.ru)"));
    }
    return new Contacts(contactCache);
  }

  public void modify(GroupContacts contact) {
    selectContactById(contact.getId());
    editContact();
    fillContactForm(contact);
    saveContact();
    contactCache = null;
    gotoHome();
  }


}
