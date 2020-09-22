package config

abstract class DefaultConfigProviderFactory : ConfigProvider {
  abstract override fun getConfig(): ApplicationConfig
  protected abstract val filePath: String
}