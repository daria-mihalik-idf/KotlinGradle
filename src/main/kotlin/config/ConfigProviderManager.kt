package config

class ConfigProviderManager {
    fun setFileType(file: FileType): DefaultConfigProviderFactory {
        return when (file) {
            FileType.JSON -> {
                JsonConfigFactory()
            }
            FileType.YAML -> {
                YamlConfigFactory()
            }
        }
    }
}