package ui.pages.crm

import com.codeborne.selenide.Selenide.`$`
import org.openqa.selenium.By
import ui.elements.ButtonElement
import ui.elements.InputElement
import ui.pages.BasePage
import ui.waiter.Waiter

class CrmBorrowersPage : BasePage() {
  private val borrowerId: String = "28256"

  private val resetPasswordButton: By = By.cssSelector("div.sc-giadOv>button:not(#blockBorrowers)")
  private val blockButton: By = By.id("blockBorrowers")
  private val menuLocator1: By = By.id("mainNav")
  private val borrowerMenuLocator: By = By.cssSelector("a[href='/crm/#/borrowers']")
  private val borrowersFilterInput: By = By.name("value")
  private val submitButton: By = By.cssSelector("button[type='submit']")
  private val borrowersSearchResult: By = By.cssSelector(".amount-records")

  override fun openPage() {
    Waiter.waitPageDomLoad()
    ButtonElement.clickButton(menuLocator1)
    Waiter.waitUntilElementAppear(borrowerMenuLocator)
    ButtonElement.clickButton(borrowerMenuLocator)
  }

  fun isCrmBorrowersPageOpened(): Boolean {
    return `$`(resetPasswordButton).isDisplayed && `$`(blockButton).isDisplayed
  }

  fun searchBorrowerById() {
    ButtonElement.clickButton(borrowersFilterInput)
    InputElement.setInputElementValue(borrowersFilterInput, borrowerId)
    ButtonElement.clickButton(submitButton)
  }

  fun isBorrowersSearchResultPresent(): Boolean {
    Waiter.waitPageDomLoad()
    return `$`(borrowersSearchResult).isDisplayed
  }
}