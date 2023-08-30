package stepDefinitions;

import context.TestContext;
import io.cucumber.java.en.Given;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.LoginPage;
import pages.MemberSearchPage;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.en.When;
import pages.PageFactoryManager;

import java.time.Duration;
import java.util.List;
import java.util.Map;

public class MemberPageStepDefinition {

	//private WebDriver driver = DriverFactory.getDriver();

    private final WebDriver driver;
    private final LoginPage loginPage;
    private final MemberSearchPage memberSearch;

    //private WebDriver driver = DriverFactory.getDriver();

    public MemberPageStepDefinition(TestContext context)
    {
       driver = context.driver;
        memberSearch = PageFactoryManager.getMemberSearchPage(context.driver);
        loginPage = PageFactoryManager.getLoginPage(context.driver);
    }

    @When("clicks on the navigate icons")
    public void clicks_on_the_navigate_icons() {
        memberSearch.searchIcon();
        System.out.println("User successfully clicked on Service action");    }


    @When("clicks on member search menu")
    public void clicks_on_member_search_menu() throws InterruptedException {
        memberSearch.memberSearchMenuOption();
        System.out.println("User successfully clicked on Member Search from Service action");
        Thread.sleep(4000);
    }

    @Given("user enter the {string}")
    public void user_enter_the(String memID) throws InterruptedException {
        memberSearch.memberID(memID);
        System.out.println("User successfully entered member ID in member search page");
        Thread.sleep(1000);
    }

    @Given("user enter the memberID")
    public void user_enter_the_member_id(List<Map<String, String>> memberId)  {
        memberSearch.memberID(memberId.get(0).get("memberID"));
        
    }


    @Given("click on Search button")
    public void click_on_search_button() {
        memberSearch.searchBttn();
        System.out.println("User successfully clicked on the search button");
    }

}
