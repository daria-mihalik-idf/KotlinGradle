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
    private val stubBuilder: StubBuilder = StubBuilder(),
    private val wireMockClient: WireMock = WireMock(
        config.wireMockConfig.wireMockHost,
        config.wireMockConfig
        .wireMockPort)
) : MockService {
  private val log = TestLogger.getLogger()

  override fun isStubExist(mockConfig: MockConfig): Boolean {
    val actualWireMockStubs = wireMockClient.allStubMappings().mappings.map { it.id }
    return actualWireMockStubs.contains(mockConfig.id)
  }

  override fun addStub(mockConfig: MockConfig) {
    if (!isStubExist(mockConfig)) {
      val mapping: MappingBuilder = stubBuilder.getStubMapping(mockConfig)
      val stubMapping: StubMapping = wireMockClient.register(mapping)
      mockConfig.apply {
        id = stubMapping.id
      }
    } else {
      log.error("Mock ${mockConfig.name}/${mockConfig.id} was already configured")
    }
  }

  override fun removeStub(mockConfig: MockConfig) {
    wireMockClient.removeStubMapping(mockConfig.stubMapping)
    assert(!isStubExist(mockConfig)) {
      "Removing ${mockConfig.name} failed"
    }
    log.info("Removing ${mockConfig.name}} failed")
  }
}