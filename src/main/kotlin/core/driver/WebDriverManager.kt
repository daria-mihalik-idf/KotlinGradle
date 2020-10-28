package core.driver

class WebDriverManager(private var webDriverConfig: WebDriverConfig) {

  fun getManager(): WebDriverFactory {
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