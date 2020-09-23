package config

abstract class DefaultConfigProviderFactory : ConfigProvider {
  protected abstract val filePath: String
  protected abstract val webDriverConfigPath: String

  abstract override fun getConfig(): ApplicationConfig
  abstract fun getWebDriverConfig(): WebDriverConfig
}