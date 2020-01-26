package com.java;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class User_C008 {
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver web = new FirefoxDriver();		
		Actions action = new Actions(web);

		// Open login page
		// web.get("http://192.168.0.5:9000/index.php");
		web.get("http://gluesys01.relay5.storpia.com:54758/index.php");

		// Enter ID and Password
		WebElement element_id = web.findElement(By.id("login_userid"));
		element_id.sendKeys("admin");

		WebElement element_pass = web.findElement(By.id("login_password"));
		element_pass.sendKeys("admin");

		// Click login button
		web.findElement(By.cssSelector("input.btn_login")).click();

		// Print login success message to console
		System.out.println("Successfully logged in.");

		// Wait 10 sec for main page to be loaded
		web.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// Click eSetup icon to go to eSetup page
		web.findElement(By.name("icon_esetup")).click();

		// Click Group menu
		web.findElement(By.xpath("//ul[@id='ext-gen121']/li/div/a/span"))
		.click();
		web.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		web.findElement(
				By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/div[2]/div/div/div[2]/div/div/table/tbody/tr/td/div"))
				.click();
		web.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// WebElement e = web.findElement(By.id("//*[@id='ext-gen192']"));
		// action.keyDown(Keys.SHIFT).perform();
		action.keyDown(web.findElement(
				By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/div[2]/div/div/div[2]/div/div/table/tbody/tr/td/div"))
				, Keys.SHIFT).perform();

		web.findElement(
				By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/div[2]/div/div/div[2]/div/div[6]/table/tbody/tr/td/div"))
				.click();
		web.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// action.keyUp(e, Keys.SHIFT).perform();

		web.findElement(By.xpath("//button[contains(text(), 'Delete')]"))
		.click();
		web.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		web.findElement(By.xpath("//button[contains(text(), 'Yes')]")).click();
		web.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		web.findElement(By.xpath("//button[contains(text(), 'Yes')]")).click();
		web.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		String str = "";
		for (int second = 0;; second++) {
			if (second >= 60)
				System.out.println("timeout");
			try {
				str = web.findElement(By.xpath("//*[@id='ext-gen104']"))
						.getText();
				System.out.println(str);
				if (!str.equals("")) break;				
			} catch (Exception e1) {
			}
			Thread.sleep(1000);
		}
		web.findElement(By.xpath("//button[contains(text(), 'OK')]")).click();
		web.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		web.close();
	}
}
