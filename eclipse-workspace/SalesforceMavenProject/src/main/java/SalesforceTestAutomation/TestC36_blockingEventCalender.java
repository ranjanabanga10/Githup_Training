package SalesforceTestAutomation;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class TestC36_blockingEventCalender 
{
	static WebDriver driver;
	@Test
	public static void blockEventCalender()
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
		WebElement homeTab=driver.findElement(By.xpath("//li[@id='home_Tab']"));
		homeTab.click();
		WebElement elements=driver.findElement(By.id("lexNoThanks"));
		if(elements != null)
		{
			driver.findElement(By.id("lexNoThanks")).click();
			driver.findElement(By.id("tryLexDialogX")).click();
		}
		WebElement currentDateLink=driver.findElement(By.xpath("//a[contains(text(),'Sunday July 7, 2019')]"));
		currentDateLink.click();
		WebElement click8pmLink=driver.findElement(By.xpath("//a[contains(text(),'8:00 PM')]"));
		click8pmLink.click();
		WebElement subjectCombo=driver.findElement(By.xpath("//img[@class='comboboxIcon']"));
		subjectCombo.click();
					
		
        String MainWindow=driver.getWindowHandle();		
        		
        // To handle all new opened window.				
            Set<String> s1=driver.getWindowHandles();		
            Iterator<String> i1=s1.iterator();		
        		
        while(i1.hasNext())			
        {		
            String ChildWindow=i1.next();		
            		
            if(!MainWindow.equalsIgnoreCase(ChildWindow))			
            {    		
                 
                    // Switching to Child window
                    driver.switchTo().window(ChildWindow);	                                                                                                           
                    WebElement otherCombo=driver.findElement(By.xpath("//a[contains(text(),'Other')]"));
                    Actions action=new Actions(driver);
                	action.moveToElement(otherCombo).click().build().perform();
                    otherCombo.click();			
          	
            }		
        }		
        // Switching to Parent window i.e Main Window.
            driver.switchTo().window(MainWindow);				
   
        
        
		WebElement endTimeCombo=driver.findElement(By.xpath("//input[@id='EndDateTime_time']"));
		endTimeCombo.click();
		
		WebElement savebtn=driver.findElement(By.xpath("//td[@id='topButtonRow']//input[@name='save']"));
		savebtn.click();
        
	}
}
