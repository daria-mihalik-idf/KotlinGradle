package core.driver

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory
import com.fasterxml.jackson.module.kotlin.KotlinModule
import core.configProvider.ConfigProvider

class YamlWebDriverConfigFactory : ConfigProvider {
  override val filePath: String = "config/webdriverconfig.yaml"

  override fun getConfig(): WebDriverConfig {
    return Thread.currentThread().contextClassLoader.getResourceAsStream(filePath)?.use {
      ObjectMapper(YAMLFactory())
          .registerModule(KotlinModule())
          .readValue(it, WebDriverConfig::class.java)
    } ?: throw IllegalStateException("Could not get Application Config object")
  }
}