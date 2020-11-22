package ui.waiter

import org.openqa.selenium.*
import org.openqa.selenium.support.ui.FluentWait
import java.time.Duration

object Waiter {
  private const val DEFAULT_POLLING_TIMEOUT: Long = 3
  private const val DEFAULT_WAIT_TIMEOUT: Long = 10
  private const val PAGE_LOAD_WAIT_TIMEOUT: Long = 15

  fun waitUntilElementDisappeared(driver: WebDriver, locator: By, timeout: Long = DEFAULT_WAIT_TIMEOUT,
      pollingTimeout: Long = DEFAULT_POLLING_TIMEOUT) {
    FluentWait<WebDriver>(driver)
        .withTimeout(Duration.ofSeconds(timeout))
        .pollingEvery(Duration.ofSeconds(pollingTimeout))
        .ignoring(NoSuchElementException::class.java)
        .until { !it.findElement(locator).isDisplayed }
  }

  fun waitUntilElementAppear(driver: WebDriver, locator: By, timeout: Long =
      DEFAULT_WAIT_TIMEOUT, pollingTimeout: Long = DEFAULT_POLLING_TIMEOUT) {
    FluentWait<WebDriver>(driver)
        .withTimeout(Duration.ofSeconds(timeout))
        .pollingEvery(Duration.ofSeconds(pollingTimeout))
        .ignoring(NoSuchElementException::class.java)
        .until { it.findElement(locator).isDisplayed }
  }

  fun waitUntilPageWillOpen(driver: WebDriver, locator: By, url: String, timeout: Long =
      DEFAULT_WAIT_TIMEOUT, pollingTimeout: Long = DEFAULT_POLLING_TIMEOUT) {
    FluentWait<WebDriver>(driver)
        .withTimeout(Duration.ofSeconds(timeout))
        .pollingEvery(Duration.ofSeconds(pollingTimeout))
        .ignoring(NoSuchElementException::class.java)
        .until { it.findElement(locator).isDisplayed && url == driver.currentUrl }
  }

  fun jsWaitForPageToLoad(driver: WebDriver, timeout: Long = DEFAULT_WAIT_TIMEOUT,
      pollingTimeout: Long = DEFAULT_POLLING_TIMEOUT) {
    val js = driver as JavascriptExecutor
    val jsCommand = "return document.readyState"

    FluentWait<WebDriver>(driver)
        .withTimeout(Duration.ofSeconds(timeout))
        .pollingEvery(Duration.ofSeconds(pollingTimeout))
        .ignoring(NoSuchElementException::class.java)
        .until {
          js.executeScript(jsCommand).toString() == "complete" && js.executeScript("return jQuery.active == 0")
              .toString().toBoolean()
        }
  }

  fun waitPageDomLoad(driver: WebDriver, timeout: Long = PAGE_LOAD_WAIT_TIMEOUT,
      pollingTimeout: Long = DEFAULT_POLLING_TIMEOUT) {
    var domPreviousState: Long = 0
    FluentWait<WebDriver>(driver)
        .withTimeout(Duration.ofSeconds(timeout))
        .pollingEvery(Duration.ofSeconds(pollingTimeout))
        .ignoring(WebDriverException::class.java)
        .until {
          fun isPageDomModelFullyLoaded(): Boolean {
            val domCurrentState: Long = getElementsCountByDOM(driver)
            return if (domPreviousState == domCurrentState && isPageHasDocumentReadyState(driver)) {
              true
            } else {
              domPreviousState = domCurrentState
              false
            }
          }
          isPageDomModelFullyLoaded()
        }
  }

  private fun getElementsCountByDOM(driver: WebDriver): Long {
    val js = driver as JavascriptExecutor
    return js.executeScript("return document.getElementsByTagName('*').length") as Long
  }

  private fun isPageHasDocumentReadyState(driver: WebDriver): Boolean {
    val js = driver as JavascriptExecutor
    return "complete" == js.executeScript("return document.readyState")
  }
}