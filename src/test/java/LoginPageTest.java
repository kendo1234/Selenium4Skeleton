import Pages.HomePage;
import Pages.LoginPage;
import Utils.Reporting;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginPageTest {

    private WebDriver driver;
    private LoginPage loginPage;
    private ExtentReports extent;
    private ExtentTest extentTest;

    @BeforeEach
    public void setup() {
        // Use WebDriverManager to setup ChromeDriver
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        extent = Reporting.getInstance();
        extentTest = extent.createTest("Login Test");
        driver.get("https://www.moneysupermarket.com/account");
    }

    @Test
    public void loginWithValidCredentials() {
        extentTest.log(Status.INFO, "Test started");
        HomePage homePage = loginPage.login("username", "password");
        homePage.pageLoad();
        extentTest.log(Status.PASS, "Login successful");
    }

    @AfterEach
    public void tearDown() {
        extent.flush();
        driver.quit();
    }
}