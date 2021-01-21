package ui.pages.crm

import com.codeborne.selenide.Selenide.`$`
import core.config.ApplicationConfig
import org.openqa.selenium.By
import ui.elements.ButtonElement
import ui.elements.InputElement
import ui.elements.Navigation
import ui.pages.BasePage

class CrmLoginPage(applicationConfig: ApplicationConfig) : BasePage() {
  private val crmLoginPageUrl = "${applicationConfig.getBaseUrlWithAuthorization()}${applicationConfig.crmLoginPageUrl}"
  private val loginInput: By = By.id("username")
  private val passwordInput: By = By.id("password")
  private val captchaInput: By = By.id("captcha")
  private val logInButton: By = By.cssSelector("button[class='btn ng-binding']")
  private val crmLoginForm = By.id("main")

  override fun openPage() {
    Navigation.openUrl(crmLoginPageUrl)
  }

  fun isCrmLoginPageOpened(): Boolean {
    return `$`(crmLoginForm).isDisplayed
  }

  fun fillInputLogin(crmUserData: String) {
    InputElement.setInputElementValue(loginInput, crmUserData)
  }

  fun fillInputPassword(crmUserData: String) {
    InputElement.setInputElementValue(passwordInput, crmUserData)
  }

  fun fillCaptchaDefaultValue(crmUserData: String) {
    InputElement.setInputElementValue(captchaInput, crmUserData)
  }

  fun clickOnSubmitButton() {
    ButtonElement.clickButton(logInButton)
  }
}