package services

import ui.pages.landing.CalculatorBlock
import ui.pages.landing.SliderType
import ui.pages.landing.SliderValue

class CalculatorService() {
  private val calculatorBlock = CalculatorBlock()

  fun isCalculatorElementsDisplayed(): Boolean {
    return calculatorBlock.isCalculatorBlockDisplayed() && calculatorBlock.isCreditButtonDisplayed()
  }

  fun clickGetCreditButton() {
    calculatorBlock.clickGetCreditButton()
  }

  fun setCalculatorValue(value: String, type: SliderValue) {
    when (type) {
      SliderValue.AMOUNT_MIN, SliderValue.AMOUNT_MAX -> calculatorBlock.setAmountValue(value)
      else -> calculatorBlock.setPeriodValue(value)
    }
  }

  fun getCurrentValue(type: SliderType): String? {
    return when (type) {
      SliderType.PERIOD -> calculatorBlock.getPeriodValue()
      SliderType.AMOUNT -> calculatorBlock.getAmountValue()
    }
  }

  fun moveCalculatorSlider(value: SliderValue, type: SliderType) {
    var offset = when (value) {
      SliderValue.AMOUNT_MAX -> 400
      SliderValue.AMOUNT_MIN -> -500
      SliderValue.PERIOD_MAX -> 300
      SliderValue.PERIOD_MIN -> -400
    }
    calculatorBlock.moveSlider(offset, 0, type)
  }
}