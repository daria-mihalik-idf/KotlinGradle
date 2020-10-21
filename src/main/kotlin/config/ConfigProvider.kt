package config

interface ConfigProvider {
  fun getConfig(value: String): ApplicationConfig
}