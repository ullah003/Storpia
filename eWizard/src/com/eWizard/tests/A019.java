package com.eWizard.tests;

import java.io.*;

import static org.junit.Assert.*;
import org.openqa.selenium.*;

public class A019 extends BaseTestLogic {
	private static StringBuffer verificationErrors = new StringBuffer();
	private static String Static_Success = "", DHCP_Success = "";

	
	public A019(WebDriver webDriver, File fileConf, File fileReport) {
		super(webDriver, fileConf, fileReport);
		fConf = fileConf;
	}
	
	void startTest() throws InterruptedException  {
		System.out.println("*****************************************************************");
		System.out.println("*                       Network Setting                         *");
		System.out.println("*****************************************************************");
		System.out.println("Test A019 - Quick Setup -> Network -> Wired Network");
		System.out.println("Is it possible to set wired network configuration?\n" +
							"유선네트워크 설정은 정상적으로 되는가?\n" + 
							"----------------------------------------------------------");
		
		//Click Network menu
		driver.findElement(By.name("Image9")).click();	//go to eWizard menu
		Thread.sleep(1000);
		driver.findElement(By.xpath("//body/div[6]/div[2]/div/div/div/form/div/div/div/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[3]/td[2]")).click();	//go to Wired Network menu
		Thread.sleep(1000);
		for (int i =1; i<=2; i++){
			if(driver.findElement(By.id("wdhcp")).isSelected()) {
				// Click 'STATIC' radio button
				driver.findElement(By.id("wstatic")).click();	//click STATIC radio button
				Thread.sleep(3000);
			
				//driver.findElement(By.xpath("/html/body/div[6]/div[2]/div/div/div/form/div[2]/div/div/table/tbody/tr/td/table/tbody/tr/td[2]/table/tbody/tr[2]/td/input")).click();
				driver.findElement(By.xpath("//input[@value='OK']")).click();		//click OK button
				//driver.findElement(By.xpath("//button[contains(text(), 'Cancel')]")).click();
				Thread.sleep(20000);
				
				//Click Network menu
				driver.findElement(By.name("Image9")).click();	//go to Network menu
				Thread.sleep(1000);
				driver.findElement(By.xpath("//body/div[6]/div[2]/div/div/div/form/div/div/div/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[3]/td[2]")).click();	//go to Wired Network menu

				Thread.sleep(2000);
				if(driver.findElement(By.id("wstatic")).isSelected()) {
					Static_Success = "Static setting is completed successfully.";
				} else {
					Static_Success = "Static setting is failed.";
				}
				System.out.println(Static_Success);
			}else if(driver.findElement(By.id("wstatic")).isSelected()) {
				// Click 'DHCP' radio button
				driver.findElement(By.id("wdhcp")).click();	//click STATIC radio button
				driver.findElement(By.xpath("//input[@value='OK']")).click();		//click OK button
				Thread.sleep(30000);
						
				//Click Network menu
				driver.findElement(By.name("Image9")).click();	//go to Network menu
				Thread.sleep(1000);
				driver.findElement(By.xpath("//body/div[6]/div[2]/div/div/div/form/div/div/div/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[3]/td[2]")).click();	//go to Wired Network menu
				
				Thread.sleep(2000);
				if(driver.findElement(By.id("wdhcp")).isSelected()) {
					DHCP_Success = "DHCP setting is completed successfully.";
				} else {
					DHCP_Success = "DHCP setting is failed.";
				}
				System.out.println(DHCP_Success);
			}
		}
		
		try {
			StringBuilder builder = new StringBuilder();
	        BufferedWriter out = new BufferedWriter(new FileWriter(fReport, true));
	        
	        builder.append("\r\n*****************************************************************\r\n");
	        builder.append("*                       Network Setting                         *\r\n");
	        builder.append("*****************************************************************\r\n");
	        builder.append("Test A019 - Quick Setup -> Network -> Wired Network\r\n");
	        builder.append("Is it possible to set wired network configuration?\r\n" +
						"유선네트워크 설정은 정상적으로 되는가?\r\n");
	        builder.append("=================================================================\r\n");
	        builder.append(Static_Success + "\r\n" + DHCP_Success + "\r\n");
	        out.write(builder.toString());

			if(Lisenter != null){
				Lisenter.onReportLisenter(builder.toString());
			}
	        
	        out.close();
	        } catch (IOException e) {}
		 	
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}
}

