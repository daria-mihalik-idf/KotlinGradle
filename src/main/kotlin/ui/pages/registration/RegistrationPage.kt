package ui.pages.registration

import com.codeborne.selenide.Selenide
import com.codeborne.selenide.Selenide.`$`
import org.openqa.selenium.By
import ui.elements.ButtonElement

class RegistrationPage {
  private val rootRegistrationPageElement: By = By.cssSelector("[data-step-name]")

  fun isRegistrationPageOpened(): Boolean {
    return `$`(rootRegistrationPageElement).isDisplayed
  }
}