package core.driver

import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.remote.DesiredCapabilities

class ChromeDriverFactory(webDriverConfig: WebDriverConfig) : WebDriverFactory(webDriverConfig) {
  private val browserPackage = "webdriver.chrome.driver"
  private val browserPath = "C:\\SeleniumDriver\\chromedriver.exe"
  lateinit var driver: WebDriver

  override fun createDriver(capabilities: DesiredCapabilities): WebDriver {
    setSystemProperties(browserPackage, browserPath)
    driver = ChromeDriver(capabilities)
    configureBrowser(driver)
    return driver
  }

  override fun setCapabilities(capabilityType: String, value: Boolean): DesiredCapabilities {
    val capabilities = DesiredCapabilities.chrome()
    capabilities.setCapability(capabilityType, value)
    return capabilities
  }
}

