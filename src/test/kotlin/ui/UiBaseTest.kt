package ui

import config.*
import core.driver.WebDriverConfig
import core.driver.WebDriverConfigProviderManager
import core.driver.WebDriverFactory
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.openqa.selenium.Dimension
import org.openqa.selenium.WebDriver
import java.util.concurrent.TimeUnit

abstract class UiBaseTest {
  lateinit var driver: WebDriver
  lateinit var applicationConfig: ApplicationConfig
  private lateinit var webDriverConfig: WebDriverConfig
  private val filePath: String = "config/config.yaml"

  @BeforeEach
  fun init() {
    webDriverConfig = WebDriverConfigProviderManager().setFileType(FileType.YAML).getWebDriverConfig()
    driver = WebDriverFactory(webDriverConfig).getDriver()
  }

  fun selectBrowser() {
    driver.manage().window().size = Dimension(webDriverConfig.screenResolutionWidth,
        webDriverConfig.screenResolutionHeight)
    driver.manage().timeouts().implicitlyWait(webDriverConfig.timeouts, TimeUnit.SECONDS)
    applicationConfig = ConfigProviderManager().setFileType(FileType.YAML).getConfig(filePath)
    driver.get(applicationConfig.getBaseUrlWithAuthorization())
  }

  @AfterEach
  fun quitSession() {
    driver.quit()
  }
}