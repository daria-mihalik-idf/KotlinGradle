package ui.pages.login

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement

class PrivateAreaPage(val driver: WebDriver) {
    private val privateAreaTitle = By.xpath("//*[contains(text(),'Mi préstamo')]")

    fun isPrivateAreaOpened(): Boolean {
        val privateAreaTitleLocator: WebElement = driver.findElement(privateAreaTitle)
        return privateAreaTitleLocator.isDisplayed
    }
}