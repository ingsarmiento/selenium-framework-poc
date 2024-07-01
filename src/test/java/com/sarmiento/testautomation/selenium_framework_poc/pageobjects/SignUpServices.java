package com.sarmiento.testautomation.selenium_framework_poc.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Driver;

@Service
public class SignUpServices {

    @Autowired
    private SignUpPageObject pageObject;

    @Autowired
    private WebDriver driver;

    public void go(String url) {
        this.driver.get(url);
    }
    public void writeFirstName(String firstname) {
        this.pageObject.getFirstNameTexBox().sendKeys(firstname);
    }

    public void writeLastName(String lastName) {
        this.pageObject.getLastNameTexBox().sendKeys(lastName);
    }

    public void writeEmailAddress(String email) {
        this.pageObject.getEmailAddress().sendKeys(email);
    }

    public void writePhone(String phone) {
        this.pageObject.getPhone().sendKeys(phone);
    }

    public void selectMale() {
        this.pageObject.getGenderMale().click();
    }

    public void selectFemale() {
        this.pageObject.getGenderFemale().click();
    }

    public void writeCountry(String country) {
        new Select(this.pageObject.getCountry()).selectByValue(country);
    }

    public void writeDateOfBirthYear(String year) {
        new Select(this.pageObject.getDateOfBirthYear()).selectByValue(year);
    }

    public void writeDateOfBirthMonth(String month) {
        new Select(this.pageObject.getDateOfBirthMonth()).selectByValue(month);
    }

    public void writeDateOfBirthDay(String day) {
        new Select(this.pageObject.getDateOfBirthDay()).selectByValue(day);
    }
    /*
    public void writePassword(String password) {
        this.password).sendKeys(password);
    }*/


    public void writeConfirmPassword(String confirmPassword) {
        this.pageObject.getConfirmPassword().sendKeys(confirmPassword);
    }

    public void clickSubmit() {
        this.pageObject.getSubmit().click();
    }

    public void writeUsername(String username){
        this.pageObject.getUserNameTexBox().sendKeys(username);
    }

    public void writePassword(String password){
        this.pageObject.getPasswordTextBox().sendKeys(password);
    }

    public void clickLoginButton(){
        this.pageObject.getLoginButton().click();
    }
}
