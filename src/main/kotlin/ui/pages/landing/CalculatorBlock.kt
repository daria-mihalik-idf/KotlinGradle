package ui.pages.landing

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
        return calculatorLocator.isDisplayed
    }

    fun isGetCreditButtonPresent(): Boolean {
        val getCreditButtonLocator: WebElement = driver.findElement(getCreditButton)
        return getCreditButtonLocator.isDisplayed
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

    private fun setInputValue(locator: WebElement, value: String) {
        locator.click()
        locator.sendKeys("${Keys.CONTROL}", "a")
        locator.sendKeys("${Keys.DELETE}")
        locator.sendKeys(value)
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
}