package ui.landing

import core.Browser
import org.junit.jupiter.api.Assertions
import services.*
import ui.UiBaseTest
import org.junit.jupiter.params.provider.EnumSource
import org.junit.jupiter.params.ParameterizedTest

class LandingPageCheckCalculatorTest2 : UiBaseTest() {

  @ParameterizedTest
  @EnumSource(Browser::class)
  fun `LP - Verify Calculator And Apply for Loan`(browser: Browser) {
    selectBrowser(browser)
    val landingPage = LandingPageService(driver, applicationConfig)

    landingPage.openLandingPage()
    Assertions.assertTrue(landingPage.isOpened(), "Landing Page wasn't opened")
  }
}

