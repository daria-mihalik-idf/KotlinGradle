package ui.crm

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import services.CrmBorrowersService
import services.CrmMainService
import ui.UiBaseTest

class CrmBorrowersPageTest : UiBaseTest() {
  private val crmBorrowersService = CrmBorrowersService()

  @Test
  fun crmBorrowersPageIsAccessible() {
    val validCredentials = applicationConfig.crmLoginData
    val crmMainService = CrmMainService(applicationConfig)

    crmMainService.crmLoginPage.openPage()
    Assertions.assertTrue(crmMainService.crmLoginPage.isCrmLoginPageOpened(), "")

    crmMainService.crmLoginPage.logInCrm(validCredentials)
    Assertions.assertTrue(crmMainService.isCrmMainPageOpened(), "Crm Main Page wasn't opened")


    crmBorrowersService.crmBorrowersPage.apply {
      openPage()
      Assertions.assertTrue(crmBorrowersService.crmBorrowersPage.isCrmBorrowersPageOpened(),
          "Crm Borrowers Page wasn't opened")
      searchBorrowerById()
      Assertions.assertTrue(crmBorrowersService.crmBorrowersPage.isBorrowersSearchResultPresent(),
          "Search result not found")
    }
  }
}