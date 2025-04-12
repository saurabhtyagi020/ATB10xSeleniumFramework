package org.example.pages.PageObjectModel.AppVwo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage {

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
        return driver.findElement(loggedUser).getText();
    }
}
