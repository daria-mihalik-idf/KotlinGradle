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

    val response = crmApiService.logInCrm().getStatusCode()

    Assertions.assertEquals(response, 200, "Invalid response code")
  }
}