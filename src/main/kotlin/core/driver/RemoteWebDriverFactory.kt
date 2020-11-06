package core.driver

import org.openqa.selenium.MutableCapabilities
import org.openqa.selenium.Platform
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.remote.DesiredCapabilities
import org.openqa.selenium.remote.RemoteWebDriver
import java.net.URL

class RemoteWebDriverFactory(webDriverConfig: WebDriverConfig) : WebDriverFactory(webDriverConfig) {

  lateinit var driverConfig: WebDriverConfig
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
    caps.platform = Platform.WIN10
    caps.browserName = driverConfig.browserType
    caps.setCapability("hub", configureHost())
    caps.setCapability("applicationName", driverConfig.gridNodIdName)
    return caps
  }

  private fun configureHost(): String {
    return if (driverConfig.isRemoteDriver()) {
      "http://${driverConfig.webDriverHost}:${driverConfig.webDriverPort}/wd/hub"
    } else {
      "http://localhost:${driverConfig.webDriverPort}/wd/hub"
    }
  }
}