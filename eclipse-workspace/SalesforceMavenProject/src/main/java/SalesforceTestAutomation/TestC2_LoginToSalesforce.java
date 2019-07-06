package SalesforceTestAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;


public class TestC2_LoginToSalesforce 
{
			
				static WebDriver driver;
				@Test
				public static void LoginTest() throws InterruptedException
				{
					System.out.println("Logging into Application");
					System.setProperty("webdriver.chrome.driver", "/Users/ranjanabanga/Desktop/Maybatch19/Driver/chromedriver");

					WebDriver driver = new ChromeDriver();
					driver.get("https://login.salesforce.com/");
					WebElement userName=driver.findElement(By.name("username"));
					userName.sendKeys("raji_salesforce@sales.com");
					WebElement passWord=driver.findElement(By.cssSelector("#password"));
					passWord.sendKeys("Test@2019!");
					WebElement logIn=driver.findElement(By.xpath("//input[@id='Login']"));
					logIn.click();
					Thread.sleep(5000);
					
					WebElement gotoProfile=driver.findElement(By.xpath("//span[@id='userNavLabel']"));
					Actions actions=new Actions(driver);
					actions.moveToElement(gotoProfile).click().perform();
					driver.findElement(By.xpath("//a[contains(text(),'Logout')]")).click();
					
	

				}

			
}
