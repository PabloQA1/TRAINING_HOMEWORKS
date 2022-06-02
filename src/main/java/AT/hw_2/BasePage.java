package AT.hw_2;

import org.openqa.selenium.WebDriver;
public abstract class BasePage {

    WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void openPage(String url) {
        driver.get(url);
    }
}
