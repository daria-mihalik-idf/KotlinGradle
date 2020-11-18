package ui.waiter

import org.openqa.selenium.By
import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.NoSuchElementException
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.ui.FluentWait
import java.time.Duration

object Waiter {

  private const val DEFAULT_POLLING_TIMEOUT: Long = 1
  private const val DEFAULT_WAIT_TIMEOUT: Long = 10

  fun waitUntilElementDisappeared(driver: WebDriver, locator: By, timeout: Long = DEFAULT_WAIT_TIMEOUT,
      pollingTimeout: Long = DEFAULT_POLLING_TIMEOUT) {
    FluentWait<WebDriver>(driver)
        .withTimeout(Duration.ofSeconds(timeout))
        .pollingEvery(Duration.ofSeconds(pollingTimeout))
        .ignoring(NoSuchElementException::class.java)
        .until { !it.findElement(locator).isDisplayed }
  }

  fun waitUntilElementAppear(driver: WebDriver, locator: By, timeout: Long = DEFAULT_WAIT_TIMEOUT,
      pollingTimeout: Long = DEFAULT_POLLING_TIMEOUT) {
    FluentWait<WebDriver>(driver)
        .withTimeout(Duration.ofSeconds(timeout))
        .pollingEvery(Duration.ofSeconds(pollingTimeout))
        .ignoring(NoSuchElementException::class.java)
        .until { it.findElement(locator).isDisplayed }
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
}