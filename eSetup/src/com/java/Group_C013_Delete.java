package com.java;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Group_C013_Delete {
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
		web.findElement(By.xpath("//ul[@id='ext-gen121']/li[2]/div/a/span")).click();
		web.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

		// admin Search
		//		WebElement element_search = web.findElement(By.id("ext-comp-1192"));
		WebElement element_search = web.findElement(By.xpath("//input[@class='x-form-text x-form-field']"));
		element_search.sendKeys("users");
		web.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// Search Button Click
		web.findElement(By.xpath("//*[@class='x-form-trigger x-form-search-trigger']")).click();
		//		web.findElement(By.id("ext-gen334")).click();
		web.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		for (int second = 0;; second++) {
			if (second >= 60) System.out.println("timeout");
			try {
				String str = web.findElement(By.xpath("//div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/div[2]/div/div/div[2]/div/div/table/tbody/tr/td")).getText();
				if (str.equals("users")) {
					web.findElement(By.xpath("//div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/div[2]/div/div/div[2]/div/div/table/tbody/tr/td")).click();
					break;
				}
			} catch (Exception e) {}
			try {
				Thread.sleep(1000);
			}catch(Exception e){}
		}

		// admin Delete Button Click		
//		web.findElement(By.xpath("//button[contains(text(), 'Delete')]")).click();
		web.findElement(By.xpath("//*[@class=' x-btn-text t-icon-delete']")).click();
		web.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// Resualt Text Print
		String end = "[users] The default Group is included in the list.\n\nThe default Group can not be deleted.";
		
		for (int second = 0;; second++) {
			if (second >= 20) System.out.println("timeout");
			try {
				String str = web.findElement(By.xpath("//*[@id='ext-gen104']")).getText();
				if (str.equals(end))
					System.out.println(str); break;
			} catch (Exception e) {}
			try {
				Thread.sleep(1000);
			}catch(Exception e){}
		}		
	}
}