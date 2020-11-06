package core.driver

import org.openqa.selenium.Platform
import org.openqa.selenium.WebDriver
import org.openqa.selenium.remote.DesiredCapabilities
import org.openqa.selenium.remote.RemoteWebDriver

class RemoteWebDriverFactory(webDriverConfig: WebDriverConfig) : WebDriverFactory(webDriverConfig) {

  override val browserPackage: String = ""
  override val browserPath: String = ""

  override fun getDriver(): WebDriver {
    getDriverFactory()
    val driver = RemoteWebDriver(configureDriverCapabilities())
    configureDriverPath()
    configureBrowser(driver)
    return driver
  }

  override fun configureDriverCapabilities(): DesiredCapabilities {
    val caps = DesiredCapabilities()
//    caps.platform = Platform.WIN10
    caps.setCapability("hub", configureHub())
    return caps
  }

  private fun configureHub(): String {
    return "http://${webDriverConfig.webDriverHost}:${webDriverConfig.webDriverPort}/wd/hub"
  }
}