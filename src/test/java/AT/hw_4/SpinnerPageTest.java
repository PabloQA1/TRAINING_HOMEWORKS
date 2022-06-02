package AT.hw_4;

import org.testng.Assert;
import org.testng.annotations.Test;

public final class SpinnerPageTest extends BasePageTest{

    @Test
    public void SpinnerTest(){
        spinnerPage.openPage()
                .clickOnTheSetValueToFiveButton()
                .clickOnTheGetValueButton();
        Assert.assertTrue(spinnerPage.verifySelectedValueFromAlert());
    }
}