package stepDefinitions;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;

import driverInit.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.ContactUsPage;
import utilities.ExcelReader;

public class ContactUsSteps {
	
	private ContactUsPage contactUsPage = new ContactUsPage(DriverFactory.getDriver());

	@Given("user navigates to contact us page")
	public void user_navigates_to_contact_us_page() {
		DriverFactory.getDriver().get("https://naveenautomationlabs.com/opencart/index.php?route=information/contact");
	}

	@When("user fills the form from given sheetname {string} and rownumber {int}")
	public void user_fills_the_form_from_given_sheetname_and_rownumber(String sheetName, Integer rowNumber) throws InvalidFormatException, IOException {
		
		ExcelReader reader = new ExcelReader();
		List<Map<String,String>> testData = 
				reader.getData("./src/test/resources/config/Automation.xlsx", sheetName);
		
		String name = testData.get(rowNumber).get("name");
		String email = testData.get(rowNumber).get("email");
		String enquiry = testData.get(rowNumber).get("enquiry");
		
		contactUsPage.fillContactUsForm(name, email, enquiry);

	}

	@When("user clicks on send button")
	public void user_clicks_on_send_button() {
		contactUsPage.clickSend();
	}

	@Then("it shows a successful message {string}")
	public void it_shows_a_successful_message(String expSuccessMessage) {
		String actualSuccMessg = contactUsPage.getSuccessMessg();
		Assert.assertEquals(actualSuccMessg, expSuccessMessage);
	}

}
