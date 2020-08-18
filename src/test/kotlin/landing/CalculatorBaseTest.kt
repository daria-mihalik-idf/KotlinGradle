package landing

import config.ConfigProviderManager
import config.FileType
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import java.util.concurrent.TimeUnit

abstract class CalculatorBaseTest {
    lateinit var driver: WebDriver

    @BeforeEach
    fun init() {
        driver = ChromeDriver()
        val applicationConfig = ConfigProviderManager().setFileType(FileType.YAML).getConfig().getApplicationConfig()
        driver.get(applicationConfig)
        System.setProperty("webdriver.chrome.driver", "C:\\SeleniumDriver\\chromedriver.exe")
        (driver as ChromeDriver).manage().window().maximize()
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS)
    }

    @AfterEach
    fun quitSession() {
        driver.quit()
    }
}
