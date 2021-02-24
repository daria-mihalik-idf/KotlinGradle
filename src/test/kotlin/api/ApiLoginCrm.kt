package api

import core.config.ApplicationConfigProviderManager
import core.config.FileType
import core.http.CrmLoginService
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class ApiLoginCrm {

  val applicationConfig = ApplicationConfigProviderManager().getConfig(FileType.YAML)

  @Test
  fun checkCrmLogIn() {
    val crmApiService: CrmLoginService = CrmLoginService(applicationConfig)

    val responseStatusCode:Int = crmApiService.logInCrm().getStatusCode()

    Assertions.assertEquals(responseStatusCode, 200, "Invalid response code")
  }
}