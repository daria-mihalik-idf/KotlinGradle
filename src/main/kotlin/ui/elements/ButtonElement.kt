package ui.elements

import logger.TestLogger
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver

object ButtonElement {

  fun clickButton(driver: WebDriver, locator: By) {
    TestLogger.getLogger().info("Click button: $locator")
    driver.findElement(locator).click()
  }

  fun isElementDisplayed(driver: WebDriver, locator: By): Boolean {
    return driver.findElement(locator).isDisplayed
  }
}