package SalesforceTestAutomation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class TestC6_myProfile 
{
	static WebDriver driver;
	@Test
	public static void myProfile() throws InterruptedException
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
		Thread.sleep(6000);
		
		WebElement myprofile=driver.findElement(By.xpath("//a[contains(text(),'My Profile')]"));
		myprofile.click();
		WebElement editprofile=driver.findElement(By.xpath("//a[@class='contactInfoLaunch editLink']//img"));
		editprofile.click();
		WebElement about=driver.findElement(By.xpath("//li[@id='aboutTab']"));
		
		about.click();
		WebElement lname=driver.findElement(By.xpath("//input[@id='lastName']"));
		lname.sendKeys("Kaur");
		
		WebElement save=driver.findElement(By.xpath("//input[@class='zen-btn zen-primaryBtn zen-pas']"));
		save.click();
		
		WebElement post=driver.findElement(By.xpath("//span[contains(@class,'publisherattachtext')][contains(text(),'Post')]"));
		post.click();
		WebElement posttext=driver.findElement(By.xpath("//html"));
		posttext.sendKeys("It is Salesforce testing");
		
		WebElement fileupload=driver.findElement(By.xpath("//span[contains(@class,'publisherattachtext')][contains(text(),'File')]"));
		fileupload.click();
		WebElement computerupload=driver.findElement(By.xpath("//a[@id='chatterUploadFileAction']"));
		computerupload.click();
		WebElement selectfile=driver.findElement(By.xpath("//input[@id='chatterFile']"));
		selectfile.click();
		
		WebElement profilephoto=driver.findElement(By.xpath("//a[@id='uploadLink']"));
		profilephoto.click();
		
		WebElement classicview=driver.findElement(By.xpath("//a[contains(text(),'Switch to Salesforce Classic')]"));
		classicview.click();
		WebElement gotoProfile1=driver.findElement(By.xpath("//span[@id='userNavLabel']"));
		gotoProfile1.click();
		
		WebElement setting=driver.findElement(By.xpath("//a[contains(text(),'My Settings')]"));
		setting.click();
		WebElement gotoProfile2=driver.findElement(By.xpath("//span[@id='userNavLabel']"));
		gotoProfile2.click();
		
		WebElement dev=driver.findElement(By.xpath("//a[@class='debugLogLink menuButtonMenuLink']"));
		dev.click();
		driver.close();
		driver.quit();
		WebElement gotoProfile3=driver.findElement(By.xpath("//span[@id='userNavLabel']"));
		gotoProfile3.click();
		
		WebElement switchtoclassic=driver.findElement(By.xpath("//a[@class='menuButtonMenuLink'][contains(text(),'Switch to Lightning Experience')]"));
		switchtoclassic.click();
		WebElement gotoProfile4=driver.findElement(By.xpath("//span[@id='userNavLabel']"));
		gotoProfile4.click();
		WebElement logout=driver.findElement(By.xpath("WebElement gotoProfile3=driver.findElement(By.xpath(\"//span[@id='userNavLabel']\"));\n" + "		gotoProfile3.click();"));
		logout.click();
		
		
	}
}
