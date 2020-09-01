package services

import config.ApplicationConfig
import org.openqa.selenium.WebDriver
import ui.pages.landing.LandingPage

class LandingPageService(driver: WebDriver, applicationConfig: ApplicationConfig) {
    private val landingPage = LandingPage(driver, applicationConfig)
    val calculator = CalculatorService(driver)

    fun openLandingPage() {
        landingPage.openLandingPage()
    }

    fun isOpened():Boolean {
        return landingPage.isOpened()
    }
}