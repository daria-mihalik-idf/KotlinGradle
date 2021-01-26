package ui.crm

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import services.CrmMainService
import ui.UiBaseTest

class CrmLoginTest : UiBaseTest() {

  @Test
  fun logInCrm() {
    val validCredentials = applicationConfig.crmLoginData
    val crmMainPage = CrmMainService(applicationConfig)

    crmMainPage.crmLoginPage.openPage()
    Assertions.assertTrue(crmMainPage.crmLoginPage.isCrmLoginPageOpened(), "")

    crmMainPage.crmLoginPage.logInCrm(validCredentials)
    Assertions.assertTrue(crmMainPage.isCrmMainPageOpened(), "Crm Main Page wasn't opened")
  }
}