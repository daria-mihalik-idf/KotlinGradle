package ui

import com.codeborne.selenide.Selenide
import com.codeborne.selenide.WebDriverRunner
import core.config.ApplicationConfig
import core.config.ApplicationConfigProviderManager
import core.config.FileType
import core.driver.WebDriverConfig
import core.driver.WebDriverConfigProviderManager
import core.driver.selenide.SelenideDriverManager
import core.driver.selenium.WebDriverManager
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
    SelenideDriverManager.getDriverFactory(webDriverConfig).configDriver()
    selectBrowser()
  }

  private fun selectBrowser() {
    applicationConfig = ApplicationConfigProviderManager().getConfig(FileType.YAML)
    Selenide.open(applicationConfig.getBaseUrlWithAuthorization())
    driver = WebDriverRunner.getWebDriver()
  }

  @AfterEach
  fun quitSession() {
    WebDriverManager.removeDriver()
  }
}