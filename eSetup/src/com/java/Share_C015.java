package com.java;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Share_C015 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver web = new FirefoxDriver();

		// Open login page
		//web.get("http://192.168.0.5:9000/index.php");
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

		// Click Share menu
		web.findElement(By.xpath("//ul[@id='ext-gen121']/li[3]/div/a/span")).click();
		web.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		
		web.findElement(By.xpath("//button[contains(text(), 'Add')]")).click();
		
		//Enter Share informations (Name, desc)
		String shr = "shred";
		WebElement sharename = web.findElement(By.id("cname"));
		sharename.sendKeys(shr);
		
		WebElement sharedesc = web.findElement(By.id("cdesc"));
		sharedesc.sendKeys("Share_folder");
		
		web.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Click next--> next
		//d2.findElement(By.xpath("//table[@id='ext-comp-1143']/tbody/tr[2]/td[2]")).click();
		//d2.findElement(By.xpath("//table[@id='ext-comp-1143']/tbody/tr[2]/td[2]")).click();
		web.findElement(By.xpath("//button[contains(text(), 'Next')]")).click();
		web.findElement(By.xpath("//button[contains(text(), 'Next')]")).click();
		web.findElement(By.xpath("//button[contains(text(), 'Next')]")).click();
		
		//Click Confirm
		web.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
		web.findElement(By.xpath("//button[contains(text(), 'Confirm')]")).click();
		System.out.println("Share created Successfully.");
		//web.findElement(By.xpath("//button[contains(text(), 'OK')]")).click();
		/*
		WebElement element_search = web.findElement(By.xpath("//input[@class='x-form-text x-form-field']"));
		element_search.sendKeys(shr);
		web.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		// Search Button Click
		web.findElement(By.xpath("//*[@class='x-form-trigger x-form-search-trigger']")).click();
//		web.findElement(By.id("ext-gen334")).click();
		web.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		for (int second = 0;; second++) {
			if (second >= 20) System.out.println("timeout");
			try {
				String str = web.findElement(By.xpath("//div/div2/div/div/div2/div/div/div/div/div/div/div2/div/div/div2/div/div/table/tbody/tr/td[4]")).getText();
				if (str.equals("volume1/" +shr)) {
					System.out.println("Success"); break;
				} else {
					System.out.println("Loading"); //break;
				}

			} catch (Exception e) {}
			try {
			Thread.sleep(1000);
			}catch(Exception e){}
		}
		*/
	}	
}
