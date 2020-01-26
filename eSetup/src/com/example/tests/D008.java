package com.example.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class D008 {

	/**
	 * @param test case no.D008
	 * Activate setting and Redirection works properly?
	 * 설정적용이 정상적으로 동작하는가?
	 * 
	 * After activating HTTPS redirection can it redirect you to HTTPS connection automatically?
	 * HTTP연결에서 HTTPS 리다이렉션을 설정하면 자동으로 https로 연결 되는가?
	 * 
	 * If you remove HTTPS setting can it redirect you to HTTP connection automatically?
	 * HTTPS연결에서 HTTP 리다이렉션 설정을 제거하면 자동으로 http로 연결 되는가? 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver web = new FirefoxDriver();

		// Open login page
		web.get("http://192.168.1.84:9000");

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

		// Click HTTP/HTTPS menu
//		web.findElement(By.xpath("//ul[@id='ext-gen123']/li[6]/div/a/span")).click();
		web.findElement(By.xpath("//span[contains(text(), 'HTTP/HTTPS')]")).click();
		web.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

		try{
			Thread.sleep(3000);
		} catch(Exception e) {}
		// Click CheckBox
		web.findElement(By.xpath("//*[@name='httpsenable']")).click();
		web.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		try{
			Thread.sleep(1500);
		} catch(Exception e) {}

		// Click CheckBox
		web.findElement(By.xpath("//*[@name='httpsredirect']")).click();
		web.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		try{
			Thread.sleep(1000);
		} catch(Exception e) {}

		// Get Url
		String url = web.getCurrentUrl();
		System.out.println("--------------------HTTP--------------------");
		System.out.println("HTTP Before URL : " + url);

		// Click Confirm
		web.findElement(By.xpath("//button[contains(text(), 'Confirm')]")).click();
		web.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		try{
			Thread.sleep(8000);
		} catch(Exception e) {}

		url = web.getCurrentUrl();

		System.out.println("HTTP After URL : " + url);

		web.close();

		web.get("http://192.168.1.84:9000");

		url = web.getCurrentUrl();

		System.out.println("HTTP New Access URL : " + url);
		System.out.println();

		// Click HTTP/HTTPS menu
//		web.findElement(By.xpath("//ul[@id='ext-gen123']/li[6]/div/a/span")).click();
		web.findElement(By.xpath("//span[contains(text(), 'HTTP/HTTPS')]")).click();
		web.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

		try{
			Thread.sleep(3000);
		} catch(Exception e) {}
		// Click CheckBox
		web.findElement(By.xpath("//*[@name='httpsenable']")).click();
		web.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		try{
			Thread.sleep(1000);
		} catch(Exception e) {}

		// Get Url
		url = web.getCurrentUrl();
		System.out.println("--------------------HTTPS--------------------");
		System.out.println("HTTPS Before URL : " + url);

		// Click Confirm
		web.findElement(By.xpath("//button[contains(text(), 'Confirm')]")).click();
		web.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		try{
			Thread.sleep(8000);
		} catch(Exception e) {}

		url = web.getCurrentUrl();

		System.out.println("HTTPS Afteer URL : " + url);

		web.close();

		web.get("http://192.168.1.84:9000");

		url = web.getCurrentUrl();

		System.out.println("HTTPS New Access URL : " + url);
	}	
}
