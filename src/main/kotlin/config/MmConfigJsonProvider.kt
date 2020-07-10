package config

import com.fasterxml.jackson.core.JsonFactory
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory
import com.fasterxml.jackson.module.kotlin.KotlinModule
import kotlintest.ApplicationConfig

class MmConfigJsonProvider : ConfigProvider {
    private val filePath: String = "config/config2.json"
    override fun getConfig(): ApplicationConfig {
        return Thread.currentThread().contextClassLoader.getResourceAsStream(filePath)?.use {
            ObjectMapper(JsonFactory())
                .registerModule(KotlinModule())
                .readValue(it, ApplicationConfig::class.java)
        } ?: throw IllegalStateException("Could not get Application Config object")
    }
}