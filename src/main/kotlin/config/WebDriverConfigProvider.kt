package config

interface WebDriverConfigProvider {
  fun getWebDriverConfig(): WebDriverConfig
}