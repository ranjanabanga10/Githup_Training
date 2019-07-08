package SalesforceTestAutomation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.Test;

public class TestC35_verifyTabCustomization 
{
	static WebDriver driver;
	@Test
	public static void verifyTabCustomization()
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
		WebElement addTab=driver.findElement(By.xpath("//img[@class='allTabsArrow']"));
		addTab.click();
		WebElement customizedTab=driver.findElement(By.xpath("//input[@name='customize']"));
		customizedTab.click();
		WebElement selectedtabs=driver.findElement(By.xpath("//option[contains(text(),'Products')]"));
		//Select sel=new Select(selectedtabs);
		//sel.selectByIndex(6);
		//sel.selectByVisibleText("Products");
		selectedtabs.click();
		WebElement rmvElement=driver.findElement(By.xpath("//img[@class='leftArrowIcon']"));
		rmvElement.click();
		WebElement savebtn=driver.findElement(By.xpath("//input[@name='save']"));
		savebtn.click();
		WebElement usrProfile=driver.findElement(By.xpath("//span[@id='userNavLabel']"));
		usrProfile.click();
		WebElement logout=driver.findElement(By.xpath("//a[contains(text(),'Logout')]"));
		logout.click();
		driver.get("https://login.salesforce.com/");
		
		WebElement userName1=driver.findElement(By.name("username"));
		userName1.sendKeys("raji_salesforce@sales.com");
		WebElement passWord1=driver.findElement(By.cssSelector("#password"));
		passWord1.sendKeys("Test@2019!");
		WebElement logIn1=driver.findElement(By.xpath("//input[@id='Login']"));
		logIn1.click();
		
	}
}
