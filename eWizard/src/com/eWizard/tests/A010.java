package com.eWizard.tests;

import java.io.*;

import static org.junit.Assert.*;
import org.openqa.selenium.*;

public class A010 extends BaseTestLogic {

	private static StringBuffer verificationErrors = new StringBuffer();
	private static String status = ""; 
	
	public A010(WebDriver webDriver, File fileConf, File fileReport) {
		super(webDriver, fileConf, fileReport);
		fConf = fileConf;
	}
	
	void startTest() throws InterruptedException  {
		System.out.println("*****************************************************************");
		System.out.println("*                          Volume Type Information              *");
		System.out.println("*****************************************************************");
		System.out.println("Test A010 - Quick Setup -> Disk");
		System.out.println("Volume type information popup came out with proper information when clicked? \n" +
							"볼륨유형 정보는 정상적으로 출력되는가?\n" + 
							"----------------------------------------------------------");

		//Click Disk menu
		driver.findElement(By.name("Image4")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[contains(text(), 'Volume type information')]")).click();
		
		Thread.sleep(1000);
		if (!isElementPresent(By.id("vModeItemSingleTitle")) || !isElementPresent(By.id("vModeItemSingleContent")) 
				|| !isElementPresent(By.id("vModeItemRaid0Title")) || !isElementPresent(By.id("vModeItemRaid0Content"))
				|| !isElementPresent(By.id("vModeItemRaid1Title")) || !isElementPresent(By.id("vModeItemRaid1Content"))
				|| !isElementPresent(By.id("vModeItemJbodTitle")) || !isElementPresent(By.id("vModeItemJbodContent"))){
			status = "Can't display all type volume information!";
		}else
			status = "Can display all type volume information successfully!";
			
		System.out.println(status);
		
		driver.findElement(By.xpath("//body/div[18]/div/div/div/div/div")).click(); //cancel button
		
		driver.findElement(By.xpath("//input[@value='Close']")).click();
		
		try {
			StringBuilder builder = new StringBuilder();
	        BufferedWriter out = new BufferedWriter(new FileWriter(fReport, true));
	        builder.append("\r\n*****************************************************************\r\n");
	        builder.append("*                          Volume Type Information              *\r\n");
	        builder.append("*****************************************************************\r\n");
	        builder.append("Test A010 - Quick Setup -> Disk \r\n");
	        builder.append("Volume type information popup came out with proper information when clicked? \r\n" +
							"볼륨유형 정보는 정상적으로 출력되는가?\r\n");
	        builder.append("=================================================================\r\n");
	        builder.append(status + "\r\n");
	        
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