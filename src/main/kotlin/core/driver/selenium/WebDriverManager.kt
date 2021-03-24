package core.driver.selenium

import core.Browser
import core.driver.DriverType
import core.driver.WebDriverConfig
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
    driver = when (webDriverConfig!!.driverType) {
      DriverType.REMOTE -> RemoteWebDriverFactory(webDriverConfig!!).getDriver()
      DriverType.LOCAL -> when (webDriverConfig!!.browserType) {
        Browser.CHROME -> ChromeDriverFactory(webDriverConfig!!).getDriver()
        Browser.FIREFOX -> FirefoxDriverFactory(webDriverConfig!!).getDriver()
      }
    }
  }
}