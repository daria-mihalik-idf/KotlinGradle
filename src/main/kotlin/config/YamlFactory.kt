package config

import kotlintest.ApplicationConfig

class YamlFactory : DefaultFactory() {
    override fun getConfig(): ApplicationConfig {
        return MmConfigYamlProvider().readConfig()
    }
}