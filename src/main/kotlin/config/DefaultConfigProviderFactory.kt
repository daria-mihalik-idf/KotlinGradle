package config

abstract class DefaultConfigProviderFactory : ConfigProvider {
  abstract override fun getConfig(value: String): ApplicationConfig
}