package com.example.tests;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

public class E006 extends Network_Service{

	public void E006(){
		System.out.println("*****************************************************************");
		System.out.println("*                           Auto Router                         *");
		System.out.println("*****************************************************************");
		System.out.println("Test E006 - Auto Router");
		System.out.println("I set possible to select specific service and apply port forwarding for them? \n" +
				"�뱀젙�쒕퉬�ㅼ뿉 ��빐 UPNP �ы듃 �ъ썙�⑹쓣 �ㅼ젙 �좎닔 �덈뒗媛� \n");

		//Click Auto Router menu
		driver.findElement(By.xpath("//span[contains(text(), 'Auto router')]")).click();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

		try{
			Thread.sleep(2000);
		} catch(Exception e) {}

		String firstStatus = "";

		// Click UPnP Router List
		driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/div/div[4]/div/div/div/div[2]/div[2]/div/div/div[2]/div/div[4]/table/tbody/tr/td/div/div")).click();
		if (driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/div/div[4]/div/div/div/div[2]/div[2]/div/div/div[2]/div/div[4]/table/tbody/tr/td/div/div")).isSelected())
			firstStatus = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/div/div[4]/div/div/div/div[2]/div[2]/div/div/div[2]/div/div[4]/table/tbody/tr/td[4]/div")).getText();
		else
			firstStatus = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/div/div[4]/div/div/div/div[2]/div[2]/div/div/div[2]/div/div[4]/table/tbody/tr/td[4]/div/img")).getAttribute("src");

		// Print Status
		System.out.println("Before SSH Status : " + firstStatus);

		// Click Apply Router
		driver.findElement(By.xpath("//button[contains(text(), 'Apply to router')]")).click();

		try{
			Thread.sleep(2000); 
		} catch(Exception e) {}

		driver.findElement(By.xpath("//button[contains(text(), 'OK')]")).click();

		String secondStatus = "";
		// After Click Apply Router Status
		if (driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/div/div[4]/div/div/div/div[2]/div[2]/div/div/div[2]/div/div[4]/table/tbody/tr/td/div/div")).isSelected())
			secondStatus = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/div/div[4]/div/div/div/div[2]/div[2]/div/div/div[2]/div/div[4]/table/tbody/tr/td[4]/div/img")).getAttribute("src");
		else
			secondStatus = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/div/div[4]/div/div/div/div[2]/div[2]/div/div/div[2]/div/div[4]/table/tbody/tr/td[4]/div")).getText();

		// Print Status
		System.out.println("After SSH Status : " + secondStatus);

		// Click UPnP Router List
		driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/div/div[4]/div/div/div/div[2]/div[2]/div/div/div[2]/div/div[4]/table/tbody/tr/td/div/div")).click();

		// Click Apply Router
		driver.findElement(By.xpath("//button[contains(text(), 'Apply to router')]")).click();

		try{
			Thread.sleep(2000); 
		} catch(Exception e) {}

		driver.findElement(By.xpath("//button[contains(text(), 'OK')]")).click();

		String returnStatus = "";
		// Return Status
		if (driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/div/div[4]/div/div/div/div[2]/div[2]/div/div/div[2]/div/div[4]/table/tbody/tr/td/div/div")).isSelected())
			returnStatus = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/div/div[4]/div/div/div/div[2]/div[2]/div/div/div[2]/div/div[4]/table/tbody/tr/td[4]/div")).getText();
		else
			returnStatus = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/div/div[4]/div/div/div/div[2]/div[2]/div/div/div[2]/div/div[4]/table/tbody/tr/td[4]/div/img")).getAttribute("src");

		// Print Status
		System.out.println("Return SSH Status : " + returnStatus);
		
		try {
	        BufferedWriter out = new BufferedWriter(new FileWriter("Nerwork_Service.txt", true));
	        	out.write("*****************************************************************\r\n");
	        	out.write("*                           Auto Router                         *\r\n");
		        out.write("*****************************************************************\r\n");
		        out.write("Test E006 - Auto Router \r\n");
		        out.write("I set possible to select specific service and apply port forwarding for them? \r\n" +
						"�뱀젙�쒕퉬�ㅼ뿉 ��빐 UPNP �ы듃 �ъ썙�⑹쓣 �ㅼ젙 �좎닔 �덈뒗媛� \r\n");
		        out.write("=================================================================\r\n");
		        out.write("--------------------------First Status-------------------\r\n");
		        out.write("SSH Status : " + firstStatus + "\r\n");
		        out.write("--------------------------Second Status-------------------\r\n");
		        out.write("SSH Status : " + secondStatus + "\r\n");
		        out.write("--------------------------Return Status-------------------\r\n");
		        out.write("SSH Status : " + returnStatus + "\r\n");
	            out.close();
	        } catch (IOException e) {}
	}
}
