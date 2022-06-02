package AT.hw_6.utils.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SingletonDriver {

    private static WebDriver driver;

    private SingletonDriver() {
    }

    public static WebDriver getSingletonDriver() {
        if (driver == null) {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/test/resources/driver/chromedriver.exe");
            driver = new ChromeDriver();
        }
        return driver;
    }

    public static void closeSingletonDriver() {
        driver.quit();
        driver = null;
    }
}
