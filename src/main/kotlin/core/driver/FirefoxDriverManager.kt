package core.driver

import org.openqa.selenium.WebDriver
import org.openqa.selenium.firefox.FirefoxDriver

class FirefoxDriverManager : WebDriverManager() {
  override fun createDriver(): WebDriver {
    System.setProperty("webdriver.gecko.driver", "C:\\SeleniumDriver\\geckodriver.exe")
    return FirefoxDriver()
  }
}