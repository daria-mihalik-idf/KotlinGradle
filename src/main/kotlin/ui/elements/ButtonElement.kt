package ui.elements

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver

object ButtonElement {

  fun clickButton(driver: WebDriver, locator: By) {
    driver.findElement(locator).click()
  }

  fun isElementDisplayed(driver: WebDriver, locator: By): Boolean {
    return driver.findElement(locator).isDisplayed
  }
}