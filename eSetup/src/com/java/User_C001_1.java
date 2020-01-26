package com.java;

import java.util.StringTokenizer;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class User_C001_1 {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver web = new FirefoxDriver();
		
		// Open login page
		web.get("http://channeldemo.storpia.com:9000/");
		
		// Enter ID and Password
		WebElement element_id = web.findElement(By.id("login_userid"));
		element_id.sendKeys("admin");
		
		WebElement element_pass = web.findElement(By.id("login_password"));
		element_pass.sendKeys("admin");
		
		//Click login button
		web.findElement(By.cssSelector("input.btn_login")).click();
		
		//Print login success message to console
		System.out.println("Successfully logged in.");
		
		//Wait 10 sec for main page to be loaded
		web.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Click eSetup icon to go to eSetup page
		web.findElement(By.name("icon_esetup")).click();
		
		// Click Group menu
		web.findElement(By.xpath("//ul[@id='ext-gen121']/li[2]/div/a/span")).click();
		
		//Wait 10 sec for user page to be loaded
		web.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		web.findElement(By.xpath("//button[contains(text(), 'Add')]")).click();
		
		//Enter Group informations (Name, desc)
		WebElement groupname = web.findElement(By.id("cgroupid"));
		groupname.sendKeys("user_group");
		
		//Click next--> next
		web.findElement(By.xpath("//button[contains(text(), 'Next')]")).click();
		web.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		web.findElement(By.xpath("//button[contains(text(), 'Next')]")).click();
		web.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		//Click Confirm
//		web.findElement(By.id("ext-gen372")).click();
		web.findElement(By.xpath("//button[contains(text(), 'Confirm')]")).click();		
		web.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
		
		web.findElement(By.xpath("//*[@id='ext-gen94']")).click();		
		web.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);

		//Click User menu
		web.findElement(By.xpath("//ul[@id='ext-gen121']/li/div/a/span")).click();
		
		//Wait 10 sec for user page to be loaded
		web.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		web.findElement(By.xpath("//*[@id='ext-gen211']")).click();
//		web.findElement(By.xpath("//button[contains(text(), 'Add')]")).click();
		web.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		//Enter User informations (Name, desc, email, password)
		WebElement userid = web.findElement(By.id("cuserid"));
		userid.sendKeys("user_group");

		WebElement username = web.findElement(By.id("cuname"));
		username.sendKeys("user_name");

		WebElement useremail = web.findElement(By.id("cemail"));
		useremail.sendKeys("user@storpia.com");

		WebElement userpass = web.findElement(By.id("cpassword"));
		userpass.sendKeys("user");

		WebElement userpass1 = web.findElement(By.id("cpassword1"));
		userpass1.sendKeys("user");
		
		//Click next--> next
		web.findElement(By.xpath("//button[contains(text(), 'Next')]")).click();
		web.findElement(By.xpath("//button[contains(text(), 'Next')]")).click();
		web.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		
		//Click Confirm
		web.findElement(By.xpath("//button[contains(text(), 'Confirm')]")).click();
		web.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		web.findElement(By.xpath("//button[contains(text(), 'OK')]")).click();
		web.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		
		for (int second = 0;; second++) {
			if (second >= 60) System.out.println("timeout");
			try {
				String str = web.findElement(By.xpath("//*[@id='ext-gen104']")).getText();
				System.out.println(str);
				if (str.equals("Group name already exists.\nCan not create same User or Group.")) {
					System.out.println("예외처리 함");
					break;
				}
				} catch (Exception e) {}
			Thread.sleep(1000);
		}
		web.close();
	}

}
