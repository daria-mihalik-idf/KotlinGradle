package ui

import config.*
import core.Browser
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.openqa.selenium.Dimension
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.firefox.FirefoxDriver
import java.util.concurrent.TimeUnit

abstract class UiBaseTest {
  lateinit var driver: WebDriver
  lateinit var applicationConfig: ApplicationConfig
  private lateinit var webDriverConfig: WebDriverConfig

  @BeforeEach
  fun init() {
    webDriverConfig = WebDriverConfigProviderManager().setFileType(FileType.YAML).getWebDriverConfig()
  }

  fun selectBrowser(browser: Browser) {
    when (browser) {
      Browser.FIREFOX -> {
        driver = FirefoxDriver()
        System.setProperty("webdriver.gecko.driver", "C:\\SeleniumDriver\\geckodriver.exe")
      }
      Browser.CHROME -> {
        driver = ChromeDriver()
        System.setProperty("webdriver.chrome.driver", "C:\\SeleniumDriver\\chromedriver.exe")
      }
      else -> {
        throw IllegalArgumentException("incorrect browser type")
      }
    }
    driver.manage().window().size = Dimension(webDriverConfig.screenResolutionWidth,
        webDriverConfig.screenResolutionHeight)
    driver.manage().timeouts().implicitlyWait(webDriverConfig.timeouts, TimeUnit.SECONDS)
    applicationConfig = ConfigProviderManager().setFileType(FileType.YAML).getConfig()
    driver.get(applicationConfig.getBaseUrlWithAuthorization())
  }

  @AfterEach
  fun quitSession() {
    driver.quit()
  }
}