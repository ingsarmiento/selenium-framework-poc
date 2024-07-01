package com.sarmiento.testautomation.selenium_framework_poc.conf;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

@ComponentScan(basePackages = "com.sarmiento.testautomation.selenium_framework_poc")
@PropertySource("classpath:/application-${environment:dev}.properties")
public class TestConfig {
}
