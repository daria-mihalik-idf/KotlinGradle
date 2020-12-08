package ui.elements

import com.codeborne.selenide.Selenide.`$`
import com.codeborne.selenide.Selenide.actions
import logger.TestLogger
import org.openqa.selenium.By

object ActionElement {

  fun dragAndDrop(locator: By, xOffset: Int, yOffset: Int) {
    TestLogger.getLogger().info("Move slider $locator from $xOffset to $yOffset")
    actions().dragAndDropBy(`$`(locator), xOffset, yOffset).release().build().perform()
  }
}