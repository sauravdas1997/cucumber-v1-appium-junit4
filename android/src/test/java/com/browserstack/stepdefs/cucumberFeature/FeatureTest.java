package com.browserstack.stepdefs.cucumberFeature;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import java.util.Objects;

public class FeatureTest {
    @Given("^I run a sample step$")
    public void sampleStep() {
        System.out.println("Running Sample step");
    }

    @And("^This Step (.+)$")
    public void passingStep(String status) {
        if (Objects.equals(status, "passes")) {
            Assert.assertTrue(true);
        } else {
            Assert.fail();
        }
    }

    @Then("I enter params here '(.+)' and password '(.+)'")
    public void theyEnterUsernameAndPassword(String username, String password) {
        System.out.println("USERNAME: " + username +  " & PASSWORD: " + password);
    }

    @Then("^I run a step that will have a PendingException$")
    public void pendingExceptionStep() {
        throw new PendingException("This step is intentionally skipped.");
    }

    @Then("^I run a step that will fail with Exception$")
    public void exceptionStep() throws Exception {
        throw new RuntimeException("This step fail with an exception.");
    }

    @Before
    public void setUp() {
        System.out.println("Running Setup before test");
    }

    @After
    public void tearDown() {
        System.out.println("Running Teardown after test");
    }
}
