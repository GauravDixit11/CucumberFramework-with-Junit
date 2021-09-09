package pageObjects;

import java.util.ArrayList;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	public WebDriver driver;
	public String expectedText = "Administrator Login";
	public String expectedLoginLimitReachedErrorText = " Error: The maximum number of login attempts has been reached. Please try again in 5 minutes.";
	public String expectedErrorOnInvalidAttempt = " Error: Invalid administrator login attempt.";
	public String expectedNewSiteURL = "https://www.gcreddy.com/";

	public LandingPage(WebDriver driver) {
		this.driver = driver;
	}

	By adminstratorLoginText = By.xpath("//*[@id=\"contentText\"]/table/tbody/tr[1]/td/table/tbody/tr/td");
	By username = By.name("username");
	By password = By.name("password");
	By loginButton = By.xpath("//*[@id=\"tdb1\"]/span[2]");
	By onlineCatalog = By.xpath("/html/body/table[1]/tbody/tr[2]/td[1]/a[2]");
	By loginLimitReachedErrorText = By.xpath("/html/body/table[1]/tbody/tr/td");
	By actualErrorOnInvalidAttempt = By.xpath("/html/body/table[1]/tbody/tr/td");
	By copyrightUser = By.linkText("G C Reddy");

	public WebElement getAdminstratorLoginText() {
		return driver.findElement(adminstratorLoginText);
	}

	public WebElement getUsername() {
		return driver.findElement(username);
	}

	public WebElement getPassword() {
		return driver.findElement(password);
	}

	public WebElement clickLoginButton() {
		return driver.findElement(loginButton);
	}

	public WebElement clickOnlineCatalog() {
		return driver.findElement(onlineCatalog);
	}

	public WebElement getLoginLimitReachedText() {
		return driver.findElement(loginLimitReachedErrorText);
	}

	public WebElement getInvalidAttemptErrorText() {
		return driver.findElement(actualErrorOnInvalidAttempt);
	}

	public WebElement clickCopyrightUser() {
		return driver.findElement(copyrightUser);
	}
	
	public String userNavigateToSoftwareTestingSite() {
		ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
		return driver.getCurrentUrl();
		
	}

}
