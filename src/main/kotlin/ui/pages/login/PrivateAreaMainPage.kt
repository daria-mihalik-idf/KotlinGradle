package ui.pages.login

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import ui.elements.ButtonElement
import ui.elements.CommonElement

class PrivateAreaMainPage(val driver: WebDriver) {
  private val loanDetail = By.xpath("//*[@name='ongoingLoan']")
  private val loanHistory = By.xpath("//*[@name='historyOfLoans']")
  private val bonus = By.xpath("//*[@name='bonuses']")
  private val passwordData = By.xpath("//*[@name='changeYourPassword']")

  fun isPrivateAreaOpened(): Boolean {
    return ButtonElement.isElementPresent(driver, loanDetail) && ButtonElement.isElementPresent(driver, loanHistory) &&
        ButtonElement.isElementPresent(driver, bonus) && ButtonElement.isElementPresent(driver, passwordData)
  }
}