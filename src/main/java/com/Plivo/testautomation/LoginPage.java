package com.Plivo.testautomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Unit test for simple App.
 */
public class LoginPage extends Base
{
    public WebDriver driver = null;
    public LoginPage(WebDriver driver)
    {
        this.driver = driver;
    }

    public void loadLoginLandingPage()
    {
        driver.get("https://manage.plivo.com/accounts/login/");
    }

    public void enterUserName(String username)
    {
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys(username);
    }

    public void enterPassword(String password)
    {
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
    }

    public void clickLogin()
    {
        driver.findElement(By.xpath("//button[text()='Login']")).click();
    }
}
