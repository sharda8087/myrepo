package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.security.cert.X509Certificate;
import java.util.List;
import java.util.Map;

public class AGInquiry extends BasePage {

    public AGInquiry(WebDriver driver) {
        super(driver);
    }


    @FindBy (xpath = "//button[normalize-space()='A&G Inquiry']")
    private WebElement ANGInquiryBttn;

    @FindBy (xpath = "//h2[starts-with(@id,'modal-heading')]")
    private WebElement ANGHeading;

    @FindBy (xpath = "//p[normalize-space()='Member Name']//following::div[7]")
    private WebElement memberName;

    @FindBy (xpath = "//input[@name='UST_EPLUS__Appeals_Grievances_ID__c']")
    private WebElement appealsGrievancesID;

    @FindBy (xpath = "//div[contains(text(),'A&G Inquiry')]")
    private WebElement primaryReason;

    @FindBy (xpath = "//button[@name='UST_EPLUS__Secondary_Reason__c']")
    private WebElement secondaryReasonDropDown;

    @FindBy(xpath = "//*[@data-value='External Review']")
    private WebElement externalReview;

    @FindBy (xpath = "//*[@id='dropdown-element-1102']/lightning-base-combobox-item")
    private WebElement secondaryReasonValue;

    @FindBy (xpath = "//*[@name='UST_EPLUS__Tertiary_Reason__c']")
    private WebElement tertiaryReason;

    @FindBy (xpath = "//p[normalize-space()='Route to Department']")
    private WebElement routeToDepartment;

    @FindBy (xpath = "//*[@name='UST_EPLUS__Mark_as_Complaint__c']")
    private WebElement markAsComplaint;

    @FindBy (xpath = "//*[@name='Priority']")
    private WebElement priority;

    @FindBy (xpath = "//*[@name='Subject']")
    private WebElement subject;

    @FindBy (xpath = "//*[@name='Description']")
    private WebElement description;

    @FindBy (xpath = "//lightning-button[@class='slds-m-top_small']")
    private WebElement saveBttn;
    
    @FindBy (xpath = "//div[contains(@id,'toastDescription')]")
    private WebElement caseid;

    List<Map<String,String>> testData;

    public void clickANGInquiryBttn()
    {
        wait.until(ExpectedConditions.elementToBeClickable(ANGInquiryBttn)).click();

    }

    public String ANGHeading()
    {
       return wait.until(ExpectedConditions.visibilityOf(ANGHeading)).getText();
    }

    public String memberName()
    {
        return wait.until(ExpectedConditions.visibilityOf(memberName)).getText();
    }

    public void setAppealsGrievancesID(String appealsGrievancesId)
    {
        wait.until(ExpectedConditions.visibilityOf(appealsGrievancesID)).sendKeys(appealsGrievancesId);
    }

    public String validatePrimaryReason()
    {
        return wait.until(ExpectedConditions.visibilityOf(primaryReason)).getText();
    }

    public void setSecondaryReasonValue(String secondaryReason)
    {
        wait.until(ExpectedConditions.visibilityOf(secondaryReasonDropDown)).click();
         driver.findElement(By.xpath("//*[@data-value='"+secondaryReason+"']")).click();
        //By.xpath("//*[@data-value='External Review']");
    }

    public void setTertiaryReason(String tertiaryReasonVal)
    {
        wait.until(ExpectedConditions.visibilityOf(tertiaryReason)).click();
        driver.findElement(By.xpath("//*[@data-value='"+tertiaryReasonVal+"']")).click();
    }

       public String getRouteToDepartment()
    {
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",routeToDepartment);
        return wait.until(ExpectedConditions.visibilityOf(routeToDepartment)).getText();
    }

    public void clickMarkAsComplaint()
    {

        wait.until(ExpectedConditions.visibilityOf(markAsComplaint)).click();
    }

    public void selectMarkAsComplaint(String markAsComplaintVal)
    {
        driver.findElement(By.xpath("//*[@data-value='"+markAsComplaintVal+"']")).click();
    }

    public void setPriority(String priorityVal)
    {
        wait.until(ExpectedConditions.visibilityOf(priority)).click();
        driver.findElement(By.xpath("//*[@data-value='"+priorityVal+"' and @role='option']")).click();

    }

    public void setSubject(String subjectVal)
    {
        wait.until(ExpectedConditions.visibilityOf(subject)).sendKeys(subjectVal);
    }

    public void setDescription(String descriptionVal)
    {
        wait.until(ExpectedConditions.visibilityOf(description)).sendKeys(descriptionVal);
    }

    public void saveButton()
    {
        wait.until(ExpectedConditions.elementToBeClickable(saveBttn)).click();
    }
    
    public String printcaseid() {
    	 wait.until(ExpectedConditions.visibilityOf(caseid));
    	 String caseId = caseid.getText().replaceAll("[\\D]", "");
    	 return caseId;
    }

}
