package ui.elements

import logger.Logger
import org.openqa.selenium.WebDriver

object Navigation {

  fun openUrl(driver: WebDriver, url: String) {
    Logger.getLogger().info("Open Page $url")
    driver.get(url)
  }
}