package core.driver.selenide

import com.codeborne.selenide.Configuration
import core.Browser
import core.driver.WebDriverConfig
import org.openqa.selenium.MutableCapabilities

class RemoteSelenideWebDriverFactory(webDriverConfig: WebDriverConfig) :
    DefaultSelenideWebDriverFactory(webDriverConfig) {

  override fun startDriver() {
    Configuration.remote = "http://${webDriverConfig.webDriverHost}:${webDriverConfig.webDriverPort}/wd/hub"
    Configuration.browserCapabilities = configureDriverCapabilities()
    setupSelenideDefaultDriverConfig()
  }

  override fun configureDriverCapabilities(): MutableCapabilities {
    return when (webDriverConfig.browserType) {
      Browser.CHROME -> ChromeSelenideDriverFactory(webDriverConfig).configureDriverCapabilities()
      Browser.FIREFOX -> FirefoxSelenideDriverFactory(webDriverConfig).configureDriverCapabilities()
      else -> throw IllegalArgumentException("Unknown browser type ${webDriverConfig.browserType}")
    }
  }
}