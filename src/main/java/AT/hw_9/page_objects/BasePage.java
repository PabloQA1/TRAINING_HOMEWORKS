package AT.hw_9.page_objects;

import AT.hw_9.browser.Browser;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@Log4j2
public abstract class BasePage {

    protected WebDriver driver = Browser.getWebDriverInstance();

    public void waitForElementVisible(By locator){
        new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void colorElement(WebElement elem) {
        if (driver instanceof JavascriptExecutor) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].style.border='5px solid red'", elem);
        }
    }
}