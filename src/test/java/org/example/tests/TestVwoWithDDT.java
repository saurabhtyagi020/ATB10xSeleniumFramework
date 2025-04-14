package org.example.tests;

import io.qameta.allure.Description;
import org.example.base.CommonToAllTest;
import org.example.driver.DriverManager;
import org.example.pages.PageFactory.AppVwo.LoginPagePF;
import org.example.utils.PropertiesReader;
import org.example.utilstest.Utilexcel;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.example.driver.DriverManager.getDriver;

public class TestVwoWithDDT extends CommonToAllTest {


    @Description("Verify the VWO login with DDT for invalid test cases")
    @Test(dataProvider = "getData")
    public void test_Vwo_DDT(String email,String password)
    {
        LoginPagePF loginPagePF = new LoginPagePF(getDriver());
        String errorMsg=loginPagePF.vwo_login_with_invalidCred(email,password);

        Assert.assertEquals(errorMsg, PropertiesReader.readKey("error_message"));
    }


    @DataProvider
    public Object[][] getData(){

        return Utilexcel.readDatafromExcel("sheet1");
    }
}
