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
<<<<<<< HEAD

=======
>>>>>>> bf754452526f4d8b1fe64bc47af18d052c5bfbc0

)

public class CukesRunner {
}
