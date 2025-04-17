package org.example.tests;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.base.CommonToAllTest;
import org.example.listeners.RetryAnalyzer;

import org.example.listeners.ScreenshotListener;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.example.driver.DriverManager.getDriver;


@Listeners(ScreenshotListener.class)
@Test(retryAnalyzer = RetryAnalyzer.class)
public class TestVWoWithRetry extends CommonToAllTest{

    private static final Logger logger = LogManager.getLogger(TestVWoWithRetry.class);

    @Test
    public void testFail() {
        getDriver().get("https://app.vwo.com");
        logger.info("Starting the Testcases Page Object Model");
        Assert.assertTrue(false);
    }

    @Test
    public void testPass() {
        getDriver().get("https://app.vwo.com");
        logger.info("Starting the Testcases Page Object Model");
        Assert.assertTrue(true);
    }

}
