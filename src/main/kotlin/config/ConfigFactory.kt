package config

import kotlintest.ApplicationConfig
import java.lang.UnsupportedOperationException

class ConfigFactory : AbstractDefaultFactory() {
    override fun defineFileType(file: InputFile): ApplicationConfig {
        return when (file) {
            InputFile.JSON -> {
                JsonFile().getConfig()
            }
            InputFile.YAML -> {
                YamlFile().getConfig()
            }
            else -> throw UnsupportedOperationException("Incorrect input file type")
        }
    }
}