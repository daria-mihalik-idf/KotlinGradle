package ui.pages.registration

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import ui.elements.ButtonElement

class RegistrationPage(private val driver: WebDriver) {
  private val rootRegistrationPageElement: By = By.cssSelector("[data-step-name]")

  fun isRegistrationPageOpened(): Boolean {
    return ButtonElement.isElementPresent(driver, rootRegistrationPageElement)
  }
}