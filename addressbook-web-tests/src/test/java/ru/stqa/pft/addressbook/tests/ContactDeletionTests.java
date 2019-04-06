package ru.stqa.pft.addressbook.tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class ContactDeletionTests extends TestBase {
  public boolean acceptNextAlert = true;

  @Test
  public void testContactDeletion() {
    app.getNavigationHelper().gotoGroupPage();
    app.getContactHelper().gotoHome();
    app.getContactHelper().selectnewId();
    acceptNextAlert = true;
    app.getContactHelper().deleteContact();
    assertTrue(closeAlertAndGetItsText().matches("^Delete 1 addresses[\\s\\S]$"));
  }

  public String closeAlertAndGetItsText() {
    try {
      Alert alert = WebDriver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
