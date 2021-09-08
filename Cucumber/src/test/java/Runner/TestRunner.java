package Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/java/features",
		glue = "stepDefinition", stepNotifications = true,
		tags = "@Smoke",
		plugin = {"pretty","html:target/report.html","junit:target/reports.xml"},
		dryRun = false,
		monochrome = true
		
		)

public class TestRunner {

}
