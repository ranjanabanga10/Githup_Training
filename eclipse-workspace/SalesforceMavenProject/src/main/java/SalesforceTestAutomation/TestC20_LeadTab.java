package SalesforceTestAutomation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.Test;

public class TestC20_LeadTab 
{
	static WebDriver driver;
	@Test
	public static void leadTab() throws InterruptedException
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
		WebElement leadTab=driver.findElement(By.id("Lead_Tab"));
		leadTab.click();
		WebElement elements=driver.findElement(By.id("lexNoThanks"));
		if(elements != null)
		{
			driver.findElement(By.id("lexNoThanks")).click();
			driver.findElement(By.id("tryLexDialogX")).click();
		}
		//Test case#21
		WebElement verifyViewList=driver.findElement(By.xpath("//select[@id='fcf']"));
		verifyViewList.click();
		Thread.sleep(5000);
		
		//Test Case#22
		WebElement gobtn=driver.findElement(By.xpath("//span[@class='fBody']//input[@name='go']"));
		gobtn.click();
		driver.findElement(By.xpath("//div[@id='00Q1H000013dAr5_ACTION_COLUMN']//span[contains(text(),'Edit')]")).click();
		//editLead.click();
		driver.findElement(By.xpath("//td[@id='topButtonRow']//input[@name='save']")).click();

		Thread.sleep(5000);
		//Test Case#24
				WebElement newLead=driver.findElement(By.xpath("//input[@name='new']"));
				newLead.click();
				WebElement lname=driver.findElement(By.xpath("//input[@id='name_lastlea2']"));
				lname.sendKeys("ABCD");
				WebElement companyName=driver.findElement(By.xpath("//input[@id='lea3']"));
				companyName.sendKeys("ABCD");
				WebElement leadsave=driver.findElement(By.xpath("//td[@id='topButtonRow']//input[@name='save']"));
				leadsave.click();
		WebElement usrprofile=driver.findElement(By.xpath("//span[@id='userNavLabel']"));
		usrprofile.click();
		WebElement logout=driver.findElement(By.xpath("//a[contains(text(),'Logout')]"));
		logout.click();
		
		driver.quit();
		
	}
}
