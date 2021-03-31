package com.exercise.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"com/exercise/stepDefinitions"},
        plugin = {"pretty", "html:reports/cucumber-reports", "json:reports/Cucumber.json"},
        tags = {"@E2E"},
        monochrome = true
)

public class RunCukeTest {

}