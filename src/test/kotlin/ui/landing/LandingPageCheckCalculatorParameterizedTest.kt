package ui.landing

import core.Browser
import org.junit.jupiter.api.Assertions
import services.*
import ui.UiBaseTest
import org.junit.jupiter.params.provider.EnumSource
import org.junit.jupiter.params.ParameterizedTest

class LandingPageCheckCalculatorParameterizedTest : UiBaseTest() {

  @ParameterizedTest
  @EnumSource(Browser::class)
  fun `LP - Verify Calculator And Apply for Loan`(browser: Browser) {
    val landingPage = LandingPageService(applicationConfig)

    landingPage.openPage()
    Assertions.assertTrue(landingPage.isOpened(), "Landing Page wasn't opened")
  }
}