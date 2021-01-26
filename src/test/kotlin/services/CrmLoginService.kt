package services

import core.CrmUser
import core.config.ApplicationConfig
import ui.pages.crm.CrmLoginPage

class CrmLoginService(applicationConfig: ApplicationConfig) {
  private val crmLoginPage = CrmLoginPage(applicationConfig)

  fun openCrmLoginPage() {
    crmLoginPage.openPage()
  }

  fun isCrmLoginPageOpened(): Boolean {
    return crmLoginPage.isCrmLoginPageOpened()
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