package com.java;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByClassName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class User_C003_1 {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver web = new FirefoxDriver();

		// Open login page
		web.get("http://gluesys01.storpia.com:9000/index.php");

		String name = "admin";
		// Enter ID and Password
		WebElement element_id = web.findElement(By.id("login_userid"));
		element_id.sendKeys(name);

		WebElement element_pass = web.findElement(By.id("login_password"));
		element_pass.sendKeys(name);

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
		
		// Search Box input
		WebElement element_search = web.findElement(By.id("ext-comp-1144"));
		element_search.sendKeys("admin");
		web.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		
		// Search Button Click
		web.findElement(By.id("ext-gen234")).click();
//		web.findElement(By.xpath("//*[@id='ext-gen234']")).click();		
		web.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		// 검색한 단어와 검색된 user의 이름을 비교
		for (int second = 0;; second++) {
			if (second >= 60) System.out.println("timeout");
			try {
//				String str = web.findElement(By.xpath("//div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/div[2]/div/div/div[2]/div/div/table/tbody/tr/td")).getText();
				String str = web.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/div[2]/div/div/div[2]/div/div/table/tbody/tr/td/div")).getText();
				if (str.equals(name)) {
					System.out.println("검색어와 일치"); break;
				} else {
					System.out.println("검색어와 일치하지 않음"); //break;
				}
			} catch (Exception e) {}
			Thread.sleep(1000);
		}
		web.close();
	}
}
