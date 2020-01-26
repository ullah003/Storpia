//쓰기캐쉬지원 동작이 정상적인가?
//Can enable disable write cache successfully?

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

public class B015 extends System_Setting {
//	private static WebDriver driver;
//	private static String baseUrl;
	private static String successMsg = "", status = "", popupMsg = "";
//	private static StringBuffer verificationErrors = new StringBuffer();
	
//	public static void main(String []args) throws Exception {
	public void B015() throws InterruptedException{
		System.out.println("*****************************************************************");
		System.out.println("*                       Disk Write Cache                      *");
		System.out.println("*****************************************************************");
		System.out.println("Test B015 - System -> Disk ");
		System.out.println("Can enable disable write cache successfully? \n" +
				"쓰기캐쉬지원 동작이 정상적인가? \n" +
				"------------------------------------------");
		
				
		//driver.findElement(By.xpath("//ul[@id='ext-gen119']/li[2]/div")).click();
		driver.findElement(By.linkText("Disk")).click();
		
		//driver.findElement(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div/div/div/ul/li[2]/a[2]/em/span/span")).click();
		//driver.findElement(By.linkText("Disk Management")).click();
		
		Thread.sleep(3000);
		//Select disk						  
		//driver.findElement(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[2]/div/div/div/div/div/div/div/form/div/div/div/div/div[2]/div[2]/div/div/div[2]/div/div/table/tbody/tr/td/div")).click();
		driver.findElement(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/div/div/div/form/div/div/div/div/div[2]/div[2]/div/div/div[2]/div/div/table/tbody/tr/td/div")).click();
									 //body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/div/div/div/form/div/div/div/div/div[2]/div[2]/div/div/div[2]/div/div/table/tbody/tr/td/div
		//Click Write Cache support button
		driver.findElement(By.xpath("//button[contains(text(), 'Write Cache support')]")).click();
		//driver.findElement(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[2]/div/div/div/div/div/div/div/form/div/div/div/div/div[2]/div/div/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[2]/td[2]/em/button")).click();
		
		//System.out.println("Write cache support popup open.");
		if (isElementPresent(By.xpath("/html/body/div[18]/div[2]/div/div/div/div/div/div[2]/span"))){
			popupMsg = driver.findElement(By.xpath("/html/body/div[18]/div[2]/div/div/div/div/div/div[2]/span")).getText();
			driver.findElement(By.xpath("//button[contains(text(), 'OK')]")).click();
			System.out.println("Output : " + popupMsg);
		}else{
			if (!driver.findElement(By.id("CacheEnable")).isSelected()){
				status = "Currently Write Cache is NOT ENABLED, going to enable it. ";
				driver.findElement(By.id("CacheEnable")).click();
					
				driver.findElement(By.xpath("//button[contains(text(), 'Confirm')]")).click();
				Thread.sleep(2000);		
		
				popupMsg = driver.findElement(By.xpath("/html/body/div[21]/div[2]/div/div/div/div/div/div[2]/span")).getText();
				System.out.println("Output : " + popupMsg);
		
				driver.findElement(By.xpath("//button[contains(text(), 'OK')]")).click();
				
				//Select disk
				//driver.findElement(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[2]/div/div/div/div/div/div/div/form/div/div/div/div/div[2]/div[2]/div/div/div[2]/div/div/table/tbody/tr/td/div")).click();
				driver.findElement(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/div/div/div/form/div/div/div/div/div[2]/div[2]/div/div/div[2]/div/div/table/tbody/tr/td/div")).click();
				//Click Write Cache support button
				//driver.findElement(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[2]/div/div/div/div/div/div/div/form/div/div/div/div/div[2]/div/div/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[2]/td[2]/em/button")).click();
				driver.findElement(By.xpath("//button[contains(text(), 'Write Cache support')]")).click();
				if (driver.findElement(By.id("CacheEnable")).isSelected())
					successMsg = "Write Cache enabled successfully.";
				else
					successMsg = "Write Cache enable failed.";
						
				driver.findElement(By.xpath("//button[contains(text(), 'Close')]")).click();
			}else{
				status = "Currently Write Cache is ENABLED, going to disable it.";
				driver.findElement(By.id("CacheEnable")).click();
				
				driver.findElement(By.xpath("//button[contains(text(), 'Confirm')]")).click();
				Thread.sleep(1000);		
		
				popupMsg = driver.findElement(By.xpath("/html/body/div[21]/div[2]/div/div/div/div/div/div[2]/span")).getText();
				System.out.println("Output : " + popupMsg);
		
				driver.findElement(By.xpath("//button[contains(text(), 'OK')]")).click();
				
				//Select disk
				//driver.findElement(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[2]/div/div/div/div/div/div/div/form/div/div/div/div/div[2]/div[2]/div/div/div[2]/div/div/table/tbody/tr/td/div")).click();
				driver.findElement(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/div/div/div/form/div/div/div/div/div[2]/div[2]/div/div/div[2]/div/div/table/tbody/tr/td/div")).click();
				//Click Write Cache support button
				//driver.findElement(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[2]/div/div/div/div/div/div/div/form/div/div/div/div/div[2]/div/div/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[2]/td[2]/em/button")).click();
				driver.findElement(By.xpath("//button[contains(text(), 'Write Cache support')]")).click();
				
				if (!driver.findElement(By.id("CacheEnable")).isSelected())
					successMsg = "Write Cache DISABLED successfully.";
				else
					successMsg = "Write Cache DISABLE failed.";
						
				driver.findElement(By.xpath("//button[contains(text(), 'Close')]")).click();
			}
			System.out.println(status + "\nSystem Output: " + popupMsg + "\n" + successMsg);
		}
		
		try {
	        BufferedWriter out = new BufferedWriter(new FileWriter("D:\\System_Setting.txt", true));
	            out.write("\r\n*****************************************************************\r\n");
		        out.write("*                           Disk Information                      *\r\n");
		        out.write("*****************************************************************\r\n");
		        out.write("Test B008 - System -> Disk \r\n");
		        out.write("Can it show Disk information properly? \r\n" +
							"디스크 리스트가 정상적으로 출력되는가?\r\n");
		        out.write("=================================================================\r\n");
                out.write(status + "\nSystem Output: " + popupMsg + "\n" + successMsg);
	            out.close();
	        } catch (IOException e) {}
		
		// After
		//driver.quit();
//		String verificationErrorString = verificationErrors.toString();
//		if (!"".equals(verificationErrorString)) {
//			fail(verificationErrorString);
//		}
	}	

//	private static boolean isElementPresent(By by) {
//		try {
//			driver.findElement(by);
//			return true;
//		} catch (NoSuchElementException e) {
//			return false;
//		}
//	}
	
	public static boolean isElementPresent(By by) {
	    boolean flag = true;
	    driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	    if (!(driver.findElements(by).size() > 0)) {
	        flag = false;
	    } 
	    driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
	    return flag;
	}
}
