package ui.elements

import com.codeborne.selenide.Selenide.`$`
import logger.TestLogger
import org.openqa.selenium.By

object ButtonElement {

  fun clickButton(buttonLocator: By) {
    TestLogger.getLogger().info("Click button: $buttonLocator")
    `$`(buttonLocator).click()
  }
}