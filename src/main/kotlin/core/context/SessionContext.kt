package core.context

import core.http.MyResponse

class SessionContext {

  val currentHttpResponse: MyResponse? = null

  var authUserCookie: AuthUserCookie = AuthUserCookie()
}