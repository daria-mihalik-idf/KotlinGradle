package ui

import config.*
import core.driver.WebDriverConfig
import core.driver.WebDriverConfigProviderManager
import core.driver.WebDriverFactory
import core.driver.WebDriverManager
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.openqa.selenium.WebDriver
import org.openqa.selenium.remote.DesiredCapabilities

abstract class UiBaseTest {
  lateinit var driver: WebDriver
  lateinit var applicationConfig: ApplicationConfig
  private lateinit var webDriverConfig: WebDriverConfig
  private val filePath: String = "config/config.yaml"
  private lateinit var capabilities: DesiredCapabilities
  private lateinit var webDriverFactory: WebDriverFactory

  @BeforeEach
  fun init() {
    webDriverConfig = WebDriverConfigProviderManager().setFileType(FileType.YAML).getWebDriverConfig()
    driver = WebDriverManager(webDriverConfig).getDriverFactory().getDriver()
  }

  fun selectBrowser() {
    applicationConfig = ConfigProviderManager().setFileType(FileType.YAML).getConfig(filePath)
    driver.get(applicationConfig.getBaseUrlWithAuthorization())
  }

  @AfterEach
  fun quitSession() {
    driver.quit()
  }
}