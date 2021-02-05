package ui.crm

import core.CrmUser
import org.junit.jupiter.api.Test
import services.CrmBorrowersService
import services.CrmLoginService
import services.CrmHomeService
import ui.UiBaseTest

class CrmBorrowersPageTest : UiBaseTest() {
  private val borrowerId: String = "28256"

  @Test
  fun crmBorrowersPageIsAccessible() {
    val validCredentials: CrmUser = applicationConfig.crmLoginData
    val crmMainService = CrmHomeService()
    val crmBorrowersService = CrmBorrowersService()
    val crmLoginService = CrmLoginService(applicationConfig)

    crmLoginService.apply {
      openCrmLoginPage()
      verifyCrmLoginPageOpened()
      logInCrm(validCredentials)
    }

    crmMainService.verifyCrmHomePageOpened()

    crmBorrowersService.apply {
      openCrmBorrowersPage()
      verifyCrmBorrowersPageOpened()
      searchBorrowerById(borrowerId)
      verifyBorrowersSearchResultPresent()
    }
  }
}