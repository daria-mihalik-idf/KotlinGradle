package core.wiremock.service

import com.github.tomakehurst.wiremock.client.MappingBuilder
import com.github.tomakehurst.wiremock.client.WireMock
import com.github.tomakehurst.wiremock.stubbing.StubMapping
import core.config.ApplicationConfig
import core.wiremock.builder.StubBuilder
import core.wiremock.config.MockConfig
import logger.TestLogger

class WireMockService(
    config: ApplicationConfig,
    private val stubBuilder: StubBuilder = StubBuilder()
) : MockService {

  private val log = TestLogger.getLogger()
  private val wireMockConfig = config.wireMockConfig
  private val wireMockClient: WireMock = WireMock(wireMockConfig.wireMockHost, wireMockConfig.wireMockPort)

  override fun verifyMock(mockConfig: MockConfig): Boolean {
    val actualWireMockStubs = wireMockClient.allStubMappings().mappings.map { it.id }
    return actualWireMockStubs.contains(mockConfig.id)
  }

  override fun addStub(mockConfig: MockConfig) {
    if (!verifyMock(mockConfig)) {
      val mapping: MappingBuilder = stubBuilder.getStub(mockConfig)
      val stubMapping: StubMapping = wireMockClient.register(mapping)
      mockConfig.id = stubMapping.id
      mockConfig.stubMapping = stubMapping
    } else {
      log.error("Mock ${mockConfig.name}/${mockConfig.id} was already configured")
    }
  }

  override fun removeStub(mockConfig: MockConfig) {
    wireMockClient.removeStubMapping(mockConfig.stubMapping)
    assert(!verifyMock(mockConfig)) {
      "Removing ${mockConfig.name}} was failed"
    }
    log.info("Mock ${mockConfig.name}} is removed")
  }
}