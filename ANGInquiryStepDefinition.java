package stepDefinitions;

import context.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.collections4.bag.SynchronizedSortedBag;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import pages.AGInquiry;
import pages.MemberSearchPage;
import pages.MemberVerificationPage;
import pages.PageFactoryManager;
import utils.ExcelReader;

import java.io.IOException;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

public class ANGInquiryStepDefinition {

    private final AGInquiry angInquiry;
    private final MemberSearchPage memberSearch;
    private final MemberVerificationPage memberVerification;

    Hashtable<String, String> data = new Hashtable<String, String>();
    private static String serviceAction;
    private static String primaryReason;
    private static String secondaryReason1;
    private static String tertiaryReason1;
    private static String memberID;
    private static String subject;
    private static String description;
    private static String priority;
    private static String markAsComplaint;
    private static String AppealsGrievancesId;

    public ANGInquiryStepDefinition(TestContext context)
    {
        angInquiry = PageFactoryManager.getAGInquiry(context.driver);
        memberSearch = PageFactoryManager.getMemberSearchPage(context.driver);
        memberVerification = PageFactoryManager.getMemberVerificationPage(context.driver);

    }

    @Given("Collect the details from sheet {string} and  rowNum {int}")
    public void collect_the_details_from_sheet_and_row_num(String sheetName, Integer rowNum) throws IOException, InvalidFormatException  {
        ExcelReader reader = new ExcelReader();
		
		  String filePath = System.getProperty("user.dir") +
		  "\\src\\test\\resources\\testData\\Member_EPLUSTestData.xlsx";
		 
			/*
			 * String filePath = System.getProperty("user.dir") +                                                                       
			 * "\\src\\test\\resources\\testData\\coatestdata.xlsx";
			 */
		 
        List<Map<String,String>> testData = reader.getData(filePath, sheetName);
        serviceAction = testData.get(rowNum).get("Service Action");
        primaryReason = testData.get(rowNum).get("Primary Reason");
        secondaryReason1 = testData.get(rowNum).get("Secondary Reason");
        tertiaryReason1 = testData.get(rowNum).get("Tertiary Reason");
        memberID = testData.get(rowNum).get("Member ID");
        subject = testData.get(rowNum).get("Subject");
        description = testData.get(rowNum).get("Description");
        priority = testData.get(rowNum).get("Priority");
        markAsComplaint = testData.get(rowNum).get("Mark As Complaint");
        AppealsGrievancesId = testData.get(rowNum).get("Appeals Grievances ID");
    }

    @Given("Clicks on A&G Inquiry button")
    public void clicks_on_a_g_inquiry_button() {
        angInquiry.clickANGInquiryBttn();
    }

    @When("Validate whether A&G inquiry page is open")
    public void validate_whether_a_g_inquiry_page_is_open() {

        String expected = primaryReason;
                //"A&G Inquiry";
        //System.out.println("data variable " + data);
        String actual = angInquiry.ANGHeading();
        Assert.assertEquals(actual,expected);
    }

    @Then("Validate Member Name")
    public void validate_member_name() {
        String expected = "Christ Ronaldo";
        String actual = angInquiry.memberName();
        System.out.println("Member Name is : " + actual);
        //Assert.assertEquals(actual,expected);
    }
    @When("Enter value on Appeals_Grievances ID")
    public void enter_value_on_appeals_grievances_id() {

        angInquiry.setAppealsGrievancesID(AppealsGrievancesId);
    }
    @Then("Validate Primary Reason")
    public void validate_primary_reason() {
        String expected = "A&G Inquiry";
        System.out.println("Primary Reason is: "+ primaryReason);
                //"A&G Inquiry";
        String actual = angInquiry.validatePrimaryReason();
        System.out.println("Actual Primary Reason is: "+ actual);
        Assert.assertEquals(actual,expected);
    }

    @Then("Select Secondary Reason value")
    public void select_secondary_reason_value_from_dropdown() {

        System.out.println("Secondary Reason is: "+ secondaryReason1);
        angInquiry.setSecondaryReasonValue(secondaryReason1);
    }
    @Then("Select Secondary Reason value from dropdown")
    public void select_secondary_reason_value_from_dropdown(List<Map<String, String>> secondaryReason) {

       angInquiry.setSecondaryReasonValue(secondaryReason.get(0).get("secondaryReason"));
    }

    @When("Select Tertiary Reason value")
    public void select_tertiary_reason_value_from_dropdown() {

        if(secondaryReason1.equalsIgnoreCase("External Review")) {
            System.out.println("Tertiary Reason Not required");
        } else {
            angInquiry.setTertiaryReason(tertiaryReason1);
        }
    }
    
    @When("Select Tertiary Reason value from dropdown")
    public void select_tertiary_reason_value_from_dropdown(List<Map<String, String>> tertiaryReason) {

        angInquiry.setTertiaryReason(tertiaryReason.get(0).get("tertiaryReason"));

    }
    @When("Validate Route to Department text")
    public void validate_route_to_department_text() {
        String expected = "Route to Department";
        String actual = angInquiry.getRouteToDepartment();
        Assert.assertEquals(actual, expected);
    }
    @When("Click Mark as Complaint?")
    public void click_mark_as_complaint() {
        angInquiry.clickMarkAsComplaint();
    }
    @When("Select Value from Mark as Complaint?")
    public void select_value_from_mark_as_complaint(List<Map<String, String>> markAsComplaintVal) {
        angInquiry.selectMarkAsComplaint(markAsComplaintVal.get(0).get("markAsComplaint"));
    }

    @When("Select Value from Mark as Complaint")
    public void select_value_from_mark_as_complaint() {
        angInquiry.selectMarkAsComplaint(markAsComplaint);
    }
    @When("Select Priority")
    public void select_priority(List<Map<String, String>> priority) {
        angInquiry.setPriority(priority.get(0).get("priority"));
    }

    @When("Select member Priority")
    public void select_member_priority() {
        angInquiry.setPriority(priority);
    }

    @When("Enter value in {string}")
    public void enter_value_in(String subject) {
        angInquiry.setSubject(subject);
        
          }


    @When("Enter value in Description {string}")
    public void enter_value_in_description(String description) {
        angInquiry.setDescription(description);
    }

    @When("Enter value in member Description")
    public void enter_value_in_member_description() {
        angInquiry.setDescription(description);
        System.out.println("successfully entered description for inquiry");
    }

    @When("Click on Save Button")
    public void click_on_save_button() {
        angInquiry.saveButton();
        System.out.println("successfully clicked on save button of Inquiry");
        
    }
    
    @Then("Print Case Id rowNum {int}")
    public void print_case_id_row_num(int rowNum) throws Exception, Exception {
    	String caseId = angInquiry.printcaseid();
        System.out.println("print case id: " + caseId);
        ExcelReader.writeData(rowNum, caseId);
        
    }
    
    @Given("user enter the memberID {string}")
    public void user_enter_the_member_id(String memberId) {
        memberSearch.memberID(memberId);
    }

    @Given("user enter the member id")
    public void user_enter_the_member_id() {
        memberSearch.memberID(memberID);
        System.out.println("Entered Member ID");
    }
    
    @Then("Clicks on Verify button {string}")
    public void clicks_on_verify_button(String memberType) {
        memberVerification.setMemberVerifyButton(memberType);
    }
    
    @Then("Select Secondary Reason value from {string} dropdown")
    public void select_secondary_reason_value_from_dropdown(String secondaryReason) {
        angInquiry.setSecondaryReasonValue(secondaryReason);
    }
    
    @When("Select Tertiary Reason value from {string} dropdown")
    public void select_tertiary_reason_value_from_dropdown(String tertiaryReason) {
        angInquiry.setTertiaryReason(tertiaryReason);
    }
    
    @When("Select Value from Mark as Complaint {string}?")
    public void select_value_from_mark_as_complaint(String markAsComplaint) {
        angInquiry.selectMarkAsComplaint(markAsComplaint);
        System.out.println("Select Mark as Complaint");
    }
    
    @When("Enter value in Subject")
    public void enter_value_in_subject(List<Map<String, String>> subject) {
        angInquiry.setSubject(subject.get(0).get("Subject"));
    }

    @When("Enter value in member Subject")
    public void enter_value_in_member_subject() {

        angInquiry.setSubject(subject);
        System.out.println("Subjected selected");

    }
    
    @When("Enter value in Description")
    public void enter_value_in_description(List<Map<String, String>> description) {
        angInquiry.setDescription(description.get(0).get("Description"));
        System.out.println("Entered Description");
    }
    
    

}
