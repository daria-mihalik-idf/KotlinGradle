package config

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory
import com.fasterxml.jackson.module.kotlin.KotlinModule

class YamlConfigFactory : DefaultConfigProviderFactory() {

  override fun getConfig(value: String): ApplicationConfig {
    return Thread.currentThread().contextClassLoader.getResourceAsStream(value)?.use {
      ObjectMapper(YAMLFactory())
          .registerModule(KotlinModule())
          .readValue(it, ApplicationConfig::class.java)
    } ?: throw IllegalStateException("Could not get Application Config object")
  }
}
