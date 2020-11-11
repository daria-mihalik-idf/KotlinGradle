package core.config

class ApplicationConfigProviderManager {
  fun getConfig(file: FileType): ApplicationConfig {
    return when (file) {
      FileType.JSON -> {
        JsonConfigFactory().getConfig()
      }
      FileType.YAML -> {
        YamlConfigFactory().getConfig()
      }
    }
  }
}