package core.driver

import org.openqa.selenium.WebDriver
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.remote.DesiredCapabilities

class FirefoxDriverFactory(webDriverConfig: WebDriverConfig) : WebDriverFactory(webDriverConfig) {
  private val browserPackage = "webdriver.gecko.driver"
  private val browserPath = "C:\\SeleniumDriver\\geckodriver.exe"
  lateinit var driver: WebDriver

  override fun createDriver(capabilities: DesiredCapabilities): WebDriver {
    setSystemProperties(browserPackage, browserPath)
    driver = FirefoxDriver(capabilities)
    configureBrowser(driver)
    return driver
  }

  override fun setCapabilities(capabilityType: String, value: Boolean): DesiredCapabilities {
    val capabilities = DesiredCapabilities.chrome()
    capabilities.setCapability(capabilityType, value)
    return capabilities
  }
}