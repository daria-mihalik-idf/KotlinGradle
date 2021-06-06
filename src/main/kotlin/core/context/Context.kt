package core.context

import core.config.ApplicationConfig
import core.config.ApplicationConfigProviderManager
import core.config.FileType
import core.context.listener.EventManager
import core.context.listener.EventType
import core.context.listener.RememberAuthTokenListener
import core.context.listener.RememberResponseStatusCodeListener

interface Context {
  val appConfig: ApplicationConfig
  val session: SessionContext
}

class DefaultContext : Context {
  private val eventManager: EventManager = EventManager()

  init {
    eventManager.subscribe(EventType.AUTH_TOKEN, RememberAuthTokenListener())
    eventManager.subscribe(EventType.STATUS_CODE, RememberResponseStatusCodeListener())
  }

  override val appConfig: ApplicationConfig = ApplicationConfigProviderManager().getConfig(FileType.YAML)
  override val session: SessionContext = SessionContext(eventManager)
}