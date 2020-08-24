package landing

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import services.CalculatorService
import services.SliderValue


class LandingPageCheckCalculatorTest : CalculatorBaseTest() {
    private val minPeriodValue = "7"
    private val maxPeriodValue = "30"
    private val minAmountValue = "1,000"
    private val maxAmountValue = "4,000"

    @Test
    fun `LP - Verify Calculator And Apply for Loan`() {
        val lp = LandingPage(driver)
        val calculatorService = CalculatorService(driver)

        Assertions.assertTrue(lp.isOpened(), "LP wasn't opened")

        lp.setPeriodValue(maxPeriodValue)
        Assertions.assertEquals(
            maxPeriodValue,
            calculatorService.getCurrentValue(SliderType.PERIOD),
            "Max period is incorrect"
        )

        lp.setPeriodValue(minPeriodValue)
        Assertions.assertEquals(
            minPeriodValue,
            calculatorService.getCurrentValue(SliderType.PERIOD),
            "Min period is incorrect"
        )

        lp.setAmountValue(maxAmountValue)
        Assertions.assertEquals(
            maxAmountValue,
            calculatorService.getCurrentValue(SliderType.AMOUNT),
            "Max amount is incorrect"
        )

        lp.setAmountValue(minAmountValue)
        Assertions.assertEquals(
            minAmountValue,
            calculatorService.getCurrentValue(SliderType.AMOUNT),
            "Min amount is incorrect"
        )
        Assertions.assertTrue(lp.isGetCreditButtonPresent(), "getCreditButton wasn't displayed")

        val registrationPage = lp.clickGetCreditButton()

        Assertions.assertTrue(registrationPage.isRegistrationPageOpened(), "registration page wasn't opened")
    }

    @Test
    fun `LP - Calculator Check`() {
        val lp = LandingPage(driver)
        Assertions.assertTrue(lp.isOpened(), "LP wasn't opened")

        val calculatorService = CalculatorService(driver)

        calculatorService.moveSlider(SliderValue.AMOUNT_MAX, SliderType.AMOUNT)
        Assertions.assertEquals(
            maxAmountValue,
            calculatorService.getCurrentValue(SliderType.AMOUNT),
            "Incorrect max amount"
        )

        calculatorService.moveSlider(SliderValue.AMOUNT_MIN, SliderType.AMOUNT)
        Assertions.assertEquals(
            minAmountValue,
            calculatorService.getCurrentValue(SliderType.AMOUNT),
            "Incorrect min amount"
        )

        calculatorService.moveSlider(SliderValue.PERIOD_MAX, SliderType.PERIOD)
        Assertions.assertEquals(
            maxPeriodValue,
            calculatorService.getCurrentValue(SliderType.PERIOD),
            "Incorrect max period"
        )

        calculatorService.moveSlider(SliderValue.PERIOD_MIN, SliderType.PERIOD)
        Assertions.assertEquals(
            minPeriodValue,
            calculatorService.getCurrentValue(SliderType.PERIOD),
            "Incorrect min period"
        )
    }
}

