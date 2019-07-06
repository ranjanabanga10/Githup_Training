package SalesforceTestAutomation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.Assert;

import org.testng.annotations.Test;

public class TestC1_LoginErrorMessage 
{
	
	@Test
	public static void loginErrorMsg()
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
	    /*WebElement passWord=*/
		driver.findElement(By.cssSelector("#password"));
	    //passWord.sendKeys("Test@2019!");
	    driver.findElement(By.cssSelector("#password")).sendKeys(Keys.RETURN);
	   
	    driver.findElement(By.cssSelector("#password")).clear();
	    
	    
		
		
		WebElement logIn=driver.findElement(By.xpath("//input[@id='Login']"));
		logIn.click();
		String actual_msg=driver.findElement(By.cssSelector("#password")).getText();
		String expect=("Please enter your password");
		Assert.assertEquals(actual_msg, expect);
		//System.out.println("Please enter your password");
		
	}


}
