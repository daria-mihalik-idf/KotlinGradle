package ui.pages.login

import core.config.ApplicationConfig
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
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
    val privateAreaTitleLocator: WebElement = driver.findElement(privateAreaTitle)
    return privateAreaTitleLocator.isDisplayed
  }

  fun fillInputLogin(userData: String) {
    driver.findElement(loginInput).sendKeys(userData)
  }

  fun fillInputPassword(userData: String) {
    driver.findElement(passwordInput).sendKeys(userData)
  }

  fun clickSubmitButton() {
    val submitButtonLocator: WebElement = driver.findElement(submitButton)
    submitButtonLocator.click()
  }
}


