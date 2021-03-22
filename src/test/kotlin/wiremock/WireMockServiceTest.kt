package wiremock

import core.wiremock.service.WireMockService
import core.wiremock.stubs.LogInCrmMockConfig
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class WireMockServiceTest : WireMockBaseTest() {
  private val wireMockService: WireMockService = WireMockService(config)

  @Test
  fun verifySelectedMockAdded() {
    val logInCrmMock: LogInCrmMockConfig = LogInCrmMockConfig()
    wireMockService.addStub(logInCrmMock)
    val isMockAdded = wireMockService.verifyMock(logInCrmMock)
    assertTrue(isMockAdded, "LoginCrmMock wasn't added")
  }

  @Test
  fun verifySelectedMockRemoved() {
    val logInCrmMock: LogInCrmMockConfig = LogInCrmMockConfig()
    wireMockService.apply {
      addStub(logInCrmMock)
      removeStub(logInCrmMock)
    }
    assertFalse(wireMockService.verifyMock(logInCrmMock), "LoginCrmMock wasn't removed")
  }
}