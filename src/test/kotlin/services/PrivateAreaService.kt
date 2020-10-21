package services

import config.ApplicationConfig
import org.openqa.selenium.WebDriver
import ui.pages.login.PrivateAreaMainPage

class PrivateAreaService(driver: WebDriver, applicationConfig: ApplicationConfig) {
  private val privateAreaPage = PrivateAreaMainPage(driver)
  val privateAreaLoginPage = PrivateAreaLoginService(driver, applicationConfig)

  fun isPrivateAreaOpened(): Boolean {
    return privateAreaPage.isPrivateAreaOpened()
  }
}