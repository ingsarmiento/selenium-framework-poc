package com.sarmiento.testautomation.selenium_framework_poc.tasks;

import com.sarmiento.testautomation.selenium_framework_poc.pageobjects.SignUpServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SignIn {

    @Autowired
    private SignUpServices signUpServices;

    public void signIn() {
        signUpServices.clickLoginButton();
    }
}
