package context

import core.context.ContextHolder
import core.http.MyResponse
import core.http.RegistrationService
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class GetRegistrationResponseStatusCodeTest {
  val applicationConfig = ContextHolder.getDefaultContext().appConfig

  @Test
  fun checkRegistrationOpen() {
    val registrationService = RegistrationService(applicationConfig)
    val response: MyResponse = registrationService.registrationGet(applicationConfig.getBaseUrl())
    ContextHolder.getDefaultContext().session.currentHttpResponse = response

    val expectedResponseStatusCode = response.getStatusCode()
    val actualResponseStatusCode = ContextHolder.getDefaultContext().session.responseStatusCode

    Assertions.assertEquals(expectedResponseStatusCode, actualResponseStatusCode, "Invalid status code")
  }
}
