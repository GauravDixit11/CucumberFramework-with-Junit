package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UserInterfacePage {
	public WebDriver driver;
	public String expectedUserInterfaceTitle = "GCR Shop";
	
	public UserInterfacePage(WebDriver driver) {
		this.driver = driver;
	}

	By login = By.linkText("login");
	By createAccount = By.linkText("create an account");
	By shoppingCart = By.linkText("Shopping Cart");
	
	
	public WebElement clickLogin() {
		return driver.findElement(login);
	}
	
	public WebElement clickCreateAccount() {
		return driver.findElement(createAccount);
	}
	
	public WebElement clickShoppingCart() {
		return driver.findElement(shoppingCart);
	}
	
	public String getUserInterfacePageTitle() {
		return driver.getTitle();
		
	}
}
