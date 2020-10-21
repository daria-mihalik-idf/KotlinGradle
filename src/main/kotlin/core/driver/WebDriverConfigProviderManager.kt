package core.driver

import config.FileType

class WebDriverConfigProviderManager {
  fun setFileType(file: FileType): DefaultWebDriverConfigFactory {
    return when (file) {
      FileType.YAML -> {
        YamlWebDriverConfigFactory()
      }
      else -> throw IllegalArgumentException("Incorrect file type")
    }
  }
}