package landing

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.openqa.selenium.By
import org.openqa.selenium.Keys
import org.openqa.selenium.WebElement

class CalculatorInputData : CalculatorBaseTest() {
    private val minPeriodValue: String = "7"
    private val maxPeriodValue: String = "30"
    private val minAmountValue: String = "1,000"
    private val maxAmountValue: String = "4,000"

    private val amountInput: By = By.cssSelector("[data-test-id='calculator_amount']")
    private val periodInput: By = By.cssSelector("[data-test-id='calculator_days']")

    @Test
    fun `LP - CalculatorInputData`() {
        val amountLocator: WebElement = driver.findElement(amountInput)
        val periodLocator: WebElement = driver.findElement(periodInput)

        setValue(amountLocator, maxAmountValue)
        var changedValue = driver.findElement(amountInput).getAttribute("value").toString()
        Assertions.assertEquals(maxAmountValue, changedValue, "Max value is incorrect")

        setValue(amountLocator, minAmountValue)
        changedValue = driver.findElement(amountInput).getAttribute("value").toString()
        Assertions.assertEquals(minAmountValue, changedValue, "Min value is incorrect")

        setValue(periodLocator, maxPeriodValue)
        changedValue = driver.findElement(periodInput).getAttribute("value").toString()
        Assertions.assertEquals(maxPeriodValue, changedValue, "Max period is incorrect")

        setValue(periodLocator, minPeriodValue)
        changedValue = driver.findElement(periodInput).getAttribute("value").toString()
        Assertions.assertEquals(minPeriodValue, changedValue, "Min period is incorrect")
    }

    private fun setValue(locator: WebElement, value: String) {
        locator.click()
        locator.sendKeys("${Keys.CONTROL}", "a")
        locator.sendKeys("${Keys.DELETE}")
        locator.sendKeys(value)
    }
}