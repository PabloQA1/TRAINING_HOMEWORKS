package AT.hw_3;

import AT.hw_2.LoginPage;
import AT.hw_2.MailPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public abstract class BasePageTest {

    protected WebDriver driver;
    protected LoginPage loginPage;
    protected MailPage mailPage;

    @BeforeMethod
    public void setUp() {
        if (driver == null) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
            driver.manage().window().maximize();
            loginPage = new LoginPage(driver);
            mailPage = new MailPage(driver);
        }
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
        driver = null;
    }
}