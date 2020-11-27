package services

import core.config.ApplicationConfig
import core.User
import org.openqa.selenium.WebDriver
import ui.pages.BasePage
import ui.pages.login.PrivateAreaLoginPage

class PrivateAreaLoginService(driver: WebDriver, applicationConfig: ApplicationConfig){
  private val privateAreaLoginPage = PrivateAreaLoginPage(driver, applicationConfig)

   fun openPage() {
    privateAreaLoginPage.openPage()
  }

  fun isOpened(): Boolean {
    return privateAreaLoginPage.isLoginOpened()
  }

  fun logInPrivateArea(user: User) {
    privateAreaLoginPage.apply {
      fillInputLogin(user.mail)
      fillInputPassword(user.password)
      clickSubmitButton()
    }
  }
}