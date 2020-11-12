package ui.pages.landing

import org.openqa.selenium.*
import org.openqa.selenium.interactions.Actions
import ui.elements.ButtonElement
import ui.elements.CommonElement
import ui.elements.InputElement

class CalculatorBlock(private val driver: WebDriver) {
  private val calculator: By = By.className("hero__calculator")
  private val getCreditButton: By = By.cssSelector("[data-test-id='calculator_submit']")
  private val amountSlider: By = By.cssSelector("[data-test-id='amount'] [class*='slider-handle']")
  private val periodSlider: By =
      By.xpath("//*[@data-test-id='period']//div[contains(@class, 'mainCalculator__slider')]/span")
  private val periodInput: By = By.cssSelector("[data-test-id='calculator_days']")
  private val amountInput: By = By.cssSelector("[data-test-id='calculator_amount']")

  fun isCalculatorBlockPresent(): Boolean {
    return ButtonElement.isElementPresent(driver, calculator)
  }

  fun isGetCreditButtonPresent(): Boolean {
    return ButtonElement.isElementPresent(driver, getCreditButton)
  }

  fun moveSlider(xOffset: Int, yOffset: Int, type: SliderType) {
    val actions = Actions(driver)
    val locator = when (type) {
      SliderType.AMOUNT -> CommonElement.getElement(driver, amountSlider)
      SliderType.PERIOD -> CommonElement.getElement(driver, periodSlider)
    }
    actions.dragAndDropBy(locator, xOffset, yOffset).release().build().perform()
  }

  fun clickGetCreditButton() {
    ButtonElement.clickButton(driver, getCreditButton)
  }

  fun setPeriodValue(value: String) {
    InputElement.setInputValue(periodInput, value, driver)
  }

  fun getPeriodValue(): String {
    return CommonElement.getElementValue(driver, periodInput)
  }

  fun setAmountValue(value: String) {
    InputElement.setInputValue(amountInput, value, driver)
  }

  fun getAmountValue(): String {
    return CommonElement.getElementValue(driver, amountInput)
  }
}