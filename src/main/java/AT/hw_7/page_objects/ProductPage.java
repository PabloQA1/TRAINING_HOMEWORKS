package AT.hw_7.page_objects;

import org.openqa.selenium.By;
import java.util.ArrayList;

public class ProductPage extends BasePage {

    private static final By ADD_TO_CART_BUTTON = By.xpath("//*[@id='isCartBtn_btn']");

    public ProductPage addToTheCart() {
         ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        waitForElementVisible(ADD_TO_CART_BUTTON);
        driver.findElement(ADD_TO_CART_BUTTON).click();
        return new ProductPage();
    }
}
