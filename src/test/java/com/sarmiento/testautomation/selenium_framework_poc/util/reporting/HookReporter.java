package com.sarmiento.testautomation.selenium_framework_poc.util.reporting;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class HookReporter {

    private static final String ELASTIC_SEARCH_URL = "http://localhost:9200/automation/suite";

    private static final String EXECUTION_ID = "12b27564-42c7-4824-ad90-8fba4bde2222";

    //@After
    public void reportFinalScenarioStatus(Scenario scenario) {
        ScenarioExecutionInfo scenarioExecutionInfo = new ScenarioExecutionInfo();
        scenarioExecutionInfo.setExecutionId(EXECUTION_ID);
        scenarioExecutionInfo.setStatus(scenario.getId());
        scenarioExecutionInfo.setName(scenario.getName());
        scenarioExecutionInfo.setStatus(scenario.getStatus().toString());

        RestAssured
                .given()
                .body(scenarioExecutionInfo)
                .contentType(ContentType.JSON).when()
                .post(ELASTIC_SEARCH_URL);
    }
}
