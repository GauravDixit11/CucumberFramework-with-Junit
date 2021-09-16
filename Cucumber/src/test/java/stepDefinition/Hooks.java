package stepDefinition;


import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;
import utilities.Base;

public class Hooks extends Base{

	
	
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

