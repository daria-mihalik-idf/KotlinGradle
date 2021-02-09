package ui.pages.crm

import org.openqa.selenium.By
import ui.elements.ButtonElement
import ui.waiter.Waiter

class CrmNavigationMenuBlock {
  private val menuDropdownLocator: By = By.id("mainNav")
  private val borrowerMenuLocator: By = By.cssSelector("a[href='/crm/#/borrowers']")

  fun clickMenuDropdown() {
    Waiter.waitPageDomLoad()
    ButtonElement.clickButton(menuDropdownLocator)
  }

  fun clickBorrowersMenu() {
    Waiter.waitUntilElementAppear(borrowerMenuLocator)
    ButtonElement.clickButton(borrowerMenuLocator)
  }
}