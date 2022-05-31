package AT.hw_7.page_objects;

import org.openqa.selenium.By;

public class ResultsPage extends BasePage {

    private static final By SEARCH_RESULTS_LIST = By.xpath("//*[@class='s-item__info clearfix']//*[@class='s-item__title']");
    private static final String ITEM = "//*[@class='s-item__info clearfix']//*[contains(text(),'%s')]";

    public boolean getTextFromFirstProduct(String item) {
        return driver.findElements(SEARCH_RESULTS_LIST).get(1).getText().toLowerCase().contains(item.toLowerCase());
    }

    public ProductPage goToFirstProductPage() {
       driver.findElements(SEARCH_RESULTS_LIST).get(1).click();
        return new ProductPage();
    }
}

