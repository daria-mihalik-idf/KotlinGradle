package core.driver

import org.openqa.selenium.WebDriver
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.firefox.FirefoxOptions

class FirefoxDriverFactory(webDriverConfig: WebDriverConfig) : WebDriverFactory(webDriverConfig),
    DriverPathConfiguration {

  override val browserPackage = "webdriver.gecko.driver"
  override val browserPath = "C:\\SeleniumDriver\\geckodriver.exe"

  override fun getDriver(): WebDriver {
    val driver = FirefoxDriver(configureDriverCapabilities())
    configureDriverPath()
    setupDefaultDriverConfig(driver)
    return driver
  }

  override fun configureDriverCapabilities(): FirefoxOptions {
    val options = FirefoxOptions()
    options.merge(getGeneralCapabilities())
    return options
  }
}