package AT.hw_9.page_objects;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import java.util.ArrayList;

@Log4j2
public class ProductPage extends BasePage {

    private static final By ADD_TO_CART_BUTTON = By.xpath("//*[@id='isCartBtn_btn']");

    public ProductPage addToTheCart() {
         ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        waitForElementVisible(ADD_TO_CART_BUTTON);
        log.debug("Click Add to card button");
        driver.findElement(ADD_TO_CART_BUTTON).click();
        return new ProductPage();
    }
}
