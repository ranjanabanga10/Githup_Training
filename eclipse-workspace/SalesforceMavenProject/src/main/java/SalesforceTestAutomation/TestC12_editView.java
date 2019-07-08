package SalesforceTestAutomation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class TestC12_editView 
{
	static WebDriver driver;
	@Test
	public static void editView()
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
		WebElement accountview=driver.findElement(By.id("fcf"));
		Select sel=new Select(accountview);
		sel.selectByVisibleText("My Accounts");
		WebElement editview=driver.findElement(By.xpath("//span[@class='fFooter']//a[contains(text(),'Edit')]"));
		editview.click();
		WebElement viewName=driver.findElement(By.id("fname"));
		viewName.sendKeys("Recent_Changes");
		WebElement filterField=driver.findElement(By.id("fcol1"));
		Select sel1=new Select(filterField);
		sel1.selectByVisibleText("Account Name");
		
		WebElement filteroperator=driver.findElement(By.id("fop1"));
		Select sel2=new Select(filteroperator);
		sel2.selectByVisibleText("contains");
		
		WebElement filtervalue=driver.findElement(By.xpath("//input[@id='fval1']"));
		filtervalue.sendKeys("Last Weeks");
		
		WebElement selectoption=driver.findElement(By.xpath("//select[@id='colselector_select_0']//option[contains(text(),'Last Activity')]"));
		
		selectoption.click();
		
		WebElement clicktoAdd=driver.findElement(By.xpath("//a[@id='colselector_select_0_right']//img[@class='rightArrowIcon']"));
		clicktoAdd.click();
		
		WebElement savebtn=driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[2]/div[2]/form[1]/div[3]/table[1]/tbody[1]/tr[1]/td[2]/input[1]"));
		
		savebtn.click();
	}
}
