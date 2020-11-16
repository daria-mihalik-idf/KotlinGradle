package ui.elements

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver

object CommonElement {

  fun getElementValue(driver: WebDriver, locator: By): String {
    return driver.findElement(locator).getAttribute("value")
  }
}