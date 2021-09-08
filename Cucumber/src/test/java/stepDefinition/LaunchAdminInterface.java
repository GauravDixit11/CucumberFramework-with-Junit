package stepDefinition;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.HomePage;
import pageObjects.LandingPage;
import pageObjects.UserInterfacePage;
import utilities.Base;

public class LaunchAdminInterface extends Base{

	LandingPage landingpage;
	UserInterfacePage userInterfacePage;
	HomePage homePage;

	@When("Launch the browser")
	public void launch_the_browser() throws Exception {
		driver = Base.getDriver();
	}

	@Then("Browser should be started")
	public void browser_should_be_started() {
		@SuppressWarnings("unused")
		String actualTitle = driver.getTitle();
		String expectedTitle = "";
		Assert.assertTrue(actualTitle = expectedTitle, true);

	}

	@Given("User is on the landing page")
	public void user_is_on_the_landing_page() {
		landingpage = new LandingPage(driver);
		Assert.assertTrue(landingpage.getAdminstratorLoginText().getText().contains(landingpage.expectedText));
	}

	@When("Enter username {string} and password {string} and click on login button")
	public void enter_username_and_password_and_click_on_login_button(String val, String val2) {
		landingpage.getUsername().sendKeys(val);
		landingpage.getPassword().sendKeys(val2);
		landingpage.clickLoginButton().click();
	}

	@When("^Enter (.*) and (.*) invalid and click on login button$")
	public void enter_and_invalid_and_click_on_login_button(String username, String password) {
		landingpage.getUsername().sendKeys(username);
		landingpage.getPassword().sendKeys(password);
		landingpage.clickLoginButton().click();
	}

	@When("Click on the link of online Catalog")
	public void click_on_the_link_of_online_catalog() {
		landingpage.clickOnlineCatalog().click();
	}

	@Then("^Capture the Error message and compare with expected for fourth times$")
	public void capture_the_error_message_and_compare_with_expected_for_fourth_times() {
		int i = 0;
		if (i == 4) {
			Assert.assertTrue(landingpage.getLoginLimitReachedText().getText()
					.contains(landingpage.expectedLoginLimitReachedErrorText));
		}
		i++;
	}

	@Then("Return the existence status of create an account,login, and Shopping Cart links")
	public void return_the_existence_status_of_create_an_account_login_and_shopping_cart_links() {

		userInterfacePage = new UserInterfacePage(driver);

		Assert.assertTrue(userInterfacePage.clickLogin().isDisplayed());
		Assert.assertTrue(userInterfacePage.clickCreateAccount().isDisplayed());
		Assert.assertTrue(userInterfacePage.clickShoppingCart().isDisplayed());
	}

	@Then("Verify the user is on User Interface")
	public void verify_the_user_is_on_user_interface() {
		userInterfacePage = new UserInterfacePage(driver);
		Assert.assertTrue(
				userInterfacePage.getUserInterfacePageTitle().contains(userInterfacePage.expectedUserInterfaceTitle));

	}

	@Then("Capture the text Administrator Login for verification")
	public void capture_the_text_adminstrator_login_for_verification() {

		Assert.assertTrue(landingpage.getAdminstratorLoginText().getText().contains(landingpage.expectedText));

	}

	@Then("User lands on home page of Admin Interface")
	public void user_lands_on_home_page_of_admin_interface() {
		homePage = new HomePage(driver);
		Assert.assertTrue(homePage.getHomePageTitle().contains(homePage.expectedHomePageTitle));
	}

	@Then("Check the text on the home page")
	public void check_the_text_on_the_home_page() throws InterruptedException {
		Thread.sleep(10);
		homePage.clickLogoff().click();
	}

	@Then("Error message should be displayed on landing page")
	public void error_message_should_be_displayed_on_landing_page() {

		Assert.assertTrue(
				landingpage.getInvalidAttemptErrorText().getText().contains(landingpage.expectedErrorOnInvalidAttempt));
	}

}
