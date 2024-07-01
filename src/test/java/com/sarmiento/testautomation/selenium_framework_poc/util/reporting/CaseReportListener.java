package com.sarmiento.testautomation.selenium_framework_poc.util.reporting;

import io.cucumber.plugin.ConcurrentEventListener;
import io.cucumber.plugin.event.*;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class CaseReportListener implements ConcurrentEventListener {

    private static final String ELASTIC_SEARCH_URL = "http://localhost:9200/automation/suite";

    private static final String EXECUTION_ID = "12b27564-42c7-4824-ad90-8fba4bde2222";

  /*  public void onTestCaseStarted(TestCaseEvent event) {
        TestCase testCase = event.getTestCase();
        System.out.printf("Starting %s\n", testCase.getName());
    }*/

    public void onTestCaseFinished(TestCaseFinished event) {
        /*TestCase testCase = event.getTestCase();
        System.out.printf("Finished %s\n", testCase.getName());

        Result result = event.getResult();
        if (result.getStatus() == Status.FAILED) {
            final Throwable error = result.getError();
            error.printStackTrace();
        }*/
        ScenarioExecutionInfo scenarioExecutionInfo = new ScenarioExecutionInfo();
        scenarioExecutionInfo.setExecutionId(EXECUTION_ID);
        scenarioExecutionInfo.setStatus(event.getTestCase().getId().toString());
        scenarioExecutionInfo.setName(event.getTestCase().getName());
        scenarioExecutionInfo.setStatus(event.getResult().getStatus().toString());

        RestAssured
                .given()
                .body(scenarioExecutionInfo)
                .contentType(ContentType.JSON).when()
                .post(ELASTIC_SEARCH_URL);
    }

    @Override
    public void setEventPublisher(EventPublisher eventPublisher) {
        eventPublisher.registerHandlerFor(TestCaseFinished.class, this::onTestCaseFinished);
    }
}
