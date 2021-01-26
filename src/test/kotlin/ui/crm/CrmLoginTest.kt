package ui.crm

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import services.CrmMainService
import ui.UiBaseTest

class CrmLoginTest : UiBaseTest() {

  @Test
  fun logInCrm() {
    val validCredentials = applicationConfig.crmLoginData
    val crmMainService = CrmMainService(applicationConfig)


    crmMainService.crmLoginService.openCrmLoginPage()
    Assertions.assertTrue(crmMainService.crmLoginService.isCrmLoginPageOpened(), "")

    crmMainService.crmLoginService.logInCrm(validCredentials)
    Assertions.assertTrue(crmMainService.isCrmMainPageOpened(), "Crm Main Page wasn't opened")
  }
}