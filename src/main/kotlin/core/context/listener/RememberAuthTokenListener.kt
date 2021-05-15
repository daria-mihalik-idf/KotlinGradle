package core.context.listener

import core.context.ContextHolder
import core.http.MyResponse

class RememberAuthTokenListener : Listener {
  override fun onUpdate(value: Any) {
    ContextHolder.getDefaultContext().session.authToken = (value as MyResponse).getCookies()["AuthUser"]
  }
}