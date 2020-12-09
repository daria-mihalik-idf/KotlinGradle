package ui.pages.login

import com.codeborne.selenide.Selenide.`$`
import org.openqa.selenium.By

class PrivateAreaMainPage {
  private val loanDetail = By.xpath("//*[@name='ongoingLoan']")
  private val loanHistory = By.xpath("//*[@name='historyOfLoans']")

  fun isPrivateAreaOpened(): Boolean {
    return `$`(loanDetail).isDisplayed && `$`(loanHistory).isDisplayed
  }
}