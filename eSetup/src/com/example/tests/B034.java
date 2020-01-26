//설정초기화는 정상적으로 설정 되는가?
//(초기화 완료후 네트워크는 dhcp서버에서 새로운 주소를 받아 이동)
//Reset Configuration can reset system settings? After reset it will be redirected to DHCP IP. 


package com.example.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class B034 {
	private static WebDriver driver;
	private static String baseUrl;
	private static StringBuffer verificationErrors = new StringBuffer();	
	
	public static void main(String [] args) throws Exception {
		// Before
		driver = new FirefoxDriver();
		baseUrl = "http://192.168.1.84:9000/";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		// Test
		driver.get(baseUrl);
		driver.findElement(By.id("login_userid")).clear();
		driver.findElement(By.id("login_userid")).sendKeys("admin");
		driver.findElement(By.id("login_password")).clear();
		driver.findElement(By.id("login_password")).sendKeys("admin");
		driver.findElement(By.cssSelector("input.btn_login")).click();
		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout");
			try { if (isElementPresent(By.name("icon_esetup"))) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}
		
		System.out.println("---------------Test Case-------------------");
		System.out.println("설정초기화는 정상적으로 설정 되는가?\n(초기화 완료후 네트워크는 dhcp서버에서 새로운 주소를 받아 이동)");
		System.out.println("Reset Configuration can reset system settings?\n(After reset it will be redirected to DHCP IP.)");
		System.out.println("-------------------------------------------");
		
		driver.findElement(By.name("icon_esetup")).click();
		
		// Click Network menu
		System.out.println("Move to Network menu");
		driver.findElement(By.xpath("//body/div/div[2]/div/div/div/div/ul/div/li[2]/ul/li/div/a/span")).click();

		// Network Device select
		System.out.println("select Network Device");
		driver.findElement(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/div/div/div[2]/div[2]/div/div/div[2]/div/div/table/tbody/tr/td/div")).click();

		// Click Modify Button
		System.out.println("Click Modify Button");
		driver.findElement(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/div/div/div[2]/div/div/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[2]/td[2]/em/button")).click();

		Thread.sleep(5000);

		// Click 'STATIC' radio button
		System.out.println("Click 'STATIC' radio button");
		driver.findElement(By.xpath("//label[@for='wstatic']")).click();


		driver.findElement(By.xpath("//button[contains(text(), 'Confirm')]")).click();
		Thread.sleep(10000);

		// get Address Assign
		String addressAssign = driver.findElement(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/div/div/div[2]/div[2]/div/div/div[2]/div/div/table/tbody/tr/td[3]/div")).getText();

		if(addressAssign.equals("static")) {
			System.out.println("Static IP setting is completed successfully.");
		} else {	
			System.out.println("Static IP setting is failed.");
		}
		
		//Refresh
		try{
			Thread.sleep(2000);
		} catch(Exception e) {}
		String url = driver.getCurrentUrl();  
		driver.navigate().to(url);  
		try{
			Thread.sleep(2000);
		} catch(Exception e) {}
		
		// Click Reset Configuration menu
		driver.findElement(By.xpath("//body/div/div[2]/div/div/div/div/ul/div/li[2]/ul/li[9]/div/a/span")).click();		
		
		Thread.sleep(3000);
		
		// Click Reset Configuration button		
		driver.findElement(By.xpath("//button[contains(text(), 'Reset Configuration')]")).click();
		
		driver.findElement(By.xpath("//button[contains(text(), 'Yes')]")).click();
		
		System.out.println("-----------------------------------------------------");
		System.out.println("Rebooting the system.....");
		System.out.println("-----------------------------------------------------");
		for (int second = 0;; second++) {
			if (second >= 120) fail("timeout");
			try { if (isElementPresent(By.cssSelector("input.btn_login"))) break; } catch (Exception e) {}
			Thread.sleep(1000);			
		}
		
		//Refresh
		try{
			Thread.sleep(2000);
		} catch(Exception e) {}
		url = driver.getCurrentUrl();  
		driver.navigate().to(url);  
		try{
			Thread.sleep(2000);
		} catch(Exception e) {}
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		// login
		System.out.println("Move to storpia main page");
		driver.get(baseUrl);
		driver.findElement(By.id("login_userid")).clear();
		driver.findElement(By.id("login_userid")).sendKeys("admin");
		driver.findElement(By.id("login_password")).clear();
		driver.findElement(By.id("login_password")).sendKeys("admin");
		driver.findElement(By.cssSelector("input.btn_login")).click();
		
		// Input Setup information
		System.out.println("Input initial settings information");
		//driver.switchTo().frame("boxIframe");
		//Click Next
		driver.findElement(By.id("nstep")).click();
		Thread.sleep(5000);
		
		// input information
		driver.findElement(By.id("email")).sendKeys("support@storpia.com");
		driver.findElement(By.id("password")).sendKeys("admin");
		driver.findElement(By.id("password1")).sendKeys("admin");
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//body/div[7]/div[2]/div/div/div/form/div[2]/div/div/table/tbody/tr/td/table/tbody/tr/td[2]/table/tbody/tr[2]/td/input[2]")).click();
		//Thread.sleep(3000);
		// Time setting --> failed
		//driver.findElement(By.xpath("//button[contains(text(), 'Next')]")).click();
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//body/div[7]/div[2]/div/div/div/form/div[3]/div/div/table/tbody/tr/td/table/tbody/tr/td[2]/table/tbody/tr[2]/td/input[5]")).click();
		//Thread.sleep(2000);
		
		//driver.findElement(By.xpath("//button[contains(text(), 'Next')]")).click();
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//body/div[7]/div[2]/div/div/div/form/div[4]/div/div/table/tbody/tr/td/table/tbody/tr/td[2]/table/tbody/tr[2]/td/input[2]")).click();
		Thread.sleep(3000);
		
		//driver.findElement(By.xpath("//button[contains(text(), 'Next')]")).click();
		driver.findElement(By.xpath("//body/div[7]/div[2]/div/div/div/form/div[5]/div/div/table/tbody/tr/td/table/tbody/tr/td[2]/table/tbody/tr[2]/td/input[2]")).click();
		Thread.sleep(3000);
		
		Thread.sleep(5000);
		//driver.findElement(By.xpath("//body/div[7]/div[2]/div/div/div/form/div[5]/div/div/table/tbody/tr/td/table/tbody/tr/td[2]/table/tbody/tr[2]/td/input[2]")).click();
		
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//body/div[7]/div[2]/div/div/div/form/div[10]/div/div/table/tbody/tr/td/table/tbody/tr/td[2]/table/tbody/tr[2]/td/input")).click();
		//Thread.sleep(3000);
		//driver.findElement(By.xpath("//button[contains(text(), 'OK')]")).click();
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[contains(text(), 'OK')]")).click();
		
		//driver.findElement(By.xpath("//body/div[19]/div[2]/div/div/div/div/table/tbody/tr/td/img")).click();		
		
		driver.findElement(By.name("icon_esetup")).click();
		
		
		// Click Network menu
		driver.findElement(By.xpath("//body/div/div[2]/div/div/div/div/ul/div/li[2]/ul/li/div/a/span")).click();
		
		// get Address Assign
		addressAssign = driver.findElement(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/div/div/div[2]/div[2]/div/div/div[2]/div/div/table/tbody/tr/td[3]/div")).getText();
		
		if(addressAssign.equals("dhcp")) {
			System.out.println("Initializing the settings is completed successfully.");
		} else {
			System.out.println("Initializing the settings is failed.");			
		}
		
		
		
		// After
		//driver.quit();
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
