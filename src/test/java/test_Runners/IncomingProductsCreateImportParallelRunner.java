package test_Runners;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"html:target/default-cucumber-reports",
                "json:target/parallel-cucumber3.json"
        },
        features = "src/test/resources/features/incoming_products_create_import",
        glue = "step_definitions"
)
public class IncomingProductsCreateImportParallelRunner {
}
