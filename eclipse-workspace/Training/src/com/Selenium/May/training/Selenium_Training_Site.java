package com.Selenium.May.training;

import java.awt.Robot;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Selenium_Training_Site {
	WebDriver driver;

	public void invokeBrowser(String url) {
		try {
			System.setProperty("webdriver.chrome.driver", "/Users/ranjanabanga/Desktop/Maybatch19/Driver/chromedriver");

			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
			driver.get("url");
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public void elementLocatorTechniques() {

		try {
			invokeBrowser("https://selenium-prd.firebaseapp.com/");
			driver.get("https://selenium-prd.firebaseapp.com/");
			String titleofThepage = driver.getTitle();
			System.out.println(titleofThepage);
			WebElement userName = driver.findElement(By.xpath("//input[@id='email_field']"));
			WebElement userPassword = driver.findElement(By.id("password_field"));
			WebElement userLoginButton = driver.findElement(By.xpath("//button[contains(text(),'Login to Account')]"));
			userName.sendKeys("admin123@gmail.com");
			userPassword.sendKeys("admin123");
			userLoginButton.click();

			WebElement HomeTab = driver.findElement(By.xpath("//a[contains(text(),'Home')]"));
			HomeTab.click();
			WebElement name = driver.findElement(By.id("name"));
			name.sendKeys("Malisha paul");
			WebElement FName = driver.findElement(By.id("lname"));
			FName.sendKeys("Jarnail");
			WebElement PostAddress = driver.findElement(By.id("postaladdress"));
			PostAddress.sendKeys("P.O.Box 123, Concord, CA 94520");
			WebElement personalAddress = driver.findElement(By.id("personaladdress"));
			personalAddress.sendKeys("1682 Clayton Rd, concord, ca 94520");
			WebElement Male = driver.findElement(By.xpath("//span[1]//input[1]"));
			Male.click();
			WebElement Female = driver.findElement(By.xpath("//span[2]//input[1]"));
			Female.click();
			WebElement drpCity = driver.findElement(By.id("city"));
			Select dropdown = new Select(drpCity);
			dropdown.selectByVisibleText("NEW DELHI");

			WebElement drpCourse = driver.findElement(By.id("course"));
			Select drpdwnCourse = new Select(drpCourse);
			drpdwnCourse.selectByVisibleText("MBA");

			WebElement drpDistrict = driver.findElement(By.id("district"));
			Select drpdwnDistrict = new Select(drpDistrict);
			drpdwnDistrict.selectByVisibleText("GOA");

			WebElement drpState = driver.findElement(By.id("state"));
			Select drpdwnState = new Select(drpState);
			drpdwnState.selectByVisibleText("PATNA");

			WebElement Pincode = driver.findElement(By.id("pincode"));
			Pincode.sendKeys("94520");
			WebElement EmailID = driver.findElement(By.id("emailid"));
			EmailID.sendKeys("rbanga@live.com");
			WebElement switchTo = driver.findElement(By.xpath("//button[contains(text(),'Switch To')]"));
			
			Actions action = new Actions(driver);
			action.moveToElement(switchTo).build().perform();
		
			WebElement alert=driver.findElement(By.linkText("Alert"));
			alert.click();
			WebElement windowalert=driver.findElement(By.xpath("//button[contains(text(),'Window Alert')]"));
			windowalert.click();
			Alert alert1=driver.switchTo().alert();
			String alerttext=alert1.getText();
			System.out.println(alerttext);
			alert1.accept();
			WebElement palert=driver.findElement(By.xpath("//button[contains(text(),'Promt Alert')]"));
			palert.click();
			Alert promptAlert=driver.switchTo().alert();
			Thread.sleep(5000);
			promptAlert.sendKeys("Ranjana Banga");
			String promptal=promptAlert.getText();
			
			promptAlert.accept();
			System.out.println(promptal);
			
			WebElement windowsbutton=driver.findElement(By.xpath("//a[contains(text(),'Windows')]"));
			Actions ac=new Actions(driver);
			ac.moveToElement(windowsbutton);
			ac.click().build().perform();
			//driver.close();
			//windowsbutton.click();
			
			WebElement clickNewTab=driver.findElement(By.xpath("//a[1]//button[1]"));
			Actions aa=new Actions(driver);
			aa.moveToElement(clickNewTab).click().build().perform();
			clickNewTab.click();
			

			WebElement clickNewWindow=driver.findElement(By.xpath("//a[2]//button[1]"));
			Actions bb=new Actions(driver);
			bb.moveToElement(clickNewWindow).click().build().perform();
			//clickNewWindow.click();
		
			
			WebElement tabs=driver.findElement(By.linkText("Tabs"));
			tabs.click();
			
			WebElement london=driver.findElement(By.xpath("//button[contains(text(),'London')]"));
			london.click();
			
			
			WebElement paris=driver.findElement(By.xpath("//button[@class='tablinks active']"));
			paris.click();
			
			WebElement tokyo=driver.findElement(By.xpath("//button[@class='tablinks active']"));
			tokyo.click();
		

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {

		Selenium_Training_Site myObj = new Selenium_Training_Site();
		myObj.elementLocatorTechniques();

	}

}
