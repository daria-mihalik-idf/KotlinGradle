package core.context.listener

import core.context.ContextHolder
import core.http.MyResponse

interface RegistrationServiceListener {
  fun onOpenRegistration(response: MyResponse)
}

class RememberAuthTokenListener : RegistrationServiceListener {
  override fun onOpenRegistration(response: MyResponse) {
    ContextHolder.getDefaultContext().session.authToken = response.getCookies()["AuthUser"]
  }
}