package AT.hw_4;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class DroppablePage extends BasePage {

    @FindBy(className = "demo-frame")
    private WebElement iFrame;

    @FindBy(id = "draggable")
    private WebElement draggableElement;

    @FindBy(id = "droppable")
    private WebElement droppableElement;

    public DroppablePage(WebDriver driver) {
        super(driver);
    }

    public DroppablePage openPage() {
        openPage("droppable/");
        switchToIframe(iFrame);
        return this;
    }

    public DroppablePage dropElement() {
        Actions actions = new Actions(driver);
        actions.dragAndDrop(draggableElement, droppableElement)
                .perform();
        return this;
    }

    public boolean isElementSuccessfullyDropped() {
        return droppableElement.getText().contains("Dropped!");
    }
}
