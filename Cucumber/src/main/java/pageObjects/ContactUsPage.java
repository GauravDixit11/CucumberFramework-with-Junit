package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactUsPage {
	
	private WebDriver driver;

	private By yourName = By.id("input-name");
	private By email = By.id("input-email");
	private By enquiry = By.id("input-enquiry");
	private By submitButton = By.xpath("//input[@value='Submit']");
	private By successMessg = By.xpath("//p[text()='Your enquiry has been successfully sent to the store owner!']");

	public ContactUsPage(WebDriver driver) {
		this.driver = driver;
	}

	public String getContactUsPageTitle() {
		return driver.getTitle();
	}
	
	public void fillContactUsForm(String Name, String emailId, String enquiryMsg) {	
		driver.findElement(yourName).sendKeys(Name);
		driver.findElement(email).sendKeys(emailId);
		driver.findElement(enquiry).sendKeys(enquiryMsg);
	}

	public void clickSend() {
		driver.findElement(submitButton).click();
	}
	
	public String getSuccessMessg() {
		return driver.findElement(successMessg).getText();
	}	

}
