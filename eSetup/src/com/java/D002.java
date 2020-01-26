package com.java;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class D002 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver web = new FirefoxDriver();

		// Open login page
		web.get("http://gluesys01.storpia.com:9000/index.php");

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

		// Click CIFS menu
		web.findElement(By.xpath("//ul[@id='ext-gen123']/li/div/a/span")).click();
		web.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		web.findElement(By.id("cifsenable")).click();
		Actions action = new Actions(web);
		action.sendKeys(" ");
		
		for (int second = 0;; second++) {
			if (second >= 60) System.out.println("timeout");
			try {				
				String str = web.findElement(By.id("//*[@id='serverdesc']")).getClass().getName();
				System.out.println(str);
				if (str.equals("admin")) {
					web.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/div[2]/div/div/div[2]/div/div/table/tbody/tr/td/div")).click(); break;
				} else {
					System.out.println("wait");
				}
			} catch (Exception e) {}
			try{
			Thread.sleep(1000);
			} catch(Exception e) {}
		}
		
	}

}
