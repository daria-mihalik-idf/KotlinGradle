package core.driver

import org.openqa.selenium.*
import org.openqa.selenium.remote.CapabilityType
import org.openqa.selenium.remote.DesiredCapabilities

abstract class WebDriverFactory(protected var webDriverConfig: WebDriverConfig) {

  abstract fun getDriver(): WebDriver

  fun setupDefaultDriverConfig(driver: WebDriver) {
    driver.manage().window().size = Dimension(webDriverConfig.screenResolutionWidth,
        webDriverConfig.screenResolutionHeight)
  }

  fun getGeneralCapabilities(): DesiredCapabilities {
    val capabilities = DesiredCapabilities()
    capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true)
    return capabilities
  }

  abstract fun configureDriverCapabilities(): MutableCapabilities
}


