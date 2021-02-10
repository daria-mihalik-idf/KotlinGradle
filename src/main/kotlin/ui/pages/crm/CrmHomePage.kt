package ui.pages.crm

import com.codeborne.selenide.Selenide.`$`
import org.openqa.selenium.By

class CrmHomePage {
  private val menuLocator: By = By.id("main")

  fun verifyCrmHomePageOpened(): Boolean {
    return `$`(menuLocator).isDisplayed
  }
}