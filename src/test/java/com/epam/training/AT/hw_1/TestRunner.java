package com.epam.training.AT.hw_1;

import com.epam.training.AT.hw_1.utils.TestListener;
import org.testng.TestNG;
import java.util.Collections;
import java.util.List;

public abstract class TestRunner {

    public static void main(String[] args) {
        TestNG testNG = new TestNG();
        testNG.addListener(new TestListener());
        List<String> files = Collections.singletonList(
                "testng.xml");
        testNG.setTestSuites(files);
        testNG.run();
    }
}
