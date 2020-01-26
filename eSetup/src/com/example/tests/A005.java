//It shows all software listing with its version successfully?
//각 소프트웨어의 내용이 정상적으로 출력 되는가?

package com.example.tests;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class A005 extends System_Information {
//	private static WebDriver driver;
//	private static String baseUrl;
	private static StringBuffer verificationErrors = new StringBuffer();
	private static String Contents = "", Lighttpd = "", PHP = "", Samba = "", NFS = "", ProFTP = "", AppleTalk = "";
	//private static String Status = "";
	
	//public static void main(String [] args) throws Exception {
	public void A005(){
		System.out.println("*****************************************************************");
		System.out.println("*                             Software                          *");
		System.out.println("*****************************************************************");
		System.out.println("Test A005 - System Status -> Software");
		System.out.println("It shows all software listing with its version successfully? \n" +
				"각 소프트웨어의 내용이 정상적으로 출력 되는가? \n");
		// Before
//		driver = new FirefoxDriver();
//		baseUrl = "http://192.168.1.8:9000/";
//		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		// Test
//		driver.get(baseUrl + "/");
//		driver.findElement(By.id("login_userid")).clear();
//		driver.findElement(By.id("login_userid")).sendKeys("admin");
//		driver.findElement(By.id("login_password")).clear();
//		driver.findElement(By.id("login_password")).sendKeys("admin");
//		driver.findElement(By.cssSelector("input.btn_login")).click();
//		for (int second = 0;; second++) {
//			if (second >= 60) fail("timeout");
//			try { if (isElementPresent(By.name("icon_esetup"))) break; } catch (Exception e) {}
//			Thread.sleep(1000);
//		}
//
//		driver.findElement(By.name("icon_esetup")).click();
		//driver.findElement(By.xpath("//ul[@id='ext-gen78']/div/li/ul/li/div/a/span")).click();
		driver.findElement(By.linkText("System Status")).click();
		//driver.findElement(By.cssSelector("html.ext-strict body#ext-gen11.ext-gecko div#content-panel.x-panel div#ext-gen28.x-panel-bwrap div#ext-gen29.x-panel-body div#systemInfo-panel.x-panel div#ext-gen32.x-panel-bwrap div#ext-gen33.x-panel-body div#ext-comp-1009.x-tab-panel div#ext-gen36.x-tab-panel-header div#ext-gen39.x-tab-strip-wrap ul#ext-gen41.x-tab-strip li#ext-comp-1009__ext-comp-1013 a#ext-gen51.x-tab-right em.x-tab-left span.x-tab-strip-inner span.x-tab-strip-text")).click();		
		driver.findElement(By.linkText("Software")).click();
		
		System.out.println("----------------------------------------");
		System.out.println("Software");
		System.out.println("----------------------------------------");
		System.out.println("Category \t\tContents");
		System.out.println("-------- \t\t--------");

		Lighttpd = driver.findElement(By.xpath("//body/div[2]/div/div/div/div[2]/div/div/div[2]/div/div[2]/div/div/div/div/form/div/div[2]/div/div/div/div[2]/div/div/table/tbody/tr/td[2]/div")).getText();
		System.out.println("Lighttpd \t\t" + Lighttpd);		
		
		PHP = driver.findElement(By.xpath("//body/div[2]/div/div/div/div[2]/div/div/div[2]/div/div[2]/div/div/div/div/form/div/div[2]/div/div/div/div[2]/div/div[2]/table/tbody/tr/td[2]/div")).getText();
		System.out.println("PHP      \t\t" + PHP);
		
		Samba = driver.findElement(By.xpath("//body/div[2]/div/div/div/div[2]/div/div/div[2]/div/div[2]/div/div/div/div/form/div/div[2]/div/div/div/div[2]/div/div[3]/table/tbody/tr/td[2]/div")).getText();
		System.out.println("Samba    \t\t" + Samba);
		
		NFS = driver.findElement(By.xpath("//body/div[2]/div/div/div/div[2]/div/div/div[2]/div/div[2]/div/div/div/div/form/div/div[2]/div/div/div/div[2]/div/div[4]/table/tbody/tr/td[2]/div")).getText();
		System.out.println("NFS      \t\t" + NFS);
		
		ProFTP = driver.findElement(By.xpath("//body/div[2]/div/div/div/div[2]/div/div/div[2]/div/div[2]/div/div/div/div/form/div/div[2]/div/div/div/div[2]/div/div[5]/table/tbody/tr/td[2]/div")).getText();
		System.out.println("ProFTPD  \t\t" + ProFTP);
		
		AppleTalk = driver.findElement(By.xpath("//body/div[2]/div/div/div/div[2]/div/div/div[2]/div/div[2]/div/div/div/div/form/div/div[2]/div/div/div/div[2]/div/div[6]/table/tbody/tr/td[2]/div")).getText();
		System.out.println("AppleTalk\t\t" + AppleTalk);
		
		try {
	        BufferedWriter out = new BufferedWriter(new FileWriter("D:\\System_Information.txt", true));
	        	out.write("*****************************************************************\r\n");
		        out.write("*                              Software                         *\r\n");
		        out.write("*****************************************************************\r\n");
		        out.write("Test A005 - System Status -> Software \r\n");
		        out.write("It shows all software listing with its version successfully? \r\n" +
							"각 소프트웨어의 내용이 정상적으로 출력 되는가?\r\n");
		        out.write("=================================================================\r\n");
                out.write("Category\tContents\r\n" +
                		"Lighttpd \t" + Lighttpd + "\r\n" + 
                		"PHP \t\t" + PHP + "\r\n" + 
                		"Samba \t\t" + Samba + "\r\n" +
                		"NFS \t\t" + NFS + "\r\n" +
                		"ProFTPD \t" + ProFTP + "\r\n" +
                		"AppleTalk \t" + AppleTalk + "\r\n");
	            out.close();
	        } catch (IOException e) {}
		
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
