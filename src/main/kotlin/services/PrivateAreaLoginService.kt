package services

import config.ApplicationConfig
import core.User
import org.openqa.selenium.WebDriver
import ui.pages.login.PrivateAreaLoginPage


class PrivateAreaLoginService(driver: WebDriver, applicationConfig: ApplicationConfig) {
    private val privateAreaLoginPage = PrivateAreaLoginPage(driver, applicationConfig)

    fun openLoginPage() {
        privateAreaLoginPage.openLoginPage()
    }

    fun isOpened(): Boolean {
        return privateAreaLoginPage.isLoginOpened()
    }

    fun logInPrivateArea(user: User) {
        privateAreaLoginPage.apply {
            fillInputLogin(user.mail)
            fillInputPassword(user.password)
            clickSubmitButton()
        }
    }
}