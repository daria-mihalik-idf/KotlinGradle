package core.context

import core.context.listener.EventManager
import core.context.listener.EventType
import core.http.MyResponse

class SessionContext(private val eventManager: EventManager) {

  var currentHttpResponse: MyResponse? = null
    set(value) {
      field = value
      if (value != null) {
        eventManager.notifyUpdate(EventType.AUTH_TOKEN, value)
      }
    }

  var authToken: String? = null
}