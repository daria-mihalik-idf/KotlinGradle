package services

import config.ApplicationConfig
import org.openqa.selenium.WebDriver
import ui.pages.login.LoginPrivateAreaPage


class LoginPrivateAreaPageService(driver: WebDriver, applicationConfig: ApplicationConfig) {
    private val loginPrivateAreaPage = LoginPrivateAreaPage(driver, applicationConfig)

    fun openLoginPage() {
        loginPrivateAreaPage.openLoginPage()
    }

    fun isOpened(): Boolean {
        return loginPrivateAreaPage.isLoginOpened()
    }

    fun logInPrivateArea() {
        loginPrivateAreaPage.fillLoginInput().fillPasswordInput().clickSubmitButton()
    }
}