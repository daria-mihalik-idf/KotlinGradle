package core.driver.selenide

import com.codeborne.selenide.Configuration
import core.driver.WebDriverConfig
import org.openqa.selenium.*
import org.openqa.selenium.remote.CapabilityType
import org.openqa.selenium.remote.DesiredCapabilities

abstract class DefaultSelenideWebDriverFactory(protected var webDriverConfig: WebDriverConfig) {

  abstract fun startDriver()

  fun setupSelenideDefaultDriverConfig() {
    Configuration.browserSize = getScreenResolution()
    Configuration.timeout = webDriverConfig.timeouts
    Configuration.headless = webDriverConfig.headlessMode
  }

  private fun getScreenResolution(): String {
    return "${webDriverConfig.screenResolutionWidth}x${webDriverConfig.screenResolutionHeight}"
  }

  fun getGeneralCapabilities(): DesiredCapabilities {
    val capabilities = DesiredCapabilities()
    capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true)
    return capabilities
  }

  abstract fun configureDriverCapabilities(): MutableCapabilities
}