package com.sarmiento.testautomation.selenium_framework_poc.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PageBase {

    @Autowired
    public PageBase(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
