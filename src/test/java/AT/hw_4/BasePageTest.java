package AT.hw_4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import java.util.concurrent.TimeUnit;

public abstract class BasePageTest {

    protected WebDriver driver;
    protected CheckboxRadioPage checkboxRadioPage;
    protected DroppablePage droppablePage;
    protected SelectMenuPage selectMenuPage;
    protected TooltipPage tooltipPage;
    protected SpinnerPage spinnerPage;

    @BeforeClass
    public void setUp() {
        if (driver == null) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
            driver.manage().window().maximize();
            initPage();
        }
    }

    public void initPage() {
        checkboxRadioPage = new CheckboxRadioPage(driver);
        droppablePage = new DroppablePage(driver);
        selectMenuPage = new SelectMenuPage(driver);
        tooltipPage = new TooltipPage(driver);
        spinnerPage = new SpinnerPage(driver);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
        driver = null;
    }
}