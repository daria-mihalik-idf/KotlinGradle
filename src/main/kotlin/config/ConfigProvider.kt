package config

import kotlintest.ApplicationConfig

interface ConfigProvider {
    fun readConfig(): ApplicationConfig
}