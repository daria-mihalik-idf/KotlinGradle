package ui.pages.login

import config.ApplicationConfig
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement

class LoginPage(private val driver: WebDriver, applicationConfig: ApplicationConfig) {
    private val loginPageUrl = applicationConfig.getBaseUrl() + applicationConfig.landingEndpoint +
            applicationConfig.loginUrl
    private val loginMail = applicationConfig.loginMail
    private val loginPassword = applicationConfig.loginPassword
    private val loginInput: By = By.cssSelector("[name='login']")
    private val passwordInput: By = By.cssSelector("[name='password']")
    private val submitButton: By = By.cssSelector("button[name='login-btn']")
    private val passwordRecoveryLink: By = By.cssSelector("a[href*='password-recovery']")

    fun openLoginPage() {
        driver.get(loginPageUrl)
    }

    fun isLoginOpened(): Boolean {
        return find(loginInput).isDisplayed && find(passwordInput).isDisplayed && find(submitButton).isDisplayed
                && find(passwordRecoveryLink).isDisplayed
    }

    private fun find(by: By): WebElement {
        return driver.findElement(by)
    }

    fun logInPrivateArea() {
        find(loginInput).sendKeys(loginMail)
        find(passwordInput).sendKeys(loginPassword)
        find(submitButton).click()
    }
}