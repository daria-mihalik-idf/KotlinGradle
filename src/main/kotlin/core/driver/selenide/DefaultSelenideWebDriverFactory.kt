package core.driver.selenide

import com.codeborne.selenide.Configuration
import core.driver.WebDriverConfig

abstract class DefaultSelenideWebDriverFactory(protected var webDriverConfig: WebDriverConfig) {

  fun setupSelenideDefaultDriverConfig() {
    Configuration.browserSize = webDriverConfig.getScreenResolution()
    Configuration.timeout = webDriverConfig.timeouts
    Configuration.headless = webDriverConfig.headlessMode
  }

  abstract fun configDriver()
}