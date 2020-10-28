package core.driver

import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.firefox.FirefoxOptions
import org.openqa.selenium.remote.CapabilityType
import org.openqa.selenium.remote.DesiredCapabilities

class FirefoxDriverFactory(webDriverConfig: WebDriverConfig) : WebDriverFactory(webDriverConfig) {
  override val browserPackage = "webdriver.gecko.driver"
  override val browserPath = "C:\\SeleniumDriver\\geckodriver.exe"

  override fun getDriver(): WebDriver {
    configureDriverPath()
    val options = FirefoxOptions()
    options.merge(getGeneralCapabilities())
    val driver = FirefoxDriver(options)
    configureBrowser(driver)
    return driver
  }
}