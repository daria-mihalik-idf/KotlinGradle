package ui.landing

import org.openqa.selenium.By
import org.openqa.selenium.Keys
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.interactions.Actions
import services.SliderValue

enum class SliderType() {
    AMOUNT, PERIOD
}

class CalculatorBlock(private val driver: WebDriver) {
    private val calculator: By = By.className("hero__calculator")
    private val getCreditButton: By = By.cssSelector("[data-test-id='calculator_submit']")
    private val amountSlider: By = By.cssSelector("[data-test-id='amount'] [class*='slider-handle']")
    private val periodSlider: By =
        By.xpath("//*[@data-test-id='period']//div[contains(@class, 'mainCalculator__slider')]/span")
    private val periodInput: By = By.cssSelector("[data-test-id='calculator_days']")
    private val amountInput: By = By.cssSelector("[data-test-id='calculator_amount']")

    fun isCalculatorBlockPresent(): Boolean {
        val calculatorLocator: WebElement = driver.findElement(calculator)
        val getCreditButtonLocator: WebElement = driver.findElement(getCreditButton)
        return calculatorLocator.isDisplayed && getCreditButtonLocator.isDisplayed
    }

    private fun setInputValue(locator: WebElement, value: String) {
        locator.click()
        locator.sendKeys("${Keys.CONTROL}", "a")
        locator.sendKeys("${Keys.DELETE}")
        locator.sendKeys(value)
    }

    fun moveSlider(xOffset: Int, yOffset: Int, type: SliderType) {
        val actions = Actions(driver)
        val locator = when (type) {
            SliderType.AMOUNT -> driver.findElement(amountSlider)
            SliderType.PERIOD -> driver.findElement(periodSlider)
        }
        actions.dragAndDropBy(locator, xOffset, yOffset).release().build().perform()
    }

    private fun clickGetCreditBtn() {
        driver.findElement(getCreditButton).click()
    }

    fun setValue(locator: WebElement, value: String) {
        setInputValue(locator, value)
    }

    fun setPeriodValue(value: String) {
        val periodLocator: WebElement = driver.findElement(periodInput)
        setInputValue(periodLocator, value)
    }

    fun getPeriodValue(): String {
        return driver.findElement(periodInput).getAttribute("value")
    }

    fun setAmountValue(value: String) {
        val periodLocator: WebElement = driver.findElement(amountInput)
        setInputValue(periodLocator, value)
    }

    fun getAmountValue(): String {
        return driver.findElement(amountInput).getAttribute("value")
    }

    fun clickGetCreditButton() {
        clickGetCreditBtn()
    }

    fun moveSlider(value: SliderValue, type: SliderType) {
        var offset = 0
        offset = when (value) {
            SliderValue.AMOUNT_MAX -> 400
            SliderValue.AMOUNT_MIN -> -500
            SliderValue.PERIOD_MAX -> 300
            SliderValue.PERIOD_MIN -> -400
        }
        CalculatorBlock(driver).moveSlider(offset, 0, type)
    }

    fun getCurrentValue(type: SliderType): String {
        return when (type) {
            SliderType.PERIOD -> getPeriodValue()
            else -> getAmountValue()
        }
    }
}