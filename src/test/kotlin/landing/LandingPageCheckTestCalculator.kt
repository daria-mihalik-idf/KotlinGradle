package landing

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.openqa.selenium.*
import org.openqa.selenium.interactions.Actions


class LandingPageCheckTestCalculator : CalculatorBaseTest() {
    private val minPeriodValue = "7"
    private val maxPeriodValue = "30"
    private val minAmountValue = "1,000"
    private val maxAmountValue = "4,000"
    private val registrationUrl = "client-area/index.html#/registration"

    @Test
    fun `LP - Verify Calculator Displayed`() {
        val calculator: By = By.className("hero__calculator")
        val calculatorLocator: WebElement = driver.findElement(calculator)
        Assertions.assertTrue(calculatorLocator.isDisplayed, "Calculator isn't displayed")

        val getCreditButton: By = By.cssSelector("[data-test-id='calculator_submit']")
        val calculatorGetCreditButton: WebElement = driver.findElement(getCreditButton)
        Assertions.assertTrue(calculatorGetCreditButton.isDisplayed, "Calculator isn't displayed")
    }

    @Test
    fun `LP - Verify Take Loan Button displayed and forward to registration`() {
        val getCreditButton: By = By.cssSelector("[data-test-id='calculator_submit']")
        val creditButtonLocator: WebElement = driver.findElement(getCreditButton)
        Assertions.assertTrue(creditButtonLocator.isDisplayed, "getCreditButton isn't displayed")
        click2Element(driver, creditButtonLocator)
        Assertions.assertTrue(driver.currentUrl.contains(registrationUrl), "registration isn't open")

        val rootRegistrationPageElement: By = By.cssSelector("[data-step-name]")
        val rootRegistrationPageElementLocator: WebElement = driver.findElement(rootRegistrationPageElement)
        Assertions.assertTrue(rootRegistrationPageElementLocator.isDisplayed, "registration page wasn't opened")
        // TODO: no ui on reg
    }

    private fun click2Element(driver: WebDriver, element: WebElement?) {
        val executor = driver as JavascriptExecutor
        executor.executeScript("arguments[0].click();", element)
    }

    @Test
    fun `LP - Calculator Slider Check`() {
        val actions = Actions(driver)
        val amountSlider: By = By.cssSelector("[data-test-id='amount'] [class*='slider-handle']")
        val amountSliderLocator: WebElement = driver.findElement(amountSlider)
        val amountInput: By = By.cssSelector("[data-test-id='calculator_amount']")

        actions.dragAndDropBy(amountSliderLocator, 400, 0).release().build().perform()
        var changedValue = driver.findElement(amountInput).getAttribute("value")
        Assertions.assertEquals(changedValue, maxAmountValue, "Incorrect max amount")

        actions.dragAndDropBy(amountSliderLocator, -500, 0).release().build().perform()
        changedValue = driver.findElement(amountInput).getAttribute("value")
        Assertions.assertEquals(changedValue, minAmountValue, "Incorrect min amount")

        val periodSlider: By =
            By.xpath("//*[@data-test-id='period']//div[contains(@class, 'mainCalculator__slider')]/span")
        val periodSliderLocator: WebElement = driver.findElement(periodSlider)
        val periodInput: By = By.cssSelector("[data-test-id='calculator_days']")
        changedValue = driver.findElement(periodInput).getAttribute("value")

        actions.dragAndDropBy(periodSliderLocator, 300, 0).release().build().perform()
        Assertions.assertEquals(changedValue, maxPeriodValue, "Incorrect max period")

        actions.dragAndDropBy(periodSliderLocator, -400, 0).release().build().perform()
        Assertions.assertEquals(changedValue, minPeriodValue, "Incorrect min period")
    }

    @Test
    fun `LP - Calculator Input Data`() {
        val amountInput: By = By.cssSelector("[data-test-id='calculator_amount']")
        val amountLocator: WebElement = driver.findElement(amountInput)

        setInputValue(amountLocator, maxAmountValue)
        var changedValue = driver.findElement(amountInput).getAttribute("value")
        Assertions.assertEquals(maxAmountValue, changedValue, "Max value is incorrect")

        setInputValue(amountLocator, minAmountValue)
        changedValue = driver.findElement(amountInput).getAttribute("value")
        Assertions.assertEquals(minAmountValue, changedValue, "Min value is incorrect")

        val periodInput: By = By.cssSelector("[data-test-id='calculator_days']")
        val periodLocator: WebElement = driver.findElement(periodInput)

        setInputValue(periodLocator, maxPeriodValue)
        changedValue = driver.findElement(periodInput).getAttribute("value")
        Assertions.assertEquals(maxPeriodValue, changedValue, "Max period is incorrect")

        setInputValue(periodLocator, minPeriodValue)
        changedValue = driver.findElement(periodInput).getAttribute("value")
        Assertions.assertEquals(minPeriodValue, changedValue, "Min period is incorrect")
    }

    private fun setInputValue(locator: WebElement, value: String) {
        locator.click()
        locator.sendKeys("${Keys.CONTROL}", "a")
        locator.sendKeys("${Keys.DELETE}")
        locator.sendKeys(value)
    }
}


