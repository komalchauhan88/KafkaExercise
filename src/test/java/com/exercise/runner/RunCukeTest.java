/**
 * JUnit runner to kick-off the execution gluing the features and stepDefinitions
 *
 * @author Komal Kumar
 */

package com.exercise.runner;

import com.exercise.stepDefinitions.KafkaExercise;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

import java.sql.SQLException;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"com/exercise/stepDefinitions"},
        plugin = {"pretty", "html:reports/cucumber-reports", "json:reports/Cucumber.json"},
        tags = {"@E2E"},
        monochrome = true
)

public class RunCukeTest extends KafkaExercise {

    public RunCukeTest() throws SQLException {
    }

    @BeforeClass
    public static void setup() {
        System.out.println("====>>>> Test Execution Started <<<<====");
    }

    @AfterClass
    public static void teardown() {

        executorService.shutdown();
        System.out.println("====>>>> Executor Services Stopped <<<<====");
        System.out.println("====>>>> Test Execution Completed <<<<====");

    }
}