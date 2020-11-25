package ui.elements

import logger.TestLogger
import org.openqa.selenium.WebDriver

object Navigation {

  fun openUrl(driver: WebDriver, url: String) {
    TestLogger.getLogger().info("Open Page $url")
    driver.get(url)
  }
}