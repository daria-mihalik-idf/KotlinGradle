package ui.crm

import core.CrmUser
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import services.CrmMainService
import ui.UiBaseTest

class CrmLoginTest : UiBaseTest() {

  @Test
  fun logInCrm() {
    val validCredentials = CrmUser(applicationConfig.crmLoginMail, applicationConfig.crmLoginPassword, applicationConfig
        .crmCaptchaValue)
    val crmMainService = CrmMainService(applicationConfig)

    crmMainService.crmLoginPage.openPage()
    Assertions.assertTrue(crmMainService.crmLoginPage.isOpened(), "")

    crmMainService.crmLoginPage.logInCrm(validCredentials)
    Assertions.assertTrue(crmMainService.isCrmMainPageOpened(), "Crm Main Page wasn't opened")
  }
}

