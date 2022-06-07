package AT.hw_9.browser;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

@Log4j2
public class Browser {

    private static WebDriver driver;

    public static WebDriver getWebDriverInstance() {
        if (driver != null) {
            return driver;
        }
        return driver = init();
    }

    public static WebDriver init() {
        if (driver == null) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.manage().window().maximize();
        }
        log.info("Browser is started!");
        return driver;
    }

    public static void close() {
        try {
            driver.quit();
        } catch (Exception ex) {
            ex.printStackTrace();
            log.fatal("Error, browser is not closed!");
        } finally {
            driver = null;
        }
    }
}


