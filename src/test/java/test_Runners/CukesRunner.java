package test_Runners;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = "html:target/cucumber-reports",
        features = "src/test/resources/features",
        glue = "step_definitions",
        dryRun = false,
        tags =  "@smoketest"


)

public class CukesRunner {
}
