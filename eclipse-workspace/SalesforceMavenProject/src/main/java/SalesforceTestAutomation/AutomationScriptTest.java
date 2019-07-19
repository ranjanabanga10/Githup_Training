package SalesforceTestAutomation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class AutomationScriptTest extends ReUsableMethod 
{
	static WebDriver driver;
	static ExtentTest Logger;
	static ExtentReports report;
	
	@BeforeMethod
	public static void setUp()
	{
		System.setProperty("webdriver.chrome.driver", "/Users/ranjanabanga/Desktop/Maybatch19/Driver/chromedriver");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.get("https://login.salesforce.com/");
	}
	
	@Test
	public static void loginErrorMsg()
	{
		System.setProperty("webdriver.chrome.driver", "/Users/ranjanabanga/Desktop/Maybatch19/Driver/chromedriver");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		
		//Test case #1
		driver.get("https://login.salesforce.com/");
		WebElement userName=driver.findElement(By.xpath("//input[@id='username']"));
		enterText(userName,"raji_salesforce@sales.com","userName");

	    driver.findElement(By.id("password")).sendKeys(Keys.RETURN);
	    driver.findElement(By.id("password")).clear();
	    
		
		WebElement logIn=driver.findElement(By.xpath("//input[@id='Login']"));
		clickButton(logIn,"Login");
		
		WebElement actual_msg=driver.findElement(By.className("loginError"));
		System.out.println("Actual Message is:  "+actual_msg);
		
		//String expect=("Please enter your password");
		assertStatement(actual_msg,"Please enter your password","not matched....");
		//Assert.assertEquals(actual_msg, expect);
		ReUsableMethod.report.endTest(Logger);
		ReUsableMethod.report.flush();
	}
		//Test case#2
	@Test
		public static void LoginTest() throws InterruptedException
		{
			System.out.println("Logging into Application");
			System.setProperty("webdriver.chrome.driver", "/Users/ranjanabanga/Desktop/Maybatch19/Driver/chromedriver");

			WebDriver driver = new ChromeDriver();
			driver.get("https://login.salesforce.com/");
			
			WebElement userName=driver.findElement(By.xpath("//input[@id='username']"));
			enterText(userName,"raji_salesforce@sales.com","username");
			
			WebElement passWord=driver.findElement(By.id("password"));
			enterText(passWord,"Test@2019!","password");
			
			
			WebElement logIn=driver.findElement(By.xpath("//input[@id='Login']"));
			clickButton(logIn,"Login");
			Thread.sleep(3000);
			
			WebElement gotoProfile=driver.findElement(By.xpath("//*[@id='userNavButton']"));
			Actions actions=new Actions(driver);
			actions.moveToElement(gotoProfile).click().perform();
			driver.findElement(By.xpath("//a[contains(text(),'Logout')]")).click();
			ReUsableMethod.report.endTest(Logger);
			ReUsableMethod.report.flush();


		}
		@AfterMethod
		
		public static void tearDown()
		{
			driver.close();
		}


}
