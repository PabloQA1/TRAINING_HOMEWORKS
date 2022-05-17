package AT.hw_4;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SpinnerPage extends BasePage{

    @FindBy(className = "demo-frame")
    private WebElement iFrame;

    @FindBy(id = "setvalue")
    private WebElement setValueToFiveButton;

    @FindBy(id = "getvalue")
    private WebElement getValueButton;

    public SpinnerPage(WebDriver driver) {
        super(driver);
    }

    public SpinnerPage openPage() {
        openPage("spinner/");
        switchToIframe(iFrame);
        return this;
    }

    public SpinnerPage clickOnTheSetValueToFiveButton() {
        setValueToFiveButton.click();
        return this;
    }

    public SpinnerPage clickOnTheGetValueButton() {
        getValueButton.click();
        return this;
    }

    public boolean verifySelectedValueFromAlert() {
        Alert alert = driver.switchTo().alert();
        return  alert.getText().equals("5");
    }
}
