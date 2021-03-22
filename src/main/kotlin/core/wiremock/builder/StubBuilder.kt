package core.wiremock.builder

import com.github.tomakehurst.wiremock.client.MappingBuilder
import com.github.tomakehurst.wiremock.client.ResponseDefinitionBuilder
import com.github.tomakehurst.wiremock.client.WireMock
import core.wiremock.config.MockConfig

class StubBuilder {
  private val filePath: String = "config/mockResponse.json"

  fun getStub(mockConfig: MockConfig): MappingBuilder {
    val mappingBuilder: MappingBuilder = WireMock
        .any(WireMock.urlMatching(mockConfig.url))
        .atPriority(mockConfig.priority)
        .withName(mockConfig.name)
    val responseDefinitionBuilder = buildResponseDefinition(mockConfig)
    return mappingBuilder.willReturn(responseDefinitionBuilder)
  }

  private fun buildResponseDefinition(mockConfig: MockConfig): ResponseDefinitionBuilder {

    val responseDefinitionBuilder: ResponseDefinitionBuilder = WireMock.aResponse()
    responseDefinitionBuilder
        .withBody(convertFileToString())
        .withStatus(mockConfig.responseStatusCode)
        .withHeader("content-type", mockConfig.responseContentType)
    return responseDefinitionBuilder
  }

  private fun convertFileToString(): String? {
    return Thread.currentThread().contextClassLoader.getResourceAsStream(this.filePath)?.readBytes()
        ?.toString(Charsets.UTF_8)
  }
}