package com.epam.training.AT.hw_1;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

public class SummationWithFactoryTest extends AbstractTest {

    private final int expectedResult;

    @Factory(dataProvider = "dataMethod")
    public SummationWithFactoryTest(int value) {
        this.expectedResult = value;
    }

    @DataProvider
    public static Object[][] dataMethod() {
        return new Object[][]{{7}};
    }

    @Test(description = "Summation test")
    public void sumtest() {
        Calculator calculator = new Calculator();
        long result = calculator.sum(2, 5);
        Assert.assertEquals(result, expectedResult);
    }
}
