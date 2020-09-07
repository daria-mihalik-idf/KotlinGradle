package services

import org.openqa.selenium.WebDriver
import ui.pages.login.PrivateAreaPage

class PrivateAreaPageService(driver: WebDriver) {
    private val privateAreaPage = PrivateAreaPage(driver)

    fun isPrivateAreaOpened(): Boolean {
        return privateAreaPage.isPrivateAreaOpened()
    }
}