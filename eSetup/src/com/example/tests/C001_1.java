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

public class C001_1 extends UserAndShare {
	private static StringBuffer verificationErrors = new StringBuffer();
	String result = "";
	/**
	 * @param test case no.C001_1
	 * 사용자추가 예외처리는 정상 동작 하는가?
	 * (그룹명과 동일한 사용자는 생성할수 없음)
	 */
	public void C001_1() {
//		// TODO Auto-generated method stub
//		WebDriver web = new FirefoxDriver();
//		
//		// Open login page
//		web.get("http://http://192.168.0.5:9000/");
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
//		System.out.println("--------------------------");
//		
//		// Wait 10 sec for main page to be loaded
//		web.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		
//		// Click eSetup icon to go to eSetup page
//		web.findElement(By.name("icon_esetup")).click();
		
		// Click Group menu
//		web.findElement(By.xpath("//ul[@id='ext-gen121']/li[2]/div/a/span")).click();
		driver.findElement(By.linkText("Group")).click();
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		// Click Add Button(Group Menu)
		driver.findElement(By.xpath("//button[contains(text(), 'Add')]")).click();
		
		// Enter Group informations (Name, desc)
		WebElement groupname = driver.findElement(By.id("cgroupid"));
		groupname.sendKeys("user_group");
		System.out.println("Group Info Success");
		System.out.println("--------------------------");
		
		//Click next--> next
		driver.findElement(By.xpath("//button[contains(text(), 'Next')]")).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//button[contains(text(), 'Next')]")).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		try{
			Thread.sleep(1000);
			} catch(Exception e) {}
		
		// Click Confirm
		driver.findElement(By.xpath("//button[contains(text(), 'Confirm')]")).click();		
		driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);		
		
		try{
			Thread.sleep(3000);
			} catch(Exception e) {}
		
		// Click OK
		driver.findElement(By.xpath("//button[contains(text(), 'OK')]")).click();		
		driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
		System.out.println("Group Create Success");
		System.out.println("--------------------------");

		// Refresh
		try{
			Thread.sleep(2000);
		} catch(Exception e) {}
		String url = driver.getCurrentUrl();		
		driver.navigate().to(url);		
		try{
			Thread.sleep(2000);
		} catch(Exception e) {}
		
		// Click User menu
		driver.findElement(By.xpath("//ul[@id='ext-gen121']/li/div/a/span")).click();
//		web.findElement(By.xpath("//span[contains(text(), 'User')]")).click();  // can't read
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		try{
			Thread.sleep(3000);
			} catch(Exception e) {}
		
		// Click Add Button(User Menu)
		driver.findElement(By.xpath("//button[contains(text(), 'Add')]")).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		System.out.println("Add Button Click Success");
		System.out.println("--------------------------");
		
		//Enter User informations (Name, desc, email, password)
		WebElement userid = driver.findElement(By.id("cuserid"));
		userid.sendKeys("user_group");

		WebElement username = driver.findElement(By.id("cuname"));
		username.sendKeys("user_name");

		WebElement useremail = driver.findElement(By.id("cemail"));
		useremail.sendKeys("user@storpia.com");

		WebElement userpass = driver.findElement(By.id("cpassword"));
		userpass.sendKeys("user");

		WebElement userpass1 = driver.findElement(By.id("cpassword1"));
		userpass1.sendKeys("user");
		
		//Click next--> next
		driver.findElement(By.xpath("//button[contains(text(), 'Next')]")).click();
		driver.findElement(By.xpath("//button[contains(text(), 'Next')]")).click();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		
		try{
			Thread.sleep(3000);
			} catch(Exception e) {}
		
		//Click Confirm
		driver.findElement(By.xpath("//button[contains(text(), 'Confirm')]")).click();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		
		// Error Message Check
		for (int second = 0;; second++) {
			if (second >= 60) System.out.println("timeout");
			try {
				String str = driver.findElement(By.xpath("//*[@class='ext-mb-text']")).getText();
				
				System.out.println(str);
				System.out.println("--------------------------");
				if (str.equals("Group name already exists.\nCan not create same User or Group.")) {
					result = "Exception Successfully";
					System.out.println(result);					
					break;
				}
				Thread.sleep(1000);
			} catch (Exception e) {}
		}
		
		// Click OK Button
		driver.findElement(By.xpath("//button[contains(text(), 'OK')]")).click();
		
		// Write File
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter("C:\\UserAndShare.txt", true));
			out.write("*****************************************************************\r\n");
			out.write("*                     Exception_Create User                     *\r\n");
			out.write("*****************************************************************\r\n");
			out.write("Test C001-1 - User\r\n");
			out.write("사용자추가 예외처리는 정상 동작 하는가?\r\n" +
					"(그룹명과 동일한 사용자는 생성할수 없음) \r\n");
			out.write("=================================================================\r\n");		        
			if(result != null)
				out.write("Test C001-1 ----------------------------> PASS \r\n");
			else
				out.write("Test C001-1 ----------------------------> FAIL \r\n");

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
