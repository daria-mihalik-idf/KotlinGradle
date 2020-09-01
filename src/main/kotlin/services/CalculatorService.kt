package services

import config.ApplicationConfig
import org.openqa.selenium.NotFoundException
import org.openqa.selenium.WebDriver
import ui.pages.landing.CalculatorBlock

enum class SliderValue {
    AMOUNT_MIN, AMOUNT_MAX, PERIOD_MIN, PERIOD_MAX, AMOUNT, PERIOD
}

class CalculatorService(private val driver: WebDriver, applicationConfig: ApplicationConfig) {
    private val calculatorBlock = CalculatorBlock(driver)
    private val landingPageUrl = applicationConfig.getBaseUrl() + applicationConfig.landingEndpoint

    fun openLandingPage() {
        driver.get(landingPageUrl)
    }

    fun isCalculatorElementsDisplayed(): Boolean {
        return calculatorBlock.isCalculatorBlockPresent() && calculatorBlock.isGetCreditButtonPresent()
    }

    fun setCalculatorValue(value: String, type: SliderValue) {
        when (type) {
            SliderValue.AMOUNT_MIN, SliderValue.AMOUNT_MAX -> calculatorBlock.setAmountValue(value)
            else -> calculatorBlock.setPeriodValue(value)
        }
    }

    fun getCurrentValue(type: SliderValue): String {
        return when (type) {
            SliderValue.PERIOD -> calculatorBlock.getPeriodValue()
            SliderValue.AMOUNT -> calculatorBlock.getAmountValue()
            else -> throw NotFoundException("No such field")
        }
    }

    fun moveCalculatorSlider(value: SliderValue, type: SliderValue) {
        var offset = when (value) {
            SliderValue.AMOUNT_MAX -> 400
            SliderValue.AMOUNT_MIN -> -500
            SliderValue.PERIOD_MAX -> 300
            SliderValue.PERIOD_MIN -> -400
            else -> throw NotFoundException("No such value")
        }
        calculatorBlock.moveSlider(offset, 0, type)
    }
}



