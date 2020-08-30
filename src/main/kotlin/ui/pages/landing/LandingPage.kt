package ui.landing

import config.ApplicationConfig
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import ui.pages.landing.CalculatorBlock

class LandingPage(private val driver: WebDriver) {
    private val landingPageTitle: By = By.xpath("//*[text()='Préstamos en línea']")
    val calculator = CalculatorBlock(driver)

    fun openLandingPage(applicationConfig: ApplicationConfig) {
        driver.get(applicationConfig.getBaseUrl())
    }

    fun isOpened(): Boolean {
        val landingPageTitleLocator: WebElement = driver.findElement(landingPageTitle)
        return landingPageTitleLocator.isDisplayed && calculator.isCalculatorBlockPresent()
    }
}