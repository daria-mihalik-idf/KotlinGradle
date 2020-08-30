package services

import org.openqa.selenium.WebDriver
import ui.pages.landing.CalculatorBlock
import ui.landing.LandingPage
import ui.pages.landing.SliderType

enum class SliderValue {
    AMOUNT_MIN, AMOUNT_MAX, PERIOD_MIN, PERIOD_MAX
}

class CalculatorService(private val driver: WebDriver) {
    private val calculatorBlock = CalculatorBlock(driver)

    fun isCalculatorElementsDisplayed(): Boolean {
        return calculatorBlock.isCalculatorBlockPresent() && calculatorBlock.isGetCreditButtonPresent()
    }

    fun setCalculatorValue(value: String, type: SliderValue) {
        if (type == SliderValue.AMOUNT_MIN || type == SliderValue.AMOUNT_MAX)
            calculatorBlock.setAmountValue(value) else
            calculatorBlock.setPeriodValue(value)
    }

    fun getCurrentValue(type: SliderType): String {
        return when (type) {
            SliderType.PERIOD -> calculatorBlock.getPeriodValue()
            else -> calculatorBlock.getAmountValue()
        }
    }

    fun moveCalculatorSlider(value: SliderValue, type: SliderType) {
        var offset = when (value) {
            SliderValue.AMOUNT_MAX -> 400
            SliderValue.AMOUNT_MIN -> -500
            SliderValue.PERIOD_MAX -> 300
            SliderValue.PERIOD_MIN -> -400
        }
        CalculatorBlock(driver).moveSlider(offset, 0, type)
    }
}



