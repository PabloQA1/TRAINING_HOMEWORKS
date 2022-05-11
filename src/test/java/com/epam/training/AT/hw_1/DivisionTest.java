package com.epam.training.AT.hw_1;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DivisionTest extends AbstractTest {

    @Test(description = "Division test")
    public void divFunctionWithLongValuesTest() {
        long result = calculator.div(10, 4);
        Assert.assertNotEquals(result, 2.5);
    }

    @Test(description = "Division test")
    public void divFunctionWithDoubleValuesTest() {
        double result = calculator.div(10.0, 4.0);
        Assert.assertEquals(result, 2.5);
    }
}
