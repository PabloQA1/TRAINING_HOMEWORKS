package AT.hw_4;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class TooltipPage extends BasePage {

    @FindBy(className = "demo-frame")
    private WebElement iFrame;

    @FindBy(xpath = "//a[contains(text(),'Tooltips')]")
    private WebElement toolTip;

    @FindBy(css = ".ui-tooltip-content")
    private WebElement toolTipText;

    public TooltipPage(WebDriver driver) {
        super(driver);
    }

    public TooltipPage openPage() {
        openPage("tooltip/");
        switchToIframe(iFrame);
        return this;
    }

    public TooltipPage hoverMouseOnTheTooltipsText() {
        Actions actions = new Actions(driver);
        actions.moveToElement(toolTip)
                .perform();
        return this;
    }

    public boolean verifyToolTipText() {
        return toolTipText.getText().equals("That's what this widget is");
    }
}
