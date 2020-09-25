package config

abstract class DefaultWebDriverConfigFactory : WebDriverConfigProvider {
  protected abstract val webDriverConfigPath: String

  abstract override fun getWebDriverConfig(): WebDriverConfig
}