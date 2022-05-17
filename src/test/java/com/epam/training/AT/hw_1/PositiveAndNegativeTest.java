package com.epam.training.AT.hw_1;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PositiveAndNegativeTest extends AbstractTest {

    @Test(description = "Positive and negative test")
    public void isPositiveFunctionWithLongValuesTest() {
        boolean result = calculator.isPositive(3);
        Assert.assertTrue(result);
    }

    @Test(description = "Positive and negative test")
    public void isNegativeFunctionWithLongValuesTest() {
        boolean result = calculator.isNegative(-1);
        Assert.assertTrue(result);
    }

    @Test(description = "Positive and negative test")
    public void isNegativeFunctionWithLongValuesTest2() {
        boolean result = calculator.isNegative(-0);
        Assert.assertFalse(result);
    }

    @Test(description = "Positive and negative test", dataProvider = "DataProvider")
    public void isPositiveFunctionWithDataProviderTest(int value) {
        boolean result = calculator.isPositive(value);
        Assert.assertTrue(result);
    }
}
