package AT.hw_4;

import org.testng.Assert;
import org.testng.annotations.Test;

public final class CheckboxRadioPageTest extends BasePageTest {

    @Test
    public void radioGroupTest() {
        checkboxRadioPage.openPage()
                .clickOnTheNewYorkRadioButton();
        Assert.assertTrue(checkboxRadioPage.isTheNewYorkRadioButtonSelected());
    }

    @Test
    public void checkboxTest() {
        checkboxRadioPage.openPage()
                .clickOnTheTwoStarsCheckbox();
        Assert.assertTrue(checkboxRadioPage.isTheTwoStarsCheckboxSelected());
    }
}