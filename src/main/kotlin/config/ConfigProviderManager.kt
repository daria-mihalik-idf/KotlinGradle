package config

class ConfigProviderManager {
    fun setFileType(file: InputFile): DefaultFactory {
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