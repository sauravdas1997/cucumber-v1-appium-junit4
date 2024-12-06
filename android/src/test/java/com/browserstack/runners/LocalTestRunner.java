package com.browserstack.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/localTest/",
//        dryRun = true, // To Skip tests
        glue = "com.browserstack.stepdefs.demoTest",
        plugin = {"pretty", "html:target/cucumber-report.html"}
)
public class LocalTestRunner {
}
