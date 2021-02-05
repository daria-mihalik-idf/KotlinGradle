package services

import org.junit.jupiter.api.Assertions
import ui.pages.crm.CrmHomePage

class CrmHomeService {
  private val crmHomePage = CrmHomePage()

  fun verifyCrmHomePageOpened() {
    Assertions.assertTrue(crmHomePage.verifyCrmHomePageOpened(), "Crm Main Page wasn't opened")
  }
}