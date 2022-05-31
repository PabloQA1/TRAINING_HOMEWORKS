package AT.hw_5;

import AT.hw_5.business_objects.User;
import AT.hw_5.page_objects.LoginPage;
import AT.hw_5.page_objects.MailPage;
import com.codeborne.selenide.Configuration;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public abstract class BasePageTest {

    protected LoginPage loginPage;
    protected MailPage mailPage;
    protected User user;

    protected void pageObjectsInitializer() {
        loginPage = new LoginPage();
        mailPage = new MailPage();
    }

    @BeforeClass
    public void setUp() {
        Configuration.browser = "chrome";
        Configuration.timeout = 15000;
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
        Configuration.headless = false;
        pageObjectsInitializer();
    }

    @AfterClass
    public void quit() {
        getWebDriver().quit();
    }
}