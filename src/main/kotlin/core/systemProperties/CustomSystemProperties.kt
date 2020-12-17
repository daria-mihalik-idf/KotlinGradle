package core.systemProperties

enum class CustomSystemProperties(private val value: String) : SystemProperties {
  CHROME_BROWSER("webdriver.browser.chrome"),
  FIREFOX_BROWSER("webdriver.browser.firefox"),
  BROWSER_TYPE("webdriver.browser.name"),
  BROWSER_HEADLESS("webdriver.browser.headless"),
  WEBDRIVER_TYPE("webdriver.type"),
  WEBDRIVER_PORT("webdriver.port"),
  WEBDRIVER_HOST("webdriver.host");

  override fun getName(): String = this.value
}