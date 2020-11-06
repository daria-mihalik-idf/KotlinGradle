package core.driver

import core.Browser
import org.openqa.selenium.MutableCapabilities
import org.openqa.selenium.WebDriver
import org.openqa.selenium.remote.RemoteWebDriver
import java.net.URL

class RemoteWebDriverFactory(webDriverConfig: WebDriverConfig) : WebDriverFactory(webDriverConfig) {

  override val browserPackage: String = ""
  override val browserPath: String = ""
  private val hubUrl: String = "http://${webDriverConfig.webDriverHost}:${webDriverConfig.webDriverPort}/wd/hub"

  override fun getDriver(): WebDriver {
    val driver = RemoteWebDriver(URL(hubUrl), configureDriverCapabilities())
    configDefaultDriverConfig(driver)
    return driver
  }

  override fun configureDriverCapabilities(): MutableCapabilities {
    return when (webDriverConfig.browserType) {
      Browser.CHROME -> ChromeDriverFactory(webDriverConfig).configureDriverCapabilities()
      Browser.FIREFOX -> FirefoxDriverFactory(webDriverConfig).configureDriverCapabilities()
    }
  }
}