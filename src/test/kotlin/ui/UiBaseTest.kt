package ui

import core.config.ApplicationConfig
import core.config.ApplicationConfigProviderManager
import core.config.FileType
import core.driver.WebDriverConfig
import core.driver.WebDriverConfigProviderManager
import core.driver.WebDriverManager
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.openqa.selenium.WebDriver

abstract class UiBaseTest {
  lateinit var driver: WebDriver
  lateinit var applicationConfig: ApplicationConfig
  private lateinit var webDriverConfig: WebDriverConfig

  @BeforeEach
  fun init() {
    webDriverConfig = WebDriverConfigProviderManager().getConfig(FileType.YAML)
    WebDriverManager.setConfig(webDriverConfig)
    driver = WebDriverManager.getWebDriver()
  }

  fun selectBrowser() {
    applicationConfig = ApplicationConfigProviderManager().getConfig(FileType.YAML)
    driver.get(applicationConfig.getBaseUrlWithAuthorization())
  }

  @AfterEach
  fun quitSession() {
    WebDriverManager.removeDriver()
  }
}