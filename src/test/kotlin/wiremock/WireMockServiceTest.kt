package wiremock

import core.wiremock.config.MockConfig
import core.wiremock.service.WireMockService
import core.wiremock.stubs.LogInCrmMockConfig
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class WireMockServiceTest : WireMockBaseTest() {
  private val wireMockService: WireMockService = WireMockService(config)

  @Test
  fun verifySelectedMockAdded() {
    val logInCrmMock: MockConfig = LogInCrmMockConfig()
    wireMockService.addStub(logInCrmMock)
    val isMockAdded = wireMockService.isStubExist(logInCrmMock)
    assertTrue(isMockAdded, "LoginCrmMock wasn't added")
  }

  @Test
  fun verifySelectedMockRemoved() {
    val logInCrmMock: MockConfig = LogInCrmMockConfig()
    wireMockService.apply {
      addStub(logInCrmMock)
      removeStub(logInCrmMock)
    }
    assertFalse(wireMockService.isStubExist(logInCrmMock), "LoginCrmMock wasn't removed")
  }
}