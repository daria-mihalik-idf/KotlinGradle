package ui.privateArea

import core.User
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import services.PrivateAreaService
import ui.UiBaseTest

class PrivateAreaLoginTest : UiBaseTest() {
  private val mail = "trrg90000@mail.ru"
  private val password = "11111111"

  @Test
  fun logInPrivateArea() {

    val validCredentials = User(mail, password)
    val privateAreaPage = PrivateAreaService(driver, applicationConfig)

    privateAreaPage.privateAreaLoginPage.openPage()
    Assertions.assertTrue(privateAreaPage.privateAreaLoginPage.isOpened(), "Login Page wasn't opened")

    privateAreaPage.privateAreaLoginPage.logInPrivateArea(validCredentials)
    Assertions.assertTrue(privateAreaPage.isPrivateAreaOpened(), "Private Area Page wasn't opened")
  }
}