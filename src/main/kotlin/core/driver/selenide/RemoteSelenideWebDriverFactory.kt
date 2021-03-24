package core.driver.selenide

import com.codeborne.selenide.Configuration
import core.Browser
import core.driver.WebDriverConfig
import org.openqa.selenium.remote.DesiredCapabilities

class RemoteSelenideWebDriverFactory(webDriverConfig: WebDriverConfig) :
    DefaultSelenideWebDriverFactory(webDriverConfig) {

  private fun configureDriverCapabilities() {
    return when (webDriverConfig.browserType) {
      Browser.CHROME -> ChromeSelenideDriverFactory(webDriverConfig).configDriver()
      Browser.FIREFOX -> FirefoxSelenideDriverFactory(webDriverConfig).configDriver()
    }
  }

  private fun getDefaultCapabilities(): DesiredCapabilities {
    val caps = DesiredCapabilities()
    caps.setCapability("enableVNC", true)
    return caps
  }

  override fun configDriver() {
    configureDriverCapabilities()
    Configuration.remote = "http://${webDriverConfig.webDriverHost}:${webDriverConfig.webDriverPort}/wd/hub"
    Configuration.browserCapabilities.merge(getDefaultCapabilities())
  }
}