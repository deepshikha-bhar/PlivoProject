package com.Plivo.testautomation;

import org.junit.Test;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertTrue;

/**
 * Unit test for simple App.
 */
public class LoginTest extends Base
{

    @Test
    public void Login_Test()
    {
        WebDriver driver = initializeDriver();
        LoginPage l = new LoginPage(driver);
        l.loadLoginLandingPage();
        l.enterUserName(prop.getProperty("userName"));
        l.enterPassword(prop.getProperty("password"));
        l.clickLogin();
        HomePage h = new HomePage(driver);
        h.clickNumbers();
        h.clickBuyNumber();
        h.selectCountryAsUS();
        h.selectFilter("location");
        h.selectCityOrState("california");
        h.clickSearch();
        h.clickBuyForEvenNumber();
        h.validateSuccessMessage();

    }
}
