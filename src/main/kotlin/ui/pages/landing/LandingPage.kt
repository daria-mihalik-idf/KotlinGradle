package ui.pages.landing

import core.config.ApplicationConfig
import org.openqa.selenium.By
import ui.elements.ButtonElement
import ui.elements.Navigation
import ui.pages.BasePage
import ui.waiter.Waiter

class LandingPage(applicationConfig: ApplicationConfig) : BasePage() {
  private val landingPageUrl = applicationConfig.getBaseUrl() + applicationConfig.landingEndpoint
  private val landingPageTitle: By = By.xpath("//*[@class='header_body_text']//h1")
  private val calculator: CalculatorBlock = CalculatorBlock()

  override fun openPage() {
    Navigation.openUrl(landingPageUrl)
    Waiter.jsWaitForPageToLoad()
    calculator.waitCalculatorBlockDisplayed()
  }

  fun isOpened(): Boolean {
    return ButtonElement.isElementDisplayed(landingPageTitle)
  }
}