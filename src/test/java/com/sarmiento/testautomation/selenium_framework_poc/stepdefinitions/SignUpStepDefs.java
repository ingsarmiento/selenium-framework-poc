package com.sarmiento.testautomation.selenium_framework_poc.stepdefinitions;

import com.sarmiento.testautomation.selenium_framework_poc.builders.data.UserBuilder;
import com.sarmiento.testautomation.selenium_framework_poc.models.User;
import com.sarmiento.testautomation.selenium_framework_poc.pageobjects.SignUpServices;
import com.sarmiento.testautomation.selenium_framework_poc.tasks.NavigateTo;
import com.sarmiento.testautomation.selenium_framework_poc.tasks.SignIn;
import com.sarmiento.testautomation.selenium_framework_poc.tasks.UserFillSignIn;
import io.cucumber.java.en.*;
import io.cucumber.spring.ScenarioScope;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;

@ScenarioScope
public class SignUpStepDefs {

    @Autowired
    private NavigateTo navigateTo;
    @Autowired
    private UserFillSignIn userFillSignIn;
    @Autowired
    private SignIn signIn;

    @Given("Pepito wants to have an account")
    public void pepito_wants_to_have_an_account() {
        navigateTo.goToLoginPage();
    }

    @When("he sends required information to get the account")
    public void he_sends_required_information_to_get_the_account() {
        userFillSignIn.fillData(UserBuilder.createUser().withDefaultInfo().build());
    }

    @Then("he should be told that the account was created")
    public void heShouldBeToldThatTheAccountWasCreated() {
        signIn.signIn();
    }

    @Then("he should be told that the account was not created")
    public void heShouldBeToldThatTheAccountWasNotCreated() {
        assertThat(true).isEqualTo(false);
    }
}
