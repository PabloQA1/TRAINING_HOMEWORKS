package AT.hw_4;

import org.testng.Assert;
import org.testng.annotations.Test;

public final class TooltipPageTest extends BasePageTest{

    @Test
    public void selectMenuTest() {
        tooltipPage.openPage()
                        .hoverMouseOnTheTooltipsText();
        Assert.assertTrue(tooltipPage.verifyToolTipText());
    }
}