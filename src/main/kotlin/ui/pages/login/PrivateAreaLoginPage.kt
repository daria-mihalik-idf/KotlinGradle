package ui.pages.login

import com.codeborne.selenide.Selenide.`$`
import core.config.ApplicationConfig
import org.openqa.selenium.By
import ui.elements.ButtonElement
import ui.elements.InputElement
import ui.elements.Navigation
import ui.pages.BasePage

class PrivateAreaLoginPage(applicationConfig: ApplicationConfig) : BasePage() {
  private val loginPageUrl = "${applicationConfig.getBaseUrl()}${applicationConfig.loginPrivateAreaPageUrl}"
  private val privateAreaTitle = By.xpath("//h3[@class='ng-binding']")
  private val loginInput: By = By.cssSelector("[name='login']")
  private val passwordInput: By = By.cssSelector("[name='password']")
  private val submitButton: By = By.cssSelector("button[name='login-btn']")

  fun isLoginOpened(): Boolean {
    return `$`(privateAreaTitle).isDisplayed
  }

  fun fillInputLogin(userData: String) {
    InputElement.setInputElementValue(loginInput, userData)
  }

  fun fillInputPassword(userData: String) {
    InputElement.setInputElementValue(passwordInput, userData)
  }

  fun clickSubmitButton() {
    ButtonElement.clickButton(submitButton)
  }

  override fun openPage() {
    Navigation.openUrl(loginPageUrl)
  }
}