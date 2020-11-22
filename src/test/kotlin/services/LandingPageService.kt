package services

import core.config.ApplicationConfig
import org.openqa.selenium.WebDriver
import ui.pages.BasePage
import ui.pages.landing.LandingPage

class LandingPageService(driver: WebDriver, applicationConfig: ApplicationConfig) : BasePage() {
  private val landingPage = LandingPage(driver, applicationConfig)
  val calculator = CalculatorService(driver)

  override fun openPage() {
    landingPage.openPage()
  }

  fun isOpened(): Boolean {
    return landingPage.isOpened()
  }
}