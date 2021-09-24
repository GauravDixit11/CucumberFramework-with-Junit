package stepDefinition;



import java.util.ArrayList;



import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utilities.Base;

public class Hooks extends Base{

	@Before
	public void beforeTest() {
		
		String path = System.getProperty("user.dir")+"\\report\\index.html";
		ExtentSparkReporter reporter =  new ExtentSparkReporter(path);
		reporter.config().setReportName("Cucumber Test Results");
		reporter.config().setDocumentTitle("Cucumber Test");
		
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Gaurav Dixit");
	}
	
	@After
	public void afterSmokeTest() {
		driver.close();
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs.get(0));
        driver.close();
   
 //     Explicit Wait       
 //     WebDriverWait wait = new WebDriverWait(driver, 20);
 //     wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("")));
        
        
        // Fluent Wait
	//	Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
     //   		.withTimeout(Duration.ofSeconds(10))
      //  		.pollingEvery(Duration.ofSeconds(10))
       // 		.ignoring(Exception.class);
        
      
  	}
	}

