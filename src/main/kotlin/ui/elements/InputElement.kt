package ui.elements

import org.openqa.selenium.By
import org.openqa.selenium.Keys
import org.openqa.selenium.WebDriver

object InputElement {

  fun setInputValue(locator: By, value: String, driver: WebDriver) {
    var element = driver.findElement(locator)
    element.click()
    element.sendKeys("${Keys.CONTROL}", "a")
    element.sendKeys("${Keys.DELETE}")
    element.sendKeys(value)
  }

  fun inputElement(driver: WebDriver, element: By, value: String) {
    driver.findElement(element).sendKeys(value)
  }
}