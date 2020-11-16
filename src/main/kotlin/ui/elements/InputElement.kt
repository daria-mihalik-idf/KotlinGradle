package ui.elements

import org.openqa.selenium.By
import org.openqa.selenium.Keys
import org.openqa.selenium.WebDriver

object InputElement {

  fun setInputValueInPrefilledField(driver: WebDriver, locator: By, value: String) {

    val element = driver.findElement(locator)
    element.click()
    element.sendKeys("${Keys.CONTROL}", "a")
    element.sendKeys("${Keys.DELETE}")
    element.sendKeys(value)
  }

  fun setInputElement(driver: WebDriver, element: By, value: String) {
    driver.findElement(element).sendKeys(value)
  }

  fun getInputValue(driver: WebDriver, locator: By): String {
    return driver.findElement(locator).getAttribute("value")
  }
}