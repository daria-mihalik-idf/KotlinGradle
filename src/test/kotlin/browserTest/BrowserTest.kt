package browserTest

import core.Browser
import core.systemProperties.CustomSystemProperties
import core.configProvider.WebDriverConfigProvider
import core.driver.WebDriverConfig
import core.driver.selenium.WebDriverManager
import org.junit.jupiter.api.*

class BrowserTest {

  private lateinit var webDriverConfig: WebDriverConfig
  private val headlessMode = "true"
  private val browserType = Browser.FIREFOX
  private val webDriverHost = "192.168.100.39"
  private val webDriverPort = "4444"

  //  private val driverType = "LOCAL"
  private val chromeVersion = "87.0.4280.20"

  @BeforeEach
  fun init() {
    webDriverConfig = WebDriverConfigProvider().getWebDriverConfig()
  }

  @AfterEach
  fun quitSession() {
    WebDriverManager.removeDriver()
  }

  @Test
  fun checkCustomSystemPropertiesWork() {

    CustomSystemProperties.BROWSER_HEADLESS.set(headlessMode)
    CustomSystemProperties.BROWSER_TYPE.set(browserType.browserName)
    CustomSystemProperties.WEBDRIVER_HOST.set(webDriverHost)
    CustomSystemProperties.WEBDRIVER_PORT.set(webDriverPort)
    CustomSystemProperties.CHROME_BROWSER.set(chromeVersion)

    webDriverConfig = WebDriverConfigProvider().getWebDriverConfig()

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