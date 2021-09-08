package stepDefinition;


import io.cucumber.java.After;
import utilities.Base;

public class Hooks extends Base{

	@After("@RegressionTest")
	public void afterRegressionTest() {
		driver.close();
	}
	
	@After("@SmokeTest")
	public void afterSmokeTest() {
		driver.close();
	}
}
