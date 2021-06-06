package core.context

import core.context.listener.EventManager
import core.context.listener.EventType
import core.http.MyResponse

class SessionContext(private val eventManager: EventManager) {

  var currentHttpResponse: MyResponse? = null
    set(value) {
      field = value
      value?.let {
        eventManager.apply {
          notifyUpdate(EventType.AUTH_TOKEN, it)
          notifyUpdate(EventType.STATUS_CODE, it)
        }
      }
    }

  var authToken: String? = null
  var responseStatusCode: Int? = null
}