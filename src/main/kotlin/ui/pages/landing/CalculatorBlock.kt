package ui.pages.landing

import com.codeborne.selenide.Selenide.`$`
import org.openqa.selenium.*
import ui.elements.*
import ui.waiter.Waiter

class CalculatorBlock {
  private val calculator: By = By.className("hero__calculator")
  private val creditButton: By = By.cssSelector("[data-test-id='calculator_submit']")
  private val amountSlider: By = By.cssSelector("[data-test-id='amount'] [class*='slider-handle']")
  private val periodSlider: By =
      By.xpath("//*[@data-test-id='period']//div[contains(@class, 'mainCalculator__slider')]/span")
  private val periodInput: By = By.cssSelector("[data-test-id='calculator_days']")
  private val amountInput: By = By.cssSelector("[data-test-id='calculator_amount']")

  fun isCalculatorBlockDisplayed(): Boolean {
    return `$`(calculator).isDisplayed
  }

  fun waitCalculatorBlockDisplayed() {
    Waiter.waitUntilElementAppear(creditButton)
  }

  fun isCreditButtonDisplayed(): Boolean {
    return `$`(creditButton).isDisplayed
  }

  fun moveSlider(xOffset: Int, yOffset: Int, type: SliderType) {
    val locator = when (type) {
      SliderType.AMOUNT -> amountSlider
      SliderType.PERIOD -> periodSlider
    }
    ActionElement.dragAndDrop(locator, xOffset, yOffset)
  }

  fun clickGetCreditButton() {
    ButtonElement.clickButton(creditButton)
    Waiter.waitUntilElementDisappeared(creditButton)
  }

  fun setPeriodValue(value: String) {
    InputElement.setInputValueInPrefilledField(periodInput, value)
  }

  fun getPeriodValue(): String? {
    return InputElement.getInputValue(periodInput)
  }

  fun setAmountValue(value: String) {
    InputElement.setInputValueInPrefilledField(amountInput, value)
  }

  fun getAmountValue(): String? {
    return InputElement.getInputValue(amountInput)
  }
}