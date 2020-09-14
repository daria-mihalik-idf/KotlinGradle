package ui.pages.landing

import config.ApplicationConfig
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement

class LandingPage(private val driver: WebDriver, applicationConfig: ApplicationConfig) {
    private val landingPageTitle: By = By.xpath("//*[@class=\"header_body_text\"]//h1")
    private val calculator = CalculatorBlock(driver)
    private val landingPageUrl = applicationConfig.getBaseUrl() + applicationConfig.landingEndpoint

    fun openLandingPage() {
        driver.get(landingPageUrl)
    }

    fun isOpened(): Boolean {
        val landingPageTitleLocator: WebElement = driver.findElement(landingPageTitle)
        return landingPageTitleLocator.isDisplayed && calculator.isCalculatorBlockPresent()
    }
}