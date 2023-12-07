package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

    private WebDriver driver;

    private By welomeMessage = By.className("serenity-navigation__greeting");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void pageLoad() {
        WebElement welcome = driver.findElement(welomeMessage);
        welcome.isDisplayed();
    }
}

