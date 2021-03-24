package wiremock

import core.http.CrmLoginService
import core.wiremock.config.MockConfig
import core.wiremock.service.WireMockService
import core.wiremock.stubs.LogInCrmMockConfig
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

class WireMockHttpClientTest : WireMockBaseTest() {
  private val wireMockService: WireMockService = WireMockService(config)

  @Test
  fun getCrmLoginResponseFromStub() {
    val logInCrmMock: MockConfig = LogInCrmMockConfig()
    wireMockService.addStub(logInCrmMock)

    val crmLoginResponse = CrmLoginService(config).logInCrm(
        "http://${config.wireMockConfig.wireMockHost}:${config.wireMockConfig.wireMockPort}",
        logInCrmMock.url)

    assertAll(
        { Assertions.assertEquals(logInCrmMock.responseStatusCode, crmLoginResponse.response.code) },
//        { Assertions.assertEquals(logInCrmMock.stubMapping?.response?.body, crmLoginResponse) }
    )
  }
}