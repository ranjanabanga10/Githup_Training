package SalesforceTestAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class TestC3_remberMe 
{
	static WebDriver driver;
	@Test
	public static void rememberMe() throws InterruptedException
	{
		
		
			System.setProperty("webdriver.chrome.driver", "/Users/ranjanabanga/Desktop/Maybatch19/Driver/chromedriver");

			WebDriver driver = new ChromeDriver();
			driver.get("https://login.salesforce.com/");
			WebElement userName=driver.findElement(By.name("username"));
			userName.sendKeys("raji_salesforce@sales.com");
			
			
			WebElement passWord=driver.findElement(By.cssSelector("#password"));
			passWord.sendKeys("Test@2019!");
			
			WebElement logIn=driver.findElement(By.xpath("//input[@id='Login']"));
			logIn.click();
			
			WebElement rememberme=driver.findElement(By.id("rememberUn"));
			
			//Actions action=new Actions(driver);
			//action.moveToElement(rememberme).click();
			
			rememberme.click();
			Thread.sleep(5000);
			
			WebElement gotoProfile=driver.findElement(By.xpath("//div[@id='userNavButton']"));
			Actions actions=new Actions(driver);
			actions.moveToElement(gotoProfile).click().perform();
			driver.findElement(By.xpath("//a[contains(text(),'Logout')]")).click();
			
			
			Thread.sleep(5000);
	
		
	
	}
}
