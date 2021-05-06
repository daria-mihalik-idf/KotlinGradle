package api

import core.config.ApplicationConfigProviderManager
import core.config.FileType
import core.context.ContextHolder
import core.http.CrmLoginService
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class ApiLoginCrm {

  val applicationConfig = ContextHolder.getDefaultContext().appConfig

  @Test
  fun checkCrmLogIn() {
    val crmApiService = CrmLoginService(applicationConfig)

    val responseStatusCode:Int = crmApiService.logInCrm("").getStatusCode()

    Assertions.assertEquals(responseStatusCode, 200, "Invalid response code")
  }
}