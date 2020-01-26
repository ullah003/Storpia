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

public class C011 extends UserAndShare {
	private static StringBuffer verificationErrors = new StringBuffer();	
	/**
	 * @param test case no.C011
	 * Admin user can't be deleted?
	 * 관리자는 삭제 할수 없음
	 */
	
	public void C011() {
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
		
		// admin Search
		WebElement element_search = driver.findElement(By.xpath("//input[@class='x-form-text x-form-field']"));
		element_search.sendKeys("admin");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		// Search Button Click
//		driver.findElement(By.xpath("//*[@class='x-form-trigger x-form-search-trigger']")).click();
		driver.findElement(By.xpath("//*[@src='/extjs/resources/images/default/s.gif']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		// admin Click
		driver.findElement(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/div[2]/div/div/div[2]/div/div")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		for (int second = 0;; second++) {
			if (second >= 60) System.out.println("timeout");
			try {
				String str = driver.findElement(By.xpath("//div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/div[2]/div/div/div[2]/div/div/table/tbody/tr/td")).getText();
				if (str.equals("admin")) {
					driver.findElement(By.xpath("//div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/div[2]/div/div/div[2]/div/div/table/tbody/tr/td")).click();
					break;
				}
			} catch (Exception e) {}
			try {
			Thread.sleep(1000);
			}catch(Exception e){}
		}
		
		// admin Delete Button Click
		driver.findElement(By.xpath("//button[contains(text(), 'Delete')]")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		// Result Text Print
		boolean result = false;
		String end = "[admin] Administrator account is included in the list.\n\nThe administrator can not be deleted.";
		for (int second = 0;; second++) {
			if (second >= 20) System.out.println("timeout");
			try {
				String str = driver.findElement(By.xpath("//*[@class='ext-mb-text']")).getText();
				if (str.equals(end)) {
					System.out.println(str);
					result = true;
					break;
				}
			} catch (Exception e) {}
			try {
			Thread.sleep(1000);
			}catch(Exception e){}
		}
		
		// Write File
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter("C:\\UserAndShare.txt", true));
			out.write("*****************************************************************\r\n");
			out.write("*                  Admin user can't be deleted                  *\r\n");
			out.write("*****************************************************************\r\n");
			out.write("Test C011 - User\r\n");
			out.write("Admin user can't be deleted? \r\n" +
					"관리자는 삭제 할수 없음 \r\n");
			out.write("=================================================================\r\n");		        
			if(result == true)
				out.write("Test C011 ----------------------------> PASS \r\n");
			else
				out.write("Test C011 ----------------------------> FAIL \r\n");

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
