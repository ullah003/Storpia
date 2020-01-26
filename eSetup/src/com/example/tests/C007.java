package com.example.tests;

import static org.junit.Assert.fail;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


public class C007 extends UserAndShare {
	private static StringBuffer verificationErrors = new StringBuffer();	
	/**
	 * @param test case no.C007
	 * Can it sort normally after search?
	 * 검색후 정렬은 정상적으로 동작 되는가? 
	 */
	public void C007() {
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

		// Click User menu
		driver.findElement(By.linkText("User")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		// Search type
//		WebElement element_search = web.findElement(By.id("ext-comp-1144"));
		WebElement element_search = driver.findElement(By.xpath("//input[@class='x-form-text x-form-field']"));
		element_search.sendKeys("user");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		// Search Button Click
		driver.findElement(By.xpath("//*[@class='x-form-trigger x-form-search-trigger']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		// Search List
		String[] before = new String[25];
		
		try {
			Thread.sleep(1000);
		} catch(Exception e) {}
		
		// Before Sort Element
				System.out.println("Before Sort Element");
				for (int i = 0; i < 25; i++) {
					before[i] = driver.findElement(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/div[2]/div/div/div[2]/div/div[" + (i+1) + "]/table/tbody/tr/td/div")).getText();
					System.out.println(before[i]);
				}
		
		// Search List Sort
		Arrays.sort(before);
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// Sort Userid Click
		driver.findElement(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/div[2]/div/div/div/div/div/table/thead/tr/td/div")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		int success = 0;
		String[] after = new String[25];
		
		// Compared
		for (int i = 0; i < 25; i++){
			after[i] = driver.findElement(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/div[2]/div/div/div[2]/div/div[" + (i+1) + "]/table/tbody/tr/td/div")).getText();
			if (after[i].equals(before[i])) {
				System.out.println(i + ": Like");
				success = 1;
			} else {
				success = 0;
				System.out.println(i + ": Sort Fail");
				break;
			}
		}
		if (success == 1)
			System.out.println("Sort Success");
		// Write File
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter("C:\\UserAndShare.txt", true));
			out.write("*****************************************************************\r\n");
			out.write("*                      Sort after searching                     *\r\n");
			out.write("*****************************************************************\r\n");
			out.write("Test C007 - User\r\n");
			out.write("Can it sort normally after search? \r\n" + 
					"검색후 정렬은 정상적으로 동작 되는가? \r\n");
			out.write("=================================================================\r\n");		        
			if(success == 1)
				out.write("Test C007 ----------------------------> PASS \r\n");
			else
				out.write("Test C007 ----------------------------> FAIL \r\n");

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