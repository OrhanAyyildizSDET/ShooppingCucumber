package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "pretty",
                "html:target/html_reports/cucumber.html",
                "json:target/json_reports/cucumber.json",
                "junit:target/xml_reports/cucumber.xml",
                "rerun:target/failedRerun.txt",
        },
        monochrome = false,
        features = "./src/test/resources/features",
        glue = {"stepDefinitions"},
        tags = " @customer_exel",
        dryRun = false
)

/*Runners class is used for run test case
Runners connects feature files and step definitions
feature:path of the features
glue:path of the step definitions
*/
public class RegressionTestRunner {
}