package ui.elements

import logger.TestLogger
import org.openqa.selenium.WebDriver
import ui.waiter.Waiter

object Navigation {

  fun openUrl(driver: WebDriver, url: String) {
    TestLogger.getLogger().info("Open Page $url")
    driver.get(url)
    Waiter.waitPageDomLoad(driver)
  }
}