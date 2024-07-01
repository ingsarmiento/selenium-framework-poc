package com.sarmiento.testautomation.selenium_framework_poc.util.reporting;

import com.sarmiento.testautomation.selenium_framework_poc.enums.TakeScreenshotCondition;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;

import java.util.UUID;

public class PhotographerHook {

    @Autowired
    private ApplicationContext ctx;

    @Value("${take.screenshot.condition}")
    TakeScreenshotCondition condition;

    @After
    public void takeScreenshotAfterScenario(Scenario scenario) {
        if (TakeScreenshotCondition.endOfScenario == condition)
            takeScreenShot(scenario);
    }

    @AfterStep
    public void takeScreenshotAfterEveryStep(Scenario scenario) {
        if (TakeScreenshotCondition.everyStep == condition)
            takeScreenShot(scenario);
    }

    @After
    public void takeScreenshotAfterFailing(Scenario scenario) {
        if (TakeScreenshotCondition.failingScenario == condition && scenario.isFailed())
            takeScreenShot(scenario);
    }

    private void takeScreenShot(Scenario scenario) {
        try {
            final byte[] screenshot = this.ctx.getBean(TakesScreenshot.class).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "img/png", UUID.randomUUID().toString());
        } catch (WebDriverException wde) {
            System.out.printf("There was an error taking screenshot: %s\n", wde.getMessage());
        }
    }
}
