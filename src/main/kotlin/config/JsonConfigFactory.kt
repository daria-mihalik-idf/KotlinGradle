package config

import kotlintest.ApplicationConfig

class JsonConfigFactory : DefaultFactory() {
    override fun getConfig(): ApplicationConfig {
        return MmConfigJsonProvider().readConfig()
    }
}