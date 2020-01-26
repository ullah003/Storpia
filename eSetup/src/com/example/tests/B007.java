//Can it update DDNS name successfully? 
//DDNS 설정이 정상적으로 저장 되는가? 

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

public class B007 extends System_Setting {
	private static String ServerName = "", ServerName1 = "", Success = "";
	
	//public static void main(String []args) throws Exception {
	public void B007() throws InterruptedException{
		System.out.println("*****************************************************************");
		System.out.println("*                           DDNS Update                         *");
		System.out.println("*****************************************************************");
		System.out.println("Test B007 - System -> Network -> DDNS");
		System.out.println("Can it update DDNS name successfully? \n" +
				"DDNS 설정이 정상적으로 저장 되는가?  \n" + 
				"----------------------------------------------------------\n");

		driver.findElement(By.linkText("System Status")).click();
		Thread.sleep(1000);
		// System Status menu		
		// get server name before changing server name
		ServerName = driver.findElement(By.xpath("//body/div[2]/div/div/div/div[2]/div/div/div[2]/div/div/div/div/div/div/form/div/div[2]/div/div/div/div[2]/div/div/table/tbody/tr/td[2]/div")).getText();
		System.out.println("Server name before change : " + ServerName);
		
		String DDNS_Name = "";
		if(ServerName.equals("demo01"))
			DDNS_Name = "demo02";
		else
			DDNS_Name = "demo01";		
		
		// Click Network menu
		driver.findElement(By.xpath("//body/div/div[2]/div/div/div/div/ul/div/li[2]/ul/li/div/a/span")).click();
		driver.findElement(By.id("hostname")).clear();
		driver.findElement(By.id("hostname")).sendKeys(DDNS_Name);
		driver.findElement(By.xpath("//button[contains(text(), 'Apply DDNS settings')]")).click();
		
		Thread.sleep(2000);
		
		// Click OK
		driver.findElement(By.xpath("//button[contains(text(), 'OK')]")).click();
		
		Thread.sleep(2000);
		
		// Click System Status menu
		driver.findElement(By.xpath("//body/div/div[2]/div/div/div/div/ul/div/li/ul/li/div/a/span")).click();		
		
		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout");
			try { if (isElementPresent(By.xpath("//body/div[2]/div/div/div/div[2]/div/div/div[2]/div/div/div/div/div/div/form/div/div[2]/div/div/div/div[2]/div/div/table/tbody/tr/td[2]/div"))) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}
		
		Thread.sleep(2000);
		ServerName1 = driver.findElement(By.xpath("//body/div[2]/div/div/div/div[2]/div/div/div[2]/div/div/div/div/div/div/form/div/div[2]/div/div/div/div[2]/div/div/table/tbody/tr/td[2]/div")).getText();		
		System.out.println("Server name after change : " + ServerName1);
		
		if(ServerName.equals(ServerName1)) { 
			Success = "Changing DDNS name is failed.";
		} else {
			Success = "DDNS name is changed successfully.";
		}
		System.out.println(Success);
		
		try {
	        BufferedWriter out = new BufferedWriter(new FileWriter("D:\\System_Setting.txt", true));
	            out.write("\r\n*****************************************************************\r\n");
		        out.write("*                               DHCP/Static                         *\r\n");
		        out.write("*****************************************************************\r\n");
		        out.write("Test B007 - System -> Network -> DHCP/Static \r\n");
		        out.write("Is Wired network setup UI changes according to DHCP/Static selection? \r\n" +
							"수동주소(static), 자동주소(dhcp) 설정에 따른 UI는 정상동작 하는가?\r\n");
		        out.write("=================================================================\r\n");
                out.write("Server name before change : " + ServerName + "\r\n" + "Server name after change : " +  ServerName1 + "\r\n");
                out.write(Success);
	            out.close();
	    } catch (IOException e) {}
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
