package services

import config.ApplicationConfig
import org.openqa.selenium.WebDriver
import ui.pages.login.PrivateAreaPage

class PrivateAreaPageService(driver: WebDriver, applicationConfig: ApplicationConfig) {
    private val privateAreaPage = PrivateAreaPage(driver)
    val privateAreaLoginPage = PrivateAreaLoginPageService(driver, applicationConfig)

    fun isPrivateAreaOpened(): Boolean {
        return privateAreaPage.isPrivateAreaOpened()
    }
}