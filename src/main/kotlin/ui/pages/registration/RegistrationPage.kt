package ui.pages.registration

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement

class RegistrationPage(driver: WebDriver){
    private var driver: WebDriver = driver
    private val rootRegistrationPageElement: By = By.cssSelector("[data-step-name]")

    fun isRegistrationPageOpened(): Boolean {
        val rootRegistrationPageElementLocator: WebElement = driver.findElement(rootRegistrationPageElement)
        return rootRegistrationPageElementLocator.isDisplayed
    }
}