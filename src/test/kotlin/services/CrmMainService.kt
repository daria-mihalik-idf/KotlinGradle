package services

import org.junit.jupiter.api.Assertions
import ui.pages.crm.CrmMainPage

class CrmMainService {
  private val crmMainPage = CrmMainPage()

  fun verifyCrmMainPageOpened() {
    Assertions.assertTrue(crmMainPage.verifyCrmMainPageOpened(), "Crm Main Page wasn't opened")
  }
}