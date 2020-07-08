package config

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory
import com.fasterxml.jackson.module.kotlin.KotlinModule
import kotlintest.ApplicationConfig

interface ConfigProvider {
    fun getConfig(): ApplicationConfig
}

class MmConfigProvider : ConfigProvider {
    private val filepath: String = "config\\config.yaml"
    override fun getConfig(): ApplicationConfig {
        return Thread.currentThread().contextClassLoader.getResourceAsStream(filepath)?.use {
            ObjectMapper(YAMLFactory())
                .registerModule(KotlinModule())
                .readValue(it, ApplicationConfig::class.java)
        } ?: throw IllegalStateException("Could not get Application Config object")
    }
}
