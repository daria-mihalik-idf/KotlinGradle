package config

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory
import com.fasterxml.jackson.module.kotlin.KotlinModule

class YamlConfigFactory : DefaultConfigProviderFactory() {
  override val filePath: String = "config/config.yaml"
  override val webDriverConfigPath: String = "config/webdriverconfig.yaml"

  override fun getWebDriverConfig(): WebDriverConfig {
    return Thread.currentThread().contextClassLoader.getResourceAsStream(webDriverConfigPath)?.use {
      ObjectMapper(YAMLFactory())
          .registerModule(KotlinModule())
          .readValue(it, WebDriverConfig::class.java)
    } ?: throw IllegalStateException("Could not get Application Config object")
  }

  override fun getConfig(): ApplicationConfig {
    return Thread.currentThread().contextClassLoader.getResourceAsStream(filePath)?.use {
      ObjectMapper(YAMLFactory())
          .registerModule(KotlinModule())
          .readValue(it, ApplicationConfig::class.java)
    } ?: throw IllegalStateException("Could not get Application Config object")
  }
}
