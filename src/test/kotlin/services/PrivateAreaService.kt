package services

import core.config.ApplicationConfig
import ui.pages.login.PrivateAreaMainPage

class PrivateAreaService(applicationConfig: ApplicationConfig) {
  private val privateAreaPage = PrivateAreaMainPage()
  val privateAreaLogin = PrivateAreaLoginService(applicationConfig)

  fun isPrivateAreaOpened(): Boolean {
    return privateAreaPage.isPrivateAreaOpened()
  }
}