package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	private WebDriver driver;

	// 1. By Locators: OR
	private By emailId = By.id("input-email");
	private By password = By.id("input-password");
	private By signInButton = By.xpath("//input[@value='Login']");
	private By forgotPwdLink = By.linkText("Forgotten Password");
	private By myAccount = By.xpath("//span[text()='My Account']");
	private By loginButton = By.xpath("//a[text()='Login']");

	// 2. Constructor of the page class:
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	// 3. Page actions: features(behavior) of the page the form of methods:

	public String getLoginPageTitle() {
		return driver.getTitle();
	}

	public boolean isForgotPwdLinkExist() {
		return driver.findElement(forgotPwdLink).isDisplayed();
	}

	public void enterUserName(String username) {
		driver.findElement(emailId).sendKeys(username);
	}

	public void enterPassword(String pwd) {
		driver.findElement(password).sendKeys(pwd);
	}

	public By getPassword() {
		return password;
	}

	public void setPassword(By password) {
		this.password = password;
	}

	public By getSignInButton() {
		return signInButton;
	}

	public void setSignInButton(By signInButton) {
		this.signInButton = signInButton;
	}

	public void clickOnLogin() {
		driver.findElement(signInButton).click();
	}

	public LandingPage doLogin(String un, String pwd) {
		System.out.println("login with: " + un + " and " + pwd);
		driver.findElement(emailId).sendKeys(un);
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(signInButton).click();
		return new LandingPage(driver);
	}
	
	public LandingPage navigateToLoginPage() {
		driver.findElement(myAccount).click();
		driver.findElement(loginButton).click();
		return new LandingPage(driver);
	}


}
