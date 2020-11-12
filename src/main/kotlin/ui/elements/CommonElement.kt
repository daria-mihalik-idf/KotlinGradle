package ui.elements

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement

object CommonElement {

  fun getElementValue(driver: WebDriver, element: By): String {
    return driver.findElement(element).getAttribute("value")
  }

  fun getElement(driver: WebDriver, element: By): WebElement {
    return driver.findElement(element)
  }
}