//Power Off, system restart works normally?
//전원 끄기,절전모드,시스템 재시작은 정상 동작 되는가?


package com.example.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class B024 {
	private static WebDriver driver;
	private static String baseUrl;
	private static String strParam = "";
	private static StringBuffer verificationErrors = new StringBuffer();
		
	public static void main(String [] args) throws InterruptedException {
		driver = new FirefoxDriver();
		baseUrl = "http://192.168.1.9:9000/";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		// Test
		driver.get(baseUrl + "/index.php");
		driver.findElement(By.id("login_userid")).clear();
		driver.findElement(By.id("login_userid")).sendKeys("admin");
		driver.findElement(By.id("login_password")).clear();
		driver.findElement(By.id("login_password")).sendKeys("admin");
		driver.findElement(By.cssSelector("input.btn_login")).click();
//		for (int second = 0;; second++) {
//			if (second >= 60) fail("timeout");
//			try { if (isElementPresent(By.name("icon_esetup"))) break; } catch (Exception e) {}
//			Thread.sleep(1000);
//		}
		
		System.out.println("------------------ Test Case ----------------------");
		System.out.println("전원 끄기,절전모드,시스템 재시작은 정상 동작 되는가?");
		System.out.println("전원 끄기,절전모드,시스템 재시작은 정상 동작 되는가?");
		System.out.println("---------------------------------------------------");
		
		driver.findElement(By.name("icon_esetup")).click();
		//Get device name
		strParam = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div/div/div[2]/div/div/div/div/div/div/form/div/div[2]/div/div/div/div[2]/div/div/table/tbody/tr/td[2]/div")).getText();
		System.out.println("Server name : " + strParam);
				
		driver.findElement(By.xpath("//body/div/div[2]/div/div/div/div/ul/div/li[2]/ul/li[6]/div/a/span")).click();
		

		// Select Power Off RadioButton
		driver.findElement(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/div/div/div/div/div/div/div/div/div[2]/form/div/div/div/div/div/div/div/div/input")).click();
		Thread.sleep(1000);				
		driver.findElement(By.xpath("//button[contains(text(), 'Confirm')]")).click();		
		Thread.sleep(1000);	
		driver.findElement(By.xpath("//button[contains(text(), 'No')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[contains(text(), 'OK')]")).click();
		
		System.out.println("Shutting down.....");
		Thread.sleep(10000);
		
		
		// Check Relay server
		///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		// Move 'http://my.storpia.com/'
		driver.get("http://my.storpia.com/");

		// find Device (device name)
		driver.findElement(By.xpath("//body/div[2]/div/div[2]/span[2]/div")).click();
		
		Thread.sleep(3000);
		driver.switchTo().frame("boxIframe"); //switch to iframe
		//driver.findElement(By.xpath("//input[@class='textbox1']")).clear();
		driver.findElement(By.xpath("//body/div/form/dl/dd/input")).clear();
		
		
		//driver.findElement(By.xpath("//input[@class='textbox1']")).sendKeys(strParam);
		driver.findElement(By.xpath("//body/div/form/dl/dd/input")).sendKeys(strParam);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//body/div/form/dl[2]/dd/input")).click();		

		// get Device status
		String status = driver.findElement(By.xpath("//body/div[2]/div/div[2]/table/tbody/tr[3]/td[2]")).getText();

		String result = "Power Off or network disconnected.";
		String result1 = "Port is closed.";
		
		if(status.equals(result1) || status.equals(result)) {
			System.out.println("Device is turned off successfully.");
		}else {
			System.out.println("Device Shutdown failed.");
		}
		///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

//		//Refresh
//		try{
//			Thread.sleep(2000);
//		} catch(Exception e) {}
//		String url = driver.getCurrentUrl(); 
//		System.out.println("current url--------:" + url);
//		driver.navigate().to(url);  
//		try{
//			Thread.sleep(2000);
//		} catch(Exception e) {}

		// Check url
		System.out.println("BASE url--------:" + baseUrl);
		driver.get(baseUrl + "/index.php");		
		try {
			if (!isElementPresent(By.cssSelector("input.btn_login")) || !isElementPresent(By.cssSelector("icon_efiler"))){
				System.out.println("Device is turned off successfully.");			
			}else{
				System.out.println("Device Shutdown failed2.");
			}
		} catch (Exception e) {}		
		
//		// Select Power Restart RadioButton
//		driver.findElement(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/div/div/div/div/div/div/div/div/div[2]/form/div/div/div/div/div[2]/div/div/div/input")).click();
//		Thread.sleep(1000);				
//		driver.findElement(By.xpath("//button[contains(text(), 'Confirm')]")).click();		
//		Thread.sleep(1000);	
//		driver.findElement(By.xpath("//button[contains(text(), 'No')]")).click();
//		System.out.println("Device is restarted successfully.");
		
		
		// After
		//driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
		
	}

	public static boolean isElementPresent(By by) {
	    boolean flag = true;
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	    if (!(driver.findElements(by).size() > 0)) {
	        flag = false;
	    } 
	    driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
	    return flag;
	}
}
