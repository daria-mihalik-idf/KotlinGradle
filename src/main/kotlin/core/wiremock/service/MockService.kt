package core.wiremock.service

import core.wiremock.config.MockConfig

interface MockService {
  fun isStubExist(mockConfig: MockConfig): Boolean
  fun addStub(mockConfig: MockConfig)
  fun removeStub(mockConfig: MockConfig)
}