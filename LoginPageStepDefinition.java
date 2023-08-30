package stepDefinitions;

import context.TestContext;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.PageFactoryManager;

import java.util.List;
import java.util.Map;

public class LoginPageStepDefinition {
	private final WebDriver driver;
	private final LoginPage loginPage;
	//private WebDriver driver = DriverFactory.getDriver();

	public LoginPageStepDefinition(TestContext context)
	{
		driver = context.driver;
		loginPage = PageFactoryManager.getLoginPage(context.driver);

	}
	
	@Given("Launch Browser and Navigate to website")
	public void launch_browser_and_navigate_to_website() {
		//driver = DriverFactory.getDriver();
		  driver.get("https://ust-hps-int-dev-ed.my.salesforce.com/");
		//driver.get("https://usthps-coa-dev-ed.my.salesforce.com/");
		
	}

	@When("User enter {string} and valid {string}")
	public void user_enter_and_valid(String email, String password) throws InterruptedException {
		loginPage.LogIn_Action(email, password);
	}
	@When("User enter username {string} and valid password {string}")
	public void user_enter_username_and_valid_password(String email, String password) throws InterruptedException {
		System.out.println("Email = "+ email + "Password ="+ password);
		String pass = password+'#';
		loginPage.LogIn_Action(email, pass);
	}

	@When("User enter username and valid password")
	public void user_enter_username_and_valid_password(List<Map<String, String>> Customers) throws InterruptedException {
	String email = Customers.get(0).get("username");
	String pass = Customers.get(0).get("password");
		loginPage.LogIn_Action(email, pass);
	}


	@When("click on signin button")
	public void click_on_signin_button() throws InterruptedException {
		loginPage.clickonSignin();
	}

	@Then("Navigate to Home page")
	public void navigate_to_home_page() {
	   System.out.println("successfully Landed on Homepage");
	}


}
