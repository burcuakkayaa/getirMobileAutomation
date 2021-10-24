package myTestRunners;


import io.cucumber.junit.Cucumber;

import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/java/AppFeatures/category.feature"},
        glue = {"stepDefinitions", "myHooks"},
        tags = "@emulator or @realDevice",
        plugin = { "pretty", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                "timeline:test-output-thread/",
                "rerun:src/test/resources/failedrerun.txt"
        },
        monochrome = true,
        publish = true
)
public class TestRunner {
}
