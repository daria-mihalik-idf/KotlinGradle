package ui.waiter

import com.codeborne.selenide.Condition
import com.codeborne.selenide.Selenide.`$`
import org.openqa.selenium.By

object CustomWaiter {
  private const val DEFAULT_POLLING_TIMEOUT_SECONDS: Long = 3
  private const val DEFAULT_WAIT_TIMEOUT_SECONDS: Long = 10
  private const val PAGE_LOAD_WAIT_TIMEOUT_SECONDS: Long = 15

  fun waitForElementTextLoad(locator: By, value: String, timeout: Long = DEFAULT_WAIT_TIMEOUT_SECONDS) {
    `$`(locator).waitUntil(Condition.text(value), timeout)
  }

  fun waitForElementAttributeLoad(locator: By, attributeName: String, attributeText: String, timeout:
  Long =
      DEFAULT_WAIT_TIMEOUT_SECONDS) {
    `$`(locator).waitUntil(Condition.attribute(attributeName, attributeText), timeout)
  }

  fun waitForAttributeAndTextElementLoad(locator: By, attributeName: String, attributeText: String, value: String) {
    `$`(locator).shouldHave(
        Condition.attribute(attributeName, attributeText),
        Condition.text(value))
  }
}