package ui.pages.landing

import core.config.ApplicationConfig
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import ui.elements.ButtonElement
import ui.waiter.Waiter

class LandingPage(private val driver: WebDriver, applicationConfig: ApplicationConfig) {
  private val landingPageUrl = applicationConfig.getBaseUrl() + applicationConfig.landingEndpoint
  private val landingPageTitle: By = By.xpath("//*[@class='header_body_text']//h1")
  private val creditButton: By = By.cssSelector("[data-test-id='calculator_submit']")
  private val calculator = CalculatorBlock(driver)

  fun openLandingPage() {
    driver.get(landingPageUrl)
  }

  fun isOpened(): Boolean {
    Waiter(driver).waitUntilElementAppear(creditButton)
    return ButtonElement.isElementDisplayed(driver, landingPageTitle) && calculator.isCalculatorBlockPresent()
  }
}