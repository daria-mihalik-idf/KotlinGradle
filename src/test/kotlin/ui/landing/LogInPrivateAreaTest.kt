package ui.landing

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import services.PrivateAreaPageService
import ui.UiBaseTest

class LogInPrivateAreaTest : UiBaseTest() {

    @Test
    fun logInPrivateArea() {
        val privateAreaPage = PrivateAreaPageService(driver, applicationConfig)

        privateAreaPage.loginPrivateAreaPage.openLoginPage()
        Assertions.assertTrue(privateAreaPage.loginPrivateAreaPage.isOpened(), "Login Page wasn't opened")

        privateAreaPage.loginPrivateAreaPage.logInPrivateArea()
        Assertions.assertTrue(privateAreaPage.isPrivateAreaOpened(), "Private Area Page wasn't opened")
    }
}