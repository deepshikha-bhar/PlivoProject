package com.Plivo.testautomation;

//import org.apache.bcel.generic.Select;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.WebDriver;

import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * Unit test for simple App.
 */
public class HomePage
{
    public WebDriver driver = null;
    public HomePage(WebDriver driver)
    {
        this.driver = driver;
    }



    public void clickNumbers()
    {
        driver.findElement(By.xpath("//a[contains(@href,'number')]")).click();
    }

    public void clickBuyNumber()
    {
        driver.findElement(By.xpath("//a[contains(@href,'number') and text()='Buy Number']")).click();
    }

    public void selectCountryAsUS()
    {
        Select drpCountry = new Select(driver.findElement(By.xpath("//select[@id='country']")));
        drpCountry.selectByValue("US");

    }
    public void selectFilter(String filter)
    {
        Select drpFilter = new Select(driver.findElement(By.xpath("//select[@placeholder='Select a filter']")));
        drpFilter.selectByValue(filter);
    }

    public void selectCityOrState(String city)
    {
        driver.findElement(By.xpath("//input[@placeholder='City or State']")).sendKeys(city);
    }
    public void clickSearch(){
        try {
            driver.findElement(By.xpath("//button[@type='submit']")).click();
            Thread.sleep(10000);
        }
        catch(Exception e)
        {

        }
    }
    public void clickBuyForEvenNumber()
    {
        List<WebElement> elements= driver.findElements(By.xpath("//div[@class='number-search-results']//tbody/tr"));
        int i=1;
        for (WebElement element:elements){
            String phoneNumber = element.getAttribute("id");
            if(phoneNumber.charAt(1)=='2' && (Integer.parseInt(phoneNumber.substring(1)))%2==0) {
                driver.findElement(By.xpath("//div[@class='number-search-results']//tbody/tr["+i+"]//td/button[contains(text(),'Buy')]")).click();
                break;
            }
            i++;
        }

    }

    public void validateSuccessMessage()
    {
        String message = driver.findElement(By.xpath("//div[@id='result']")).getText();
        String successMessage = driver.findElement(By.xpath("//div[@class='modal-header']/p")).getText();
        System.out.println(message);
        Assert.assertEquals("Failure message is thrown ","Buy This Number",successMessage);
    }
}
