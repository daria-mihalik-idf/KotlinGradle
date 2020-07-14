package config

import kotlintest.ApplicationConfig

class YamlFile : ConfigProvider {
    override fun getConfig(): ApplicationConfig {
        return MmConfigYamlProvider().getConfig()
    }
}