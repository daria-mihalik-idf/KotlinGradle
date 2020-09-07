package ui.pages.login

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement

class PrivateAreaPage(val driver: WebDriver) {
    private val calculator = By.xpath("//*[@class='calculator']")
    private val privateAreaTitle = By.xpath("//*[contains(text(),'Mi préstamo')]")

    fun isPrivateAreaOpened(): Boolean {
        val privateAreaTitleLocator: WebElement = driver.findElement(privateAreaTitle)
        val calculatorLocator: WebElement = driver.findElement(calculator)
        return privateAreaTitleLocator.isDisplayed && calculatorLocator.isDisplayed
    }
}