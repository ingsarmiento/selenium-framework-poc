package com.sarmiento.testautomation.selenium_framework_poc;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features",
        plugin = {"me.jvt.cucumber.report.PrettyReports:target/cucumber",
        "com.sarmiento.testautomation.selenium_framework_poc.util.reporting.CaseReportListener"})
public class CucumberTest {
}
