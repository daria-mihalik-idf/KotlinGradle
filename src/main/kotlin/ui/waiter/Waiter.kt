package ui.waiter

import org.openqa.selenium.By
import org.openqa.selenium.NoSuchElementException
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.ui.FluentWait
import java.time.Duration

interface Waiter {

  companion object {
    const val SEC_TIMEOUT: Long = 1
    const val TWENTY_SEC_TIMEOUT: Long = 20
  }

  fun waitUntilElementDisappeared(driver: WebDriver, locator: By, timeout: Long = TWENTY_SEC_TIMEOUT,
      pollingTimeout: Long = SEC_TIMEOUT) {
    FluentWait<WebDriver>(driver)
        .withTimeout(Duration.ofSeconds(timeout))
        .pollingEvery(Duration.ofSeconds(pollingTimeout))
        .ignoring(NoSuchElementException::class.java)
        .until { !it.findElement(locator).isDisplayed }
  }

  fun waitUntilElementAppear(driver: WebDriver, locator: By, timeout: Long = TWENTY_SEC_TIMEOUT,
      pollingTimeout: Long = SEC_TIMEOUT) {
    FluentWait<WebDriver>(driver)
        .withTimeout(Duration.ofSeconds(timeout))
        .pollingEvery(Duration.ofSeconds(pollingTimeout))
        .ignoring(NoSuchElementException::class.java)
        .until { it.findElement(locator).isDisplayed }
  }
}