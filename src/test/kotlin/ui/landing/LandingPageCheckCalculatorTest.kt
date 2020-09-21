package ui.landing

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import services.*
import ui.UiBaseTest
import ui.pages.landing.SliderType
import ui.pages.landing.SliderValue

class LandingPageCheckCalculatorTest : UiBaseTest() {
  private val minPeriodValue = "7"
  private val maxPeriodValue = "30"
  private val minAmountValue = "1,000"
  private val maxAmountValue = "4,000"

  @Test
  fun `LP - Verify Calculator And Apply for Loan`() {
    val landingPage = LandingPageService(driver, applicationConfig)

    landingPage.openLandingPage()
    Assertions.assertTrue(landingPage.isOpened(), "Landing Page wasn't opened")

    landingPage.calculator.setCalculatorValue(maxPeriodValue, SliderValue.PERIOD_MAX)
    Assertions.assertEquals(
        maxPeriodValue,
        landingPage.calculator.getCurrentValue(SliderType.PERIOD),
        "Landing Page calculator max period value is incorrect"
    )

    landingPage.calculator.setCalculatorValue(minPeriodValue, SliderValue.PERIOD_MIN)
    Assertions.assertEquals(
        minPeriodValue,
        landingPage.calculator.getCurrentValue(SliderType.PERIOD),
        "Landing Page calculator min period value is incorrect"
    )

    landingPage.calculator.setCalculatorValue(maxAmountValue, SliderValue.AMOUNT_MAX)
    Assertions.assertEquals(
        maxAmountValue,
        landingPage.calculator.getCurrentValue(SliderType.AMOUNT),
        "Landing Page calculator max amount value is incorrect"
    )

    landingPage.calculator.setCalculatorValue(minAmountValue, SliderValue.AMOUNT_MIN)
    Assertions.assertEquals(
        minAmountValue,
        landingPage.calculator.getCurrentValue(SliderType.AMOUNT),
        "Landing Page calculator min amount value is incorrect"
    )
    Assertions.assertTrue(landingPage.calculator.isCalculatorElementsDisplayed(),
        "getCreditButton wasn't displayed on calculator")

    landingPage.calculator.clickGetCreditButton()
    val registrationPage = RegistrationPageService(driver)

    Assertions.assertTrue(registrationPage.isRegistrationPageOpened(), "Registration page wasn't opened")
  }

  @Test
  fun `LP - Calculator Check`() {
    val landingPage = LandingPageService(driver, applicationConfig)

    landingPage.openLandingPage()
    Assertions.assertTrue(landingPage.isOpened(), "Landing Page wasn't opened")

    landingPage.calculator.moveCalculatorSlider(SliderValue.AMOUNT_MAX, SliderType.AMOUNT)
    Assertions.assertEquals(
        maxAmountValue,
        landingPage.calculator.getCurrentValue(SliderType.AMOUNT),
        "Landing Page calculator max amount value is incorrect"
    )

    landingPage.calculator.moveCalculatorSlider(SliderValue.AMOUNT_MIN, SliderType.AMOUNT)
    Assertions.assertEquals(
        minAmountValue,
        landingPage.calculator.getCurrentValue(SliderType.AMOUNT),
        "Landing Page calculator min amount value is incorrect"
    )

    landingPage.calculator.moveCalculatorSlider(SliderValue.PERIOD_MAX, SliderType.PERIOD)
    Assertions.assertEquals(
        maxPeriodValue,
        landingPage.calculator.getCurrentValue(SliderType.PERIOD),
        "Landing Page calculator max period value is incorrect"
    )

    landingPage.calculator.moveCalculatorSlider(SliderValue.PERIOD_MIN, SliderType.PERIOD)
    Assertions.assertEquals(
        minPeriodValue,
        landingPage.calculator.getCurrentValue(SliderType.PERIOD),
        "Landing Page calculator min amount value is incorrect"
    )
  }
}

