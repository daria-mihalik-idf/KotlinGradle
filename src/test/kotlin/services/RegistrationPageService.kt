package services

import ui.pages.registration.RegistrationPage

class RegistrationPageService {
  private val registration = RegistrationPage()

  fun isRegistrationPageOpened() = registration.isRegistrationPageOpened()
}