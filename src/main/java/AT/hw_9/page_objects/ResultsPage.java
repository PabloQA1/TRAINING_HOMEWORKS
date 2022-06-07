package AT.hw_9.page_objects;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;

@Log4j2
public class ResultsPage extends BasePage {

    private static final By SEARCH_RESULTS_LIST = By.xpath("//*[@class='s-item__info clearfix']//*[@class='s-item__title']");

    public boolean getTextFromFirstProduct(String item) {
        return driver.findElements(SEARCH_RESULTS_LIST).get(1).getText().toLowerCase().contains(item.toLowerCase());
    }

    public ProductPage goToFirstProductPage() {
        log.debug("Open first product page in the search list");
        driver.findElements(SEARCH_RESULTS_LIST).get(1).click();
        return new ProductPage();
    }
}

