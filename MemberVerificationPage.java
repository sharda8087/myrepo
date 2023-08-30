package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MemberVerificationPage extends BasePage {

    public MemberVerificationPage(WebDriver driver) {
       super(driver);

    }

    @FindBy(xpath="//h2[text()='Member Verification']")
    private WebElement validateCaseOriginVerificationPop;
    
    @FindBy(xpath="//*[text()='Member Verification']")
    private WebElement memberVerificationPop;

    @FindBy (xpath="(//*[@class='slds-checkbox_faux'])[1]")
    private WebElement checkboxMemberID;

    @FindBy (xpath="(//*[@class='slds-checkbox_faux'])[4]")
    private WebElement checkboxMemberName;

    @FindBy (xpath="(//*[@class='slds-checkbox_faux'])[5]")
    private WebElement checkboxMemberDateOfBirth;

    @FindBy (xpath="(//*[@class='slds-checkbox_faux'])[7]")
    private WebElement checkboxMemberMailingAddress;

    @FindBy(xpath="//*[@name='memberVerify']")
    private WebElement memberVerifyButton;

    @FindBy (xpath="//*[@name='nonMemberVerify']")
    private WebElement nonMemberVerifyButton;

    @FindBy(xpath="//*[@name='originfield']")
    private WebElement caseOrigin;

    @FindBy(xpath = "//*[@title='Inbound - Phone Call']")
    private WebElement inbountPhoneCall;

    @FindBy(xpath = "//*[@name='memberType']")
    private WebElement memberType;

    @FindBy (xpath = "//*[@title='Member']")
    private WebElement member;

    @FindBy (xpath = "//*[@title='Non Member']")
    private WebElement nonMember;


    public String validateCaseOriginVerificationPop()
    {
        return wait.until(ExpectedConditions.visibilityOf(validateCaseOriginVerificationPop)).getText();
    }

    public void setCaseOrigin()
    {
        wait.until(ExpectedConditions.elementToBeClickable(caseOrigin)).click();
    }
    public void setInbountPhoneCall()
    {
        wait.until(ExpectedConditions.elementToBeClickable(inbountPhoneCall)).click();
    }

    public void setMemberType()
    {
        wait.until(ExpectedConditions.elementToBeClickable(memberType)).click();
    }

    public void setMember()
    {
        wait.until(ExpectedConditions.elementToBeClickable(member)).click();
    }

    public void setNonMember()
    {
        wait.until(ExpectedConditions.elementToBeClickable(nonMember)).click();
    }


    public String memberVerPop()
    {
       return wait.until(ExpectedConditions.visibilityOf(memberVerificationPop)).getText();
    }

    public void checkboxMemberID()
    {
        wait.until(ExpectedConditions.elementToBeClickable(checkboxMemberID)).click();
    }

    public void checkboxMemberName()
    {
        wait.until(ExpectedConditions.elementToBeClickable(checkboxMemberName)).click();
    }

    public void checkboxMemberDateOfBirth()
    {
        wait.until(ExpectedConditions.elementToBeClickable(checkboxMemberDateOfBirth)).click();
    }

    public void checkboxMemberMailingAddress()
    {
        wait.until(ExpectedConditions.elementToBeClickable(checkboxMemberMailingAddress)).click();
    }

    public void setMemberVerifyButton(String verifyButton)
    {
       if(verifyButton.equalsIgnoreCase("Member")) {
           ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", memberVerifyButton);
           memberVerifyButton.click();
       }
       else if (verifyButton.equalsIgnoreCase("Non Member")){
           ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", nonMemberVerifyButton);
           nonMemberVerifyButton.click();
       }
       }




}
