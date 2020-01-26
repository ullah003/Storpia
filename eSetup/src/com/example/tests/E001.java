package com.example.tests;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class E001 extends Network_Service{
	private static String successMsg = "";
	
	public void E001(){
		System.out.println("*****************************************************************");
		System.out.println("*                     my.Storpia Device name                    *");
		System.out.println("*****************************************************************");
		System.out.println("Test E001 - my.Storpia Device name");
		System.out.println("Can it show domain name of DDNS setting properly? \n" +
				"설정한 DDNS의 도메인이 정상적으로 출력 되는가?\n" +
				"---------------------------------------------------------------");
		
/*		
		//Click Network Menu
		driver.findElement(By.xpath("//span[contains(text(), 'Network')]")).click();

		// DDNS Setup	
		WebElement ddns = driver.findElement(By.id("hostname"));
		ddns.sendKeys("gluesys02");

		// Click Save...
		driver.findElement(By.xpath("//button[contains(text(), 'Apply DDNS settings')]")).click();

		//Refresh
		try{
			Thread.sleep(2000);
		} catch(Exception e) {}
		String url = driver.getCurrentUrl();		
		driver.navigate().to(url);
		try{
			Thread.sleep(2000);
		} catch(Exception e) {}
*/
		// Click System Status Menu
		driver.findElement(By.xpath("//span[contains(text(), 'System Status')]")).click();
		String serverName = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div/div/div[2]/div/div/div/div/div/div/form/div/div[2]/div/div/div/div[2]/div/div/table/tbody/tr/td[2]/div")).getText();
		System.out.println("System Status");
		System.out.println("------------------------");
		System.out.println("Server name : " + serverName);
		System.out.println("------------------------");
		System.out.println();

		//Refresh
		try{
			Thread.sleep(2000);
		} catch(Exception e) {}
		String url = driver.getCurrentUrl();		
		driver.navigate().to(url);
		try{
			Thread.sleep(2000);
		} catch(Exception e) {}

		// Click My.storpia device name menu
		driver.findElement(By.xpath("//span[contains(text(), 'My.Storpia device name')]")).click();

		try{
			Thread.sleep(1500);
		} catch(Exception e) {}
		// Get DDNS name
		String ddnsName = driver.findElement(By.id("ddnsHostname")).getText();
		ddnsName = ddnsName.substring(7, 7+serverName.length());
		System.out.println("My.storpia device name");
		System.out.println("------------------------");
		System.out.println("DDNS name : " + ddnsName);
		System.out.println("------------------------");

		/*
		// Click Network Menu
		driver.findElement(By.xpath("//span[contains(text(), 'Network')]")).click();

		// DDNS Setup
		ddns = driver.findElement(By.id("hostname"));
		ddns.sendKeys("gluesys01");

		// Click Save...
		driver.findElement(By.xpath("//button[contains(text(), 'Apply DDNS settings')]")).click();
*/
		
		if (serverName.equals(ddnsName))
			successMsg = "Can show DDNS name successfully.";
		else
			successMsg = "Show DDNS name FAIL.";
		System.out.println(successMsg);
		
		
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter("D:\\Nerwork_Service.txt", true));
			out.write("*****************************************************************\r\n");
			out.write("*                      my.Storpia Device name                   *\r\n");
			out.write("*****************************************************************\r\n");
			out.write("Test E001 - my.Storpia Device name \r\n");
			out.write("Can it show domain name of DDNS setting properly? \r\n" +
					"설정한 DDNS의 도메인이 정상적으로 출력 되는가?\r\n");
			out.write("=================================================================\r\n");
			out.write("-----------------------------System Status-----------------------\r\n");
			out.write("Server name : " + serverName + "\r\n");
			out.write("------------------------My.storpia device name-------------------\r\n");
			out.write("DDNS name : " + ddnsName + "\r\n" + successMsg + "\r\n");
			out.close();
		} catch (IOException e) {}
	}
}
