package org.example.tests;

import io.qameta.allure.Description;
import org.example.base.CommonToAllTest;
import org.example.driver.DriverManager;

import org.example.pages.PageObjectModel.AppVwo.imporved_POM.DashboardPage;
import org.example.pages.PageObjectModel.AppVwo.imporved_POM.LoginPage;
import org.example.utils.PropertiesReader;
import org.example.utils.WaitHelpers;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestVwoLogin_03_PropertiesReader_driverManager_POM_CommanToAll extends CommonToAllTest {

    @Description("Verify the vwo login with Property reader file")
    @Test(priority = 1, enabled = true)
    public void testVwologinWithInvalidCred()
    {

        LoginPage loginPage = new LoginPage(DriverManager.getDriver());
        String error_msg=loginPage.loginToVwoWithInvalidloginCred(PropertiesReader.readKey("invalid_username"),PropertiesReader.readKey("invalid_password"));

        Assert.assertEquals(error_msg,PropertiesReader.readKey("error_message"));

    }

    @Description("Verify the vwo login with valid cred")
    @Test(priority = 1, enabled = true)
    public void test_loginWithValidCred()
    {


        LoginPage loginPage = new LoginPage(DriverManager.getDriver());
        loginPage.loginToVwoWithValidloginCred(PropertiesReader.readKey("username"),PropertiesReader.readKey("password"));


        DashboardPage dashboardPage = new DashboardPage(DriverManager.getDriver());

        String loggedInuser=dashboardPage.userDashboardLogin();

        Assert.assertEquals(loggedInuser,PropertiesReader.readKey("expected_username"));

    }


}
