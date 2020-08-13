package core

import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement

interface ISliderAction {
    fun moveAmountSliderToMinimum(slider: WebElement, position: Int, driver:WebDriver)
    fun moveAmountSliderToMaximum(slider: WebElement, position: Int, driver:WebDriver)
    fun movePeriodSliderToMinimum(slider: WebElement, position: Int, driver: WebDriver)
    fun movePeriodSliderToMaximum(slider: WebElement, position: Int, driver: WebDriver)
}