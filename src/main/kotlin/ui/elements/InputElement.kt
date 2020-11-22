package ui.elements

import logger.Logger
import org.openqa.selenium.By
import org.openqa.selenium.Keys
import org.openqa.selenium.WebDriver

object InputElement {

  fun setInputValueInPrefilledField(driver: WebDriver, locator: By, value: String) {
    val element = driver.findElement(locator)
    element.click()
    element.sendKeys("${Keys.CONTROL}", "a")
    element.sendKeys("${Keys.DELETE}")
    Logger.getLogger().info("Set Input element value [$value] in Prefilled Field with sendKeys")
    element.sendKeys(value)
  }

  fun setInputElement(driver: WebDriver, element: By, value: String) {
    Logger.getLogger().info("Set Input element value [$value] with sendKeys")
    driver.findElement(element).sendKeys(value)
  }

  fun getInputValue(driver: WebDriver, locator: By): String {
    Logger.getLogger().info("Get Input element value $locator ")
    return driver.findElement(locator).getAttribute("value")
  }
}