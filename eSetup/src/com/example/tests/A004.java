//It shows the status of each services successfully?
//각 서비스의 상태정보가 정상적으로 출력 되는가?
//서비스 상태정보가 현재 장비의 상태와 동일 한가?

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

public class A004 extends System_Information {
//	private static WebDriver driver;
//	private static String baseUrl;
	private static StringBuffer verificationErrors = new StringBuffer();
	private static String cifsActive = "", cifs_extActive = "", nfsActive = "", ftpActive = "", atalkActive = "", sshActive = "", telnetActive = "";
	private static String cifsStatus = "", cifs_extStatus = "", nfsStatus = "", ftpStatus = "", atalkStatus = "", sshStatus = "", telnetStatus = "";
	
	//public static void main(String [] args) {
	public void A004(){
		System.out.println("*****************************************************************");
		System.out.println("*                          Service Status                       *");
		System.out.println("*****************************************************************");
		System.out.println("Test A004 - System Status -> Service Status");
		System.out.println("It shows the status of each services successfully? \n" +
				"각 서비스의 상태정보가 정상적으로 출력 되는가? \n" + 
				"서비스 상태정보가 현재 장비의 상태와 동일 한가? \n");
		// Before
//		driver = new FirefoxDriver();
//		baseUrl = "http://192.168.1.9:9000/";
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
		//driver.findElement(By.cssSelector("html.ext-strict body#ext-gen11.ext-gecko div#content-panel.x-panel div#ext-gen28.x-panel-bwrap div#ext-gen29.x-panel-body div#systemInfo-panel.x-panel div#ext-gen32.x-panel-bwrap div#ext-gen33.x-panel-body div#ext-comp-1009.x-tab-panel div#ext-gen36.x-tab-panel-header div#ext-gen39.x-tab-strip-wrap ul#ext-gen41.x-tab-strip li#ext-comp-1009__ext-comp-1012 a#ext-gen49.x-tab-right em.x-tab-left span.x-tab-strip-inner span.x-tab-strip-text")).click();
		driver.findElement(By.linkText("Service Status")).click();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("----------------------------------------");
		System.out.println("Service Status");
		System.out.println("----------------------------------------");
		cifsActive = driver.findElement(By.xpath("//body/div[2]/div/div/div/div[2]/div/div/div[2]/div/div[2]/div/div/div/div/form/div/div[2]/div/div/div/div[2]/div/div/table/tbody/tr/td[2]/div")).getText();
		cifsStatus = driver.findElement(By.xpath("//body/div[2]/div/div/div/div[2]/div/div/div[2]/div/div[2]/div/div/div/div/form/div/div[2]/div/div/div/div[2]/div/div/table/tbody/tr/td[3]/div")).getText();		
		System.out.println("cifs \t\t" + cifsActive + "\t" + cifsStatus);

		cifs_extActive = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div/div/div[2]/div/div[2]/div/div/div/div/form/div/div[2]/div/div/div/div[2]/div/div[2]/table/tbody/tr/td[2]/div")).getText();
		cifs_extStatus = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div/div/div[2]/div/div[2]/div/div/div/div/form/div/div[2]/div/div/div/div[2]/div/div[2]/table/tbody/tr/td[3]/div")).getText();
		System.out.println("cifs extension \t" + cifs_extActive + "\t" + cifs_extStatus);
		
		nfsActive = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div/div/div[2]/div/div[2]/div/div/div/div/form/div/div[2]/div/div/div/div[2]/div/div[3]/table/tbody/tr/td[2]/div")).getText();
		nfsStatus = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div/div/div[2]/div/div[2]/div/div/div/div/form/div/div[2]/div/div/div/div[2]/div/div[3]/table/tbody/tr/td[3]/div")).getText();
		System.out.println("nfs \t\t" + nfsActive + "\t" + nfsStatus);
		
		ftpActive = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div/div/div[2]/div/div[2]/div/div/div/div/form/div/div[2]/div/div/div/div[2]/div/div[4]/table/tbody/tr/td[2]/div")).getText();
		ftpStatus = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div/div/div[2]/div/div[2]/div/div/div/div/form/div/div[2]/div/div/div/div[2]/div/div[4]/table/tbody/tr/td[3]/div")).getText();
		System.out.println("ftp \t\t" + ftpActive + "\t" + ftpStatus);
		
		atalkActive = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div/div/div[2]/div/div[2]/div/div/div/div/form/div/div[2]/div/div/div/div[2]/div/div[5]/table/tbody/tr/td[2]/div")).getText();
		atalkStatus = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div/div/div[2]/div/div[2]/div/div/div/div/form/div/div[2]/div/div/div/div[2]/div/div[5]/table/tbody/tr/td[3]/div")).getText();
		System.out.println("atalk \t\t" + atalkActive + "\t" + atalkStatus);
		
		sshActive = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div/div/div[2]/div/div[2]/div/div/div/div/form/div/div[2]/div/div/div/div[2]/div/div[6]/table/tbody/tr/td[2]/div")).getText();
		sshStatus = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div/div/div[2]/div/div[2]/div/div/div/div/form/div/div[2]/div/div/div/div[2]/div/div[6]/table/tbody/tr/td[3]/div")).getText();
		System.out.println("ssh \t\t" + sshActive + "\t" + sshStatus);
		
		telnetActive = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div/div/div[2]/div/div[2]/div/div/div/div/form/div/div[2]/div/div/div/div[2]/div/div[7]/table/tbody/tr/td[2]/div")).getText();
		telnetStatus = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div/div/div[2]/div/div[2]/div/div/div/div/form/div/div[2]/div/div/div/div[2]/div/div[7]/table/tbody/tr/td[3]/div")).getText();
		System.out.println("telnet \t\t" + telnetActive + "\t" + telnetStatus);
		
		try {
	        BufferedWriter out = new BufferedWriter(new FileWriter("D:\\System_Information.txt", true));
	            out.write("*****************************************************************\r\n");
		        out.write("*                           Service Status                      *\r\n");
		        out.write("*****************************************************************\r\n");
		        out.write("Test A004 - System Status -> Service Status \r\n");
		        out.write("It shows the status of each services successfully? \r\n" +
							"각 서비스의 상태정보가 정상적으로 출력 되는가?\r\n" + 
							"서비스 상태정보가 현재 장비의 상태와 동일 한가?\r\n");
		        out.write("=================================================================\r\n");
                out.write("ServiceName\tActive  Status \r\n" +
                		"cifs \t\t" + cifsActive + "\t" + cifsStatus + "\r\n" + 
                		"cifs extension \t" + cifs_extActive + "\t" + cifs_extStatus + "\r\n" + 
                		"nfs \t\t" + nfsActive + "\t" + nfsStatus + "\r\n" + 
                		"ftp \t\t" + ftpActive + "\t" + ftpStatus + "\r\n" +
                		"atalk \t\t" + atalkActive + "\t" + atalkStatus + "\r\n" +
                		"ssh \t\t" + sshActive + "\t" + sshStatus + "\r\n" +
                		"telnet \t\t" + telnetActive + "\t" + telnetStatus + "\r\n");
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
