package core.driver

import core.configProvider.ConfigProvider
import core.config.FileType

class WebDriverConfigProviderManager {
  fun getConfig(file: FileType): WebDriverConfig {
    return when (file) {
      FileType.YAML -> {
        YamlWebDriverConfigFactory().getConfig()
      }
      else -> throw IllegalArgumentException("Incorrect file type")
    }
  }
}