package stepDefinition;


import java.util.ArrayList;

import io.cucumber.java.After;
import utilities.Base;

public class Hooks extends Base{

	
	
	@After
	public void afterSmokeTest() {
		driver.close();
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs.get(0));
        driver.close();
	}
}
