package com.sarmiento.testautomation.selenium_framework_poc.pageobjects;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

@Getter
@Component
public class SignUpPageObject extends PageBase {

    public SignUpPageObject(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@ng-model='FirstName']")
    private WebElement firstNameTexBox;
    @FindBy(xpath = "//input[@ng-model='LastName']")
    private WebElement lastNameTexBox;
    @FindBy(xpath = "//input[@ng-model='email']")
    private WebElement emailAddress;
    @FindBy(xpath = "//input[@type='tel']")
    private WebElement phone;
    @FindBy(xpath = ("//input[@value='Male']"))
    private WebElement genderMale;
    @FindBy(xpath = "//input[@value='FeMale']")
    private WebElement genderFemale;
    @FindBy(id = "countries")
    private WebElement country;
    @FindBy(id = "yearbox")
    private WebElement dateOfBirthYear;
    @FindBy(xpath = "//select[@ng-model='monthbox']")
    private WebElement dateOfBirthMonth;
    @FindBy(id = "daybox")
    private WebElement dateOfBirthDay;
    @FindBy(id = "firstpassword")
    private WebElement password;
    @FindBy(id = "secondpassword")
    private WebElement confirmPassword;
    @FindBy(id = "submitbtn")
    private WebElement submit;
    @FindBy(id = "user-name")
    private WebElement userNameTexBox;
    @FindBy(id = "password")
    private WebElement passwordTextBox;
    @FindBy(id = "login-button")
    private WebElement loginButton;


}
