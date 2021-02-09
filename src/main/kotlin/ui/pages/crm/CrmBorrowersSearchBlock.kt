package ui.pages.crm

import org.openqa.selenium.By
import ui.elements.ButtonElement
import ui.elements.InputElement

class CrmBorrowersSearchBlock {
  private val borrowersFilterInput: By = By.name("value")
  private val submitButton: By = By.cssSelector("button[type='submit']")

  fun clickOnFilterInput() {
    ButtonElement.clickButton(borrowersFilterInput)
  }

  fun setValueInFilterInput(userData: String) {
    InputElement.setInputElementValue(borrowersFilterInput, userData)
  }

  fun clickOnSubmitButton() {
    ButtonElement.clickButton(submitButton)
  }
}