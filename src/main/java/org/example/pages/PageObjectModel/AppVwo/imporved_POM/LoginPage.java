package org.example.pages.PageObjectModel.AppVwo.imporved_POM;

import org.example.base.CommanToAll;
import org.example.driver.DriverManager;
import org.example.utils.WaitHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.example.driver.DriverManager.driver;

public class LoginPage extends CommanToAll {

    WebDriver driver;
    public LoginPage(WebDriver driver)
    {
        this.driver = driver;
    }

    private By username = By.id("login-username");
    private By userpassword = By.id("login-password");
    private By signin = By.id("js-login-btn");
    private By errormsg=By.id("js-notification-box-msg");

    public void loginToVwoWithValidloginCred(String user,String pwd)
    {
       openVwourl();
       enterInput(username,user);
       enterInput(userpassword,pwd);
       clickElement(signin);

    }

    public String loginToVwoWithInvalidloginCred(String user,String pwd)
    {

        openVwourl();
        enterInput(username,user);
        enterInput(userpassword,pwd);
        clickElement(signin);


        WaitHelpers.checkVisibility(DriverManager.getDriver(),errormsg);

        return getText(errormsg);


    }

}
