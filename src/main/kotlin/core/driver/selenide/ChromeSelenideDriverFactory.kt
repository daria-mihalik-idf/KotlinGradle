package core.driver.selenide

import com.codeborne.selenide.Configuration
import core.Browser
import core.driver.DriverPathConfiguration
import core.driver.WebDriverConfig
import org.openqa.selenium.chrome.ChromeOptions

class ChromeSelenideDriverFactory(webDriverConfig: WebDriverConfig) : DefaultSelenideWebDriverFactory(webDriverConfig),
    DriverPathConfiguration {

  override val browserPackage = "webdriver.chrome.driver"
  override val browserPath = "C:\\SeleniumDriver\\chromedriver.exe"

  override fun startDriver() {
    Configuration.browser = Browser.CHROME.browserName
    Configuration.browserVersion = webDriverConfig.chromeVersion
    Configuration.browserCapabilities = getGeneralCapabilities().merge(ChromeOptions())
    configureDriverPath()
    setupSelenideDefaultDriverConfig()
  }

  override fun configureDriverCapabilities(): ChromeOptions {
    val options = ChromeOptions()
    options.merge(getGeneralCapabilities())
    return options
  }
}