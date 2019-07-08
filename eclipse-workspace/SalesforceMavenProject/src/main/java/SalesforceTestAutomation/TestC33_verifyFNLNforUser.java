package SalesforceTestAutomation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestC33_verifyFNLNforUser 
{
	static WebElement driver;
	
	@Test
	public static void verifyFNLNforUser()
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
	WebElement homeTab=driver.findElement(By.xpath("//li[@id='home_Tab']"));
	homeTab.click();
	WebElement elements=driver.findElement(By.id("lexNoThanks"));
	if(elements != null)
	{
		driver.findElement(By.id("lexNoThanks")).click();
		driver.findElement(By.id("tryLexDialogX")).click();
	}
	WebElement profileLink=driver.findElement(By.xpath("//h1[@class='currentStatusUserName']//a[contains(text(),'Ranjana Banga')]"));
	profileLink.click();
	}
	
}
