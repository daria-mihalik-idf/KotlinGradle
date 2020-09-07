package config

import com.fasterxml.jackson.core.JsonFactory
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule

class JsonConfigFactory : DefaultConfigProviderFactory() {
   override val filePath = "config/config2.json"

    override fun getConfig(): ApplicationConfig {
        return Thread.currentThread().contextClassLoader.getResourceAsStream(filePath)?.use {
            ObjectMapper(JsonFactory())
                .registerModule(KotlinModule())
                .readValue(it, ApplicationConfig::class.java)
        } ?: throw IllegalStateException("Could not get Application Config object")
    }
}