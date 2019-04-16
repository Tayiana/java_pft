package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.pft.addressbook.model.GroupContacts;

import java.util.ArrayList;
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

  public void selectContact(int index) {
    wd.findElements(By.name("selected[]")).get(index).click();
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

  public void deleteContact() {
    click(By.xpath("//input[@value='Delete']"));
  }
    public void alertdelete() {
      wd.switchTo().alert().accept();
    }

  public void create(GroupContacts contacts) {
    gotoAddNew();
    fillContactForm(contacts);
    clickEnter();
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

  public List<GroupContacts> list() {
    List<GroupContacts> contacts = new ArrayList<GroupContacts>();
    List<WebElement> elements = wd.findElements(By.name("entry"));
    for (WebElement element : elements) {

      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      String name = element.getText();
      String lastname = element.getText();
      GroupContacts contact = new GroupContacts( id, name, null, lastname, null, null, null, null, null);
      contacts.add(contact);
    }

    return contacts;
  }
  public void modify(int index, GroupContacts contact) {
    selectContact(index);
    editContact();
    fillContactForm(contact);
    saveContact();
    gotoHome();
  }

}
