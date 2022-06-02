package AT.hw_6;

import AT.hw_6.business_objects.User;
import AT.hw_6.page_objects.LoginPage;
import AT.hw_6.page_objects.MailPage;
import AT.hw_6.utils.driver.BrowserFactory;
import AT.hw_6.utils.driver.DecoratorDriver;
import AT.hw_6.utils.driver.SingletonDriver;
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
    protected User user;

    @BeforeMethod
    public void setUp() {
        driver = SingletonDriver.getSingletonDriver();
        WebDriverManager.chromedriver().setup();
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        loginPage = new LoginPage(driver);
        mailPage = new MailPage(driver);
    }

    @AfterMethod
    public void tearDown() {
      SingletonDriver.closeSingletonDriver();
    }

    @BeforeMethod
    public void setUpWithBrowserFactory() {
   WebDriver driver = BrowserFactory.create("Edge");
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        loginPage = new LoginPage(driver);
        mailPage = new MailPage(driver);
    }

    @AfterMethod
    public void WithBrowserFactory() {
       BrowserFactory.closeAllDriver();
    }

    @BeforeMethod
    public void setUpWithDecorateDriverClass() {
        System.setProperty("webdriver.chrome.driver",
                System.getProperty("user.dir") + "/src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        WebDriver decoratedDriver = new DecoratorDriver(driver);
        decoratedDriver.get("https://account.protonmail.com/");
        loginPage = new LoginPage(driver);
        mailPage = new MailPage(driver);
    }
}