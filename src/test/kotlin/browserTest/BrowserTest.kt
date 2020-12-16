package browserTest

import com.codeborne.selenide.Selenide
import core.Browser
import core.systemProperties.CustomSystemProperties
import core.configProvider.WebDriverConfigProvider
import core.driver.WebDriverConfig
import org.junit.jupiter.api.*

class BrowserTest {

  private lateinit var webDriverConfig: WebDriverConfig
  private val headlessMode = "true"
  private val browserType = Browser.FIREFOX
  private val webDriverHost = "192.168.100.39"
  private val webDriverPort = "4444"
  private val webDriverType = "LOCAL"
  private val chromeVersion = "87.0.4280.20"

  @BeforeEach
  fun init() {
    webDriverConfig = WebDriverConfigProvider().getWebDriverConfig()
  }

  @AfterEach
  fun clearProperty() {
    CustomSystemProperties.BROWSER_HEADLESS.clear()
    CustomSystemProperties.BROWSER_TYPE.clear()
    CustomSystemProperties.WEBDRIVER_HOST.clear()
    CustomSystemProperties.WEBDRIVER_PORT.clear()
    CustomSystemProperties.CHROME_BROWSER.clear()
    CustomSystemProperties.WEBDRIVER_TYPE.clear()

    Selenide.closeWebDriver()
  }

  @Test
  fun checkCustomSystemPropertiesWork() {
    CustomSystemProperties.BROWSER_HEADLESS.set(headlessMode)
    CustomSystemProperties.BROWSER_TYPE.set(browserType.browserName)
    CustomSystemProperties.WEBDRIVER_HOST.set(webDriverHost)
    CustomSystemProperties.WEBDRIVER_PORT.set(webDriverPort)
    CustomSystemProperties.CHROME_BROWSER.set(chromeVersion)
    CustomSystemProperties.WEBDRIVER_TYPE.set(webDriverType)

    assertAll(
        {
          Assertions.assertEquals(headlessMode.toBoolean(), webDriverConfig.headlessMode)
        },
        {
          Assertions.assertEquals(browserType, webDriverConfig.browserType)
        },
        {
          Assertions.assertEquals(webDriverHost, webDriverConfig.webDriverHost)
        },
        {
          Assertions.assertEquals(webDriverPort, webDriverConfig.webDriverPort)
        },
        {
          Assertions.assertEquals(chromeVersion, webDriverConfig.chromeVersion)
        }
    )
  }
}