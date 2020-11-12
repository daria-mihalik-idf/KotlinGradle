package ui.pages.login

import core.config.ApplicationConfig
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import ui.elements.ButtonElement
import ui.elements.InputElement
import java.io.FileInputStream
import java.util.*

class PrivateAreaLoginPage(private val driver: WebDriver, applicationConfig: ApplicationConfig) {
  private val loginPageUrl = "${applicationConfig.getBaseUrl()}${applicationConfig.loginPrivateAreaPageUrl}"
  private val privateAreaTitle = By.xpath("//h3[@class='ng-binding']")
  private val loginInput: By = By.cssSelector("[name='login']")
  private val passwordInput: By = By.cssSelector("[name='password']")
  private val submitButton: By = By.cssSelector("button[name='login-btn']")

  fun openLoginPage() {
    driver.get(loginPageUrl)
  }

  fun isLoginOpened(): Boolean {
    return ButtonElement.isElementPresent(driver, privateAreaTitle)
  }

  fun fillInputLogin(userData: String) {
    InputElement.inputElement(driver, loginInput, userData)
  }

  fun fillInputPassword(userData: String) {
    InputElement.inputElement(driver, passwordInput, userData)
  }

  fun clickSubmitButton() {
    ButtonElement.clickButton(driver, submitButton)
  }
}