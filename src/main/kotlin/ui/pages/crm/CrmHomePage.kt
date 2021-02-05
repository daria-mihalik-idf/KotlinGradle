package ui.pages.crm

import com.codeborne.selenide.Selenide.`$`
import org.openqa.selenium.By
import ui.elements.ButtonElement
import ui.waiter.Waiter

class CrmHomePage {
  private val menuLocator: By = By.id("main")
  private val menuDropdownLocator: By = By.id("mainNav")
  private val borrowerMenuLocator: By = By.cssSelector("a[href='/crm/#/borrowers']")

   fun verifyCrmHomePageOpened(): Boolean {
    return `$`(menuLocator).isDisplayed
  }

   fun clickMenuDropdown() {
    Waiter.waitPageDomLoad()
    ButtonElement.clickButton(menuDropdownLocator)
  }

   fun clickBorrowersMenu() {
    Waiter.waitUntilElementAppear(borrowerMenuLocator)
    ButtonElement.clickButton(borrowerMenuLocator)
  }
}