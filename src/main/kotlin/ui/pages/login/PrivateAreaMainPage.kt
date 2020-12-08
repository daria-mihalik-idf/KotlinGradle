package ui.pages.login

import org.openqa.selenium.By
import ui.elements.ButtonElement

class PrivateAreaMainPage {
  private val loanDetail = By.xpath("//*[@name='ongoingLoan']")
  private val loanHistory = By.xpath("//*[@name='historyOfLoans']")

  fun isPrivateAreaOpened(): Boolean {
    return ButtonElement.isElementDisplayed(loanDetail) && ButtonElement.isElementDisplayed(loanHistory)
  }
}