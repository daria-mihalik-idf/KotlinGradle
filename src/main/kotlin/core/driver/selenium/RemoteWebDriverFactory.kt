package core.driver.selenium

import core.Browser
import core.driver.WebDriverConfig
import org.openqa.selenium.MutableCapabilities
import org.openqa.selenium.WebDriver
import org.openqa.selenium.remote.RemoteWebDriver
import java.net.URL

class RemoteWebDriverFactory(webDriverConfig: WebDriverConfig) : WebDriverFactory(webDriverConfig) {

  private val hubUrl: String = "http://${webDriverConfig.webDriverHost}:${webDriverConfig.webDriverPort}/wd/hub"

  override fun getDriver(): WebDriver {
    val driver = RemoteWebDriver(URL(hubUrl), configureDriverCapabilities())
    setupDefaultDriverConfig(driver)
    return driver
  }

  override fun configureDriverCapabilities(): MutableCapabilities {
    return when (webDriverConfig.browserType) {
      Browser.CHROME -> ChromeDriverFactory(webDriverConfig).configureDriverCapabilities()
      Browser.FIREFOX -> FirefoxDriverFactory(webDriverConfig).configureDriverCapabilities()
      else -> throw IllegalArgumentException("Unknown browser type ${webDriverConfig.browserType}")
    }
  }
}