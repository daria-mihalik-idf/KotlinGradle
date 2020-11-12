package ui.elements

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver

object ButtonElement {

  fun clickButton(driver: WebDriver, buttonLocator: By) {
    driver.findElement(buttonLocator).click()
  }

  fun isElementPresent(driver: WebDriver, buttonLocator: By): Boolean {
    return driver.findElement(buttonLocator).isDisplayed
  }
}