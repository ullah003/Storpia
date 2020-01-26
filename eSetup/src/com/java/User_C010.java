package com.java;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class User_C010 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver web = new FirefoxDriver();
		Actions action = new Actions(web);

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

		// Click Group menu
		web.findElement(By.xpath("//ul[@id='ext-gen121']/li/div/a/span")).click();
		web.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		// admin Search
		WebElement element_search = web.findElement(By.id("ext-comp-1144"));
		element_search.sendKeys("admin");
		web.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		// Search Button Click
//		web.findElement(By.id("ext-gen234")).click();
		web.findElement(By.xpath("//*[@class='x-form-trigger x-form-search-trigger']")).click();
		web.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		for (int second = 0;; second++) {
			if (second >= 60) System.out.println("timeout");
			try {
//				String str = web.findElement(By.xpath("//div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/div[2]/div/div/div[2]/div/div/table/tbody/tr/td")).getText();
				String str = web.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/div[2]/div/div/div[2]/div/div/table/tbody/tr/td/div")).getText();
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
		// admin Modify Button Click
//		web.findElement(By.id("ext-gen215")).click();
		web.findElement(By.xpath("//button[contains(text(), 'Modify')]")).click();
		
		web.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println(1);
	}
}
