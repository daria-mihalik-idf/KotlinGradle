package core.driver

class WebDriverManager(private var webDriverConfig: WebDriverConfig) {

  fun getDriverFactory(): WebDriverFactory {
    return when (webDriverConfig.browserType) {
      "CHROME" -> ChromeDriverFactory(webDriverConfig)
      "FIREFOX" -> FirefoxDriverFactory(webDriverConfig)
      else -> throw IllegalArgumentException("WebDriverFactory not defined for browser ${webDriverConfig.browserType}")
    }
  }
}