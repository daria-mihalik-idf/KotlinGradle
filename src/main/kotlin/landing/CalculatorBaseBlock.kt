package landing

import org.openqa.selenium.By
import org.openqa.selenium.Keys
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.interactions.Actions

enum class SliderType() {
    AMOUNT, PERIOD
}

class CalculatorBaseBlock {
    private val getCreditButton: By = By.cssSelector("[data-test-id='calculator_submit']")
    private val amountSlider: By = By.cssSelector("[data-test-id='amount'] [class*='slider-handle']")
    private val periodSlider: By =
        By.xpath("//*[@data-test-id='period']//div[contains(@class, 'mainCalculator__slider')]/span")

    fun setInputValue(locator: WebElement, value: String) {
        locator.click()
        locator.sendKeys("${Keys.CONTROL}", "a")
        locator.sendKeys("${Keys.DELETE}")
        locator.sendKeys(value)
    }

    fun moveSlider(driver: WebDriver, xOffset: Int, yOffset: Int, type: SliderType) {
        val actions = Actions(driver)
        val locator = when (type) {
            SliderType.AMOUNT -> driver.findElement(amountSlider)
            SliderType.PERIOD -> driver.findElement(periodSlider)
        }
        actions.dragAndDropBy(locator, xOffset, yOffset).release().build().perform()
    }

    fun isGetCreditButtonPresent(driver: WebDriver): Boolean {
        return driver.findElement(getCreditButton).isDisplayed
    }

    fun clickGetCreditButton(driver: WebDriver) {
        driver.findElement(getCreditButton).click()
    }
}