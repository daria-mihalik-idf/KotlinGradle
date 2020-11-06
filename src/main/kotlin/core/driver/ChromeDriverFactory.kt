package core.driver

import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions

class ChromeDriverFactory(webDriverConfig: WebDriverConfig) : WebDriverFactory(webDriverConfig) {
  override val browserPackage = "webdriver.chrome.driver"
  override val browserPath = "C:\\SeleniumDriver\\chromedriver.exe"

  override fun getDriver(): WebDriver {
    val driver = ChromeDriver(configureDriverCapabilities())
    configureDriverPath()
    configDefaultDriverConfig(driver)
    return driver
  }

  public override fun configureDriverCapabilities(): ChromeOptions {
    val options = ChromeOptions()
    options.merge(getGeneralCapabilities())
    return options
  }
}

