package com.sarmiento.testautomation.selenium_framework_poc.builders.data;

import com.sarmiento.testautomation.selenium_framework_poc.models.User;

public class UserBuilder {

    private User user;

    public static UserBuilder createUser() {
        return new UserBuilder();
    }

    public UserBuilder but(){
        return withDefaultInfo();
    }

    public UserBuilder withDefaultInfo() {
        this.user = User.builder().username("standard_user").password("secret_sauce").build();
        return this;
    }

    public User build() {
        return this.user;
    }
}
