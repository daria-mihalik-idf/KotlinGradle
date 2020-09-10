package services

import config.ApplicationConfig
import org.openqa.selenium.WebDriver
import ui.pages.login.InputField
import ui.pages.login.PrivateAreaLoginPage


class PrivateAreaLoginPageService(driver: WebDriver, applicationConfig: ApplicationConfig) {
    private val privateAreaLoginPage = PrivateAreaLoginPage(driver, applicationConfig)

    fun openLoginPage() {
        privateAreaLoginPage.openLoginPage()
    }

    fun isOpened(): Boolean {
        return privateAreaLoginPage.isLoginOpened()
    }

    fun logInPrivateArea(mail: String, password: String) {
        privateAreaLoginPage.apply {
            fillInput(InputField.LOGIN_INPUT, mail)
            fillInput(InputField.PASSWORD_INPUT, password)
            clickSubmitButton()
        }
    }
}