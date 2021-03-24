package wiremock

import com.github.tomakehurst.wiremock.WireMockServer
import com.github.tomakehurst.wiremock.core.WireMockConfiguration
import core.config.ApplicationConfigProviderManager
import core.config.FileType
import logger.TestLogger
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
abstract class WireMockBaseTest {
  protected val config = ApplicationConfigProviderManager().getConfig(FileType.YAML)
  protected lateinit var wireMockServer: WireMockServer
  private val log = TestLogger.getLogger()

  @BeforeAll
  fun startWireMockServer() {
    wireMockServer = WireMockServer(WireMockConfiguration.options().port(config.wireMockConfig.wireMockPort))
    wireMockServer.start()
    log.info("WireMock server was started on ${config.wireMockConfig.wireMockPort} port")
  }

  @AfterEach
  fun removeWireMockStubs() {
    wireMockServer.resetAll()
    log.info("All WireMock stubs are removed")
  }

  @AfterAll
  fun stopWireMockServer() {
    wireMockServer.stop()
    log.info("WireMockServer was stoped")
  }
}