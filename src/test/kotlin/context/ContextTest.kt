package context

import core.context.ContextHolder
import core.context.listener.RememberAuthTokenListener
import core.http.MyResponse
import core.http.RegistrationService
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class ContextTest {

  val applicationConfig = ContextHolder.getDefaultContext().appConfig

  @Test
  fun checkRegistrationOpen() {
    val registrationService = RegistrationService(applicationConfig, listOf(RememberAuthTokenListener()))
    val response: MyResponse = registrationService.registrationGet(applicationConfig.getBaseUrl())
    ContextHolder.getDefaultContext().session.currentHttpResponse = response
    val expectedAuthUserCookie = response.getCookies()["AuthUser"]
    val actualAuthUserCookie = ContextHolder.getDefaultContext().session.authToken

    Assertions.assertEquals(expectedAuthUserCookie, actualAuthUserCookie, "Invalid authUser cookie")
  }
}