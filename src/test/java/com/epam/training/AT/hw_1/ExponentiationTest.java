package com.epam.training.AT.hw_1;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ExponentiationTest extends AbstractTest {

    @Test(description = "Exponent test")
    public void sqrtFunctionWithDoubleValuesTest() {
        double result = calculator.sqrt(-9.9);
        Assert.assertEquals(result, 3.146426544510455);
    }

    @Test(description = "Exponent test")
    public void powFunctionWithDoubleValuesTest() {
        double result = calculator.pow(2.5,3);
        Assert.assertEquals(result, 15.625);
    }

    @Test(description = "Exponent test")
    public void powFunctionWithDoubleValuesTest2() {
        double result = calculator.pow(-2.5,3);
        Assert.assertEquals(result, -15.625);
    }

    @Test(description = "Exponent test", groups = "Parametrized test")
    @Parameters({"first-num", "second-num"})
    public void powFunctionParametrizedTest(double firstNum, double secondNum) {
        double result = calculator.pow(firstNum,secondNum);
        Assert.assertEquals(result, 15.625);
    }
}
