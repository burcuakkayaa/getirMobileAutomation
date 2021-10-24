package myTestRunners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = { "pretty", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
        "timeline:test-output-thread/",
        "rerun:src/test/resources/failedrerun.txt"},
        monochrome = true,
        glue = {"stepDefinitions", "myHooks"},
        features = {"@src/test/resources/failedrerun.txt"})
public class FailedRun {
}
