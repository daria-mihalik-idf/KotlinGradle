package core.driver

import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver

class ChromeDriverManager : WebDriverManager() {
  override fun createDriver(): WebDriver {
    System.setProperty("webdriver.chrome.driver", "C:\\SeleniumDriver\\chromedriver.exe")
    return ChromeDriver()
  }
}

