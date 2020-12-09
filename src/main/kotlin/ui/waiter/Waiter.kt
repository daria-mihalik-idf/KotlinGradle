package ui.waiter

import com.codeborne.selenide.Selenide.executeJavaScript
import com.codeborne.selenide.WebDriverRunner
import logger.TestLogger
import org.openqa.selenium.*
import org.openqa.selenium.support.ui.FluentWait
import java.time.Duration

object Waiter {
  private const val DEFAULT_POLLING_TIMEOUT_SECONDS: Long = 3
  private const val DEFAULT_WAIT_TIMEOUT_SECONDS: Long = 10
  private const val PAGE_LOAD_WAIT_TIMEOUT_SECONDS: Long = 15

  fun waitUntilElementDisappeared(locator: By, timeout: Long = DEFAULT_WAIT_TIMEOUT_SECONDS,
      pollingTimeout: Long = DEFAULT_POLLING_TIMEOUT_SECONDS) {
    TestLogger.getLogger().info("Wait until the element $locator  disappears")
    FluentWait<WebDriver>(WebDriverRunner.getWebDriver())
        .withTimeout(Duration.ofSeconds(timeout))
        .pollingEvery(Duration.ofSeconds(pollingTimeout))
        .ignoring(NoSuchElementException::class.java)
        .until { !it.findElement(locator).isDisplayed }
  }

  fun waitUntilElementAppear(locator: By, timeout: Long =
      DEFAULT_WAIT_TIMEOUT_SECONDS, pollingTimeout: Long = DEFAULT_POLLING_TIMEOUT_SECONDS) {
    TestLogger.getLogger().info("Wait until the element $locator appears")
    FluentWait<WebDriver>(WebDriverRunner.getWebDriver())
        .withTimeout(Duration.ofSeconds(timeout))
        .pollingEvery(Duration.ofSeconds(pollingTimeout))
        .ignoring(NoSuchElementException::class.java)
        .until { it.findElement(locator).isDisplayed }
  }

  fun jsWaitForPageToLoad(timeout: Long = DEFAULT_WAIT_TIMEOUT_SECONDS,
      pollingTimeout: Long = DEFAULT_POLLING_TIMEOUT_SECONDS) {
    val jsCommand = "return document.readyState"
    TestLogger.getLogger().info("Wait for JS scripts is fully executed")
    FluentWait<WebDriver>(WebDriverRunner.getWebDriver())
        .withTimeout(Duration.ofSeconds(timeout))
        .pollingEvery(Duration.ofSeconds(pollingTimeout))
        .ignoring(NoSuchElementException::class.java)
        .until {
          executeJavaScript<Long>(jsCommand).toString() == "complete" && executeJavaScript<Long>(
              "return jQuery.active " +
                  "==" +
                  " 0")
              .toString().toBoolean()
        }
  }

  fun waitPageDomLoad(timeout: Long = PAGE_LOAD_WAIT_TIMEOUT_SECONDS,
      pollingTimeout: Long = DEFAULT_POLLING_TIMEOUT_SECONDS) {
    TestLogger.getLogger().info("Wait for page dom model is fully loaded")
    var domPreviousState: Long = 0
    FluentWait<WebDriver>(WebDriverRunner.getWebDriver())
        .withTimeout(Duration.ofSeconds(timeout))
        .pollingEvery(Duration.ofSeconds(pollingTimeout))
        .ignoring(WebDriverException::class.java)
        .until {
          fun isPageDomModelFullyLoaded(): Boolean {
            val domCurrentState: Long = getElementsCountByDOM()
            TestLogger.getLogger().info("Dom elements - previous: $domPreviousState | current: $domCurrentState")
            return if (domPreviousState == domCurrentState && isPageHasDocumentReadyState()) {
              true
            } else {
              domPreviousState = domCurrentState
              false
            }
          }
          isPageDomModelFullyLoaded()
        }
  }

  private fun getElementsCountByDOM(): Long {
    return executeJavaScript<Long>("return document.getElementsByTagName('*').length")
        ?: throw IllegalStateException("Executed script returns null")
  }

  private fun isPageHasDocumentReadyState(): Boolean {
    val isDocumentStateReady: Boolean = "complete" == executeJavaScript("return document.readyState")
    TestLogger.getLogger().info("Document.readyState: $isDocumentStateReady")
    return isDocumentStateReady
  }
}