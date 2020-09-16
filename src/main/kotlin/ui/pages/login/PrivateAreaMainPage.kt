package ui.pages.login

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement

class PrivateAreaMainPage(val driver: WebDriver) {
    private val loanDetail = By.xpath("//*[@name='ongoingLoan']")
    private val loanHistory = By.xpath("//*[@name='historyOfLoans']")
    private val bonus = By.xpath("//*[@name='bonuses']")
    private val passwordData = By.xpath("//*[@name='changeYourPassword']")

    fun isPrivateAreaOpened(): Boolean {
        val loanDetailLocator: WebElement = driver.findElement(loanDetail)
        val loanHistoryLocator: WebElement = driver.findElement(loanHistory)
        val bonusLocator: WebElement = driver.findElement(bonus)
        val passwordDataLocator: WebElement = driver.findElement(passwordData)
        return loanDetailLocator.isDisplayed && loanHistoryLocator.isDisplayed && bonusLocator.isDisplayed
                && passwordDataLocator.isDisplayed
    }
}