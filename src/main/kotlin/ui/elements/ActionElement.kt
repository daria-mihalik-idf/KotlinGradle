package ui.elements

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.interactions.Actions

object ActionElement {

  fun dragAndDrop(driver: WebDriver, locator: By, xOffset: Int, yOffset: Int) {
    val value = driver.findElement(locator)
    Actions(driver).dragAndDropBy(value, xOffset, yOffset).release().build().perform()
  }
}