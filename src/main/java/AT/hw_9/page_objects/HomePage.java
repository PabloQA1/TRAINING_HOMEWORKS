package AT.hw_9.page_objects;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;

@Log4j2
public class HomePage extends BasePage {

    public static final String URL = "https://www.ebay.com/";
    private static final By SEARCH_FIELD = By.cssSelector("#gh-ac");
    private static final By SEARCH_BUTTON = By.xpath("//input[@id='gh-btn']");

    public HomePage openPage() {
        log.info("Open: " + URL + "page");
    driver.get(URL);
        return this;
    }

    public HomePage fillingSearchField(String searchItem){
        log.debug("Enter  " + searchItem + " in the Search field");
        driver.findElement(SEARCH_FIELD).sendKeys(searchItem);
        return new HomePage();
    }

    public ResultsPage clickOnTheSearchButton(){
        waitForElementVisible(SEARCH_BUTTON);
        log.debug("Click Search button");
        driver.findElement(SEARCH_BUTTON).click();
        colorElement(driver.findElement(SEARCH_BUTTON));
        return new ResultsPage();
    }
}
