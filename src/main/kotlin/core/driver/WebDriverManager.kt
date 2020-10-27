package core.driver

class WebDriverManager {
  fun getManager(webDriverConfig: WebDriverConfig): WebDriverFactory {
    return when (webDriverConfig.browserType) {
      "CHROME" -> ChromeDriverFactory(webDriverConfig)
      "FIREFOX" -> FirefoxDriverFactory(webDriverConfig)
      else -> throw IllegalArgumentException("Web Driver Factory not defined for browser ${
        webDriverConfig
            .browserType
      }")
    }
  }
}