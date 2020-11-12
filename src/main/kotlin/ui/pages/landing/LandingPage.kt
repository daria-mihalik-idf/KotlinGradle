package ui.pages.landing

import core.config.ApplicationConfig
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import ui.elements.ButtonElement

class LandingPage(private val driver: WebDriver, applicationConfig: ApplicationConfig) {
  private val landingPageUrl = applicationConfig.getBaseUrl() + applicationConfig.landingEndpoint
  private val landingPageTitle: By = By.xpath("//*[@class='header_body_text']//h1")
  private val calculator = CalculatorBlock(driver)

  fun openLandingPage() {
    driver.get(landingPageUrl)
  }

  fun isOpened(): Boolean {
    return ButtonElement.isElementPresent(driver, landingPageTitle) && calculator.isCalculatorBlockPresent()
  }
}