package ui

import com.codeborne.selenide.Selenide
import core.config.ApplicationConfig
import core.config.ApplicationConfigProviderManager
import core.config.FileType
import core.driver.WebDriverConfig
import core.driver.WebDriverConfigProviderManager
import core.driver.selenide.SelenideDriverManager
import core.driver.selenium.WebDriverManager
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.BeforeEach

abstract class UiBaseTest {
  lateinit var applicationConfig: ApplicationConfig
  private lateinit var webDriverConfig: WebDriverConfig

  @BeforeAll
  fun configureUrl() {
    applicationConfig = ApplicationConfigProviderManager().getConfig(FileType.YAML)
  }

  @BeforeEach
  fun init() {
    webDriverConfig = WebDriverConfigProviderManager().getConfig(FileType.YAML)
    SelenideDriverManager.getDriverFactory(webDriverConfig).configDriver()
    Selenide.open(applicationConfig.getBaseUrlWithAuthorization())
  }

  @AfterEach
  fun quitSession() {
    WebDriverManager.removeDriver()
  }
}