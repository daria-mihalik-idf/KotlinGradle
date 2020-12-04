package core.driver.selenide

import com.codeborne.selenide.Configuration
import core.Browser
import core.driver.DriverPathConfiguration
import core.driver.WebDriverConfig
import org.openqa.selenium.firefox.FirefoxOptions

class FirefoxSelenideDriverFactory(webDriverConfig: WebDriverConfig) : DefaultSelenideWebDriverFactory(webDriverConfig),
    DriverPathConfiguration {

  override val browserPackage = "webdriver.gecko.driver"
  override val browserPath = "C:\\SeleniumDriver\\geckodriver.exe"

  override fun startDriver() {
    Configuration.browser = Browser.FIREFOX.toString()
    Configuration.browserCapabilities = getGeneralCapabilities().merge(FirefoxOptions())
    configureDriverPath()
    setupSelenideDefaultDriverConfig()
  }

  override fun configureDriverCapabilities(): FirefoxOptions {
    val options = FirefoxOptions()
    options.merge(getGeneralCapabilities())
    return options
  }
}