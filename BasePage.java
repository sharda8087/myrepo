package pages;

import com.google.common.base.Function;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ConfigLoader;
import utils.ExcelReader;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;

public class BasePage {
	protected WebDriver driver;
	protected WebDriverWait wait;
	//protected ExcelReader excel;
	public static int elementWaitInSeconds = 0;
	public BasePage(WebDriver driver)
	{
		this.driver = driver; //Here "this" keyword represent to current class

		wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		PageFactory.initElements(driver, this);
		/*excel = new ExcelReader(
				System.getProperty("user.dir") + "\\src\\test\\resources\\testData\\testData.xlsx");*/

	}
	
	public void load(String brandName, String market, String lang, String endPoint) throws InterruptedException
	{
		
		driver.get(ConfigLoader.getInstance().getBaseUrlBBW(market)+"/"+lang+"/"+endPoint);
		Thread.sleep(2000);
		/*
		 * WebElement element=driver.findElement(By.xpath(
		 * "//*[@class='exponea-subbox-close-cross']")); fluentWait(element);
		 */
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[@class='exponea-subbox-close-cross']")))).click();
		
	}
	
	
	public void isAvailability(final WebElement ele1, final String message) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20))
				.pollingEvery(Duration.ofSeconds(1)).ignoring(NoSuchElementException.class);

		WebElement element = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				WebElement ele = ele1;
				if (ele.getText().trim().equalsIgnoreCase(message)) {
					return ele;
				} else {
					return null;
				}
			}
		});
	}

	
	
	public String fluentWait(final WebElement element) {
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20))
				.pollingEvery(Duration.ofSeconds(2)).ignoring(NoSuchElementException.class);

		String foo = wait.until(new Function<WebDriver, String>() {
			public String apply(WebDriver driver) {
				return element.getText();
			}
		});

		return foo;
	};
	
	public void fluentWaitClick(final WebElement element) {
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofSeconds(2)).ignoring(NoSuchElementException.class);

		String foo = wait.until(new Function<WebDriver, String>() {

			public String apply(WebDriver driver) {

				return element.getText();
			}
		});
		//return foo;
	};

//Currently using only finding the payment method section, this will change later.
	public void fluentClicks()
	{
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofSeconds(5))
				.ignoring(java.util.NoSuchElementException.class);

		/*
		 * WebElement foo = wait.until(driver -> {
		 * System.out.println("Finding the Payment section"); return
		 * driver.findElement(By.xpath("//*[text()='Payment Methods']")); })
		 */;
	}
	public boolean isElementDisplayed(WebElement element) {

		boolean flag = false;
		try {
			waitVisibilityOfElement(element);
			flag = element.isDisplayed();
		} catch (StaleElementReferenceException stale) {
		} catch (Exception e) {
		}
		// logger.info("Is element " + element + " displayed - " + flag);
		return flag;
	}
	
	public void waitVisibilityOfElement(WebElement element) {
		webDriverWait().until(ExpectedConditions.visibilityOf(element));
	}
	
	public WebDriverWait webDriverWait() {
		return new WebDriverWait(driver, Duration.ofSeconds(elementWaitInSeconds));
	}


	public void waitFor(int sleepTime) {

		try {

			Thread.sleep(sleepTime);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}
	
	public void clickButtonWithOutScroll(WebElement element) {
		waitElementToBeClickable(element);
		element.click();
	}
	
	public void waitElementToBeClickable(WebElement element) {
		
			webDriverWait().until(ExpectedConditions.elementToBeClickable(element));
		
	}
	
	public void scrollDown()
	{
		/*
		 * int pressX = driver.manage().window().getSize().width / 2; int bottomY =
		 * driver.manage().window().getSize().height * 4 / 5; int topY =
		 * driver.manage().window().getSize().height / 8; //TouchAction touchAction =
		 * new TouchAction((PerformsTouchActions) driver); Actions actions = new
		 * Actions(driver) actions.press(PointOption.point(pressX, bottomY))
		 * .waitAction(WaitOptions.waitOptions(Duration.ofMillis(3000))).moveTo(
		 * PointOption.point(pressX, topY)) .release().perform();
		 */
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,350)", "");
	}
	
	
	public String getText(WebElement element) {

		String data = "";

		try {
			data = element.getText().trim();
		} catch (Exception e) {

		}
		return data;
	}
	
	
	public void captureScreenshot() throws IOException {

		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		String screenshotName;
		Date d = new Date();
		screenshotName = d.toString().replace(":", "_").replace(" ", "_") + ".jpg";

		FileUtils.copyFile(scrFile,
				new File(System.getProperty("user.dir") + "\\target\\surefire-reports\\html\\" + screenshotName));

		//test.log(LogStatus.INFO, "Captured the Screenshots");
	}

	
}
