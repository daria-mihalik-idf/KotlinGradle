package ui.pages.landing

import core.config.ApplicationConfig
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import ui.elements.ButtonElement
import ui.elements.Navigation
import ui.pages.BasePage
import ui.waiter.Waiter

class LandingPage(private val driver: WebDriver, applicationConfig: ApplicationConfig) : BasePage() {
  private val landingPageUrl = applicationConfig.getBaseUrl() + applicationConfig.landingEndpoint
  private val landingPageTitle: By = By.xpath("//*[@class='header_body_text']//h1")
  private val calculator: CalculatorBlock = CalculatorBlock(driver)

  override fun openPage() {
    Navigation.openUrl(landingPageUrl)
    Waiter.jsWaitForPageToLoad(driver)
    calculator.waitCalculatorBlockDisplayed()
  }

  fun isOpened(): Boolean {
    return ButtonElement.isElementDisplayed(landingPageTitle)
  }
}