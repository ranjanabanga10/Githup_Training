package SalesforceTestAutomation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestC25_newContact 
{
	static WebElement driver;
	
	@Test
	public static void newContact()
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
		WebElement contactTab=driver.findElement(By.xpath("//a[contains(text(),'Contacts')]"));
		contactTab.click();
		WebElement elements=driver.findElement(By.id("lexNoThanks"));
		if(elements != null)
		{
			driver.findElement(By.id("lexNoThanks")).click();
			driver.findElement(By.id("tryLexDialogX")).click();
		}
		WebElement newContact=driver.findElement(By.xpath("//input[@name='new']"));
		newContact.click();
		WebElement lastName=driver.findElement(By.xpath("//input[@id='name_lastcon2']"));
		lastName.sendKeys("Paul");
		WebElement accountName=driver.findElement(By.xpath("//input[@id='con4']"));
		accountName.sendKeys("ABC Company For Beginner");
		WebElement saveContact=driver.findElement(By.xpath("//td[@id='topButtonRow']//input[@name='save']"));
		saveContact.click();
	}

}
