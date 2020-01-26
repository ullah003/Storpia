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

public class C010 extends UserAndShare {
	private static StringBuffer verificationErrors = new StringBuffer();	
	/**
	 * @param test case no.C010
	 * For Admin, only admin information can be modified, Group and Privileges tabs will be disabled?
	 * 관리자는 관리자 정보만 수정되는가?(그룹과, 권한설정은 disabled 되어있는가? )
	 */
	
	public void C010() {
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
//		WebElement element_search = web.findElement(By.id("ext-comp-1144"));
		WebElement element_search = driver.findElement(By.xpath("//input[@class='x-form-text x-form-field']"));
		element_search.sendKeys("admin");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		// Search Button Click
		driver.findElement(By.xpath("//*[@class='x-form-trigger x-form-search-trigger']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		// admin Modify
		for (int second = 0;; second++) {
			if (second >= 60) System.out.println("timeout");
			try {
				String str = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/div[2]/div/div/div[2]/div/div/table/tbody/tr/td/div")).getText();
				if (str.equals("admin")) {
					driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/div[2]/div/div/div[2]/div/div/table/tbody/tr/td/div")).click(); break;
				} else {
					System.out.println("wait");
				}
			} catch (Exception e) {}
			try{
			Thread.sleep(1000);
			} catch(Exception e) {}
		}
		
		// admin Modify Button Click
		driver.findElement(By.xpath("//button[contains(text(), 'Modify')]")).click();

		try{
			Thread.sleep(1000);
			} catch(Exception e) {}
		
		// Group, Privileges disabled
		String group = driver.findElement(By.xpath("//li[@id='userModifyWinInfo__userGroupInfoWindow']")).getAttribute("class");
		String privileges = driver.findElement(By.xpath("//li[@id='userModifyWinInfo__userShareInfoWindow']")).getAttribute("class");		
		
		boolean bGroup = false;
		boolean bPrivileges = false;
		
		if (group.contains("disabled")) {
			System.out.println("Group Modify Disabled");
			bGroup = true;
		} else { 
			bGroup = false;
		}
		if (privileges.contains("disabled")) {
			System.out.println("Privileges Modify Disabled");
			bPrivileges = true;
		} else {
			bPrivileges = false;
		}
			

		// Write File
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter("C:\\UserAndShare.txt", true));
			out.write("*****************************************************************\r\n");
			out.write("*              For Admin, modify admin information              *\r\n");
			out.write("*****************************************************************\r\n");
			out.write("Test C010 - User\r\n");
			out.write("For Admin, only admin information can be modified, Group and Privileges tabs will be disabled? \r\n" +
					"관리자는 관리자 정보만 수정되는가?(그룹과, 권한설정은 disabled 되어있는가? ) \r\n");
			out.write("=================================================================\r\n");		        
			if(bGroup == true && bPrivileges == true)
				out.write("Test C010 ----------------------------> PASS \r\n");
			else
				out.write("Test C010 ----------------------------> FAIL \r\n");

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
