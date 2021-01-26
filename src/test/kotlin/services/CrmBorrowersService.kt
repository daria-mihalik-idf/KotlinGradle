package services

import ui.pages.crm.CrmBorrowersPage

class CrmBorrowersService {
  val crmBorrowersPage = CrmBorrowersPage()

  fun openPage() {
    crmBorrowersPage.openPage()
  }

  fun isOpened(): Boolean {
    return crmBorrowersPage.isCrmBorrowersPageOpened()
  }
}