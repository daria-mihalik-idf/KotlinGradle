package api

import core.context.ContextHolder
import core.http.MyResponse
import core.http.RegistrationService
import core.context.listener.RememberAuthTokenListener
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class ContextTest {

  val applicationConfig = ContextHolder.getDefaultContext().appConfig

  @Test
  fun checkCrmLogIn() {
    val registrationService = RegistrationService(applicationConfig, listOf(RememberAuthTokenListener()))
    val response: MyResponse = registrationService.openRegistration(applicationConfig.getBaseUrl())
    val authUserCookie = response.getCookies()["AuthUser"]
    val actualAuthUserCookie = ContextHolder.getDefaultContext().session.authToken

    Assertions.assertEquals(authUserCookie, actualAuthUserCookie, "Invalid response code")
  }
}