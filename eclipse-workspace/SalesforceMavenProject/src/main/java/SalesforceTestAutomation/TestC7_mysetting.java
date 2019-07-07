package SalesforceTestAutomation;

import java.awt.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class TestC7_mysetting 
{
	static WebDriver driver;
	@Test
	public static void mysetting()
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
		
		WebElement mysetting=driver.findElement(By.xpath("//a[contains(text(),'My Settings')]"));
		mysetting.click();
		
		WebElement personal=driver.findElement(By.xpath("//span[@id='PersonalInfo_font']"));
		personal.click();
		
		Actions action=new Actions(driver);
		action.moveToElement(personal).build().perform();
		
		WebElement loginhistory=driver.findElement(By.xpath("//span[@id='LoginHistory_font']"));
		loginhistory.click();
		
		
		WebElement downloadloginhistory=driver.findElement(By.xpath("//a[contains(text(),'Download login history for last six months, includ')]"));
		downloadloginhistory.click();
		driver.navigate().back();
		
		WebElement displayLayout=driver.findElement(By.xpath("//div[@id='DisplayAndLayout']"));
		Actions action1=new Actions(driver);
		action1.moveToElement(displayLayout).build().perform();
		displayLayout.click();
		
		
		WebElement customizedTabs=driver.findElement(By.id("CustomizeTabs_font"));
		Actions ac=new Actions(driver);
		ac.build().perform();
		customizedTabs.click();
		
		WebElement customApp=driver.findElement(By.xpath("//select[@id='p4']"));
		Select selectElement=new Select(customApp);
		selectElement.selectByVisibleText("Salesforce Chatter");
		
		WebElement availabletabs=driver.findElement(By.xpath("//option[contains(text(),'Reports')]"));
		availabletabs.click();
		
		WebElement addtoSelectedOption=driver.findElement(By.xpath("//img[@class='rightArrowIcon']"));
		addtoSelectedOption.click();
		WebElement savebtn=driver.findElement(By.xpath("//input[@name='save']"));
		savebtn.click();
		
		
		WebElement email=driver.findElement(By.id("EmailSetup"));
		email.click();
		WebElement emailsetting=driver.findElement(By.id("EmailSettings_font"));
		emailsetting.click();
		WebElement emailName=driver.findElement(By.id("sender_name"));
		emailName.clear();
		emailName.sendKeys("Malisha Paul");
		WebElement emailAddress=driver.findElement(By.id("sender_email"));
		emailAddress.clear();
		emailAddress.sendKeys("bangaranjana@yahoo.com");
		WebElement bccCopyEmail=driver.findElement(By.id("auto_bcc1"));
		bccCopyEmail.click();
		WebElement savebtnEmailSetting=driver.findElement(By.xpath("//input[@name='save']"));
		savebtnEmailSetting.click();
		Alert art=driver.switchTo().alert();
		art.accept();
		
		WebElement Clanders_Reminders=driver.findElement(By.id("CalendarAndReminders_font"));
		Clanders_Reminders.click();
		WebElement reminder=driver.findElement(By.id("Reminders_font"));
		reminder.click();
		WebElement reminderPreview=driver.findElement(By.id("testbtn"));
		reminderPreview.click();
	}
}
