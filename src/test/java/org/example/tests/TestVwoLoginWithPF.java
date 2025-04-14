package org.example.tests;

import io.qameta.allure.Description;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.base.CommonToAllTest;
import org.example.driver.DriverManager;
import org.example.pages.PageFactory.AppVwo.DashboardPage_PF;
import org.example.pages.PageFactory.AppVwo.LoginPagePF;
import org.example.utils.PropertiesReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestVwoLoginWithPF extends CommonToAllTest {

    private static final Logger logger = LogManager.getLogger(TestVwoLoginWithPF.class);

    @Description("Verify VWO login with invalid cred PF ")
    @Test(priority = 1)
    public void test_vwo_login_invaidcred()
    {
        logger.info("Test case started");
        LoginPagePF loginPagePF = new LoginPagePF(DriverManager.getDriver());
        String error_msg=loginPagePF.vwo_login_with_invalidCred(PropertiesReader.readKey("invalid_username"),PropertiesReader.readKey("invalid_password"));
        logger.info("Test case finished");

        Assert.assertEquals(error_msg,PropertiesReader.readKey("error_message"));

    }

    @Description("Verify that VWO login with valid creds")
    @Test(priority = 2,enabled = false)
    public void test_vwo_login_withValidCred()
    {
        LoginPagePF loginPagePF = new LoginPagePF(DriverManager.getDriver());
        loginPagePF.vwo_login_withvalidCred(PropertiesReader.readKey("username"),PropertiesReader.readKey("password"));

        DashboardPage_PF dashboardPagePf = new DashboardPage_PF(DriverManager.getDriver());
        String loggedUsername=dashboardPagePf.vwo_dashboard_login();

        Assert.assertEquals(loggedUsername,PropertiesReader.readKey("expected_username"));
    }

}
