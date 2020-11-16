package ui.pages.landing

import org.openqa.selenium.*
import ui.elements.*
import ui.waiter.Waiter

class CalculatorBlock(private val driver: WebDriver) : Waiter {
  private val calculator: By = By.className("hero__calculator")
  val creditButton: By = By.cssSelector("[data-test-id='calculator_submit']")
  private val amountSlider: By = By.cssSelector("[data-test-id='amount'] [class*='slider-handle']")
  private val periodSlider: By =
      By.xpath("//*[@data-test-id='period']//div[contains(@class, 'mainCalculator__slider')]/span")
  private val periodInput: By = By.cssSelector("[data-test-id='calculator_days']")
  private val amountInput: By = By.cssSelector("[data-test-id='calculator_amount']")

  fun isCalculatorBlockDisplayed(): Boolean {
    return ButtonElement.isElementDisplayed(driver, calculator)
  }

  fun isCreditButtonDisplayed(): Boolean {
    return ButtonElement.isElementDisplayed(driver, creditButton)
  }

  fun moveSlider(xOffset: Int, yOffset: Int, type: SliderType) {
    val locator = when (type) {
      SliderType.AMOUNT -> amountSlider
      SliderType.PERIOD -> periodSlider
    }
    ActionElement.dragAndDrop(driver, locator, xOffset, yOffset)
  }

  fun clickGetCreditButton() {
    ButtonElement.clickButton(driver, creditButton)
    waitUntilElementDisappeared(driver, creditButton)
  }

  fun setPeriodValue(value: String) {
    InputElement.setInputValueInPrefilledField(driver, periodInput, value)
  }

  fun getPeriodValue(): String {
    return InputElement.getInputValue(driver, periodInput)
  }

  fun setAmountValue(value: String) {
    InputElement.setInputValueInPrefilledField(driver, amountInput, value)
  }

  fun getAmountValue(): String {
    return InputElement.getInputValue(driver, amountInput)
  }
}