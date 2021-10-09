package Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/AccountsPage.feature",
		glue = "stepDefinition", stepNotifications = true,
		plugin = {"pretty",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				"timeline:test-output-thread/",
				 "rerun:target/rerun.txt"},
		dryRun = false,
		monochrome = true
		
		)

public class TestRunner {

}
