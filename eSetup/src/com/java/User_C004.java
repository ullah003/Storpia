package com.java;

import java.util.StringTokenizer;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class User_C004 {
	
	public static void main(String[] args) throws InterruptedException {
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

		// Click Group menu
		web.findElement(By.xpath("//ul[@id='ext-gen121']/li/div/a/span")).click();
		web.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		String cnt = "";
		String last = "";
		for (int second = 0;; second++) {
			if (second >= 60) System.out.println("timeout");
			try {
				last = web.findElement(By.xpath("//div[@id='ext-comp-1149']")).getText();
				StringTokenizer st = new StringTokenizer(last, " ");
				st.nextToken();
				last = st.nextToken();
				cnt = web.findElement(By.xpath("//input[@id='ext-comp-1148']")).getText();
				System.out.println(cnt + "//////" + last);
				if (cnt.equals("1")) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}
		
		web.findElement(By.xpath("//button[@class=' x-btn-text x-tbar-page-next']")).click();
		web.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		for (int second = 0;; second++) {
			if (second >= 60) System.out.println("timeout");
			try {
				cnt = web.findElement(By.xpath("//input[@class='x-form-text x-form-field x-form-num-field x-tbar-page-number']")).getText();
				if (cnt.equals("2")) {
					System.out.println("next success");
					break;} else {
						System.out.println("next fail"); break;
					}
				} catch (Exception e) {}
			Thread.sleep(1000);
		}
		web.findElement(By.xpath("//button[@class=' x-btn-text x-tbar-page-prev']")).click();
		web.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		for (int second = 0;; second++) {
			if (second >= 60) System.out.println("timeout");
			try {
				cnt = web.findElement(By.xpath("//input[@class='x-form-text x-form-field x-form-num-field x-tbar-page-number']")).getText();
				if (cnt.equals("1")) {
					System.out.println("prev success");
					break;} else {
						System.out.println("prev fail"); break;
					}
				} catch (Exception e) {}
			Thread.sleep(1000);
		}
		
		web.findElement(By.xpath("//button[@class=' x-btn-text x-tbar-page-last']")).click();
		web.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		for (int second = 0;; second++) {
			if (second >= 60) System.out.println("timeout");
			try {
				cnt = web.findElement(By.xpath("//input[@class='x-form-text x-form-field x-form-num-field x-tbar-page-number']")).getText();
				if (cnt.equals(last)) {
					System.out.println("last success");
					break;} else {
						System.out.println("last fail"); break;
					}
				} catch (Exception e) {}
			Thread.sleep(1000);
		}
		
		web.findElement(By.xpath("//button[@class=' x-btn-text x-tbar-page-first']")).click();
		web.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		for (int second = 0;; second++) {
			if (second >= 60) System.out.println("timeout");
			try {
				cnt = web.findElement(By.xpath("//input[@class='x-form-text x-form-field x-form-num-field x-tbar-page-number']")).getText();
				if (cnt.equals("1")) {
					System.out.println("first success");
					break;} else {
						System.out.println("first fail"); break;
					}
				} catch (Exception e) {}
			Thread.sleep(1000);
		}
		web.close();
	}
}
