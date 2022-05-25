package com.epam.training.AT.hw_1;

import org.testng.annotations.*;
public abstract class AbstractTest {

    com.epam.tat.module4.Calculator calculator;

    @BeforeSuite
    public void beforeSuite(){
        System.out.println("Test suite STARTS!>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" +
                ">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
    }

    @BeforeMethod (groups = "SetUp")
    public void setUpCalculator() {
    calculator = new com.epam.tat.module4.Calculator();
    }

    @AfterTest
    public void afterSuite(){
        System.out.println("Test suite has FINISHED!>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" +
                ">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
    }
    @DataProvider
    public static Object[][] DataProvider() {
        return new Object[][]{
                {1},
                {22342},
                {113234},
                {21345},
                {1768},
                {22562}};
    }
}
