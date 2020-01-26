//For each event log is being saved properly?
//각 이벤트에 대해 로그가 정상적으로 저장 되는가?
//-- Here we will change device name and will check if log message generated
		
package com.example.tests;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import org.openqa.selenium.*;

public class A008 extends System_Information {
	private static String Success = "";
	
	//public static void main(String [] args) throws InterruptedException {
	public void A008() throws InterruptedException{
		System.out.println("*****************************************************************");
		System.out.println("*                               Log                             *");
		System.out.println("*****************************************************************");
		System.out.println("Test A008 - Information -> Log");
		System.out.println("For each event log is being saved properly? \n" +
				"각 이벤트에 대해 로그가 정상적으로 저장 되는가? \n" + 
				"-- Here we will change device name and will check if log message generated \n" +
				"--------------------------------------------------------------------------------");
		
		// get Server Name
		String serverName = driver.findElement(By.xpath("//body/div[2]/div/div/div/div[2]/div/div/div[2]/div/div/div/div/div/div/form/div/div[2]/div/div/div/div[2]/div/div/table/tbody/tr/td[2]/div")).getText();		
		// Network Menu Click
		driver.findElement(By.xpath("//body/div/div[2]/div/div/div/div/ul/div/li[2]/ul/li/div/a/span")).click();
		Thread.sleep(3000);
		
		serverName = "demo01";
		
		// input hostname
		driver.findElement(By.name("hostname")).clear();
		Thread.sleep(1000);
		driver.findElement(By.name("hostname")).sendKeys(serverName);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[contains(text(), 'Apply DDNS settings')]")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//button[contains(text(), 'OK')]")).click();
		
		Thread.sleep(3000);	
		
		//Refresh
		try{
			Thread.sleep(2000);
		} catch(Exception e) {}
		String url = driver.getCurrentUrl();  
		driver.navigate().to(url);  
		try{
			Thread.sleep(2000);
		} catch(Exception e) {} 
		
		// Log Menu Click
		driver.findElement(By.xpath("//body/div/div[2]/div/div/div/div/ul/div/li/ul/li[3]/div/a/span")).click();
		
		Thread.sleep(5000);
		
		// Get log
		String LogMessage = driver.findElement(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/div[2]/div/div/div[2]/div/div/table/tbody/tr/td[5]/div")).getText();

		
		if(LogMessage.equals("[" + serverName + "] Device name registration")) {
			Success = "Log is saved successfully.";
		} else {
			Success = "Can't save log message (FAIL).";
		}
		System.out.println(Success);
		
		try {
	        BufferedWriter out = new BufferedWriter(new FileWriter("D:\\System_Information.txt", true));
	            out.write("\r\n*****************************************************************\r\n");
		        out.write("*                                Log                           *\r\n");
		        out.write("*****************************************************************\r\n");
		        out.write("Test A008 - Information -> Log \r\n");
		        out.write("For each event log is being saved properly? \r\n" +
							"각 이벤트에 대해 로그가 정상적으로 저장 되는가?\r\n" + 
		        			"-- Here we will change device name and will check if log message generated \r\n");
		        out.write("=================================================================\r\n");
                out.write(Success + "\r\n");
	            out.close();
	        } catch (IOException e) {}
	}
}
