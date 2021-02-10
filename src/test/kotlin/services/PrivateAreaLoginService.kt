package services

import core.config.ApplicationConfig
import core.User
import ui.pages.privateArea.PrivateAreaLoginPage

class PrivateAreaLoginService(applicationConfig: ApplicationConfig) {
  private val privateAreaLoginPage = PrivateAreaLoginPage(applicationConfig)

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