package config

class ConfigProviderManager {
    fun setFileType(file: InputFile): DefaultConfigProviderFactory {
        return when (file) {
            InputFile.JSON -> {
                JsonConfigFactory()
            }
            InputFile.YAML -> {
                YamlConfigFactory()
            }
        }
    }
}