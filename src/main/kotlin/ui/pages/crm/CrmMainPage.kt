package ui.pages.crm

import com.codeborne.selenide.Selenide.`$`
import org.openqa.selenium.By

class CrmMainPage {
  private val menuLocator: By = By.id("main")

  fun verifyCrmMainPageOpened(): Boolean {
    return `$`(menuLocator).isDisplayed
  }
}