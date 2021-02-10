package ui.pages.crm

import com.codeborne.selenide.Selenide
import org.openqa.selenium.By
import ui.waiter.Waiter

class CrmBorrowersSearchResultBlock {
  private val borrowersSearchResult: By = By.cssSelector(".amount-records")

  fun verifyBorrowersSearchResultPresent(): Boolean {
    Waiter.waitPageDomLoad()
    return Selenide.`$`(borrowersSearchResult).isDisplayed
  }
}