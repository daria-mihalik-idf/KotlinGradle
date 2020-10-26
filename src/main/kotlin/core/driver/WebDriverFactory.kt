package core.driver

import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.firefox.FirefoxDriver

class WebDriverFactory(webDriverConfig: WebDriverConfig) {
  var browserType = webDriverConfig.browserType

  fun getDriver(): WebDriver {
    return when (browserType) {
      "CHROME" -> {
        System.setProperty("webdriver.chrome.driver", "C:\\SeleniumDriver\\chromedriver.exe")
        ChromeDriver()
      }
      "FIREFOX" -> {
        System.setProperty("webdriver.gecko.driver", "C:\\SeleniumDriver\\geckodriver.exe")
        FirefoxDriver()
      }
      else -> throw IllegalArgumentException("Unknown browser")
    }
  }
}
