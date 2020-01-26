package com.example.tests;

import static org.junit.Assert.fail;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class C015 extends UserAndShare {
	private static StringBuffer verificationErrors = new StringBuffer();
	/**
	 * @param test case no.C015
	 * After adding Share, it shows Volume information from Share info?
	 * 공유 추가시 공유정보에서 볼륨정보는 정상적으로 출력되는가?
	 */
	public void C015() {
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		WebDriver web = new FirefoxDriver();
//
//		// Open login page
//		web.get("http://gluesys01.storpia.com:9000/index.php");
//
//		// Enter ID and Password
//		WebElement element_id = web.findElement(By.id("login_userid"));
//		element_id.sendKeys("admin");
//
//		WebElement element_pass = web.findElement(By.id("login_password"));
//		element_pass.sendKeys("admin");
//
//		//Click login button
//		web.findElement(By.cssSelector("input.btn_login")).click();
//
//		//Print login success message to console
//		System.out.println("Successfully logged in.");
//
//		//Wait 10 sec for main page to be loaded
//		web.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//
//		//Click eSetup icon to go to eSetup page
//		web.findElement(By.name("icon_esetup")).click();

		// Click Share menu
		driver.findElement(By.linkText("Share Folder")).click();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//button[contains(text(), 'Add')]")).click();
		
		//Enter Share informations (Name, desc)
		String shr = "shred";
		WebElement sharename = driver.findElement(By.id("cname"));
		sharename.sendKeys(shr);
		
		WebElement sharedesc = driver.findElement(By.id("cdesc"));
		sharedesc.sendKeys("Share_folder");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Click next--> next		
		driver.findElement(By.xpath("//button[contains(text(), 'Next')]")).click();
		driver.findElement(By.xpath("//button[contains(text(), 'Next')]")).click();
		driver.findElement(By.xpath("//button[contains(text(), 'Next')]")).click();
		
		//Click Confirm
		try{
			Thread.sleep(1000);
			} catch(Exception e) {}
		driver.findElement(By.xpath("//button[contains(text(), 'Confirm')]")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		try{
			Thread.sleep(3000);
			} catch(Exception e) {}
		driver.findElement(By.xpath("//button[contains(text(), 'OK')]")).click();
		System.out.println("Share created Successfully.");
		
		
		WebElement element_search = driver.findElement(By.xpath("//input[@class='x-form-text x-form-field']"));
		element_search.sendKeys(shr);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		// Search Button Click
		driver.findElement(By.xpath("//*[@class='x-form-trigger x-form-search-trigger']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("Search Success");
		
		String end = "volume1/shred";
		
		boolean result = false;
		for (int second = 0;; second++) {
			if (second >= 20) System.out.println("timeout");
			try {
				String str = driver.findElement(By.xpath("//*[@class='x-grid3-cell-inner x-grid3-col-3']")).getText();
				if (end.equals(str)) {
					System.out.println(str);
					System.out.println("Success"); 
					result = true;
					break;					
				} else {
					System.out.println("Loading");
					result = false;
				}
			} catch (Exception e) {}
			try {
			Thread.sleep(1000);
			}catch(Exception e){}
		}
		
		/*
		for (int second = 0;; second++) {
			if (second >= 20) System.out.println("timeout");
			try {
				String str = web.findElement(By.xpath("//input[@id='volume']")).getText();
				if (volume.equals(str)) {
					System.out.println(str);
					System.out.println("Volume Info Success"); break;
				} else
					System.out.println("Volume Loading");
			} catch (Exception e) {}
			try {
			Thread.sleep(1000);
			}catch(Exception e){}
		}
		
		for (int second = 0;; second++) {
			if (second >= 20) System.out.println("timeout");
			try {
				String str = web.findElement(By.xpath("//input[@id='path']")).getText();
				if (path.equals(str)) {
					System.out.println(str);
					System.out.println("Path Info Success"); break;
				} else
					System.out.println("Path Loading");
			} catch (Exception e) {}
			try {
			Thread.sleep(1000);
			}catch(Exception e){}
		}*/
		
		// Write File
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter("UserAndShare.txt", true));
			out.write("*****************************************************************\r\n");
			out.write("*                      Share Add Infomation                     *\r\n");
			out.write("*****************************************************************\r\n");
			out.write("Test C015 - Share Folder\r\n");
			out.write("After adding Share, it shows Volume information from Share info? \r\n" +
					"공유 추가시 공유정보에서 볼륨정보는 정상적으로 출력되는가?\r\n");
			out.write("=================================================================\r\n");		        
			if(result == true)
				out.write("Test C015 ----------------------------> PASS \r\n");
			else
				out.write("Test C015 ----------------------------> FAIL \r\n");

			out.write("\r\n");
			//out.flush();	
			out.close();
		} catch (IOException e) {}
		System.out.println("Write file successfully.");


		// After
//		driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}	
}
