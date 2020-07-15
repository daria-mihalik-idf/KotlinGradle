package config

import kotlintest.ApplicationConfig

class YamlConfigFactory : DefaultFactory() {
    override fun getConfig(): ApplicationConfig {
        return MmConfigYamlProvider().readConfig()
    }
}