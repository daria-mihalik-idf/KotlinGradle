package core.driver

import org.openqa.selenium.WebDriver

object WebDriverManager {
  private var webDriverConfig: WebDriverConfig? = null
  private var driver: WebDriver? = null

  fun getWebDriver(): WebDriver {
    if (driver == null) {
      initDriver()
    }
    return driver!!
  }

  fun setConfig(config: WebDriverConfig) {
    webDriverConfig = config
  }

  fun removeDriver() {
    driver?.also {
      it.quit()
      driver = null
    }
  }

  private fun initDriver() {
    driver = when (webDriverConfig!!.browserType) {
      "CHROME" -> ChromeDriverFactory(webDriverConfig!!).getDriver()
      "FIREFOX" -> FirefoxDriverFactory(webDriverConfig!!).getDriver()
      "REMOTE" -> RemoteWebDriverFactory(webDriverConfig!!).getDriver()
      else -> throw IllegalArgumentException(
          "WebDriverFactory not defined for browser ${webDriverConfig!!.browserType}")
    }
  }
}
