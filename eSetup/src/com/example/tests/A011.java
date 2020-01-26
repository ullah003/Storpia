//After clicking Refresh button can it show the newly received log information?
//새로고침 버튼 클릭시 로그내용을 새로 받아오는가? 
//TO check Refresh we opened two browsers but current FW doesn't support multiple login session, so can't test surrently.
		
package com.example.tests;

import java.util.concurrent.TimeUnit;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class A011 {
	private static WebDriver driver;
	private static WebDriver driver1; 
	private static String baseUrl;
	private static StringBuffer verificationErrors = new StringBuffer();
	private static StringBuffer verificationErrors1 = new StringBuffer();
	
	public static void main(String [] args) throws InterruptedException {
		// Before
		driver = new FirefoxDriver();
		baseUrl = "http://192.168.1.9:9000/";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver1 = new FirefoxDriver();
		driver1.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		
		// Test (driver)
		driver.get(baseUrl + "/index.php");
		driver.findElement(By.id("login_userid")).clear();
		driver.findElement(By.id("login_userid")).sendKeys("admin");
		driver.findElement(By.id("login_password")).clear();
		driver.findElement(By.id("login_password")).sendKeys("admin");
		driver.findElement(By.cssSelector("input.btn_login")).click();
		Thread.sleep(3000);

		driver.findElement(By.name("icon_esetup")).click();
		
		System.out.println("Driver open");
		
		// Test (driver1)
		driver1.get(baseUrl + "/index.php");
		driver1.findElement(By.id("login_userid")).clear();
		driver1.findElement(By.id("login_userid")).sendKeys("admin");
		driver1.findElement(By.id("login_password")).clear();
		driver1.findElement(By.id("login_password")).sendKeys("admin");
		driver1.findElement(By.cssSelector("input.btn_login")).click();
		Thread.sleep(3000);

		driver1.findElement(By.name("icon_esetup")).click();
		System.out.println("Driver1 open");
		
		
		// get Server Name
		String serverName = driver.findElement(By.xpath("//body/div[2]/div/div/div/div[2]/div/div/div[2]/div/div/div/div/div/div/form/div/div[2]/div/div/div/div[2]/div/div/table/tbody/tr/td[2]/div")).getText();		
		
		// Click Network Menu (driver)
		driver.findElement(By.xpath("//body/div/div[2]/div/div/div/div/ul/div/li[2]/ul/li/div/a/span")).click();
		Thread.sleep(3000);
		System.out.println("Driver -> Move Network menu");
		
		// Click Log Menu (driver1)
		driver1.findElement(By.xpath("//body/div/div[2]/div/div/div/div/ul/div/li/ul/li[3]/div/a/span")).click();
		System.out.println("Driver1 -> Move Log menu");
		
		//if(serverName.equals("gluesys01")) serverName = "gluesys02";
		//else serverName = "gluesys01";
		serverName = "demo02";
		
		// input hostname
		driver.findElement(By.name("hostname")).clear();
		Thread.sleep(3000);
		driver.findElement(By.name("hostname")).sendKeys(serverName);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[contains(text(), 'Apply DDNS settings')]")).click();
		Thread.sleep(3000);		
		driver.findElement(By.xpath("//button[contains(text(), 'OK')]")).click();		
		Thread.sleep(3000);
		System.out.println("Driver -> Leave Log..");
		
		// Click Refresh button (driver1)
		driver1.findElement(By.xpath("//button[contains(text(), 'Refresh')]")).click();
		System.out.println("Driver1 -> Refresh button");
		Thread.sleep(2000);

		// Get log
		String temp = driver1.findElement(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/div[2]/div/div/div[2]/div/div/table/tbody/tr/td[5]/div")).getText();
		
		if(temp.equals("[" + serverName + "] Device name registration")) {
			System.out.println("Log is saved successfully.");
		} else {
			System.out.println(temp);
		}
		
		// After
		//driver.quit();
		//driver1.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}		
	}

	private static boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}
}
