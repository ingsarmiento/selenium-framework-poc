package com.sarmiento.testautomation.selenium_framework_poc.util.reporting;

import lombok.Data;

@Data
public class ScenarioExecutionInfo {

    private String status;
    private String id;
    private String name;
    private String executionId;
}
