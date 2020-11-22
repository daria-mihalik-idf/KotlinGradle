package ui.elements

import logger.Logger
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.interactions.Actions

object ActionElement {

  fun dragAndDrop(driver: WebDriver, element: By, xOffset: Int, yOffset: Int) {
    Logger.getLogger().info("Move slider $element from $xOffset to $yOffset")
    val value = driver.findElement(element)
    Actions(driver).dragAndDropBy(value, xOffset, yOffset).release().build().perform()
  }
}