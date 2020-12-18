package ui.waiter

import com.codeborne.selenide.Condition
import com.codeborne.selenide.Driver
import com.codeborne.selenide.Selenide.`$`
import com.codeborne.selenide.conditions.AttributeWithValue
import com.codeborne.selenide.impl.Html
import org.openqa.selenium.By
import org.openqa.selenium.WebElement

object CustomWaiter {
  private const val DEFAULT_POLLING_TIMEOUT_SECONDS: Long = 3
  private const val DEFAULT_WAIT_TIMEOUT_SECONDS: Long = 5
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

  fun waitAttributeContainsText(locator: By, attributeName: String, attributeText: String, timeout: Long =
      DEFAULT_WAIT_TIMEOUT_SECONDS) {
    `$`(locator).shouldHave(
        WaitAttributeContainsTextCondition(attributeName, attributeText))
  }
}

class WaitAttributeContainsTextCondition(private val attributeName: String,
    private val expectedAttrValue: String) :
    AttributeWithValue(attributeName, expectedAttrValue) {

  override fun apply(driver: Driver, element: WebElement): Boolean {
    return Html.text.contains(getValueAttribute(element), expectedAttrValue)
  }

  override fun actualValue(driver: Driver, element: WebElement): String {
    return String.format("%s=\"%s\"", attributeName, getValueAttribute(element))
  }

  override fun toString(): String {
    return String.format("%s %s=\"%s\"", name, attributeName, expectedAttrValue)
  }

  private fun getValueAttribute(element: WebElement): String {
    val attr = element.getAttribute(attributeName)
    return attr ?: ""
  }
}