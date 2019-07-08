package SalesforceTestAutomation;


import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.Test;

public class TestC10_createAccount 
{
	static WebDriver driver;
	@Test
	public static void createAccount()
	{
		System.setProperty("webdriver.chrome.driver", "/Users/ranjanabanga/Desktop/Maybatch19/Driver/chromedriver");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.get("https://login.salesforce.com/");
		
		WebElement userName=driver.findElement(By.name("username"));
		userName.sendKeys("raji_salesforce@sales.com");
		WebElement passWord=driver.findElement(By.cssSelector("#password"));
		passWord.sendKeys("Test@2019!");
		WebElement logIn=driver.findElement(By.xpath("//input[@id='Login']"));
		logIn.click();
		
		WebElement accountTab=driver.findElement(By.id("Account_Tab"));
		accountTab.click();
		//Thread.sleep(5000);
		
		WebElement elements=driver.findElement(By.id("lexNoThanks"));
		if(elements != null)
		{
			driver.findElement(By.id("lexNoThanks")).click();
			driver.findElement(By.id("tryLexDialogX")).click();
		}
		
		WebElement newAccountCreate=driver.findElement(By.xpath("//input[@name='new']"));
		newAccountCreate.click();
		WebElement newAccountName=driver.findElement(By.id("acc2"));
		newAccountName.sendKeys("ABC Company For Beginner");
		WebElement saveAccount=driver.findElement(By.xpath("//td[@id='bottomButtonRow']//input[@name='save']"));
		saveAccount.click();
		
	}
}
