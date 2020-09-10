package ui.landing

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import services.PrivateAreaPageService
import ui.UiBaseTest

class PrivateAreaLoginTest : UiBaseTest() {
    private val mail = "ta-wAOSveXUID-4831015052@mail.ru"
    private val password = "11111111"

    @Test
    fun logInPrivateArea() {
        val privateAreaPage = PrivateAreaPageService(driver, applicationConfig)

        privateAreaPage.privateAreaLoginPage.openLoginPage()
        Assertions.assertTrue(privateAreaPage.privateAreaLoginPage.isOpened(), "Login Page wasn't opened")

        privateAreaPage.privateAreaLoginPage.logInPrivateArea(mail,password)
        Assertions.assertTrue(privateAreaPage.isPrivateAreaOpened(), "Private Area Page wasn't opened")
    }
}