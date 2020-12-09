package services

import core.config.ApplicationConfig
import ui.pages.landing.LandingPage

class LandingPageService(applicationConfig: ApplicationConfig) {
  private val landingPage = LandingPage(applicationConfig)
  val calculator = CalculatorService()

  fun openPage() {
    landingPage.openPage()
  }

  fun isOpened(): Boolean {
    return landingPage.isOpened()
  }
}