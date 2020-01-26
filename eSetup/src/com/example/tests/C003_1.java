package com.example.tests;

import static org.junit.Assert.fail;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class C003_1 extends UserAndShare {
	private static StringBuffer verificationErrors = new StringBuffer();
	boolean result = false;
	/**
	 * @param test case no.C003_1
	 * Search result is accurate acording to your search?
	 * 검색된 내용은 검색어와 일치 하는가? 
	 */
	public void C003_1() {

		// Click User menu		
		driver.findElement(By.linkText("User")).click();
		
		// Search Box input
//		WebElement element_search = web.findElement(By.name("ext-comp-1144"));
		WebElement element_search = driver.findElement(By.xpath("//input[@class='x-form-text x-form-field']"));
		element_search.sendKeys("user10");
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		
		// Search Button Click
		driver.findElement(By.xpath("//*[@class='x-form-trigger x-form-search-trigger']")).click();
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		// Compared Search word & User name
//		for (int second = 0;; second++) {
//			if (second >= 60) System.out.println("timeout");
//			try {
//				String str = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/div[2]/div/div/div[2]/div/div/table/tbody/tr/td/div")).getText();
//				if (str.equals("admin")) {
//					System.out.println("Search Successfully");
//					result = true;
//					break;
//				} else {
//					System.out.println("Searching...");
//					result = false;
//				}
//				Thread.sleep(1000);
//			} catch (Exception e) {}			
//		}
		
		// Write File
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter("C:\\UserAndShare.txt", true));
			out.write("*****************************************************************\r\n");
			out.write("*                          Search User                          *\r\n");
			out.write("*****************************************************************\r\n");
			out.write("Test C003-1 - User\r\n");
			out.write("Search result is accurate acording to your search?\r\n" + 
					"검색된 내용은 검색어와 일치 하는가?  \r\n");
			out.write("=================================================================\r\n");		        
			if(result == true)
				out.write("Test C003-1 ----------------------------> PASS \r\n");
			else
				out.write("Test C003-1 ----------------------------> FAIL \r\n");

			out.write("\r\n");
			//out.flush();	
			out.close();
		} catch (IOException e) {}

		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}
}
