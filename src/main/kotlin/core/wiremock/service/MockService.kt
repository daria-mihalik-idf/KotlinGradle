package core.wiremock.service

import core.wiremock.config.MockConfig

interface MockService {
  fun verifyMock(mockConfig: MockConfig): Boolean
  fun addStub(mockConfig: MockConfig)
  fun removeStub(mockConfig: MockConfig)
}