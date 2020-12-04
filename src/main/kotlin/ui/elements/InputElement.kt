package ui.elements

import com.codeborne.selenide.Selenide.`$`
import logger.TestLogger
import org.openqa.selenium.By
import org.openqa.selenium.Keys

object InputElement {

  fun setInputValueInPrefilledField(locator: By, value: String) {
    TestLogger.getLogger().info("Set Input element value [$value] in Prefilled Field with sendKeys")
    val element = `$`(locator)
    element.click()
    element.sendKeys("${Keys.CONTROL}", "a")
    element.sendKeys("${Keys.DELETE}")
    element.sendKeys(value)
  }

  fun setInputElementValue(element: By, value: String) {
    TestLogger.getLogger().info("Set Input element value [$value] with sendKeys")
    `$`(element).sendKeys(value)
  }

  fun getInputValue(locator: By): String? {
    TestLogger.getLogger().info("Get Input element value $locator ")
    return `$`(locator).getAttribute("value")
  }
}