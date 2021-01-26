package services

import ui.pages.crm.CrmBorrowersPage

class CrmBorrowersService {
  private val crmBorrowersPage = CrmBorrowersPage()

  fun openPage() {
    crmBorrowersPage.openPage()
  }

  fun isCrmBorrowersPageOpened(): Boolean {
    return crmBorrowersPage.isCrmBorrowersPageOpened()
  }

  fun searchBorrowerById() {
    crmBorrowersPage.searchBorrowerById()
  }

  fun isBorrowersSearchResultPresent(): Boolean {
    return crmBorrowersPage.isBorrowersSearchResultPresent()
  }
}