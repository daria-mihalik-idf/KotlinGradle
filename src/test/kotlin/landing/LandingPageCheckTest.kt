package landing

import core.SliderElement
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import org.openqa.selenium.By
import org.openqa.selenium.WebElement

class LandingPageCheckTest : BaseTest() {
    private val minMonthValue: String = "7"
    private val maxMonthValue: String = "30"
    private val minAmountValue: String = "1,500"
    private val maxAmountValue: String = "4,000"

    @Test
    fun `LP - Open Page`() {
        val sliderPeriod: WebElement =
            driver.findElement(By.xpath("//*[@data-test-id='period']//div[contains(@class, 'mainCalculator__slider')]/span"))
        val sliderLine: WebElement =
            driver.findElement(By.xpath("//*[@data-test-id='period']//div[contains(@class, 'mainCalculator__slider')]/div"))

        val amountInput = driver.findElement(By.cssSelector("[data-test-id='calculator_amount']"))
        val periodInput = driver.findElement(By.cssSelector("[data-test-id='calculator_days']"))
        val amountSliderMinValueText = driver.findElement(By.cssSelector("[data-test-id='calculator_min_amount']"))
        val amountSliderMaxValueText = driver.findElement(By.cssSelector("[data-test-id='calculator_max_amount']"))
        val periodSliderMinValueText = driver.findElement(By.cssSelector("[data-test-id='calculator_min_days']"))
        val periodSliderMaxValueText = driver.findElement(By.cssSelector("[data-test-id='calculator_max_days']"))
        val amountSlider = driver.findElement(By.cssSelector("[data-test-id='amount'] [class*='slider-handle']"))
        val periodSlider = driver.findElement(By.cssSelector("[data-test-id='period'] [class*='slider-handle']"))
        val getCreditButton = driver.findElement(By.cssSelector("[data-test-id='calculator_submit']"))

        SliderElement.moveAmountSliderToMaximum(sliderPeriod, 100, driver)
        SliderElement.moveAmountSliderToMaximum(sliderLine, 100, driver)
        Assertions.assertEquals(amountInput, maxMonthValue, "4000")

        SliderElement.moveAmountSliderToMinimum()
        SliderElement.moveAmountSliderToMinimum()

        SliderElement.movePeriodSliderToMaximum()
        SliderElement.movePeriodSliderToMaximum()

        assertAll(
            {
                Assertions.assertEquals(amountSliderMaxValueText, maxAmountValue, "Incorrect max amount")
            },
            {
                Assertions.assertEquals(amountSliderMinValueText, minAmountValue, "Incorrect min amount")
            },
            {
                Assertions.assertEquals(periodSliderMaxValueText, maxMonthValue, "Incorrect max period")
            },
            {
                Assertions.assertEquals(periodSliderMinValueText, minMonthValue, "Incorrect max period")
            }
        )
//        SliderElement.moveSliderByJavaScriptToSelectedPosition(By.cssSelector("[data-test-id='calculator_min_amount']"), 0)
//        Assertions.assertEquals(amountSliderMinValueText, "1,500")
//        SliderElement.moveSliderByJavaScriptToSelectedPosition(By.cssSelector("[data-test-id='calculator_max_amount']"), 100)
//        Assertions.assertEquals(periodSliderMaxValueText, "30")
    }
}

