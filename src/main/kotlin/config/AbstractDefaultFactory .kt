package config

import kotlintest.ApplicationConfig

abstract class AbstractDefaultFactory {
    abstract fun defineFileType(file: InputFile): ApplicationConfig
}