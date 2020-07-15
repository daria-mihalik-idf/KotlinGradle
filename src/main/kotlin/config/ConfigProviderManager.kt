package config

import kotlintest.ApplicationConfig
import java.lang.UnsupportedOperationException

class ConfigProviderManager {
    fun setFileType(file: InputFile): DefaultFactory {
        return when (file) {
            InputFile.JSON -> {
                JsonFactory()
            }
            InputFile.YAML -> {
                YamlFactory()
            }
        }
    }
}