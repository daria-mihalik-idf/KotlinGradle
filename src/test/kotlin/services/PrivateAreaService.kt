package services

import core.config.ApplicationConfig
import ui.pages.privateArea.PrivateAreaMainPage

class PrivateAreaService(applicationConfig: ApplicationConfig) {
  private val privateAreaPage = PrivateAreaMainPage()
  val privateAreaLoginService = PrivateAreaLoginService(applicationConfig)

  fun isPrivateAreaOpened(): Boolean {
    return privateAreaPage.isPrivateAreaOpened()
  }
}