package AT.hw_7.page_objects;

import org.openqa.selenium.By;

public class CartPayments extends BasePage{

    private static final By ITEM_DESCRIPTION = By.xpath(" //*[@data-test-id='cart-item-link']//*[@class='BOLD']");

    public boolean getTextFromProductInCart(String item) {
        return driver.findElement(ITEM_DESCRIPTION).getText().toLowerCase().contains(item.toLowerCase());
    }

}
