package AT.hw_7.page_objects;

import org.openqa.selenium.By;

public class HomePage extends BasePage{

    public static final String URL = "https://www.ebay.com/";
    private static final By SEARCH_FIELD = By.cssSelector("#gh-ac");
    private static final By SEARCH_BUTTON = By.xpath("//input[@id='gh-btn']");

    public HomePage openPage() {
    driver.get(URL);
        return this;
    }

    public HomePage fillingSearchField(String searchItem){
        driver.findElement(SEARCH_FIELD).sendKeys(searchItem);
        return new HomePage();
    }

    public ResultsPage clickOnTheSearchButton(){
        waitForElementVisible(SEARCH_BUTTON);
        driver.findElement(SEARCH_BUTTON).click();
        return new ResultsPage();
    }
}
