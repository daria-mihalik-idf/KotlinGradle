package context

import core.context.Context
import core.context.ContextHolder
import core.http.CrmLoginService
import org.junit.jupiter.api.Test

class ContextTest {

  private lateinit var testDynamicContext: Context
  private lateinit var authUserCookieName: String

  val applicationConfig = ContextHolder.getDefaultContext().appConfig

  @Test
  fun setSessionCookiesPropertyUpdatesNotifiersList() {
    val expectedAuthUserValue = "qwerty"
    val expectedFrontEndExperimentValue = "12345"

    val crmApiService = CrmLoginService(applicationConfig)
    val kkk = crmApiService.logInCrm()
    println("")
  }
}