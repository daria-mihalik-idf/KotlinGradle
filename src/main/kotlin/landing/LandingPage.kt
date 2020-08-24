package landing

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import ui.pages.registration.RegistrationPage

class LandingPage(private val driver: WebDriver) {
    private val calculator: By = By.className("hero__calculator")
    private val lpTitle: By = By.xpath("//*[text()='Préstamos en línea']")
    private val periodInput: By = By.cssSelector("[data-test-id='calculator_days']")
    private val amountInput: By = By.cssSelector("[data-test-id='calculator_amount']")

    fun isOpened(): Boolean {
        val lpTitleLocator: WebElement = driver.findElement(lpTitle)
        val calculatorLocator: WebElement = driver.findElement(calculator)
        return lpTitleLocator.isDisplayed && calculatorLocator.isDisplayed
    }

    fun setValue(locator: WebElement, value: String) {
        CalculatorBaseBlock().setInputValue(locator, value)
    }

    fun setPeriodValue(value: String) {
        val periodLocator: WebElement = driver.findElement(periodInput)
        CalculatorBaseBlock().setInputValue(periodLocator, value)
    }

    fun getPeriodValue(): String {
        return driver.findElement(periodInput).getAttribute("value")
    }

    fun setAmountValue(value: String) {
        val periodLocator: WebElement = driver.findElement(amountInput)
        CalculatorBaseBlock().setInputValue(periodLocator, value)
    }

    fun getAmountValue(): String {
        return driver.findElement(amountInput).getAttribute("value")
    }

    fun isGetCreditButtonPresent(): Boolean {
        return CalculatorBaseBlock().isGetCreditButtonPresent(driver)
    }

    fun clickGetCreditButton(): RegistrationPage {
        CalculatorBaseBlock().clickGetCreditButton(driver)
        return RegistrationPage(driver)
    }
}