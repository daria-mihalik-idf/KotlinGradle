package ui.pages.login

import config.ApplicationConfig
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import java.io.FileInputStream
import java.util.*

class LoginPrivateAreaPage(private val driver: WebDriver, applicationConfig: ApplicationConfig) {
    private val loginPageUrl = "${applicationConfig.getBaseUrl()}${applicationConfig.loginPrivateAreaPageUrl}"
    private val loginInput: By = By.cssSelector("[name='login']")
    private val passwordInput: By = By.cssSelector("[name='password']")
    private val submitButton: By = By.cssSelector("button[name='login-btn']")
    private val passwordRecoveryLink: By = By.cssSelector("a[href*='password-recovery']")
    private val testData = FileInputStream("C:\\automation\\KotlinGradle\\src\\main\\resources\\testdata.properties")
    private val properties = Properties()

    fun openLoginPage() {
        driver.get(loginPageUrl)
    }

    fun isLoginOpened(): Boolean {
        val loginInputLocator: WebElement = driver.findElement(loginInput)
        val passwordInputLocator: WebElement = driver.findElement(passwordInput)
        val submitButtonLocator: WebElement = driver.findElement(submitButton)
        val passwordRecoveryLinkLocator: WebElement = driver.findElement(passwordRecoveryLink)

        return loginInputLocator.isDisplayed && passwordInputLocator.isDisplayed && submitButtonLocator.isDisplayed
                && passwordRecoveryLinkLocator.isDisplayed
    }

    fun fillLoginInput(): LoginPrivateAreaPage {
        val loginInputLocator: WebElement = driver.findElement(loginInput)
        properties.load(testData)
        loginInputLocator.sendKeys(properties.getProperty("loginPage.mail"))
        return this
    }

    fun fillPasswordInput(): LoginPrivateAreaPage {
        val passwordInputLocator: WebElement = driver.findElement(passwordInput)
        properties.load(testData)
        passwordInputLocator.sendKeys(properties.getProperty("loginPage.password"))
        return this
    }

    fun clickSubmitButton() {
        val submitButtonLocator: WebElement = driver.findElement(submitButton)
        submitButtonLocator.click()
    }
}

