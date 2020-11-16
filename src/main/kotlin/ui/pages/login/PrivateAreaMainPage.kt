package ui.pages.login

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import ui.elements.ButtonElement

class PrivateAreaMainPage(val driver: WebDriver) {
  private val loanDetail = By.xpath("//*[@name='ongoingLoan']")
  private val loanHistory = By.xpath("//*[@name='historyOfLoans']")

  fun isPrivateAreaOpened(): Boolean {
    return ButtonElement.isElementDisplayed(driver, loanDetail) && ButtonElement.isElementDisplayed(driver, loanHistory)
  }
}