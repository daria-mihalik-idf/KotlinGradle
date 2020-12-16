package core.driver.selenide

import com.codeborne.selenide.Configuration
import core.configProvider.WebDriverConfigProvider
import core.driver.WebDriverConfig

abstract class DefaultSelenideWebDriverFactory(protected var webDriverConfig: WebDriverConfig) {
   var webDriver = WebDriverConfigProvider().getWebDriverConfig()

  fun setupSelenideDefaultDriverConfig() {
    Configuration.browserSize = webDriverConfig.getScreenResolution()
    Configuration.timeout = webDriverConfig.timeouts
    Configuration.headless = webDriver.headlessMode
  }

  abstract fun configDriver()
}