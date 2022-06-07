package com.epam.training.AT.hw_1;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SubtractionTest extends AbstractTest {

    @Test(description = "Subtraction test")
    public void subFunctionWithLongValuesTest() {
        long result = calculator.sub(10, 5);
        Assert.assertEquals(result,5);
    }

    @Test(description = "Subtraction test")
    public void subFunctionWithDoubleValuesTest() {
        double result = calculator.sub(7, 3);
        Assert.assertEquals(result,4);
    }
}
