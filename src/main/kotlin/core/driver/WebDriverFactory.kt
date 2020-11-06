package core.driver

import core.Browser
import org.openqa.selenium.Dimension
import org.openqa.selenium.MutableCapabilities
import org.openqa.selenium.WebDriver
import org.openqa.selenium.remote.CapabilityType
import org.openqa.selenium.remote.DesiredCapabilities
import java.util.concurrent.TimeUnit

abstract class WebDriverFactory(protected var webDriverConfig: WebDriverConfig) {
  abstract val browserPackage: String
  abstract val browserPath: String

  abstract fun getDriver(): WebDriver

  fun configureBrowser(driver: WebDriver) {
    driver.manage().window().size = Dimension(webDriverConfig.screenResolutionWidth,
        webDriverConfig.screenResolutionHeight)
    driver.manage().timeouts().implicitlyWait(webDriverConfig.timeouts, TimeUnit.SECONDS)
  }

  fun configureDriverPath() {
    System.setProperty(browserPackage, browserPath)
  }

  fun getGeneralCapabilities(): DesiredCapabilities {
    val capabilities = DesiredCapabilities()
    capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true)
    return capabilities
  }

  fun getDriverFactory(): WebDriverFactory {
    return when (webDriverConfig.browserType) {
      "CHROME" -> ChromeDriverFactory(webDriverConfig)
      "FIREFOX" -> FirefoxDriverFactory(webDriverConfig)
      else -> throw IllegalArgumentException("WebDriverFactory not defined for browser ${webDriverConfig.browserType}")
    }
  }

  protected abstract fun configureDriverCapabilities(): MutableCapabilities
}

