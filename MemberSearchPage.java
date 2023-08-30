package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MemberSearchPage extends BasePage {

	
	public MemberSearchPage(WebDriver driver) {
		super(driver);
			}

	@FindBy (xpath="//button[@title='Show Navigation Menu']")
	private WebElement navigationMenu;
	@FindBy (xpath="//span[@class='slds-media__body']//*[text()='Member Search']")
	private WebElement memberSearchMenuOption;
	@FindBy(xpath="//*[@name='memberID']")
	private WebElement memberID;
	@FindBy (xpath="(//*[@class='slds-button slds-button_brand'])[1]")
	private WebElement searchBttn;

	@FindBy(xpath = "(//button[@title='Validate Member'])[1]")
	private WebElement clickValidateMemberBttn;



	public void searchIcon()
	{
		wait.until(ExpectedConditions.visibilityOf(navigationMenu)).click();
	}

	public void memberSearchMenuOption()
	{
		wait.until(ExpectedConditions.visibilityOf(memberSearchMenuOption)).click();
	}

	public void memberID(String ID)
	{
		wait.until(ExpectedConditions.elementToBeClickable(memberID)).sendKeys(ID);

	}

	public void searchBttn()
	{
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", searchBttn);
		searchBttn.click();
	}

	public void clickValidateMemberBtn()
	{
		wait.until(ExpectedConditions.elementToBeClickable(clickValidateMemberBttn)).click();
	}

}
