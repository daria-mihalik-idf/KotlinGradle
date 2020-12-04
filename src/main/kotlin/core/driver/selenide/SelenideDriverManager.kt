package core.driver.selenide

import core.Browser
import core.driver.DriverType
import core.driver.WebDriverConfig

object SelenideDriverManager {

  fun getDriverFactory(webDriverConfig: WebDriverConfig): DefaultSelenideWebDriverFactory {
    return when (webDriverConfig.driverType) {
      DriverType.REMOTE -> RemoteSelenideWebDriverFactory(webDriverConfig)
      DriverType.LOCAL -> when (webDriverConfig.browserType) {
        Browser.CHROME -> ChromeSelenideDriverFactory(webDriverConfig)
        Browser.FIREFOX -> FirefoxSelenideDriverFactory(webDriverConfig)
      }
    }
  }
}