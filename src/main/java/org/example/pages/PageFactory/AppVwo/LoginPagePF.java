package org.example.pages.PageFactory.AppVwo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.driver.DriverManager;
import org.example.utils.PropertiesReader;
import org.example.utils.WaitHelpers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPagePF {

    private static final Logger logger = LogManager.getLogger(LoginPagePF.class);

    WebDriver driver;
    public LoginPagePF(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//input[@id='login-username']")
    private WebElement email_address;

    @FindBy(xpath = "//input[@id='login-password']")
    private WebElement email_password;

    @FindBy(xpath = "//button[@id='js-login-btn']")
    private WebElement submit_button;

    @FindBy(xpath = "//div[@id='js-notification-box-msg']")
    private WebElement notification;

    public String vwo_login_with_invalidCred(String user,String pwd)
    {

        driver.get(PropertiesReader.readKey("url"));
        logger.info("email enter in loginpage");
        email_address.sendKeys(user);
        email_password.sendKeys(pwd);
        submit_button.click();

        WaitHelpers.checkVisibilityofelement(DriverManager.getDriver(),notification);

        return notification.getText();
    }

    public void vwo_login_withvalidCred(String user,String pwd)
    {
        driver.get(PropertiesReader.readKey("url"));
        email_address.sendKeys(user);
        email_password.sendKeys(pwd);
        submit_button.click();


    }
}
