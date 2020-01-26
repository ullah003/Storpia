//판넬 show/hide 정상적으로 동작 하는가?
//If  "<<" arrow clicked from left panel can it hide/show left panel and shows the right panel UI

package com.example.tests;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class A002 extends System_Information{
//	private static WebDriver driver;
//	private static String baseUrl;
//	private static StringBuffer verificationErrors = new StringBuffer();
	private static String ShowLeft = "", HideLeft = "";
	public void A002(){
		System.out.println("*****************************************************************");
		System.out.println("*                       Hide/Show Left Panel                    *");
		System.out.println("*****************************************************************");
		System.out.println("Test A002 - System Status -> Left Panel");
		System.out.println("If  '<<' arrow clicked from left panel can it hide/show left panel and shows the right panel UI \n" +
				"판넬 show/hide 정상적으로 동작 하는가?\n");
		
	//public static void main(String []args) throws Exception {
		// Before
//		driver = new FirefoxDriver();
//		baseUrl = "http://192.168.1.9:9000/";
//		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//		
//		// Test
//		driver.get(baseUrl + "/index.php");
//		driver.findElement(By.id("login_userid")).clear();
//		driver.findElement(By.id("login_userid")).sendKeys("admin");
//		driver.findElement(By.id("login_password")).clear();
//		driver.findElement(By.id("login_password")).sendKeys("admin");
//		driver.findElement(By.cssSelector("input.btn_login")).click();
//		for (int second = 0;; second++) {
//			if (second >= 60) fail("timeout");
//			try { if (isElementPresent(By.name("icon_esetup"))) break; } catch (Exception e) {}
//			Thread.sleep(1000);
//		}
//
//		driver.findElement(By.name("icon_esetup")).click();
//		for (int second = 0;; second++) {
//			if (second >= 60) fail("timeout");
//			try { if (isElementPresent(By.id("ext-gen25"))) break; } catch (Exception e) {}
//			Thread.sleep(1000);
//		}
		
		
		driver.findElement(By.xpath("//body/div/div/div")).click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//if (isElementPresent(By.xpath("//div[@id='menuTree-xcollapsed']")))
		if (driver.findElement(By.xpath("//div[@id='menuTree-xcollapsed']")).isDisplayed()){
			HideLeft = "Left panel can hide Successfully.";
			System.out.println("Left panel can hide Successfully.");
		}else{
			HideLeft = "Can't hide Left panel.";
			System.out.println("Can't hide Left panel.");
		}
		
//		for (int second = 0;; second++) {
//			if (second >= 60) fail("timeout");
//			try { if (isElementPresent(By.id("ext-gen149"))) break; } catch (Exception e) {}
//			Thread.sleep(1000);
//		}

		driver.findElement(By.xpath("//body/div[14]/div")).click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//if (!isElementPresent(By.xpath("//div[@id='menuTree-xcollapsed']")))
		
		if (!driver.findElement(By.xpath("//div[@id='menuTree-xcollapsed']")).isDisplayed()){
			ShowLeft = "Left panel can show Successfully.";
			System.out.println("Left panel can show Successfully");
		}else{
			ShowLeft = "Can't show Left panel.";
			System.out.println("Can't show Left panel.");
		}
		
		try {
	        BufferedWriter out = new BufferedWriter(new FileWriter("D:\\System_Information.txt", true));
		        out.write("\r\n*****************************************************************\r\n");
		        out.write("*                       Hide/Show Left Panel                    *\r\n");
		        out.write("*****************************************************************\r\n");
		        out.write("Test A002 - System Status -> Left Panel\r\n");
		        out.write("If  '<<' arrow clicked from left panel can it hide/show left panel and shows the right panel UI \r\n" +
					"판넬 show/hide 정상적으로 동작 하는가?\r\n");
		        out.write("=================================================================\r\n");
		        out.write(HideLeft + "\r\n" + ShowLeft + "\r\n");
		          
	            out.close();
	        } catch (IOException e) {}
		
		// After
		//driver.quit();
//		String verificationErrorString = verificationErrors.toString();
//		if (!"".equals(verificationErrorString)) {
//			fail(verificationErrorString);
//		}
		
	}	

	private static boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}
	
//	public static boolean isElementNotPresent(By by) {
//	    boolean flag = true;
//	    driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
//	    if (!(driver.findElements(by).size() > 0)) {
//	        flag = false;
//	    } 
//	    driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
//	    return flag;
//	}
}
