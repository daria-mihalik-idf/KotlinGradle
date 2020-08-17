package landing

import config.ConfigProviderManager
import config.FileType
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import java.util.concurrent.TimeUnit

abstract class CalculatorBaseTest {
    val driver: WebDriver = ChromeDriver()

    @BeforeEach
    fun init() {
        val landingPage = ConfigProviderManager().setFileType(FileType.YAML).getConfig()
        driver.get("https://" + landingPage.user + ":" + landingPage.password + "@" + landingPage.host)
        System.setProperty("webdriver.chrome.driver", "C:\\SeleniumDriver\\chromedriver.exe")
        (driver as ChromeDriver).manage().window().maximize()
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS)
    }

    @AfterEach
    fun quitSession() {
        driver.quit()
    }
}
