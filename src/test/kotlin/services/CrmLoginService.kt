package services

import core.CrmUser
import core.config.ApplicationConfig
import org.junit.jupiter.api.Assertions
import ui.pages.crm.CrmLoginPage

class CrmLoginService(applicationConfig: ApplicationConfig) {
  private val crmLoginPage = CrmLoginPage(applicationConfig)

  fun openCrmLoginPage() {
    crmLoginPage.openPage()
  }

  fun verifyCrmLoginPageOpened() {
    Assertions.assertTrue(crmLoginPage.verifyCrmLoginPageOpened(), "Crm login page wasn't opened")
  }

  fun logInCrm(crmUser: CrmUser) {
    crmLoginPage.apply {
      fillInputLogin(crmUser.crmLoginMail)
      fillInputPassword(crmUser.crmLoginPassword)
      fillCaptchaDefaultValue(crmUser.crmCaptchaValue)
      clickOnSubmitButton()
    }
  }
}