package org.example.tests;


import io.qameta.allure.Description;
import org.example.pages.PageObjectModel.AppVwo.normal_POM.DashboardPage;
import org.example.pages.PageObjectModel.AppVwo.normal_POM.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.*;

public class TestVWOLogin_01_Normal {

    @Description("Verify the vwo login with invalid cred")
    @Test(priority = 1,enabled = true)
    public void test_vwo_loginWithNegative()
    {
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();

        LoginPage loginPage = new LoginPage(driver);
        String error_msg = loginPage.loginToVwoWithInvalidloginCred("Admin@gmail.com","273645");

        assertThat(error_msg).isNotNull().isNotBlank().isNotEmpty();
        Assert.assertEquals(error_msg,"Your email, password, IP address or location did not match");
        driver.quit();
    }

    @Description("Verify the vwo login with valid login cred")
    @Test(priority = 2,enabled = true)
    public void test_loginWitHPositive()
    {
        WebDriver driver = new EdgeDriver();

        LoginPage loginPage = new LoginPage(driver);

        loginPage.loginToVwoWithValidloginCred("contact+aug@thetestingacademy.com","TtxkgQ!s$rJBk85");

        DashboardPage dashboardPage = new DashboardPage(driver);
        String userNameOnDashboard=dashboardPage.userDashboardLogin();

        Assert.assertEquals(userNameOnDashboard,"Aman");
        driver.quit();

    }

}
