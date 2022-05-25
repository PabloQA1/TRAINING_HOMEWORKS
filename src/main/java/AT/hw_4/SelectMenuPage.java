package AT.hw_4;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class SelectMenuPage extends BasePage {

    @FindBy(className = "demo-frame")
    private WebElement iFrame;

    @FindBy(id = "speed-button")
    private WebElement speedSelectMenu;

    @FindBy(xpath = "//*[@id='speed-button']//*[@class='ui-selectmenu-text']")
    private WebElement speedSelectMenuText;

    @FindBy(id = "number-button")
    private WebElement numberSelectMenu;

    @FindBy(xpath = "//*[@id='number-button']//*[@class='ui-selectmenu-text']")
    private WebElement numberSelectMenuValue;

    public SelectMenuPage(WebDriver driver) {
        super(driver);
    }

    public SelectMenuPage openPage() {
        openPage("selectmenu/");
        switchToIframe(iFrame);
        return this;
    }

    public SelectMenuPage selectFastSpeed() {
        Actions actions = new Actions(driver);
        actions.click(speedSelectMenu).sendKeys(Keys.DOWN).sendKeys(Keys.ENTER)
                .build()
                .perform();
        return this;
    }

    public boolean isSpeedSelectMenuContainsText() {
        return speedSelectMenu.getText().equals("Fast");
    }

    public SelectMenuPage selectNumber() {
        Actions actions = new Actions(driver);
        actions.click(numberSelectMenu).sendKeys(Keys.DOWN).sendKeys(Keys.ENTER)
                .build()
                .perform();
        return this;
    }

    public boolean isSelectNumberMenuContainsNum() {
        return numberSelectMenuValue.getText().equals("3");
    }
}
