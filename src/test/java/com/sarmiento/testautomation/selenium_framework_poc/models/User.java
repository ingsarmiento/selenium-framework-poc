package com.sarmiento.testautomation.selenium_framework_poc.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {
    private String username;
    private String password;
}
