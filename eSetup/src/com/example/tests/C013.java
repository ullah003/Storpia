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

public class C013 extends UserAndShare {
	private static StringBuffer verificationErrors = new StringBuffer();	
	/**
	 * @param test case no.C013
	 * The default group (users) allows limited modification? Can't delete or set permission?
	 * 기본그룹(users) 의 설정은 제한적인가?(권한설정, 삭제 할수 없음)
	 */
	public void C013() {
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

		// Click Group menu
		driver.findElement(By.linkText("Group")).click();

		// admin Search
		WebElement element_search = driver.findElement(By.xpath("//input[@class='x-form-text x-form-field']"));
		element_search.sendKeys("users");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// Search Button Click
		driver.findElement(By.xpath("//*[@class='x-form-trigger x-form-search-trigger']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// users Selected
		for (int second = 0;; second++) {
			if (second >= 60) System.out.println("timeout");
			try {
				String str = driver.findElement(By.xpath("//div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/div[2]/div/div/div[2]/div/div/table/tbody/tr/td")).getText();
				if (str.equals("users")) {
					driver.findElement(By.xpath("//div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/div[2]/div/div/div[2]/div/div/table/tbody/tr/td")).click();
					break;
				}
			} catch (Exception e) {}
			try {
				Thread.sleep(1000);
			}catch(Exception e){}
		}

		try {
			Thread.sleep(1000);
		}catch(Exception e){}
		
		// users Modify Button Click
		driver.findElement(By.xpath("//button[contains(text(), 'Modify')]")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		try {
			Thread.sleep(1000);
		}catch(Exception e){}
		
		boolean bDisabled = false;
		// Limited modification
		String group = driver.findElement(By.xpath("//li[@id='groupModifyWinInfo__gUserInfoWindow']")).getAttribute("class");
		if (group.contains("disabled")) {
			System.out.println("Group Modify Disabled");
			bDisabled = true;
		} else {
			bDisabled = false;
		}
		System.out.println("-----------------------------------------");
		
		driver.findElement(By.xpath("//button[contains(text(), 'Cancel')]")).click();
		
		try {
			Thread.sleep(1000);
		}catch(Exception e){}
		
		// users Delete Button Click
		driver.findElement(By.xpath("//button[contains(text(), 'Delete')]")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// Resualt Text Print
		String end = "[users] The default Group is included in the list.\n\nThe default Group can not be deleted.";
		
		for (int second = 0;; second++) {
			if (second >= 20) System.out.println("timeout");
			try {
				String str = driver.findElement(By.xpath("//*[@class='ext-mb-text']")).getText();
				if (str.equals(end))
					System.out.println(str); break;
			} catch (Exception e) {}
			try {
				Thread.sleep(1000);
			}catch(Exception e){}
		}
		driver.findElement(By.xpath("//button[contains(text(), 'OK')]")).click();		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


		// Write File
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter("C:\\UserAndShare.txt", true));
			out.write("*****************************************************************\r\n");
			out.write("*               Add User properly as wizard style               *\r\n");
			out.write("*****************************************************************\r\n");
			out.write("Test C013 - Group\r\n");
			out.write("The default group (users) allows limited modification? Can't delete or set permission? \r\n" +
					"기본그룹(users) 의 설정은 제한적인가? \r\n" + 
					"(권한설정, 삭제 할수 없음)\r\n");
			out.write("=================================================================\r\n");		        
			if(bDisabled == true)
				out.write("Test C013 ----------------------------> PASS \r\n");
			else
				out.write("Test C013 ----------------------------> FAIL \r\n");
			
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