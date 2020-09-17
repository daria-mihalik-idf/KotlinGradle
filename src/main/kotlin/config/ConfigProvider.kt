package config


interface ConfigProvider {
    fun getConfig(): ApplicationConfig
}