package ui.landing

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import services.CalculatorService
import services.SliderValue
import ui.UiBaseTest
import ui.pages.landing.SliderType
import ui.pages.registration.RegistrationPage

class LandingPageCheckCalculatorTest : UiBaseTest() {
    private val minPeriodValue = "7"
    private val maxPeriodValue = "30"
    private val minAmountValue = "1,000"
    private val maxAmountValue = "4,000"
    private lateinit var landingPage: LandingPage

    @Test
    fun `LP - Verify Calculator And Apply for Loan`() {
        val calculatorService = CalculatorService(driver)

        openLandingPage()
        Assertions.assertTrue(landingPage.isOpened(), "LP wasn't opened")

        calculatorService.setCalculatorValue(maxPeriodValue, SliderValue.PERIOD_MAX)
        Assertions.assertEquals(
            maxPeriodValue,
            calculatorService.getCurrentValue(SliderType.PERIOD),
            "Max period is incorrect"
        )

        calculatorService.setCalculatorValue(minPeriodValue, SliderValue.PERIOD_MIN)
        Assertions.assertEquals(
            minPeriodValue,
            calculatorService.getCurrentValue(SliderType.PERIOD),
            "Min period is incorrect"
        )

        calculatorService.setCalculatorValue(maxAmountValue, SliderValue.AMOUNT_MAX)
        Assertions.assertEquals(
            maxAmountValue,
            calculatorService.getCurrentValue(SliderType.AMOUNT),
            "Max amount is incorrect"
        )

        calculatorService.setCalculatorValue(minAmountValue, SliderValue.AMOUNT_MIN)
        Assertions.assertEquals(
            minAmountValue,
            calculatorService.getCurrentValue(SliderType.AMOUNT),
            "Min amount is incorrect"
        )
        Assertions.assertTrue(calculatorService.isCalculatorElementsDisplayed(), "getCreditButton wasn't displayed")

        landingPage.calculator.clickGetCreditButton()
        val registrationPage = RegistrationPage(driver)

        Assertions.assertTrue(registrationPage.isRegistrationPageOpened(), "registration page wasn't opened")
    }

    @Test
    fun `LP - Calculator Check`() {
        val calculatorService = CalculatorService(driver)

        openLandingPage()
        Assertions.assertTrue(landingPage.isOpened(), "LP wasn't opened")

        calculatorService.moveCalculatorSlider(SliderValue.AMOUNT_MAX, SliderType.AMOUNT)
        Assertions.assertEquals(
            maxAmountValue,
            calculatorService.getCurrentValue(SliderType.AMOUNT),
            "Incorrect max amount"
        )

        calculatorService.moveCalculatorSlider(SliderValue.AMOUNT_MIN, SliderType.AMOUNT)
        Assertions.assertEquals(
            minAmountValue,
            calculatorService.getCurrentValue(SliderType.AMOUNT),
            "Incorrect min amount"
        )

        calculatorService.moveCalculatorSlider(SliderValue.PERIOD_MAX, SliderType.PERIOD)
        Assertions.assertEquals(
            maxPeriodValue,
            calculatorService.getCurrentValue(SliderType.PERIOD),
            "Incorrect max period"
        )

        calculatorService.moveCalculatorSlider(SliderValue.PERIOD_MIN, SliderType.PERIOD)
        Assertions.assertEquals(
            minPeriodValue,
            calculatorService.getCurrentValue(SliderType.PERIOD),
            "Incorrect min period"
        )
    }

    private fun openLandingPage() {
        landingPage = LandingPage(driver)
        landingPage.openLandingPage(applicationConfig)
    }
}

