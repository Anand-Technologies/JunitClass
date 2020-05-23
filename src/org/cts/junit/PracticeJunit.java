package org.cts.junit;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class PracticeJunit {
	static WebDriver driver;
	
	@BeforeClass
	public static void launchBrowser() {
		System.setProperty("webdriver.chrome.driver", "C:\\GreensTechnology\\JunitClass\\Driver\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	@AfterClass
	public static void CloseBrowser() {
		driver.quit();
	} 
	
	@Before
	public  void startTime() {
		Date d = new Date();
		System.out.println("Starting time is :" +d);
	}
	
	@After
	public  void endTime() {
	Date d1 = new Date();
	System.out.println("Ending time is :"+d1);
	}
	
	@Test
	public  void testCase1() {
		driver.get("https://adactin.com/HotelApp/");
	String url = driver.getCurrentUrl();
	boolean b = url.contains("Hotel");
	Assert.assertTrue("Verify username", b);
	
		WebElement userName = driver.findElement(By.id("username"));
		userName.sendKeys("anandtesting");
			String name = userName.getAttribute("value");
			Assert.assertEquals("Verify Username", "anandtesting", name);
			
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("12345");
			String pass = password.getAttribute("value");
			Assert.assertEquals("Verify password", "12345", pass);
			
		WebElement login = driver.findElement(By.id("login"));
		login.click();
		String url2 = driver.getCurrentUrl();
		boolean b2 = url2.contains("Hotel");
		Assert.assertTrue("Verify invalid url", b2);
		
	}
}