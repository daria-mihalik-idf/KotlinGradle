package config

import com.fasterxml.jackson.core.JsonFactory
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule

class JsonConfigFactory : DefaultConfigProviderFactory() {

  override fun getConfig(value: String): ApplicationConfig {
    return Thread.currentThread().contextClassLoader.getResourceAsStream(value)?.use {
      ObjectMapper(JsonFactory())
          .registerModule(KotlinModule())
          .readValue(it, ApplicationConfig::class.java)
    } ?: throw IllegalStateException("Could not get Application Config object")
  }
}