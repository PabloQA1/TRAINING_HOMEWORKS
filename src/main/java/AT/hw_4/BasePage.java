package AT.hw_4;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

    protected final WebDriver driver;
    protected final String BASE_URI = "https://jqueryui.com/";

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void openPage(String url) {
        driver.get(BASE_URI + url);
    }

    public void switchToIframe(WebElement iFrame) {
        driver.switchTo().frame(iFrame);
    }
}
