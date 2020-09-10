package ui.pages.login

import config.ApplicationConfig
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import java.io.FileInputStream
import java.util.*

class PrivateAreaLoginPage(private val driver: WebDriver, applicationConfig: ApplicationConfig) {
    private val privateAreaTitle = By.xpath("//*[text()='Accede a tu cuenta']")
    private val loginPageUrl = "${applicationConfig.getBaseUrl()}${applicationConfig.loginPrivateAreaPageUrl}"
    private val loginInput: By = By.cssSelector("[name='login']")
    private val passwordInput: By = By.cssSelector("[name='password']")
    private val submitButton: By = By.cssSelector("button[name='login-btn']")

    fun openLoginPage() {
        driver.get(loginPageUrl)
    }

    fun isLoginOpened(): Boolean {
        val privateAreaTitleLocator: WebElement = driver.findElement(privateAreaTitle)
        return privateAreaTitleLocator.isDisplayed
    }

    fun fillInput(type: InputField, userData: String) {
        when (type) {
            InputField.LOGIN_INPUT -> driver.findElement(loginInput).sendKeys(userData)
            InputField.PASSWORD_INPUT -> driver.findElement(passwordInput).sendKeys(userData)
        }
    }

    fun clickSubmitButton() {
        val submitButtonLocator: WebElement = driver.findElement(submitButton)
        submitButtonLocator.click()
    }
}


