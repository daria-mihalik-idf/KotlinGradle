package landing

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.openqa.selenium.*
import org.openqa.selenium.interactions.Actions


class LandingPageCheckCalculatorTest : CalculatorBaseTest() {
    private val minPeriodValue = "7"
    private val maxPeriodValue = "30"
    private val minAmountValue = "1,000"
    private val maxAmountValue = "4,000"

    private val calculator: By = By.className("hero__calculator")
    private val getCreditButton: By = By.cssSelector("[data-test-id='calculator_submit']")
    private val amountSlider: By = By.cssSelector("[data-test-id='amount'] [class*='slider-handle']")
    private val amountInput: By = By.cssSelector("[data-test-id='calculator_amount']")
    private val periodSlider: By =
        By.xpath("//*[@data-test-id='period']//div[contains(@class, 'mainCalculator__slider')]/span")
    private val periodInput: By = By.cssSelector("[data-test-id='calculator_days']")
    private val rootRegistrationPageElement: By = By.cssSelector("[data-step-name]")
    private val lpTitle: By = By.xpath("//*[text()='Préstamos en línea']")

    @Test
    fun `LP - Verify Calculator And Apply for Loan`() {
        val lpTitleLocator: WebElement = driver.findElement(lpTitle)
        Assertions.assertTrue(lpTitleLocator.isDisplayed, "LP wasn't opened")

        val calculatorLocator: WebElement = driver.findElement(calculator)
        Assertions.assertTrue(calculatorLocator.isDisplayed, "Calculator wasn't displayed")

        val periodLocator: WebElement = driver.findElement(periodInput)

        setInputValue(periodLocator, maxPeriodValue)
        var changedValue = driver.findElement(periodInput).getAttribute("value")
        Assertions.assertEquals(maxPeriodValue, changedValue, "Max period is incorrect")

        setInputValue(periodLocator, minPeriodValue)
        changedValue = driver.findElement(periodInput).getAttribute("value")
        Assertions.assertEquals(minPeriodValue, changedValue, "Min period is incorrect")

        val amountLocator: WebElement = driver.findElement(amountInput)

        setInputValue(amountLocator, maxAmountValue)
        changedValue = driver.findElement(amountInput).getAttribute("value")
        Assertions.assertEquals(maxAmountValue, changedValue, "Max value is incorrect")

        setInputValue(amountLocator, minAmountValue)
        changedValue = driver.findElement(amountInput).getAttribute("value")
        Assertions.assertEquals(minAmountValue, changedValue, "Min value is incorrect")

        val calculatorGetCreditButtonLocator: WebElement = driver.findElement(getCreditButton)
        Assertions.assertTrue(calculatorGetCreditButtonLocator.isDisplayed, "getCreditButton wasn't displayed")

        calculatorGetCreditButtonLocator.click()

        val rootRegistrationPageElementLocator: WebElement = driver.findElement(rootRegistrationPageElement)
        Assertions.assertTrue(rootRegistrationPageElementLocator.isDisplayed, "registration page wasn't opened")
    }

    @Test
    fun `LP - Calculator Check`() {
        val lpTitleLocator: WebElement = driver.findElement(lpTitle)
        Assertions.assertTrue(lpTitleLocator.isDisplayed, "LP wasn't opened")

        val calculatorLocator: WebElement = driver.findElement(calculator)
        Assertions.assertTrue(calculatorLocator.isDisplayed, "Calculator wasn't displayed")

        val actions = Actions(driver)
        val amountSliderLocator: WebElement = driver.findElement(amountSlider)

        actions.dragAndDropBy(amountSliderLocator, 400, 0).release().build().perform()
        var changedValue = driver.findElement(amountInput).getAttribute("value")
        Assertions.assertEquals(changedValue, maxAmountValue, "Incorrect max amount")

        actions.dragAndDropBy(amountSliderLocator, -500, 0).release().build().perform()
        changedValue = driver.findElement(amountInput).getAttribute("value")
        Assertions.assertEquals(changedValue, minAmountValue, "Incorrect min amount")

        val periodSliderLocator: WebElement = driver.findElement(periodSlider)
        actions.dragAndDropBy(periodSliderLocator, 300, 0).release().build().perform()
        changedValue = driver.findElement(periodInput).getAttribute("value")
        Assertions.assertEquals(changedValue, maxPeriodValue, "Incorrect max period")

        actions.dragAndDropBy(periodSliderLocator, -400, 0).release().build().perform()
        changedValue = driver.findElement(periodInput).getAttribute("value")
        Assertions.assertEquals(changedValue, minPeriodValue, "Incorrect min period")
    }

    private fun setInputValue(locator: WebElement, value: String) {
        locator.click()
        locator.sendKeys("${Keys.CONTROL}", "a")
        locator.sendKeys("${Keys.DELETE}")
        locator.sendKeys(value)
    }

    private fun clickToElement(driver: WebDriver, element: WebElement?) {
        val executor = driver as JavascriptExecutor
        executor.executeScript("arguments[0].click();", element)
    }
}



