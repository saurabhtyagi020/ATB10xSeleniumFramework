package org.example.pages.PageObjectModel.AppVwo.imporved_POM;

import org.example.base.CommanToAll;
import org.example.driver.DriverManager;
import org.example.utils.WaitHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage extends CommanToAll {

    WebDriver driver;
    public DashboardPage(WebDriver driver)
    {
        this.driver= driver;
    }

    //Page locator
    private By loggedUser = By.xpath("//span[@data-qa='lufexuloga']");

    //Page Actions

    public String userDashboardLogin()
    {
        WaitHelpers.checkVisibility(DriverManager.getDriver(),loggedUser);
        return getText(loggedUser);
    }

}
