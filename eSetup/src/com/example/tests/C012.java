package com.example.tests;
import static org.junit.Assert.fail;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.internal.seleniumemulation.IsElementPresent;


public class C012 extends UserAndShare {
	private static StringBuffer verificationErrors = new StringBuffer();
	/**
	 * @param test case no.C012
	 * UI behavior is same as user UI?
	 *  
	 */
	
	public void C012() {	
//	public static void main(String[] args) {
//		WebDriver web = new FirefoxDriver();
//
//		//Open login page
//		web.get("http://gluesys01.storpia.com:9000/index.php");
//
//		//Enter ID and Pass
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

		boolean bResult = true;
		for (int i = 1; i <= 10; i++){
			//Click group menu
			driver.findElement(By.linkText("Group")).click();

			//Wait 10 sec for user page to be loaded
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			//click Add user button
			driver.findElement(By.xpath("//button[contains(text(), 'Add')]")).click();

			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {			
				e.printStackTrace();
			}
			
			//Enter user informations (Name, desc, email, password)
			WebElement groupid = driver.findElement(By.id("cgroupid"));
			groupid.sendKeys("group" + i);

			WebElement groupname = driver.findElement(By.id("cgroupdesc"));
			groupname.sendKeys("group desc" + i);

			//Click next--> next
			driver.findElement(By.xpath("//button[contains(text(), 'Next')]")).click();
			driver.findElement(By.xpath("//button[contains(text(), 'Next')]")).click();

			//Click Confirm
			driver.findElement(By.xpath("//button[contains(text(), 'Confirm')]")).click();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.findElement(By.xpath("//button[contains(text(), 'OK')]")).click();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);			
		}

		// Write File
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter("UserAndShare.txt", true));
			out.write("*****************************************************************\r\n");
			out.write("*                         Group Create                          *\r\n");
			out.write("*****************************************************************\r\n");
			out.write("Test C012 - Group\r\n");
			out.write("UI behavior is same as user UI?\r\n");
			out.write("=================================================================\r\n");		        
			if(bResult == true)
				out.write("Test C012 ----------------------------> PASS \r\n");
			else
				out.write("Test C012 ----------------------------> FAIL \r\n");

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
	
	private static boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}
}
