package core.driver.selenium

import core.config.FileType
import core.driver.WebDriverConfig

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