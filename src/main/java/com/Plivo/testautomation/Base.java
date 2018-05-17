package com.Plivo.testautomation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

/**
 * Hello world!
 *
 */
public class Base
{
    public static Properties prop = new Properties();
    public WebDriver driver = null;
    public WebDriver initializeDriver() {
        try {
            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
            String fileLoc = new File(".").getCanonicalPath();
            FileInputStream fileInputStream = new FileInputStream(fileLoc + "/src/main/resources/input.properties");
            prop.load(fileInputStream);
            String browserName = prop.getProperty("browser");
            if(browserName.equalsIgnoreCase("chrome"))
            {
                String chromePath = prop.getProperty("chrome.driver.path");
                System.setProperty("webdriver.chrome.driver",chromePath);
                driver = new ChromeDriver();
            }
            else if(browserName.equalsIgnoreCase("firefox")) {
                String firefoxPath = prop.getProperty("gecko.driver.path");
                System.setProperty("webdriver.gecko.driver", firefoxPath);
                driver = new FirefoxDriver();
            }
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return driver;
    }
}
