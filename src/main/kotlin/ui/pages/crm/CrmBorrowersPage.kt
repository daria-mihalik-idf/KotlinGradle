package ui.pages.crm

import com.codeborne.selenide.Selenide.`$`
import org.openqa.selenium.By
import ui.pages.BasePage

class CrmBorrowersPage : BasePage() {
  private val resetPasswordButton: By = By.cssSelector("div.sc-giadOv>button:not(#blockBorrowers)")
  private val blockButton: By = By.id("blockBorrowers")
  private val crmNavigationMenu: CrmNavigationMenuBlock = CrmNavigationMenuBlock()
  val crmBorrowersSearch: CrmBorrowersSearchBlock = CrmBorrowersSearchBlock()
  val crmBorrowersSearchResult: CrmBorrowersSearchResultBlock = CrmBorrowersSearchResultBlock()

  override fun openPage() {
    crmNavigationMenu.clickMenuDropdown()
    crmNavigationMenu.clickBorrowersMenu()
  }

  fun verifyCrmBorrowersPageOpened(): Boolean {
    return `$`(resetPasswordButton).isDisplayed && `$`(blockButton).isDisplayed
  }
}