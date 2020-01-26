//스마트팬설정이 정상동작 하는가?
//Smart Fan setting was successful?

package com.example.tests;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
//import org.junit.*;
import static org.junit.Assert.*;
//import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.support.ui.Select;

public class B030 extends System_Setting {
	private static String Status = "", systemOutput = "", successMsg = "";
//	private static WebDriver driver;
//	private static String baseUrl;
//	private static StringBuffer verificationErrors = new StringBuffer();
	
	//public static void main(String [] args) throws InterruptedException {
	public void B030() throws InterruptedException, IOException{
		System.out.println("*****************************************************************");
		System.out.println("*                        Smart Fan Setting                      *");
		System.out.println("*****************************************************************");
		System.out.println("Test B030 - System -> Smart Fan ");
		System.out.println("Smart Fan setting was successful? \n" +
				"스마트팬설정이 정상동작 하는가? \n" + 
				"--------------------------------------------------------\n");
		
		try {
	        BufferedWriter out = new BufferedWriter(new FileWriter("D:\\System_Setting.txt", true));
	            out.write("\r\n*****************************************************************\r\n");
		        out.write("*                          Smart Fan Setting                        *\r\n");
		        out.write("*********************************************************************\r\n");
		        out.write("Test B030 - System -> Smart Fan \r\n");
		        out.write("Smart Fan setting was successful? \r\n" +
							"스마트팬설정이 정상동작 하는가?\r\n");
		        out.write("=================================================================\r\n");
//                out.write(Status + "\r\n---------------------------------------\r\n" + 
//                		"System Output message: " + systemOutput + "\r\n-------------------------------------\r\n" +
//                		successMsg + "\r\n" + "\r\n------------------------------------\r\n");
	            out.close();
	        } catch (IOException e) {}
		
		// Before
//		driver = new FirefoxDriver();
//		baseUrl = "http://192.168.1.84:9000/";
//		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		// Test
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
		
//		System.out.println("------------------ Test Case ----------------------");
//		System.out.println("스마트팬설정이 정상동작 하는가?");
//		System.out.println("Can it modify Smart Fan setting successfully?");
//		System.out.println("---------------------------------------------------");
//		
//		driver.findElement(By.name("icon_esetup")).click();
		//Click Smart Fan menu
		driver.findElement(By.xpath("//body/div/div[2]/div/div/div/div/ul/div/li[2]/ul/li[7]/div/a/span")).click();
		
		Thread.sleep(3000);
		int j = 1;
		for (int i =1; i<=10; i++){
			if(driver.findElement(By.xpath("//*[@id='fanenable']")).isSelected()) {
				//System.out.println("Smart Fan control is enabled currently. \n Will set User defined control.");
				Status = "Smart Fan control is enabled currently. \n Will set User defined control.";
				
				// Select user defined
				driver.findElement(By.xpath("//*[@id='customenable']")).click();		
				
				Thread.sleep(3000);
		
				driver.findElement(By.xpath("//img[@class='x-form-trigger x-form-arrow-trigger']")).click();
				Thread.sleep(3000);
				 
				// Select one by one
				driver.findElement(By.xpath("//body/div[14]/div/div[" + j + "]")).click();
				j = j+1;
			}else{
				//System.out.println("User defined Fan control is enabled currently. \n Will set Smart Fan control.");
				Status = "User defined Fan control is enabled currently. \n Will set Smart Fan control.";
				
				// Smart Fan check
				driver.findElement(By.xpath("//*[@id='fanenable']")).click();
			}
			System.out.println(Status);
			
			//Confirm
			Thread.sleep(1000);
			driver.findElement(By.xpath("//button[contains(text(), 'Confirm')]")).click();		
			Thread.sleep(3000);
			//String outputMsg = driver.findElement(By.xpath("//body/div[13]/div[2]/div/div/div/div/div/div[2]/span")).getText();
			systemOutput = driver.findElement(By.xpath("//div[@class='ext-mb-content']/span")).getText();
			driver.findElement(By.xpath("//button[contains(text(), 'OK')]")).click();
			System.out.println("System Output:" + systemOutput);
			
			
			try{
				Thread.sleep(2000);
			} catch(Exception e) {}
			String url = driver.getCurrentUrl();  
			driver.navigate().to(url);  
			try{
				Thread.sleep(2000);
			} catch(Exception e) {}
	
			// Click Smart Fan menu
			driver.findElement(By.xpath("//body/div/div[2]/div/div/div/div/ul/div/li[2]/ul/li[7]/div/a/span")).click();
	
			Thread.sleep(1000);
			// get status
			if(driver.findElement(By.xpath("//*[@id='fanenable']")).isSelected()) {
				//System.out.println("Smart Fan control is enabled successfully.");
				successMsg = "Smart Fan control is enabled successfully.";
			}else if(driver.findElement(By.xpath("//*[@id='customenable']")).isSelected()) {
				String status1 = driver.findElement(By.id("customfan")).getAttribute("value");
				//System.out.println("User defined Fan control set successfully to : " + status);
				successMsg = "User defined Fan control set successfully to : " + status1;
			}
			System.out.println(successMsg + "\n-----------------------------------------------------------");
		
		
			try {
		        BufferedWriter out = new BufferedWriter(new FileWriter("D:\\System_Setting.txt", true));
//		            out.write("\r\n*****************************************************************\r\n");
//			        out.write("*                          Smart Fan Setting                        *\r\n");
//			        out.write("*********************************************************************\r\n");
//			        out.write("Test B030 - System -> Smart Fan \r\n");
//			        out.write("Smart Fan setting was successful? \r\n" +
//								"스마트팬설정이 정상동작 하는가?\r\n");
//			        out.write("=================================================================\r\n");
	                out.write(Status + "\r\n" + 
	                		"System Output message: " + systemOutput + "\r\n" +
	                		successMsg + "\r\n------------------------------------\r\n\r\n");
		            out.close();
		        } catch (IOException e) {}
			
		} //End For
		
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
}
