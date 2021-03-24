package core.wiremock.config

import com.github.tomakehurst.wiremock.stubbing.StubMapping
import java.util.*

interface MockConfig {
  var id: UUID?
  val priority: Int
  val name: String
  val url: String
  val responseStatusCode: Int
  val responseContentType: String
  val responseBodyFilePath: String?
  var stubMapping: StubMapping?
}