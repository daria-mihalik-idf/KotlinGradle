package config

import kotlintest.ApplicationConfig

abstract class DefaultFactory {
    abstract fun getConfig(): ApplicationConfig
}