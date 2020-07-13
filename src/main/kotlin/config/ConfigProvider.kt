package config
import kotlintest.ApplicationConfig

interface ConfigProvider {
    fun getConfig():ApplicationConfig
}