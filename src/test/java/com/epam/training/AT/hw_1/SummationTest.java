package com.epam.training.AT.hw_1;

import com.epam.training.AT.hw_1.utils.TestListener;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestListener.class)
public class SummationTest extends com.epam.training.AT.hw_1.AbstractTest {

    @Test(description = "Summation test")
    public void sumFunctionWithLongValuesTest() {
        long result = calculator.sum(2, 5);
        Assert.assertEquals(result, 7);
    }

    @Test(description = "Summation test")
    public void sumFunctionWithDoubleValuesTest() {
        double result = calculator.sum(4.5, 5.5);
        Assert.assertEquals(result,10);
    }
}
