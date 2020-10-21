package services

import org.openqa.selenium.WebDriver
import ui.pages.registration.RegistrationPage

class RegistrationPageService(driver: WebDriver) {
  private val registration = RegistrationPage(driver)

  fun isRegistrationPageOpened() = registration.isRegistrationPageOpened()
}