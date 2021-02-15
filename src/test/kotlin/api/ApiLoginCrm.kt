package api

import core.http.CrmApiService
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class ApiLoginCrm {
  private val crmApiService: CrmApiService = CrmApiService()

  @Test
  fun checkCrmLoginPage() {
    val response = crmApiService.getCrmLoginPage().code

    Assertions.assertEquals(response, 200, "Invalid response code")
  }

  @Test
  fun checkCrmLogIn() {
    val response = crmApiService.logInCrm().code

    Assertions.assertEquals(response, 200, "Invalid response code")
  }
}