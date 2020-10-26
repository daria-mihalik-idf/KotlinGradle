package core.driver

class WebDriverManagerFactory {
  fun getManager(webDriverConfig: WebDriverConfig): WebDriverManager {
    return when (webDriverConfig.browserType) {
      "CHROME" -> ChromeDriverManager()
      "FIREFOX" -> FirefoxDriverManager()
      else -> throw IllegalArgumentException("No needed browsers")
    }
  }
}