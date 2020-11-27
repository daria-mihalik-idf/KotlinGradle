package ui.elements

import logger.TestLogger
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.interactions.Actions

object ActionElement {

  fun dragAndDrop(driver: WebDriver, locator: By, xOffset: Int, yOffset: Int) {
    TestLogger.getLogger().info("Move slider $locator from $xOffset to $yOffset")
    val value = driver.findElement(locator)
    Actions(driver).dragAndDropBy(value, xOffset, yOffset).release().build().perform()
  }
}