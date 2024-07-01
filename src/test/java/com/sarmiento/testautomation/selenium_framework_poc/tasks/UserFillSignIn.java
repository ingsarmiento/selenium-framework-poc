package com.sarmiento.testautomation.selenium_framework_poc.tasks;

import com.sarmiento.testautomation.selenium_framework_poc.models.User;
import com.sarmiento.testautomation.selenium_framework_poc.pageobjects.SignUpServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserFillSignIn {

    @Autowired
    private SignUpServices signUpServices;

    public void fillData(User user){
        signUpServices.writeUsername(user.getUsername());
        signUpServices.writePassword(user.getPassword());
    }
}
