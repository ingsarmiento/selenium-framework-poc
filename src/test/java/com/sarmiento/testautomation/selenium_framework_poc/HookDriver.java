package com.sarmiento.testautomation.selenium_framework_poc;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HookDriver {

    public static WebDriver driver;

    @Before
    public static void createDriver(){
        driver = new ChromeDriver();
    }

    @After
    public static void quitDriver(){
        if(driver != null){
            driver.quit();
        }
    }
}
