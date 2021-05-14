package core.context

import core.config.ApplicationConfig
import core.config.ApplicationConfigProviderManager
import core.config.FileType

interface Context {
  val appConfig: ApplicationConfig
  val session: SessionContext
}

class DefaultContext : Context {
  override val appConfig: ApplicationConfig = ApplicationConfigProviderManager().getConfig(FileType.YAML)
  override val session: SessionContext = SessionContext()
}