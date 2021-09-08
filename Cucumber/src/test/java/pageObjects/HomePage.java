package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
	
public WebDriver driver;
public String expectedHomePageTitle = "osCommerce Online Merchant Administration Tool";
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	By logoff = By.xpath("//a[@href='http://gcreddy.com/project/admin/login.php?action=logoff']");
	
	
	public WebElement clickLogoff() {
		return driver.findElement(logoff);
	}
	
	public String getHomePageTitle() {
		return driver.getTitle();
	}

}
