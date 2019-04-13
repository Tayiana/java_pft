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

  public void selectContact(int index) {
    wd.findElements(By.name("selected[]")).get(index).click();
    }

  public void editContact() {

    clic(By.xpath("//img[@alt='Edit']"));
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
    public void alertdelete() {
      wd.switchTo().alert().accept();
    }

  public void createContact(GroupContacts contacts) {
    gotoAddNew();
    fillContactForm(contacts);
    clickEnter();
    gotoHome();
  }

  public boolean isThereTheContact() {
   return isElementPresent(By.name("selected[]"));
  }

  public void clickEnter() {
    clic(By.xpath("(//input[@name='submit'])[2]"));
  }

  public int getContactCount() {
    return wd.findElements(By.name("selected[]")).size();
  }
}
