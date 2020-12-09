package core.driver.selenide

import com.codeborne.selenide.Configuration
import core.Browser
import core.driver.WebDriverConfig
import io.github.bonigarcia.wdm.WebDriverManager

class ChromeSelenideDriverFactory(webDriverConfig: WebDriverConfig) : DefaultSelenideWebDriverFactory(webDriverConfig) {

  override fun configDriver() {
    Configuration.browser = Browser.CHROME.browserName
    setupSelenideDefaultDriverConfig()
    configDriverBinary()
  }

  private fun configDriverBinary() {
    WebDriverManager.chromedriver().driverVersion(webDriverConfig.chromeVersion).setup()
  }
}