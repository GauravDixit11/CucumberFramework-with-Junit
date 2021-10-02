package Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "@target/rerun.txt",
		glue = "stepDefinition", stepNotifications = true,
		tags = "@Smoke",
		plugin = {"pretty","html:target/report.html",
				  "rerun:target/rerun.txt"},
		dryRun = false,
		monochrome = true
		
		)

public class FailedRunner {

}
