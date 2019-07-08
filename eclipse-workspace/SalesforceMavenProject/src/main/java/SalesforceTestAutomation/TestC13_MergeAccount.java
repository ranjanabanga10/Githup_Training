package SalesforceTestAutomation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class TestC13_MergeAccount 
{
	static WebDriver driver;
	@Test
	public static void mergeAccount()
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
		WebElement mergeAccount=driver.findElement(By.xpath("//a[contains(text(),'Merge Accounts')]"));
		mergeAccount.click();
		WebElement findAccountbyName=driver.findElement(By.id("srch"));
		findAccountbyName.sendKeys("ABC");
		WebElement clickToSearch=driver.findElement(By.xpath("//div[@class='pbWizardBody']//input[@name='srchbutton']"));
		clickToSearch.click();
		boolean x=driver.findElement(By.id("cid0")).isSelected();
		if(x==false)
		{
		WebElement clickChkBox=driver.findElement(By.id("cid0"));
		clickChkBox.click();
		}
		boolean y=driver.findElement(By.id("cid1")).isSelected();
		if(y==false)
		{
		WebElement clickChkBox1=driver.findElement(By.id("cid1"));
		clickChkBox1.click();
		}
		else
		{
		WebElement clickChkBox2=driver.findElement(By.id("cid2"));
		clickChkBox2.click();
		}
		 WebElement goNext=driver.findElement(By.xpath("//div[contains(@class,'pbBottomButtons')]//input[contains(@name,'goNext')]"));
		 goNext.click();
		 WebElement clickOnmerge=driver.findElement(By.xpath("//div[@class='pbTopButtons']//input[@name='save']"));
		 clickOnmerge.click();
		 Alert alert=driver.switchTo().alert();
		 alert.accept();
		
		
	}
}
