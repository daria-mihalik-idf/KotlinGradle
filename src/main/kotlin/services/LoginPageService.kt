package services

import config.ApplicationConfig
import org.openqa.selenium.WebDriver
import ui.pages.login.LoginPage


class LoginPageService(driver: WebDriver, applicationConfig: ApplicationConfig) {
    private val loginPage = LoginPage(driver, applicationConfig)
    val privateAreaPage = PrivateAreaPageService(driver)

    fun openLoginPage() {
        loginPage.openLoginPage()
    }

    fun isOpened(): Boolean {
        return loginPage.isLoginOpened()
    }

    fun logInPrivateArea() {
        loginPage.logInPrivateArea()
    }
}