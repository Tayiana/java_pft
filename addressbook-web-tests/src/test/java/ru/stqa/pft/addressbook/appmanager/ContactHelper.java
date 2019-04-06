package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.stqa.pft.addressbook.model.GroupContacts;

public class ContactHelper extends HelperBase{

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

  public void gotoHome() {
    clic(By.linkText("home"));
  }

  public void gotoAddNew() {
    clic(By.linkText("add new"));}


  public void selectContact() {
    clic(By.linkText("selected[]"));
  }

  public void clicDelete() {
    clic(By.linkText("//input[@value='Delete']"));
  }

  public void clicOk() {
    clic(By.linkText("update"));
  }
}
