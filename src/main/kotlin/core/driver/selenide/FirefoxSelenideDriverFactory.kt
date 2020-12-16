package core.driver.selenide

import com.codeborne.selenide.Configuration
import core.Browser
import core.configProvider.WebDriverConfigProvider
import core.driver.WebDriverConfig
import io.github.bonigarcia.wdm.WebDriverManager

class FirefoxSelenideDriverFactory(webDriverConfig: WebDriverConfig) :
    DefaultSelenideWebDriverFactory(webDriverConfig) {

  override fun configDriver() {
    Configuration.browser = Browser.FIREFOX.browserName
    setupSelenideDefaultDriverConfig()
    configDriverBinary()
  }

  private fun configDriverBinary() {
    WebDriverManager.firefoxdriver().driverVersion(webDriver.firefoxVersion).setup()
  }
}