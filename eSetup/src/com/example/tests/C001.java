package com.example.tests;
import static org.junit.Assert.fail;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.security.auth.login.LoginContext;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


public class C001 extends UserAndShare {
	private static StringBuffer verificationErrors = new StringBuffer();
	/**
	 * @param test case no.C001
	 * Can add user properly as a wizard style?
	 * 사용자 추가가 wizard 형식으로 정상 동작 되는가? 
	 */
	
	public void C001() {
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
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		
//		//Click eSetup icon to go to eSetup page
//		driver.findElement(By.name("icon_esetup")).click();

		boolean result = true;
		
		for (int i =900; i<=905; i++){
			//Click User menu
			driver.findElement(By.linkText("User")).click();

			//Wait 10 sec for user page to be loaded
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			//click Add user button
			driver.findElement(By.xpath("//button[contains(text(), 'Add')]")).click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			try{
				Thread.sleep(1500);
			} catch (Exception e) {}
			//Enter user informations (Name, desc, email, password)
			WebElement userid = driver.findElement(By.id("cuserid"));
			userid.sendKeys("user" + i);

			WebElement username = driver.findElement(By.id("cuname"));
			username.sendKeys("user name" + i);

			WebElement useremail = driver.findElement(By.id("cemail"));
			useremail.sendKeys("user" + i + "@storpia.com");

			WebElement userpass = driver.findElement(By.id("cpassword"));
			userpass.sendKeys("user" + i);

			WebElement userpass1 = driver.findElement(By.id("cpassword1"));
			userpass1.sendKeys("user" + i);

			//Click next--> next
			driver.findElement(By.xpath("//button[contains(text(), 'Next')]")).click();
			driver.findElement(By.xpath("//button[contains(text(), 'Next')]")).click();

			//Click Confirm
			driver.findElement(By.xpath("//button[contains(text(), 'Confirm')]")).click();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.findElement(By.xpath("//button[contains(text(), 'OK')]")).click();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			System.out.println("[user" + i + "] 이 생성되었습니다.");			
		}

		// Write File
		try {
	        BufferedWriter out = new BufferedWriter(new FileWriter("D:\\UserGroupShare.txt", true));
			out.write("*****************************************************************\r\n");
			out.write("*               Add User properly as wizard style               *\r\n");
			out.write("*****************************************************************\r\n");
			out.write("Test C001 - User\r\n");
			out.write("Can add user properly as a wizard style?\r\n" + 
					"사용자 추가가 wizard 형식으로 정상 동작 되는가? \r\n");
			out.write("=================================================================\r\n");		        
			if(result == true)
				out.write("Test C001 ----------------------------> PASS \r\n");
			else
				out.write("Test C001 ----------------------------> FAIL \r\n");
			
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
