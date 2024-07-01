package com.sarmiento.testautomation.selenium_framework_poc;

import com.sarmiento.testautomation.selenium_framework_poc.conf.TestConfig;
import io.cucumber.java.Before;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@CucumberContextConfiguration
@SpringBootTest
@ContextConfiguration(classes = TestConfig.class)
public class CucumberSpringContextConfiguration {

    @Before
    public void setup(){
        System.out.println("Context started");
    }
}
