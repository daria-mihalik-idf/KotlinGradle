package ui.pages.registration

import org.openqa.selenium.By
import ui.elements.ButtonElement

class RegistrationPage {
  private val rootRegistrationPageElement: By = By.cssSelector("[data-step-name]")

  fun isRegistrationPageOpened(): Boolean {
    return ButtonElement.isElementDisplayed(rootRegistrationPageElement)
  }
}