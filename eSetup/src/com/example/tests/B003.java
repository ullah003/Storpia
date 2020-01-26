//수동주소(static), 자동주소(dhcp) 설정에 따른 UI는 정상동작 하는가? 
		
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

public class B003 extends System_Setting {
	private static String addressAssign = "", Static_Success = "", DHCP_Success = "";
	
	//public static void main(String []args) throws Exception {
	public void B003() throws InterruptedException{
		System.out.println("*****************************************************************");
		System.out.println("*                             DHCP/Static                            *");
		System.out.println("*****************************************************************");
		System.out.println("Test B003 - System -> Network -> DHCP/Static");
		System.out.println("Is Wired network setup UI changes according to DHCP/Static selection? \n" +
				"수동주소(static), 자동주소(dhcp) 설정에 따른 UI는 정상동작 하는가?  +\n" + 
				"----------------------------------------------------------\n");
		
		// Click Network menu
		driver.findElement(By.xpath("//body/div/div[2]/div/div/div/div/ul/div/li[2]/ul/li/div/a/span")).click();
		// Network Device select
		driver.findElement(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/div/div/div[2]/div[2]/div/div/div[2]/div/div/table/tbody/tr/td/div")).click();
		// Click Modify Button
		driver.findElement(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/div/div/div[2]/div/div/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[2]/td[2]/em/button")).click();
		
		Thread.sleep(3000);
		// Click 'STATIC' radio button
		driver.findElement(By.xpath("//label[@for='wstatic']")).click();
		
		driver.findElement(By.xpath("//button[contains(text(), 'Confirm')]")).click();
		Thread.sleep(20000);
		
		addressAssign = driver.findElement(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/div/div/div[2]/div[2]/div/div/div[2]/div/div/table/tbody/tr/td[3]/div")).getText();
		if(addressAssign.equals("static")) {
			Static_Success = "Static setting is completed successfully.";
		} else {
			Static_Success = "Static setting is failed.";
		}
		System.out.println(Static_Success);
		
		// Network Device select
		driver.findElement(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/div/div/div[2]/div[2]/div/div/div[2]/div/div/table/tbody/tr/td/div")).click();
		// Click Modify Button
		driver.findElement(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/div/div/div[2]/div/div/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[2]/td[2]/em/button")).click();

		Thread.sleep(5000);
		// Click 'DHCP' radio button
		driver.findElement(By.xpath("//label[@for='wdhcp']")).click();

		driver.findElement(By.xpath("//button[contains(text(), 'Confirm')]")).click();
		Thread.sleep(50000);

		addressAssign = driver.findElement(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/div/div/div[2]/div[2]/div/div/div[2]/div/div/table/tbody/tr/td[3]/div")).getText();
		if(addressAssign.equals("dhcp")) {
			DHCP_Success = "DHCP setting is completed successfully.";
		} else {
			DHCP_Success = "DHCP setting is failed.";
		}
		System.out.println(DHCP_Success);
		
		try {
	        BufferedWriter out = new BufferedWriter(new FileWriter("D:\\System_Setting.txt", true));
	            out.write("\r\n*****************************************************************\r\n");
		        out.write("*                               DHCP/Static                         *\r\n");
		        out.write("*****************************************************************\r\n");
		        out.write("Test B003 - System -> Network -> DHCP/Static \r\n");
		        out.write("Is Wired network setup UI changes according to DHCP/Static selection? \r\n" +
							"수동주소(static), 자동주소(dhcp) 설정에 따른 UI는 정상동작 하는가?\r\n");
		        out.write("=================================================================\r\n");
                out.write(Static_Success + "\r\n" + DHCP_Success);
	            out.close();
	    } catch (IOException e) {}
		
	}
}
