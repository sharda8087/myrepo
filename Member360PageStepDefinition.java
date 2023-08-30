package stepDefinitions;

import context.TestContext;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.MemberSearchPage;
import pages.MemberVerificationPage;
import pages.PageFactoryManager;
import java.util.List;
import java.util.Map;

public class Member360PageStepDefinition {

   // private final WebDriver driver;
    private final MemberSearchPage memberSearch;
   private final MemberVerificationPage memberVerification;

    public Member360PageStepDefinition(TestContext context)
    {
        //this.driver = context.driver;
        //No use of driver on this page if required then we can enable above line, as of now
        // we are passing drive reference directly in class object below
        memberSearch = PageFactoryManager.getMemberSearchPage(context.driver);
        memberVerification = PageFactoryManager.getMemberVerificationPage(context.driver);
    }


    @When("Clicks on validate Member button")
    public void clicks_on_validate_member_button() throws InterruptedException {
       memberSearch.clickValidateMemberBtn();
    }
    @When("Validate member verification popup is displayed")
    public void validate_member_verification_popup_is_displayed() throws InterruptedException {

        String actual = memberVerification.validateCaseOriginVerificationPop();
        String expected = "Member Verification";
        Assert.assertEquals(actual, expected);

    }
    @Then("Select case origin and select Inbound Phonecall")
    public void select_case_origin_and_select_inbound_phonecall() throws InterruptedException {

        memberVerification.setCaseOrigin();
        memberVerification.setInbountPhoneCall();

    }
    @Then("select member type")
    public void select_member_type() throws InterruptedException {
        System.out.println("Now selecting member type member only");
        memberVerification.setMemberType();
        memberVerification.setMember();

    }

    @Then("select non member type")
    public void select_non_member_type() throws InterruptedException {

        memberVerification.setMemberType();
        memberVerification.setNonMember();
    }

    @Then("Verify member verification pop")
    public void verify_member_verification_pop() {

        String actual = memberVerification.memberVerPop();
        String expected = "Member Verification";
        Assert.assertEquals(actual, expected);
    }
    @When("Select {int} member options")
    public void select_member_options(Integer int1) throws InterruptedException {
        System.out.println("Now clicking on checkbox");
        memberVerification.checkboxMemberID();
        memberVerification.checkboxMemberName();
        memberVerification.checkboxMemberDateOfBirth();
        memberVerification.checkboxMemberMailingAddress();

        }
    @Then("Clicks on Verify button")
    public void clicks_on_verify_button(List<Map<String, String>> memberType) {
        
       memberVerification.setMemberVerifyButton(memberType.get(0).get("memberType"));
       System.out.println("Now click on verify button to verify the member id");

    }

}
