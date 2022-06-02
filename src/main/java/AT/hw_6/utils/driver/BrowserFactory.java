package AT.hw_6.utils.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import java.util.HashMap;
import java.util.Map;

public class BrowserFactory {

    private static final Map<String, WebDriver> drivers = new HashMap<>();

    public static WebDriver create(String browserName) {
        WebDriver driver = null;
        switch (browserName) {
            case "Edge":
                driver = drivers.get("Edge");
                if (driver == null) {
                    System.setProperty("webdriver.edge.driver",
                            System.getProperty("user.dir") + "/src/test/resources/driver/msedgedriver.exe");
                    driver = new EdgeDriver();
                    drivers.put("Edge", driver);
                    WebDriverManager.edgedriver().setup();
                }
                break;
            case "Chrome":
                driver = drivers.get("Chrome");
                if (driver == null) {
                    System.setProperty("webdriver.chrome.driver",
                            System.getProperty("user.dir") + "/src/test/resources/driver/chromedriver.exe");
                    driver = new ChromeDriver();
                    drivers.put("Chrome", driver);
                    WebDriverManager.chromedriver().setup();
                }
                break;
        }
        return driver;
    }

    public static void closeAllDriver() {
        for (String key : drivers.keySet()) {
            drivers.get(key).close();
            drivers.get(key).quit();
        }
    }

}

