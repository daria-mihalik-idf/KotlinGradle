package core.config

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory
import com.fasterxml.jackson.module.kotlin.KotlinModule
import core.configProvider.ConfigProvider

class YamlConfigFactory : ConfigProvider {

  override fun getConfig(): ApplicationConfig {
    return Thread.currentThread().contextClassLoader.getResourceAsStream(filePath)?.use {
      ObjectMapper(YAMLFactory())
          .registerModule(KotlinModule())
          .readValue(it, ApplicationConfig::class.java)
    } ?: throw IllegalStateException("Could not get Application Config object")
  }

  override val filePath: String = "config/config.yaml"
}