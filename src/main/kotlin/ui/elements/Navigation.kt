package ui.elements

import org.openqa.selenium.WebDriver

object Navigation {
  fun openUrl(driver: WebDriver, url: String) {
    driver.get(url)
  }
}