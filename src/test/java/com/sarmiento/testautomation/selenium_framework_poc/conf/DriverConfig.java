package com.sarmiento.testautomation.selenium_framework_poc.conf;

import com.sarmiento.testautomation.selenium_framework_poc.enums.Browser;
import com.sarmiento.testautomation.selenium_framework_poc.util.driver.DriverFactory;
import io.cucumber.spring.ScenarioScope;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.net.MalformedURLException;

@PropertySource("classpath:/application-${environment:dev}.properties")
@Configuration
public class DriverConfig {

    @Autowired
    private DriverFactory driverFactory;
    @Value("${browser}")
    private Browser browser;

    @Bean(destroyMethod = "quit")
    @ScenarioScope
    public WebDriver webDriver() throws MalformedURLException {
        return driverFactory.get(browser);
    }
}
