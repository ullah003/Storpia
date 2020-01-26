package com.java;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class User_C009 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver web = new FirefoxDriver();		
		Actions action = new Actions(web);

		// Open login page
		web.get("http://channeldemo.storpia.com:9000/");

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

		// Click User menu
		web.findElement(By.xpath("//ul[@id='ext-gen121']/li/div/a/span"))
				.click();
		web.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
//		WebElement dbc = web.findElement(
//				By.xpath("//div[@id='ext-gen200']/div/table/tbody/tr/td/div"));
		WebElement dbc = web.findElement(
				By.xpath("//div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/div[2]/div/div/div[2]/div/div/table/tbody/tr/td"));
		web.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		action.doubleClick(dbc).perform();
		web.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				
		WebElement username = web.findElement(By.id("uname"));
		username.clear();
		username.sendKeys("doubleclick");
		String name = username.getText();

		WebElement useremail = web.findElement(By.id("email"));
		username.clear();
		useremail.sendKeys("dbc@storpia.com");
		String mail = useremail.getText();

		WebElement userpass = web.findElement(By.id("password"));		
		userpass.sendKeys("1111");
		String pass = userpass.getText();

		WebElement userpass1 = web.findElement(By.id("password1"));
		userpass1.sendKeys("1111");
		
		System.out.println(name + "/" + mail + "/" + pass);
		
		//Click Confirm
		web.findElement(By.xpath("//button[contains(text(), 'Confirm')]")).click();
		web.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		web.findElement(By.xpath("//button[contains(text(), 'OK')]")).click();
		web.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		System.out.println("Modify Success");
		web.close();
	}
}
