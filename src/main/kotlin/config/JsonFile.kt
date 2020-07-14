package config

import kotlintest.ApplicationConfig

class JsonFile : ConfigProvider {
    override fun getConfig(): ApplicationConfig {
        return MmConfigJsonProvider().getConfig()
    }
}