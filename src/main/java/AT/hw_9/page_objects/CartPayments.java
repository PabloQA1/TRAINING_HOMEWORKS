package AT.hw_9.page_objects;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;

@Log4j2
public class CartPayments extends BasePage {

    private static final By ITEM_DESCRIPTION = By.xpath(" //*[@data-test-id='cart-item-link']//*[@class='BOLD']");

    public boolean getTextFromProductInCart(String item) {
        log.info("Get text description from product in cart");
        colorElement(driver.findElement(ITEM_DESCRIPTION));
        return driver.findElement(ITEM_DESCRIPTION).getText().toLowerCase().contains(item.toLowerCase());
    }
}
