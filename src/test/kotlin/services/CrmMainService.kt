package services

import core.config.ApplicationConfig
import ui.pages.crm.CrmMainPage

class CrmMainService(applicationConfig: ApplicationConfig) {
  private val crmMainPage = CrmMainPage()
  val crmLoginPage = CrmLoginService(applicationConfig)

  fun isCrmMainPageOpened(): Boolean {
    return crmMainPage.isCrmMainPageOpened()
  }
}