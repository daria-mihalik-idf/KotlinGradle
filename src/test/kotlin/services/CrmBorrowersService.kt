package services

import org.junit.jupiter.api.Assertions
import ui.pages.crm.CrmBorrowersPage

class CrmBorrowersService {
  private val crmBorrowersPage = CrmBorrowersPage()

  fun openCrmBorrowersPage() {
    crmBorrowersPage.openPage()
  }

  fun verifyCrmBorrowersPageOpened() {
    Assertions.assertTrue(crmBorrowersPage.verifyCrmBorrowersPageOpened(),
        "Crm Borrowers Page wasn't opened")
  }

  fun searchBorrowerById(userData: String) {
    crmBorrowersPage.apply {
      clickOnFilterInput()
      setValueInFilterInput(userData)
      clickOnSubmitButton()
    }
  }

  fun verifyBorrowersSearchResultPresent() {
    Assertions.assertTrue(crmBorrowersPage.verifyBorrowersSearchResultPresent(),
        "Crm Borrowers Search result not found")
  }
}