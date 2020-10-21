package core.driver

import core.driver.WebDriverConfig

interface WebDriverConfigProvider {
  fun getWebDriverConfig(): WebDriverConfig
}