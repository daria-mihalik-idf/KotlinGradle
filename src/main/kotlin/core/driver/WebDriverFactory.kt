package core.driver

import org.openqa.selenium.Dimension
import org.openqa.selenium.WebDriver
import org.openqa.selenium.remote.DesiredCapabilities
import java.util.concurrent.TimeUnit

abstract class WebDriverFactory(private var webDriverConfig: WebDriverConfig) {
  abstract fun createDriver(capabilities: DesiredCapabilities): WebDriver

  fun setSystemProperties(browserPackage: String, browserPath: String) {
    System.setProperty(browserPackage, browserPath)
  }

  fun configureBrowser(driver: WebDriver) {
    driver.manage().window().size = Dimension(webDriverConfig.screenResolutionWidth,
        webDriverConfig.screenResolutionHeight)
    driver.manage().timeouts().implicitlyWait(webDriverConfig.timeouts, TimeUnit.SECONDS)
  }

  abstract fun setCapabilities(capabilityType: String, value: Boolean): DesiredCapabilities
}

