//볼륨타입 정보는 정상적으로 출력 되는가?

package com.example.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class B013 {
	private static WebDriver driver;
	private static String baseUrl;
	private static StringBuffer verificationErrors = new StringBuffer();
	
	public static void main(String []args) throws Exception {
		// Before
		driver = new FirefoxDriver();
		baseUrl = "http://192.168.1.9:9000/";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		// Test
		driver.get(baseUrl + "/index.php");
		driver.findElement(By.id("login_userid")).clear();
		driver.findElement(By.id("login_userid")).sendKeys("admin");
		driver.findElement(By.id("login_password")).clear();
		driver.findElement(By.id("login_password")).sendKeys("admin");
		driver.findElement(By.cssSelector("input.btn_login")).click();
		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout");
			try { if (isElementPresent(By.name("icon_esetup"))) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}

		driver.findElement(By.name("icon_esetup")).click();
		driver.findElement(By.xpath("//ul[@id='ext-gen119']/li[2]/div/a/span")).click();		
		
	
		String VolumeType = driver.findElement(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/div/div/div/form/div/div/div/div/div[2]/div[2]/div/div/div[2]/div/div/table/tbody/tr/td[2]/div")).getText();
		System.out.println("Volume Type : " + VolumeType);
		
		// After
		driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}

	private static boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}
}
