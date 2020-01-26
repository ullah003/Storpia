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
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.internal.seleniumemulation.IsElementPresent;

public class C009 extends UserAndShare {
	private static StringBuffer verificationErrors = new StringBuffer();
	boolean result = false;
	/**
	 * @param test case no.C009
	 * By Double Click, user information and modification page appears normally?
	 * 리스트 더블클릭시 해당사용자의 정보 수정 페이지가 정상 동작 하는가?
	 */
	public void C009() {
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		WebDriver web = new FirefoxDriver();		
		Actions action = new Actions(driver);
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
//		// Click login button
//		web.findElement(By.cssSelector("input.btn_login")).click();
//
//		// Print login success message to console
//		System.out.println("Successfully logged in.");
//
//		// Wait 10 sec for main page to be loaded
//		web.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//
//		// Click eSetup icon to go to eSetup page
//		web.findElement(By.name("icon_esetup")).click();

		// Click User menu
		driver.findElement(By.linkText("User")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// Create User
		driver.findElement(By.xpath("//button[contains(text(), 'Add')]")).click();

		try{
			Thread.sleep(1000);
		} catch (Exception e) {}
		
		//Enter user informations (Name, desc, email, password)
		WebElement userid = driver.findElement(By.id("cuserid"));
		userid.sendKeys("double");

		WebElement username = driver.findElement(By.id("cuname"));
		username.sendKeys("user name");

		WebElement useremail = driver.findElement(By.id("cemail"));
		useremail.sendKeys("user@storpia.com");

		WebElement userpass = driver.findElement(By.id("cpassword"));
		userpass.sendKeys("user");

		WebElement userpass1 = driver.findElement(By.id("cpassword1"));
		userpass1.sendKeys("user");

		//Click next--> next
		driver.findElement(By.xpath("//button[contains(text(), 'Next')]")).click();
		driver.findElement(By.xpath("//button[contains(text(), 'Next')]")).click();

		//Click Confirm
		driver.findElement(By.xpath("//button[contains(text(), 'Confirm')]")).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//button[contains(text(), 'OK')]")).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		//Refresh
		try{
			Thread.sleep(1500);
		} catch(Exception e) {}
		String url = driver.getCurrentUrl();
		driver.navigate().to(url);
		try{
			Thread.sleep(1500);
		} catch(Exception e) {}

		// Click User menu
		driver.findElement(By.linkText("User")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// Search user
		WebElement element_search = driver.findElement(By.xpath("//input[@class='x-form-text x-form-field']"));
		element_search.sendKeys("double");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// Search Button Click
		driver.findElement(By.xpath("//*[@class='x-form-trigger x-form-search-trigger']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		try{
			Thread.sleep(1000);
		} catch (Exception e) {}

		// Double Click
		WebElement dbc = driver.findElement(By.xpath("//div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/div[2]/div/div/div[2]/div/div/table/tbody/tr/td"));
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		action.doubleClick(dbc).perform();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

		try {
			Thread.sleep(1000);
		} catch(Exception e) {}

		// check modify page
		if(isElementPresent(By.id("uname"))) {
			result = true;
			System.out.println("show modify page");
		} else {
			result = false;
			System.out.println("cannot show modify page");
		}
		
		
		// Enter Dec , Email, Password
		WebElement userDec = driver.findElement(By.id("uname"));
		userDec.clear();
		userDec.sendKeys("doubleclick");

		useremail = driver.findElement(By.id("email"));
		useremail.clear();
		useremail.sendKeys("dbc@storpia.com");

		userpass = driver.findElement(By.id("password"));		
		userpass.sendKeys("1111");

		userpass1 = driver.findElement(By.id("password1"));
		userpass1.sendKeys("1111");

		try {
			Thread.sleep(1000);
		} catch(Exception e) {}

		//Click Confirm
		driver.findElement(By.xpath("//button[contains(text(), 'Confirm')]")).click();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//button[contains(text(), 'OK')]")).click();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		System.out.println("Modify Success");


		// Write File
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter("UserAndShare.txt", true));
			out.write("*****************************************************************\r\n");
			out.write("*              Show modify page after double click              *\r\n");
			out.write("*****************************************************************\r\n");
			out.write("Test C009 - User\r\n");
			out.write("By Double Click, user information and modification page appears normally? \r\n" +
					"리스트 더블클릭시 해당사용자의 정보 수정 페이지가 정상 동작 하는가? \r\n");
			out.write("=================================================================\r\n");		        
			if(result == true)
				out.write("Test C009 ----------------------------> PASS \r\n");
			else
				out.write("Test C009 ----------------------------> FAIL \r\n");

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