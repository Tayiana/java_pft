package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.stqa.pft.addressbook.model.GroupContacts;

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
    clic(By.linkText("add new"));
  }

  public void selectId() {
    clic(By.id("21"));
  }
  public void selectnewId() {
    clic(By.id("22"));
  }

  public void updateContact() {
    clic(By.xpath("(//img[@alt='Edit'])[3]"));
  }

  public void gotoPageHome() {
    clic(By.linkText("home"));
  }

  public void gotoHome() {
    clic(By.linkText("home"));
  }

  public void saveContact() {
    clic(By.xpath("(//input[@name='update'])[2]"));
  }

  public void deleteContact() {
    clic(By.xpath("//input[@value='Delete']"));
  }
}
