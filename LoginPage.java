package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage extends BasePage {
	
	public LoginPage(WebDriver driver) {
		super(driver);
		
	}

	@FindBy(how = How.ID, using = "username")
	public static WebElement EmailId;

	@FindBy(how = How.ID, using = "password")
	public static WebElement Password;

	@FindBy(how = How.ID, using = "Login")
	private WebElement Sign_inButton;

	
	
	
	public void LogIn_Action(String sUserName, String sPassword) throws InterruptedException {

		EmailId.clear();
		Thread.sleep(500);
		EmailId.sendKeys(sUserName);
		//Thread.sleep(1000);
		Password.clear();
		Password.sendKeys(sPassword);
		
	}

	public void clickonSignin() throws InterruptedException {
		Thread.sleep(2000);
		Sign_inButton.click();
		}

}
