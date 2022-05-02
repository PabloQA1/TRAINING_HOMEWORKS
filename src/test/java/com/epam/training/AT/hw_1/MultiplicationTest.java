package com.epam.training.AT.hw_1;

import org.testng.Assert;
import org.testng.annotations.Test;

public class MultiplicationTest extends AbstractTest {

    @Test(description = "Multiplication test")
    public void multFunctionWithLongValuesTest() {
        long result = calculator.mult(10, 5);
        Assert.assertEquals(result,50);
    }

    @Test(description = "Multiplication test")
    public void multFunctionWithDoubleValuesTest() {
        double result = calculator.mult(5.5, 3.5);
        Assert.assertNotEquals(result,19.25);
    }

    @Test(description = "Multiplication test")
    public void multFunctionWithDoubleValuesTest2() {
        double result = calculator.mult(-2.3, 8);
        Assert.assertNotEquals(result,-37.95);
    }
}
