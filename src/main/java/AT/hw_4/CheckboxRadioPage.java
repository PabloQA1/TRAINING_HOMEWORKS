package AT.hw_4;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckboxRadioPage extends BasePage {

    @FindBy(className = "demo-frame")
    private WebElement iFrame;

    @FindBy(xpath = "//*[@for='radio-1']")
    private WebElement newYorkRadioButton;

    @FindBy(xpath = "//*[@for='checkbox-1']")
    private WebElement twoStarCheckbox;

    public CheckboxRadioPage(WebDriver driver) {
        super(driver);
    }

    public CheckboxRadioPage openPage() {
        openPage("checkboxradio/");
        switchToIframe(iFrame);
        return this;
    }

    public CheckboxRadioPage clickOnTheNewYorkRadioButton() {
        newYorkRadioButton.click();
        return this;
    }

    public boolean isTheNewYorkRadioButtonSelected() {
        return newYorkRadioButton.getAttribute("class").contains("checked");
    }

    public CheckboxRadioPage clickOnTheTwoStarsCheckbox() {
        twoStarCheckbox.click();
        return this;
    }

    public boolean isTheTwoStarsCheckboxSelected() {
        return twoStarCheckbox.getAttribute("class").contains("checked");
    }
}
