package stepDefinitions;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import driverInit.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LandingPage;
import pageObjects.LoginPage;

public class LandingPageSteps {
	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	private LandingPage landingPage;
	String actualpageTitle;

	@Given("user has already logged in to application")
	public void user_has_already_logged_in_to_application(DataTable credTable) {

		List<Map<String, String>> credList = credTable.asMaps();
		String userName = credList.get(0).get("username");
		String password = credList.get(0).get("password");

		DriverFactory.getDriver().get("https://naveenautomationlabs.com/opencart/");
		loginPage.navigateToLoginPage();
		landingPage = loginPage.doLogin(userName, password);

	}

	@Given("user is on Landing page")
	public void user_is_on_Landing_page() {
		actualpageTitle = landingPage.getLandingPageTitle();
	}

	@When("user get the title of the page")
	public void user_get_the_title_of_the_page() {
		System.out.println("Accounts Page title is: " + actualpageTitle);
	}

	@Then("page title should be this {string}")
	public void page_title_should_be_this(String expectedTitle) {
		assertEquals(expectedTitle, actualpageTitle);
	}

	@Then("user gets my account section")
	public void user_gets_accounts_section(DataTable sectionsTable) {

		List<String> expAccountSectionsList = sectionsTable.asList();

		System.out.println("Expected accounts section list: " + expAccountSectionsList);

		List<String> actualAccountSectionsList = landingPage.getAccountsSectionsList();
		System.out.println("Actual accounts section list: " + actualAccountSectionsList);

		Assert.assertTrue(expAccountSectionsList.containsAll(actualAccountSectionsList));

	}

	@Then("my account section count should be {int}")
	public void accounts_section_count_should_be(Integer expectedSectionCount) {
		Assert.assertTrue(landingPage.getAccountsSectionCount() == expectedSectionCount);
	}

}
