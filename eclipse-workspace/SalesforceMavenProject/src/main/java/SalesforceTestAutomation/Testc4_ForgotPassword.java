package SalesforceTestAutomation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Testc4_ForgotPassword 
{
	static WebDriver driver;
	@Test
	public static void forgotPassword()
	{
		System.setProperty("webdriver.chrome.driver", "/Users/ranjanabanga/Desktop/Maybatch19/Driver/chromedriver");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		
		
		driver.get("https://login.salesforce.com/");
		WebElement userName=driver.findElement(By.name("username"));
		userName.sendKeys("123");
		WebElement passWord=driver.findElement(By.cssSelector("#password"));
		passWord.sendKeys("22131");
		WebElement logIn=driver.findElement(By.xpath("//input[@id='Login']"));
		logIn.click();
	}
}
