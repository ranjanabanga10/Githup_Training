package SalesforceTestAutomation;

import java.util.Set;
import java.util.concurrent.TimeUnit;

//import javax.swing.text.html.HTMLDocument.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class TestC8_developerConsole 
{
	static WebDriver driver;
	@Test
	public static void developerConsole() throws InterruptedException
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
		WebElement gotoProfile=driver.findElement(By.xpath("//span[@id='userNavLabel']"));
		gotoProfile.click();
		String parentWindowHandle=driver.getWindowHandle();
		System.out.println(driver.getTitle());
		System.out.println("Parent window's handle-->"+parentWindowHandle);
		WebElement devConsole=driver.findElement(By.xpath("//a[@class='debugLogLink menuButtonMenuLink']"));
		devConsole.click();
		Set<String> s1=driver.getWindowHandles();
		java.util.Iterator<String> li=s1.iterator();
		while(li.hasNext())
		{
			String child_window=li.next();
			if(!parentWindowHandle.equalsIgnoreCase(child_window))
			{
				driver.switchTo().window(child_window);
				
				Thread.sleep(10000);
				System.out.println(driver.getTitle());
				driver.close();
			}
		}
	
		driver.switchTo().window(parentWindowHandle);
		System.out.println(driver.getTitle());
		
		
	}
}
