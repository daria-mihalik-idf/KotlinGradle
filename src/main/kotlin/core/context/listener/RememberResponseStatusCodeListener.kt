package core.context.listener

import core.context.ContextHolder
import core.http.MyResponse

class RememberResponseStatusCodeListener : Listener {
  override fun onUpdate(value: Any) {
    ContextHolder.getDefaultContext().session.responseStatusCode = (value as MyResponse).getStatusCode()
  }
}