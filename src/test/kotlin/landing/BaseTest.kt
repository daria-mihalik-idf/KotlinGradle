package landing

import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import java.util.concurrent.TimeUnit

abstract class BaseTest {
    lateinit var driver: WebDriver

    @BeforeEach
    fun init() {
        driver = ChromeDriver()
        driver.get("https://moneyman:1005@qa-delivery-mx-master.moneyman.ru")
        System.setProperty("webdriver.chrome.driver", "C:\\SeleniumDriver\\chromedriver.exe")
        (driver as ChromeDriver).manage().window().maximize()
        (driver as ChromeDriver).manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS)
    }

    @AfterEach
    fun quitSession() {
//        driver.quit()
    }
}
