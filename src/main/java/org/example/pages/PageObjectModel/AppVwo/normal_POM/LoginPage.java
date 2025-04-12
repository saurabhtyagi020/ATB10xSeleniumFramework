package org.example.pages.PageObjectModel.AppVwo.normal_POM;

import org.example.utils.WaitHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver;
     public LoginPage(WebDriver driver)
     {
         this.driver = driver;
     }


     // Page locators

        private By username = By.id("login-username");
        private By userpassword = By.id("login-password");
        private By signin = By.id("js-login-btn");
        private By errormsg=By.id("js-notification-box-msg");

        //page action

    public void loginToVwoWithValidloginCred(String user,String pwd)
    {
        driver.get("http://app.vwo.com");
        driver.findElement(username).sendKeys(user);
        driver.findElement(userpassword).sendKeys(pwd);
        driver.findElement(signin).click();

        WaitHelpers.waitJVM(5000);

    }

    public String loginToVwoWithInvalidloginCred(String user,String pwd)
    {
        driver.get("https://app.vwo.com");
        driver.findElement(username).sendKeys(user);
        driver.findElement(userpassword).sendKeys(pwd);
        driver.findElement(signin).click();

       // WaitHelpers.waitJVM(5000);
        WaitHelpers.checkVisibility(driver,errormsg);

       return driver.findElement(errormsg).getText();


    }


}
