//FW Upgrade....현재펌웨어의 정보가 정상 출력 되는가?
//"펌웨어 업그레이드는 정상적으로 동작하는가?
//(업그레이드왼료후 로그인페이지로 이동)"


package com.example.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class B031 {
	private static WebDriver driver;
	private static String baseUrl;
	private static StringBuffer verificationErrors = new StringBuffer();	
	
	public static void main(String [] args) throws Exception {
		// Before
		driver = new FirefoxDriver();
		baseUrl = "http://192.168.1.202:9000/";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		String FW_path = "C:\\Users\\raju\\Desktop\\storpia.0.9.17.bin";
		String New_Ver = "0.9.17";
		// Test
		driver.get(baseUrl);
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

		System.out.println("---------------Test Case-------------------");
		System.out.println("현재펌웨어의 정보가 정상 출력 되는가?");
		System.out.println("Can it prin't current FW information successfully?");
		System.out.println("-------------------------------------------");
		
		driver.findElement(By.name("icon_esetup")).click();
		//driver.findElement(By.name("//body/div/div[2]/div/div/div/div/ul/div/li[2]/ul/li[8]/div/a/span")).click();		
		driver.findElement(By.linkText("Firmware Management")).click();
		Thread.sleep(1000);		
		
		String model = driver.findElement(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/div/div/div/div/div/div[2]/div/div/div/div[2]/div/div/table/tbody/tr/td[2]/div")).getText();		
		String version = driver.findElement(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/div/div/div/div/div/div[2]/div/div/div/div[2]/div/div[2]/table/tbody/tr/td[2]/div")).getText();
		String firmwareDate = driver.findElement(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/div/div/div/div/div/div[2]/div/div/div/div[2]/div/div[3]/table/tbody/tr/td[2]/div")).getText();
		
		System.out.println("----------------------------------------");
		System.out.println("Firmware Management");
		System.out.println("----------------------------------------");
		System.out.println("Category \t Contents");
		System.out.println("========================================");
		System.out.println("model \t\t " + model);
		System.out.println("version \t " + version);
		System.out.println("firmwareDate \t " + firmwareDate);	
		
		System.out.println("---------------Test Case-------------------");
		System.out.println("펌웨어 업그레이드는 정상적으로 동작하는가?\n (업그레이드왼료후 로그인페이지로 이동)");
		System.out.println("FW upgrade done successfully?");
		System.out.println("-------------------------------------------");

		
		driver.findElement(By.id("firmwareFile-file")).sendKeys(FW_path);
		driver.findElement(By.xpath("//button[contains(text(), 'Confirm')]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[contains(text(), 'No')]")).click();
		
//		Thread.sleep(1000*60*10);
//		
//		//Confirmation
//		driver.findElement(By.id("login_userid")).clear();
//		driver.findElement(By.id("login_userid")).sendKeys("admin");
//		driver.findElement(By.id("login_password")).clear();
//		driver.findElement(By.id("login_password")).sendKeys("admin");
//		driver.findElement(By.cssSelector("input.btn_login")).click();
//		
//		driver.findElement(By.name("icon_esetup")).click();
//		//driver.findElement(By.name("//body/div/div[2]/div/div/div/div/ul/div/li[2]/ul/li[8]/div/a/span")).click();		
//		driver.findElement(By.linkText("Firmware Management")).click();
//		Thread.sleep(1000);		
//		
//		model = driver.findElement(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/div/div/div/div/div/div[2]/div/div/div/div[2]/div/div/table/tbody/tr/td[2]/div")).getText();		
//		version = driver.findElement(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/div/div/div/div/div/div[2]/div/div/div/div[2]/div/div[2]/table/tbody/tr/td[2]/div")).getText();
//		firmwareDate = driver.findElement(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/div/div/div/div/div/div[2]/div/div/div/div[2]/div/div[3]/table/tbody/tr/td[2]/div")).getText();
//		
//		System.out.println("----------------------------------------");
//		System.out.println("Firmware Management");
//		System.out.println("----------------------------------------");
//		System.out.println("Category \t Contents");
//		System.out.println("========================================");
//		System.out.println("Upgraded model \t\t " + model);
//		System.out.println("Upgraded version \t " + version);
//		System.out.println("Upgraded firmwareDate \t " + firmwareDate);
//		
//		if (New_Ver.equals(version)){
//			System.out.println("Firmware upgraded successfully");
//		}else
//			System.out.println("Firmware upgraded failed");
		
		// After
		//driver.quit();
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
