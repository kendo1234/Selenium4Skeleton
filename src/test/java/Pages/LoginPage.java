package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    private WebDriver driver;

    private By usernameField = By.id("data-qa='wal-input account-checker-email'");
    private By passwordField = By.id("data-qa='wal-input password-input'");
    private By continueButton = By.id("data-qa='wal-button account-checker-continue'");
    private By loginButton = By.id("data-qa='wal-button log-in-cta'");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage login(String username, String password) {
        WebElement usernameElement = driver.findElement(usernameField);
        WebElement continueElement = driver.findElement(continueButton);
        WebElement passwordElement = driver.findElement(passwordField);
        WebElement loginButtonElement = driver.findElement(loginButton);

        usernameElement.sendKeys(username);
        continueElement.click();
        passwordElement.sendKeys(password);
        loginButtonElement.click();

        // After successful login, return the HomePage
        return new HomePage(driver);
    }
}

