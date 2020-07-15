package config

import kotlintest.ApplicationConfig

class JsonFactory : DefaultFactory() {
    override fun getConfig(): ApplicationConfig {
        return MmConfigJsonProvider().readConfig()
    }
}