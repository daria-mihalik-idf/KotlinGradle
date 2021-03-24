package core.wiremock.stubs

import com.github.tomakehurst.wiremock.stubbing.StubMapping
import core.wiremock.config.MockConfig
import java.util.*

class LogInCrmMockConfig : MockConfig {
  override var id: UUID? = null
  override val priority: Int = 1
  override val name: String = "Log in MX CRM"
  override val url: String = "/secure/rest/sign/in"
  override val responseStatusCode: Int = 200
  override val responseContentType: String = "application/json"
  override val responseBodyFilePath: String? = "config/mockResponse.json"
  override var stubMapping: StubMapping? = null
}