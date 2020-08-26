package services

import org.openqa.selenium.WebDriver
import landing.CalculatorBaseBlock
import landing.LandingPage
import landing.SliderType

enum class SliderValue{
    AMOUNT_MIN, AMOUNT_MAX, PERIOD_MIN, PERIOD_MAX
}

class CalculatorService(private val driver: WebDriver){

    fun moveSlider(value: SliderValue, type: SliderType){
        var offset = 0
        when (value) {
            SliderValue.AMOUNT_MAX -> offset = 400
            SliderValue.AMOUNT_MIN -> offset = -500
            SliderValue.PERIOD_MAX -> offset = 300
            SliderValue.PERIOD_MIN -> offset = -400
        }
        CalculatorBaseBlock(driver).moveSlider(driver, offset, 0, type)
    }

    fun getCurrentValue(type: SliderType): String{
        val lp = LandingPage(driver)
        when (type) {
            SliderType.PERIOD -> return lp.calculator.getPeriodValue()
            else -> return lp.calculator.getAmountValue()
        }
    }
}



