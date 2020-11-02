package core.driver

import org.openqa.selenium.WebDriver

class WebDriverManager(private var webDriverConfig: WebDriverConfig) {

  companion object {
    var driver: WebDriver? = null
  }

  fun getDriver(): WebDriver {
    if (driver == null) {
      initDriver()
    }
    return driver!!
  }

  private fun initDriver() {
    driver = when (webDriverConfig.browserType) {
      "CHROME" -> ChromeDriverFactory(webDriverConfig).getDriver()
      "FIREFOX" -> FirefoxDriverFactory(webDriverConfig).getDriver()
      else -> throw IllegalArgumentException("WebDriverFactory not defined for browser ${webDriverConfig.browserType}")
    }
  }
}
