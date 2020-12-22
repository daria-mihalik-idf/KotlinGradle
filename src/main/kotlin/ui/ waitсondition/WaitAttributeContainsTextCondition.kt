package ui.waitсondition

import com.codeborne.selenide.Driver
import com.codeborne.selenide.conditions.AttributeWithValue
import com.codeborne.selenide.impl.Html
import org.openqa.selenium.WebElement

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