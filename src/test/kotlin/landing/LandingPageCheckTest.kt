package landing

import core.SliderElement
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.openqa.selenium.By

class LandingPageCheckTest : BaseTest() {
    private val minMonthValue: String = "7"
    private val maxMonthValue: String = "30"
    private val minAmountValue: String = "1,500"
    private val maxAmountValue: String = "4,000"

    @Test
    fun `LP - Open Page`() {
        driver.get("https://moneyman:1005@qa-delivery-mx-master.moneyman.ru")
        val text = driver.findElement(By.tagName("h1"))
        val amountInput = driver.findElement(By.cssSelector("[data-test-id='calculator_amount']"))
        val periodInput = driver.findElement(By.cssSelector("[data-test-id='calculator_days']"))
        val amountSliderMinValueText = driver.findElement(By.cssSelector("[data-test-id='calculator_min_amount']"))
        val amountSliderMaxValueText = driver.findElement(By.cssSelector("[data-test-id='calculator_max_amount']"))
        val periodSliderMinValueText = driver.findElement(By.cssSelector("[data-test-id='calculator_min_days']"))
        val periodSliderMaxValueText = driver.findElement(By.cssSelector("[data-test-id='calculator_max_days']"))
        val amountSlider = driver.findElement(By.cssSelector("[data-test-id='amount'] [class*='slider-handle']"))
        val periodSlider = driver.findElement(By.cssSelector("[data-test-id='period'] [class*='slider-handle']"))
        val getCreditButton = driver.findElement(By.cssSelector("[data-test-id='calculator_submit']"))

        Assertions.assertEquals(text.text, "Préstamos en línea")
        Assertions.assertEquals(amountSliderMaxValueText, "4,000")
        Assertions.assertEquals(amountSliderMinValueText, "1,500")
        Assertions.assertEquals(periodSliderMaxValueText, "30")
        Assertions.assertEquals(periodSliderMinValueText, "7")

//        SliderElement.moveSliderByJavaScriptToSelectedPosition(By.cssSelector("[data-test-id='calculator_min_amount']"), 0)
//        Assertions.assertEquals(amountSliderMinValueText, "1,500")
//        SliderElement.moveSliderByJavaScriptToSelectedPosition(By.cssSelector("[data-test-id='calculator_max_amount']"), 100)
//        Assertions.assertEquals(periodSliderMaxValueText, "30")
    }
}