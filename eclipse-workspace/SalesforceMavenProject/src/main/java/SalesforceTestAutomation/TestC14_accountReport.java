package SalesforceTestAutomation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class TestC14_accountReport 
{
	static WebDriver driver;
	@Test
	public static void accountReport() throws InterruptedException
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
		WebElement accountTab=driver.findElement(By.id("Account_Tab"));
		accountTab.click();
		WebElement elements=driver.findElement(By.id("lexNoThanks"));
		if(elements != null)
		{
			driver.findElement(By.id("lexNoThanks")).click();
			driver.findElement(By.id("tryLexDialogX")).click();
		}
		WebElement createReport=driver.findElement(By.xpath("//a[contains(text(),'Accounts with last activity > 30 days')]"));
		createReport.click();
		Thread.sleep(5000);
//		Alert alert=driver.switchTo().alert();
//		alert.dismiss();
//		WebElement nothanks=driver.findElement(By.xpath("//button[@id='ext-gen189']"));
//		nothanks.click();
		WebElement dateSearch=driver.findElement(By.xpath("//img[@id='ext-gen152']"));
		Actions action=new Actions(driver);
		action.moveToElement(dateSearch).click().build().perform();
		dateSearch.click();
		//Thread.sleep(5000);
		WebElement todayDate=driver.findElement(By.xpath("//button[@id='ext-gen277']"));
		Actions action1=new Actions(driver);
		action1.moveToElement(todayDate).doubleClick().build().perform();
//		todayDate.click();
//		todayDate.submit();
		WebElement saveReport=driver.findElement(By.xpath("//button[@id='ext-gen49']"));
		saveReport.click();
		Alert alert1=driver.switchTo().alert();
		alert1.accept();
		WebElement textbox=driver.findElement(By.xpath("//input[@id='saveReportDlg_reportNameField']"));
		textbox.sendKeys("Sample Report"); 
		WebElement textbox1=driver.findElement(By.xpath("//input[@id='saveReportDlg_DeveloperName']"));
		textbox1.sendKeys("SampleABC");
		WebElement saverun=driver.findElement(By.xpath("//button[@id='ext-gen417']"));
		saverun.click();
	}
}
