package ui.waiter

import org.openqa.selenium.By
import org.openqa.selenium.NoSuchElementException
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.ui.FluentWait
import java.time.Duration

class Waiter(val driver: WebDriver) {

  fun waitUntilElementDisappeared(locator: By, timeout: Long, pollingTimeout: Long) {
    FluentWait<WebDriver>(driver)
        .withTimeout(Duration.ofSeconds(timeout))
        .pollingEvery(Duration.ofSeconds(pollingTimeout))
        .ignoring(NoSuchElementException::class.java)
        .until { !it.findElement(locator).isDisplayed }
  }

  fun waitUntilElementDisappeared(locator: By) {
    waitUntilElementDisappeared(locator, TEN_SEC_TIMEOUT, SEC_TIMEOUT)
  }

  fun waitUntilElementAppear(locator: By, timeout: Long, pollingTimeout: Long) {
    FluentWait<WebDriver>(driver)
        .withTimeout(Duration.ofSeconds(timeout))
        .pollingEvery(Duration.ofSeconds(pollingTimeout))
        .ignoring(NoSuchElementException::class.java)
        .until { it.findElement(locator).isDisplayed }
  }

  fun waitUntilElementAppear(locator: By) {
    waitUntilElementAppear(locator, TEN_SEC_TIMEOUT, SEC_TIMEOUT)
  }

  companion object {
    const val SEC_TIMEOUT: Long = 1
    const val TEN_SEC_TIMEOUT: Long = 10
  }
}