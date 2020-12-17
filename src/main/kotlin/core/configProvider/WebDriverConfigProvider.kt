package core.configProvider

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory
import com.fasterxml.jackson.module.kotlin.KotlinModule
import core.Browser
import core.systemProperties.CustomSystemProperties
import core.driver.WebDriverConfig

class WebDriverConfigProvider {
  private val filePath: String = "config/webdriverconfig.yaml"

  private val webDriverConfig: WebDriverConfig = Thread.currentThread().contextClassLoader.getResourceAsStream(filePath)
      ?.use {
        ObjectMapper(YAMLFactory())
            .registerModule(KotlinModule())
            .readValue(it, WebDriverConfig::class.java)
      } ?: throw IllegalStateException("Could not get WebDriverConfig object")

  fun getWebDriverConfig(): WebDriverConfig {
    return webDriverConfig.apply {
      chromeVersion = CustomSystemProperties.CHROME_BROWSER.getDefault(webDriverConfig.chromeVersion)
      firefoxVersion = CustomSystemProperties.FIREFOX_BROWSER.getDefault(webDriverConfig.firefoxVersion)
      headlessMode = CustomSystemProperties.BROWSER_HEADLESS.getDefault(webDriverConfig.headlessMode.toString())
          .toBoolean()
      browserType = getBrowserNameConfig()
      webDriverHost = CustomSystemProperties.WEBDRIVER_HOST.getDefault(webDriverConfig.webDriverHost)
      webDriverPort = CustomSystemProperties.WEBDRIVER_PORT.getDefault(webDriverConfig.webDriverPort)
    }
  }

  private fun getBrowserNameConfig(): Browser {
    val browserName: String? = CustomSystemProperties.BROWSER_TYPE.get()
    return when {
      browserName.isNullOrEmpty() -> webDriverConfig.browserType
      else -> Browser.valueOf(browserName.toUpperCase())
    }
  }
}