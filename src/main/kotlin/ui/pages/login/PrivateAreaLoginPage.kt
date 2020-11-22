package ui.pages.login

import core.config.ApplicationConfig
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import ui.elements.ButtonElement
import ui.elements.InputElement
import ui.elements.Navigation
import ui.pages.BasePage

class PrivateAreaLoginPage(private val driver: WebDriver, applicationConfig: ApplicationConfig) : BasePage() {
  private val loginPageUrl = "${applicationConfig.getBaseUrl()}${applicationConfig.loginPrivateAreaPageUrl}"
  private val privateAreaTitle = By.xpath("//h3[@class='ng-binding']")
  private val loginInput: By = By.cssSelector("[name='login']")
  private val passwordInput: By = By.cssSelector("[name='password']")
  private val submitButton: By = By.cssSelector("button[name='login-btn']")

  fun isLoginOpened(): Boolean {
    return ButtonElement.isElementDisplayed(driver, privateAreaTitle)
  }

  fun fillInputLogin(userData: String) {
    InputElement.setInputElement(driver, loginInput, userData)
  }

  fun fillInputPassword(userData: String) {
    InputElement.setInputElement(driver, passwordInput, userData)
  }

  fun clickSubmitButton() {
    ButtonElement.clickButton(driver, submitButton)
  }

  override fun openPage() {
    Navigation.openUrl(driver, loginPageUrl)
  }
}