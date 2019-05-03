package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupContacts;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ContactHelper extends HelperBase {

  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void fillContactForm(GroupContacts groupContacts) {
    type(By.name("firstname"), groupContacts.getFirstname());
    type(By.name("middlename"), groupContacts.getMiddlename());
    type(By.name("lastname"), groupContacts.getLastname());
    type(By.name("nickname"), groupContacts.getNick());

    attach(By.name("photo"),groupContacts.getPhoto());
    type(By.name("company"), groupContacts.getCompany());
    type(By.name("address"), groupContacts.getAddress());
    type(By.name("home"), groupContacts.getHome());
    type(By.name("mobile"), groupContacts.getMobile());
    type(By.name("work"), groupContacts.getWork());
    type(By.name("email"), groupContacts.getEmail());
    type(By.name("email2"), groupContacts.getEmail2());
    type(By.name("email3"), groupContacts.getEmail3());

  }

  public void gotoAddNew() {
    click(By.linkText("add new"));
  }

  public void selectContactById(int id) {
    wd.findElement(By.cssSelector("input[value ='" + id + "']")).click();
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

  public void modify(GroupContacts contact) {
    editContact(contact.getId());
    fillContactForm(contact);
    saveContact();
    contactCache = null;
    gotoHome();
  }

  public void editContact(int id) {
    wd.findElement(By.cssSelector(String.format("a[href='edit.php?id=%s']", id))).click();
  }
  /*public void editContact() {
    click(By.xpath("//img[@alt='Edit']"));
  }*/

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
      contactCache.add(new GroupContacts().withId(id).withFirstname("Name").withMiddlename("Name middle").withLastname("NameLast").withNick("Ленин").withCompany("КПСС").withAddress("Москва, Красная, площадь, 3").withHomephone("+79067777777").withMobilphone("(7925)5656569").withWorkphone("56-89-985").withEmail("email@mail.ru").withEmail2("second@mail.ru").withEmail3("last@mail.ru"));
    }
    return new Contacts(contactCache);
  }

  public Set<GroupContacts> all2() {
    Set<GroupContacts> contacts = new HashSet<GroupContacts>();
    List<WebElement> rows = wd.findElements(By.name("entry"));
    for (WebElement row : rows) {
      List<WebElement> cells =row.findElements(By.tagName("td"));
      int id = Integer.parseInt(cells.get(0).findElement(By.tagName("input")).getAttribute("value"));
      String lastname = cells.get(1).getText();
      String firstname = cells.get(2).getText();
      String address = cells.get(3).getText();
      String allEmails = cells.get(4).getText();
      String allPhones = cells.get(5).getText();

      contacts.add(new GroupContacts().withId(id).withLastname("NameLast").withFirstname("Name").withAddress("Москва, Красная площадь, 3")
              .withAllEmails(allEmails).withAllPhones(allPhones));
    }
    return contacts;
  }

    public GroupContacts infoFromEditForm(GroupContacts contact) {
    initContactModificationById(contact.getId());
    String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
    String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
    String address = wd.findElement(By.name("address")).getAttribute("value");
    String home = wd.findElement(By.name("home")).getAttribute("value");
    String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
    String work = wd.findElement(By.name("work")).getAttribute("value");
    String email = wd.findElement(By.name("email")).getAttribute("value");
    String email2 = wd.findElement(By.name("email2")).getAttribute("value");
    String email3 = wd.findElement(By.name("email3")).getAttribute("value");
    wd.navigate().back();
    return new GroupContacts().withId(contact.getId()).withFirstname(firstname).withLastname(lastname).withAddress(address)
            .withHomephone(home).withMobilphone(mobile).withWorkphone(work).
                    withEmail(email).withEmail2(email2).withEmail3(email3);
  }

  private void initContactModificationById(int id) {
    WebElement checkbox = wd.findElement(By.cssSelector(String.format("input[value='%s']", id)));
    WebElement row = checkbox.findElement(By.xpath("./../.."));
    List<WebElement> cells = row.findElements(By.tagName("td"));
    cells.get(7).findElement(By.tagName("a")).click();
  }


}
