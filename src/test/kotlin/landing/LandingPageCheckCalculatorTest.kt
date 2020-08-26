package landing

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import services.CalculatorService
import services.SliderValue
import ui.pages.registration.RegistrationPage


class LandingPageCheckCalculatorTest : CalculatorBaseTest() {
    private val minPeriodValue = "7"
    private val maxPeriodValue = "30"
    private val minAmountValue = "1,000"
    private val maxAmountValue = "4,000"
    private lateinit var landingPage: LandingPage

    @Test
    fun `LP - Verify Calculator And Apply for Loan`() {
        openLandingPage()
        Assertions.assertTrue(landingPage.isOpened(), "LP wasn't opened")

        landingPage.calculator.setPeriodValue(maxPeriodValue)
        Assertions.assertEquals(
            maxPeriodValue,
            landingPage.calculator.getCurrentValue(SliderType.PERIOD),
            "Max period is incorrect"
        )

        landingPage.calculator.setPeriodValue(minPeriodValue)
        Assertions.assertEquals(
            minPeriodValue,
            landingPage.calculator.getCurrentValue(SliderType.PERIOD),
            "Min period is incorrect"
        )

        landingPage.calculator.setAmountValue(maxAmountValue)
        Assertions.assertEquals(
            maxAmountValue,
            landingPage.calculator.getCurrentValue(SliderType.AMOUNT),
            "Max amount is incorrect"
        )

        landingPage.calculator.setAmountValue(minAmountValue)
        Assertions.assertEquals(
            minAmountValue,
            landingPage.calculator.getCurrentValue(SliderType.AMOUNT),
            "Min amount is incorrect"
        )
        Assertions.assertTrue(landingPage.calculator.isGetCreditButtonPresent(), "getCreditButton wasn't displayed")

        landingPage.calculator.clickGetCreditButton()
        val registrationPage = RegistrationPage(driver)

        Assertions.assertTrue(registrationPage.isRegistrationPageOpened(), "registration page wasn't opened")
    }

    @Test
    fun `LP - Calculator Check`() {
        openLandingPage()
        Assertions.assertTrue(landingPage.isOpened(), "LP wasn't opened")

        landingPage.calculator.moveSlider(SliderValue.AMOUNT_MAX, SliderType.AMOUNT)
        Assertions.assertEquals(
            maxAmountValue,
            landingPage.calculator.getCurrentValue(SliderType.AMOUNT),
            "Incorrect max amount"
        )

        landingPage.calculator.moveSlider(SliderValue.AMOUNT_MIN, SliderType.AMOUNT)
        Assertions.assertEquals(
            minAmountValue,
            landingPage.calculator.getCurrentValue(SliderType.AMOUNT),
            "Incorrect min amount"
        )

        landingPage.calculator.moveSlider(SliderValue.PERIOD_MAX, SliderType.PERIOD)
        Assertions.assertEquals(
            maxPeriodValue,
            landingPage.calculator.getCurrentValue(SliderType.PERIOD),
            "Incorrect max period"
        )

        landingPage.calculator.moveSlider(SliderValue.PERIOD_MIN, SliderType.PERIOD)
        Assertions.assertEquals(
            minPeriodValue,
            landingPage.calculator.getCurrentValue(SliderType.PERIOD),
            "Incorrect min period"
        )
    }

    private fun openLandingPage() {
        landingPage = LandingPage(driver)
        landingPage.openLandingPage(applicationConfig)
    }
}

