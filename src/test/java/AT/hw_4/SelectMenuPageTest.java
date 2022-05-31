package AT.hw_4;

import org.testng.Assert;
import org.testng.annotations.Test;

public final class SelectMenuPageTest extends BasePageTest {

    @Test
    public void selectMenuTest() {
        selectMenuPage.openPage()
                .selectFastSpeed()
                .selectNumber();
        Assert.assertTrue(selectMenuPage.isSpeedSelectMenuContainsText());
        Assert.assertTrue(selectMenuPage.isSelectNumberMenuContainsNum());
    }
}