package ui.crm

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import services.CrmBorrowersService
import services.CrmMainService
import ui.UiBaseTest

class CrmBorrowersPageTest : UiBaseTest() {

  @Test
  fun crmBorrowersPageIsAccessible() {
    val validCredentials = applicationConfig.crmLoginData
    val crmMainService = CrmMainService(applicationConfig)
    val crmBorrowersService = CrmBorrowersService()

    crmMainService.crmLoginService.openCrmLoginPage()
    Assertions.assertTrue(crmMainService.crmLoginService.isCrmLoginPageOpened(), "")

    crmMainService.crmLoginService.logInCrm(validCredentials)
    Assertions.assertTrue(crmMainService.isCrmMainPageOpened(), "Crm Main Page wasn't opened")


    crmBorrowersService.apply {
      openPage()
      Assertions.assertTrue(crmBorrowersService.isCrmBorrowersPageOpened(),
          "Crm Borrowers Page wasn't opened")
      searchBorrowerById()
      Assertions.assertTrue(crmBorrowersService.isBorrowersSearchResultPresent(),
          "Search result not found")
    }
  }
}