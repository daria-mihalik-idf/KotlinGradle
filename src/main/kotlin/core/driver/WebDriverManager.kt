package core.driver

import org.openqa.selenium.WebDriver

abstract class WebDriverManager {
  abstract fun createDriver(): WebDriver
}

