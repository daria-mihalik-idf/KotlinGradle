package core.driver

import core.driver.WebDriverConfig
import core.driver.WebDriverConfigProvider

abstract class DefaultWebDriverConfigFactory : WebDriverConfigProvider {
  protected abstract val webDriverConfigPath: String

  abstract override fun getWebDriverConfig(): WebDriverConfig
}