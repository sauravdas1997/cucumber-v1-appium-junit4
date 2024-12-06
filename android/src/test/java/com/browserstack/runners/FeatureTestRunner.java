package com.browserstack.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/featureTest/",
//        dryRun = true, // To Skip tests
        glue = "com.browserstack.stepdefs.cucumberFeature",
        plugin = {"pretty", "html:target/cucumber-report.html"}
)
public class FeatureTestRunner {
}
