package landing

import config.ApplicationConfig
import config.ConfigProviderManager
import config.FileType
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.openqa.selenium.Dimension
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import java.util.concurrent.TimeUnit

abstract class CalculatorBaseTest {
    lateinit var driver: WebDriver
    val applicationConfig = ConfigProviderManager().setFileType(FileType.YAML).getConfig()

    @BeforeEach
    fun init() {
        driver = ChromeDriver()
        System.setProperty("webdriver.chrome.driver", "C:\\SeleniumDriver\\chromedriver.exe")
        driver.manage().window().size = Dimension(1600, 900)
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS)
    }

    @AfterEach
    fun quitSession() {
        driver.quit()
    }
}