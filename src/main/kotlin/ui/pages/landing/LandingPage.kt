package ui.pages.landing

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement

class LandingPage(private val driver: WebDriver) {
    private val landingPageTitle: By = By.xpath("//*[text()='Préstamos en línea']")
    val calculator = CalculatorBlock(driver)

    fun isOpened(): Boolean {
        val landingPageTitleLocator: WebElement = driver.findElement(landingPageTitle)
        return landingPageTitleLocator.isDisplayed && calculator.isCalculatorBlockPresent()
    }
}