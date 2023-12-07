package Utils;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

public class Cookies {

    public static void injectCookie(WebDriver driver) {
        Cookie sessionCookie = new Cookie("SOURCE", "your_cookie_value");
        driver.manage().addCookie(sessionCookie);
    }
}

