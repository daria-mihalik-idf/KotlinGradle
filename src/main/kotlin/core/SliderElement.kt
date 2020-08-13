package core

import org.openqa.selenium.By
import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.interactions.Actions


object SliderElement:ISliderAction {

//    fun sliderMoveToPosition() {
////        val slider: WebElement = driver.findElement(By.xpath("//*[contains(@class,\"mainCalculator__slider mainCalculator__sum ui-slider ui-corner-all ui-slider-horizontal ui-widget ui-widget-content\")][1]"))
////        var x = 10
////        val width = slider.size.getWidth()
////        val move = Actions(driver)
////        move.moveToElement(slider, width * x / 100, 0).click()
////        move.build().perform()
////        println("Slider moved")
//
//    }

    override fun moveAmountSliderToMinimum(slider: WebElement, position: Int, driver:WebDriver) {
        val js = driver as JavascriptExecutor
        js.executeScript("arguments[0].setAttribute('style', 'left: $position%;')", slider)
    }
    override fun moveAmountSliderToMaximum(slider: WebElement, position: Int, driver:WebDriver) {
        val js = driver as JavascriptExecutor
        js.executeScript("arguments[0].setAttribute('style', 'left: $position%;')", slider)
    }
    override fun movePeriodSliderToMinimum(slider: WebElement, position: Int, driver:WebDriver) {
        val js = driver as JavascriptExecutor
        js.executeScript("arguments[0].setAttribute('style', 'left: $position%;')", slider)
    }
    override fun movePeriodSliderToMaximum(slider: WebElement, position: Int, driver:WebDriver) {
        val js = driver as JavascriptExecutor
        js.executeScript("arguments[0].setAttribute('style', 'left: $position%;')", slider)
    }

}
