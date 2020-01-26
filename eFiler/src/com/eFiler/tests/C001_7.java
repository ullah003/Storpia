package com.eFiler.tests;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.openqa.selenium.*;

public class C001_7 extends BaseTestLogic {
	
	private static String efiler_free = "", efiler_used = "", main_free = "", main_used = "", successUsed = "", successFree = "";
	
	public C001_7(WebDriver webDriver, File fileConf, File fileReport) {
		super(webDriver, fileConf, fileReport);
		// TODO Auto-generated constructor stub
		fConf = fileConf;
		driver = webDriver;
	}

	void startTest() throws InterruptedException  {
		System.out.println("*****************************************************************");
		System.out.println("*                    eFiler Disk Space (Used/Free)              *");
		System.out.println("*****************************************************************");
		System.out.println("Test C001_7 - eFiler");
		System.out.println("Used and Free disk space is same as displayed in main page?\n" +
							"우측 상단부에 뜨는 용량이 제대로 표시되는가?\n"+
							"----------------------------------------------------------");
		
		
		
//		driver.findElement(By.xpath("//option[@value='kor']")).click();
		Thread.sleep(5000);
		
		efiler_used = driver.findElement(By.id("usedSize")).getText();
		efiler_free = driver.findElement(By.id("freeSize")).getText();
		
		System.out.println("eFiler Disk Used: " + efiler_used + ",  Free: " + efiler_free);
		
		driver.findElement(By.name("h_icon_home")).click();		//click Home logo located at title bar
		driver.findElement(By.id("usage_btn")).click();		//click usage button
		
		String temp = driver.findElement(By.xpath("//div[@class='usagebar-title']")).getText();
		
    	String[] tokens = temp.split(" ");
    	
    	main_used = tokens[0];
    	main_free = tokens[2];
    	
		System.out.println("Main Page Disk Used: " + main_used + ", Free:" + main_free);
		
		if (efiler_used.equals(main_used))
			successUsed = "Disk usages displayed in eFiler and Main page are same.";
		else
			successUsed = "Disk usages displayed in eFiler and Main page are not same.";
		
		if (efiler_free.equals(main_free))
			successFree = "Disk Free size displayed in eFiler and Main page are same.";
		else
			successFree = "Disk Free size displayed in eFiler and Main page are not same.";
		
		System.out.println(successUsed + "\n" +  successFree);
		
		try {
			StringBuilder builder = new StringBuilder();
	        BufferedWriter out = new BufferedWriter(new FileWriter(fReport, true));
	        
	        builder.append("\r\n*****************************************************************\r\n");
	        builder.append("*                    eFiler Disk Space (Used/Free)              *\r\n");
	        builder.append("*****************************************************************\r\n");
	        builder.append("Test C001_7 - eFiler\r\n");
	        builder.append("Used and Free disk space is same as displayed in main page?\r\n" +
							"우측 상단부에 뜨는 용량이 제대로 표시되는가?\r\n");
	        builder.append("=================================================================\r\n");
	        builder.append("eFiler Disk Used: " + efiler_used + ",  Free: " + efiler_free + "\r\n");
	        builder.append("Main Page Disk Used: " + main_used + ", Free:" + main_free + "\r\n");
	        builder.append(successUsed + "\r\n" + successFree + "\r\n");
	        out.write(builder.toString());

			if(Lisenter != null){
				Lisenter.onReportLisenter(builder.toString());
			}
			
	        out.close();
	        } catch (IOException e) {}

	}
}

