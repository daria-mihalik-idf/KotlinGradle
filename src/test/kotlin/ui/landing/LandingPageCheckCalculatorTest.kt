package ui.landing

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import services.CalculatorService
import services.SliderValue
import ui.UiBaseTest
import ui.pages.landing.LandingPage
import ui.pages.registration.RegistrationPage

class LandingPageCheckCalculatorTest : UiBaseTest() {
    private val minPeriodValue = "7"
    private val maxPeriodValue = "30"
    private val minAmountValue = "1,000"
    private val maxAmountValue = "4,000"

    @Test
    fun `LP - Verify Calculator And Apply for Loan`() {
        val calculatorService = CalculatorService(driver, applicationConfig)
        val landingPage = LandingPage(driver)

        calculatorService.openLandingPage()
        Assertions.assertTrue(landingPage.isOpened(), "LP wasn't opened")

        calculatorService.setCalculatorValue(maxPeriodValue, SliderValue.PERIOD_MAX)
        Assertions.assertEquals(
            maxPeriodValue,
            calculatorService.getCurrentValue(SliderValue.PERIOD),
            "Landing Page calculator max period value is incorrect"
        )

        calculatorService.setCalculatorValue(minPeriodValue, SliderValue.PERIOD_MIN)
        Assertions.assertEquals(
            minPeriodValue,
            calculatorService.getCurrentValue(SliderValue.PERIOD),
            "Landing Page calculator min period value is incorrect"
        )

        calculatorService.setCalculatorValue(maxAmountValue, SliderValue.AMOUNT_MAX)
        Assertions.assertEquals(
            maxAmountValue,
            calculatorService.getCurrentValue(SliderValue.AMOUNT),
            "Landing Page calculator max amount value is incorrect"
        )

        calculatorService.setCalculatorValue(minAmountValue, SliderValue.AMOUNT_MIN)
        Assertions.assertEquals(
            minAmountValue,
            calculatorService.getCurrentValue(SliderValue.AMOUNT),
            "Landing Page calculator min amount value is incorrect"
        )
        Assertions.assertTrue(calculatorService.isCalculatorElementsDisplayed(), "getCreditButton wasn't displayed")

        landingPage.calculator.clickGetCreditButton()
        val registrationPage = RegistrationPage(driver)

        Assertions.assertTrue(registrationPage.isRegistrationPageOpened(), "registration page wasn't opened")
    }

    @Test
    fun `LP - Calculator Check`() {
        val calculatorService = CalculatorService(driver, applicationConfig)
        val landingPage = LandingPage(driver)

        calculatorService.openLandingPage()
        Assertions.assertTrue(landingPage.isOpened(), "LP wasn't opened")

        calculatorService.moveCalculatorSlider(SliderValue.AMOUNT_MAX, SliderValue.AMOUNT)
        Assertions.assertEquals(
            maxAmountValue,
            calculatorService.getCurrentValue(SliderValue.AMOUNT),
            "Landing Page calculator max amount value is incorrect"
        )

        calculatorService.moveCalculatorSlider(SliderValue.AMOUNT_MIN, SliderValue.AMOUNT)
        Assertions.assertEquals(
            minAmountValue,
            calculatorService.getCurrentValue(SliderValue.AMOUNT),
            "Landing Page calculator min amount value is incorrect"
        )

        calculatorService.moveCalculatorSlider(SliderValue.PERIOD_MAX, SliderValue.PERIOD)
        Assertions.assertEquals(
            maxPeriodValue,
            calculatorService.getCurrentValue(SliderValue.PERIOD),
            "Landing Page calculator max period value is incorrect"
        )

        calculatorService.moveCalculatorSlider(SliderValue.PERIOD_MIN, SliderValue.PERIOD)
        Assertions.assertEquals(
            minPeriodValue,
            calculatorService.getCurrentValue(SliderValue.PERIOD),
            "Landing Page calculator min amount value is incorrect"
        )
    }
}

