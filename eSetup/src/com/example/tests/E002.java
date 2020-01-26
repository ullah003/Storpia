package com.example.tests;

import static org.junit.Assert.fail;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class E002 extends Network_Service{
	private static String systemOut = "", successMsg = "", status = "", preStatus = "", postStatus = "";;
//	private static StringBuffer verificationErrors = new StringBuffer();

	public void E002() throws InterruptedException{
		System.out.println("*****************************************************************");
		System.out.println("*                           Auto Router                         *");
		System.out.println("*****************************************************************");
		System.out.println("Test E002 - Auto Router");
		System.out.println("Can it activate UPnP Service successfully? \n" +
				"UPNP 활성화 옵션은 정상적으로 동작 하는가?\n" +
				"--------------------------------------------------------------");
		
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter("D:\\Nerwork_Service.txt", true));
			out.write("*****************************************************************\r\n");
			out.write("*                           Auto Router                         *\r\n");
			out.write("*****************************************************************\r\n");
			out.write("Test E002 - Auto Router \r\n");
			out.write("Can it activate UPnP Service successfully? \r\n" +
					"UPNP 활성화 옵션은 정상적으로 동작 하는가?\r\n");
			out.write("=================================================================\r\n");
//			out.write(status + "\r\n" + successMsg + "\r\n");
			out.close();
		} catch (IOException e) {}
		
		for (int i =1; i<=2; i++){
			// Click Auto Router menu
			driver.findElement(By.xpath("//span[contains(text(), 'Auto router')]")).click();
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	
			try{
				Thread.sleep(3000);
			} catch(Exception e) {}
			
			if (!driver.findElement(By.xpath("//*[@name='upnpenable']")).isSelected()) {
				preStatus = "off";
				status = "UPnP service is not activated. Will activate it.";
				driver.findElement(By.xpath("//*[@name='upnpenable']")).click();
				
				// Click Confirm
				driver.findElement(By.xpath("//button[contains(text(), 'Confirm')]")).click();
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				//Thread.sleep(5000);
				
	//			WebDriverWait wait = new WebDriverWait(driver, 10);
	//			WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(), 'OK')]")));
				
	//			waitForElement(driver, By.xpath("//button[contains(text(), 'OK')]"));
				
	//			for (int second = 0;; second++) {
	//	            if (second >= 60) fail("timeout");
	//	            try { if (isElementPresent(By.xpath("//button[contains(text(), 'OK')]"))) break; } catch (Exception e) {}
	//	            Thread.sleep(1000);
	//	        }
				
				if (isElementPresent(By.xpath("//body/div[16]/div[2]/div/div/div/div/div/div[2]/span"))){
					systemOut = driver.findElement(By.xpath("//body/div[16]/div[2]/div/div/div/div/div/div[2]/span")).getText();		
				}
				
	//			WebDriverWait wait = new WebDriverWait(driver, 10);
	//			WebElement element = wait.until(
	//			        ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(), 'OK')]")));
				
				// Click Ok
	//			driver.findElement(By.xpath("//button[contains(text(), 'OK')]")).click();
			}else{
				preStatus = "on";
				status = "UPnP service is activated. Will deactivate it.";
				driver.findElement(By.xpath("//*[@name='upnpenable']")).click();
				
				// Click Confirm
				driver.findElement(By.xpath("//button[contains(text(), 'Confirm')]")).click();
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				//Thread.sleep(5000);
				
	//			WebDriverWait wait = new WebDriverWait(driver, 10);
	//			WebElement element = wait.until(
	//			        ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(), 'OK')]")));
				
	//			waitForElement(driver, By.xpath("//button[contains(text(), 'OK')]"));
				
	//			for (int second = 0;; second++) {
	//	            if (second >= 60) fail("timeout");
	//	            try { if (isElementPresent(By.xpath("//button[contains(text(), 'OK')]"))) break; } catch (Exception e) {}
	//	            Thread.sleep(1000);
	//	        }
											   
				if (isElementPresent(By.xpath("//body/div[16]/div[2]/div/div/div/div/div/div[2]/span"))){ // check Xpath
					systemOut = driver.findElement(By.xpath("//body/div[16]/div[2]/div/div/div/div/div/div[2]/span")).getText();		
				}
				
				// Click Ok
	//			driver.findElement(By.xpath("//button[contains(text(), 'OK')]")).click();
				
			}
			System.out.println(status);
			//System.out.println("System Output: " + systemOut);
			
			pageRefresh();
			
			driver.findElement(By.xpath("//span[contains(text(), 'Auto router')]")).click();
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			Thread.sleep(2000);
			
			if (!driver.findElement(By.xpath("//*[@name='upnpenable']")).isSelected()) 
				postStatus = "off";
			else
				postStatus = "on";
			
			if (preStatus.equals(postStatus))
				successMsg = "UPnP Activate/Deactivate Failed";
			else
				successMsg = "UPnP Activate/Deactivate Successful";
			
			System.out.println(successMsg);
			
			try {
				BufferedWriter out = new BufferedWriter(new FileWriter("D:\\Nerwork_Service.txt", true));
	//			out.write("*****************************************************************\r\n");
	//			out.write("*                           Auto Router                         *\r\n");
	//			out.write("*****************************************************************\r\n");
	//			out.write("Test E002 - Auto Router \r\n");
	//			out.write("Can it activate UPnP Service successfully? \r\n" +
	//					"UPNP 활성화 옵션은 정상적으로 동작 하는가?\r\n");
	//			out.write("=================================================================\r\n");
				out.write(status + "\r\n" + successMsg + "\r\n");
				out.write("-----------------------------------------------------------------\r\n");
				out.close();
			} catch (IOException e) {}
		}//end for	
//		String verificationErrorString = verificationErrors.toString();
//		if (!"".equals(verificationErrorString)) {
//			fail(verificationErrorString);
//		}
	}
	
//	public static WebElement waitForElement(WebDriver driver, By by) {
//
//	    WebElement element = null;
//	    int counter = 0;
//	    while (element == null) {
//	        try {
//	            Thread.sleep(500);
//	            element = driver.findElement(by);
//	        } catch (Exception e) {
//	            e.printStackTrace();
//	        }
//	        if (counter > 119) {
//	            System.out.println("System has timed out");
//	        }
//	                    counter++;
//	    }
//	    return element;
//	}
//	
//	private static boolean isElementPresent(By by) {
//		try {
//			driver.findElement(by);
//			return true;
//		} catch (NoSuchElementException e) {
//			return false;
//		}
//	}
}
