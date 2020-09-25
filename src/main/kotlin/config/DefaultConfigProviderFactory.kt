package config

abstract class DefaultConfigProviderFactory : ConfigProvider {
  protected abstract val filePath: String

  abstract override fun getConfig(): ApplicationConfig
}