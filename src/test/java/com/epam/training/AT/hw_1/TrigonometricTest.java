package com.epam.training.AT.hw_1;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TrigonometricTest extends AbstractTest {

    @Test(description = "Trigonometric test", priority = 4)
    public void tgFunctionWithDoubleValuesTest() {
        double result = calculator.tg(1);
        Assert.assertEquals(result,0.0174550649282175);
    }

    @Test(description = "Trigonometric test", priority = 3)
    public void ctgFunctionWithDoubleValuesTest() {
        double result = calculator.ctg(15);
        Assert.assertEquals(result,3.7320508075688772);
    }

    @Test(description = "Trigonometric test", priority = 2)
    public void cosFunctionWithDoubleValuesTest() {
        double result = calculator.cos(1);
        Assert.assertEquals(result,0.9998476951563912);
    }

    @Test(description = "Trigonometric test", priority = 1)
    public void sinFunctionWithDoubleValuesTest() {
        double result = calculator.sin(0);
        Assert.assertEquals(result,0.0);
    }
}
