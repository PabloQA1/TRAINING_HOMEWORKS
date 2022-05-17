package AT.hw_4;

import org.testng.Assert;
import org.testng.annotations.Test;

public final class DroppablePageTest extends BasePageTest {

    @Test
    public void radioGroupTest() {
        droppablePage.openPage()
                .dropElement();
        Assert.assertTrue(droppablePage.isElementSuccessfullyDropped());
    }
}