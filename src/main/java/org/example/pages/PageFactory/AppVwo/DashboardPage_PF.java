package org.example.pages.PageFactory.AppVwo;

import org.example.driver.DriverManager;
import org.example.utils.WaitHelpers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage_PF {

    WebDriver driver;
    public DashboardPage_PF(WebDriver driver)
    {
        this.driver= driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//span[@data-qa='lufexuloga']")
    private WebElement dashboard;

    public String vwo_dashboard_login()
    {
        WaitHelpers.checkVisibilityofelement(DriverManager.getDriver(),dashboard);
        return dashboard.getText();
    }
}

