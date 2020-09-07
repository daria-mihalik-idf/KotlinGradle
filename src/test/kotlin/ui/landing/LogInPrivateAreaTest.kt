package ui.landing

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import services.LoginPageService
import ui.UiBaseTest

class LogInPrivateAreaTest : UiBaseTest() {

    @Test
    fun logInPrivateArea() {
        val loginPage = LoginPageService(driver, applicationConfig)

        loginPage.openLoginPage()
        Assertions.assertTrue(loginPage.isOpened(), "Login Page wasn't opened")

        loginPage.logInPrivateArea()
        Assertions.assertTrue(loginPage.privateAreaPage.isPrivateAreaOpened(), "Private Area Page wasn't opened")
    }
}