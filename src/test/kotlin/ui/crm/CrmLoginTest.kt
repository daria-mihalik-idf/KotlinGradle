package ui.crm

import core.CrmUser
import org.junit.jupiter.api.Test
import services.CrmLoginService
import services.CrmMainService
import ui.UiBaseTest

class CrmLoginTest : UiBaseTest() {

  @Test
  fun logInCrm() {
    val validCredentials: CrmUser = applicationConfig.crmLoginData
    val crmMainService = CrmMainService()
    val crmLoginService = CrmLoginService(applicationConfig)

    crmLoginService.apply {
      openCrmLoginPage()
      verifyCrmLoginPageOpened()
      logInCrm(validCredentials)
    }

    crmMainService.verifyCrmMainPageOpened()
  }
}