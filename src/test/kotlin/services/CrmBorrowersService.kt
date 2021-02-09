package services

import org.junit.jupiter.api.Assertions
import ui.pages.crm.CrmBorrowersPage
import ui.pages.crm.CrmBorrowersSearchBlock
import ui.pages.crm.CrmBorrowersSearchResultBlock

class CrmBorrowersService {
  private val crmBorrowersPage = CrmBorrowersPage()
  private val crmBorrowersSearchBlock = CrmBorrowersSearchBlock()
  private val crmBorrowersSearchResult = CrmBorrowersSearchResultBlock()

  fun openCrmBorrowersPage() {
    crmBorrowersPage.openPage()
  }

  fun verifyCrmBorrowersPageOpened() {
    Assertions.assertTrue(crmBorrowersPage.verifyCrmBorrowersPageOpened(),
        "Crm Borrowers Page wasn't opened")
  }

  fun searchBorrowerById(userData: String) {
    crmBorrowersSearchBlock.apply {
      clickOnFilterInput()
      setValueInFilterInput(userData)
      clickOnSubmitButton()
    }
  }

  fun verifyBorrowersSearchResultPresent() {
    Assertions.assertTrue(crmBorrowersSearchResult.verifyBorrowersSearchResultPresent(),
        "Crm Borrowers Search result not found")
  }
}