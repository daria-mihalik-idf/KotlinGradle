package ui.pages.crm

import com.codeborne.selenide.Selenide.`$`
import org.openqa.selenium.By
import ui.elements.ButtonElement
import ui.elements.InputElement
import ui.pages.BasePage
import ui.waiter.Waiter

class CrmBorrowersPage : BasePage() {
  private val resetPasswordButton: By = By.cssSelector("div.sc-giadOv>button:not(#blockBorrowers)")
  private val blockButton: By = By.id("blockBorrowers")
  private val borrowersFilterInput: By = By.name("value")
  private val submitButton: By = By.cssSelector("button[type='submit']")
  private val borrowersSearchResult: By = By.cssSelector(".amount-records")
  private val crmHomePage:CrmHomePage = CrmHomePage()

  override fun openPage() {
    crmHomePage.clickMenuDropdown()
    crmHomePage.clickBorrowersMenu()
  }

  fun verifyCrmBorrowersPageOpened(): Boolean {
    return `$`(resetPasswordButton).isDisplayed && `$`(blockButton).isDisplayed
  }

  fun clickOnFilterInput() {
    ButtonElement.clickButton(borrowersFilterInput)
  }

  fun setValueInFilterInput(userData: String) {
    InputElement.setInputElementValue(borrowersFilterInput, userData)
  }

  fun clickOnSubmitButton() {
    ButtonElement.clickButton(submitButton)
  }

  fun verifyBorrowersSearchResultPresent(): Boolean {
    Waiter.waitPageDomLoad()
    return `$`(borrowersSearchResult).isDisplayed
  }
}