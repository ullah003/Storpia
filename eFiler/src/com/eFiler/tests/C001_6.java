package com.eFiler.tests;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.openqa.selenium.*;

public class C001_6 extends BaseTestLogic {
	
	private static String successMsg = "";
	
	public C001_6(WebDriver webDriver, File fileConf, File fileReport) {
		super(webDriver, fileConf, fileReport);
		// TODO Auto-generated constructor stub
		fConf = fileConf;
		driver = webDriver;
	}

	void startTest() throws InterruptedException  {
		System.out.println("*****************************************************************");
		System.out.println("*                       eFiler Language Change                  *");
		System.out.println("*****************************************************************");
		System.out.println("Test C001_6 - eFiler");
		System.out.println("When other language selected does it auto refreshed and updates display language?\n" +
							"언어를 변경하면 페이지가 새로고침되면서 언어가 변경되는가?\n"+
							"----------------------------------------------------------");
		
		driver.findElement(By.name("h_icon_efiler")).click();		//go to eFiler from eSetup page
		Thread.sleep(2000);
		
		//driver.findElement(By.name("webLanguage")).click();			//Click language drop down
		driver.findElement(By.xpath("//option[@value='kor']")).click();
		Thread.sleep(5000);

		String efiler_title = driver.findElement(By.xpath("//div[@id='list-bar-id']/table/tbody/tr/th[2]/a")).getText();
		//System.out.println("--->" + efiler_title);

		//If eSetup Menu items exists 
		if (efiler_title.equals("이름")){
			successMsg = "Language updated to Korean successfully.";
		}else
			successMsg = "Language update FAIL!";
		
		System.out.println(successMsg);
		
		driver.findElement(By.xpath("//option[@value='eng']")).click();
		Thread.sleep(3000);
		
		try {
			StringBuilder builder = new StringBuilder();
	        BufferedWriter out = new BufferedWriter(new FileWriter(fReport, true));
	        
	        builder.append("\r\n*****************************************************************\r\n");
	        builder.append("*                       eFiler Language Change                  *\r\n");
	        builder.append("*****************************************************************\r\n");
	        builder.append("Test C001_6 - eFiler\r\n");
	        builder.append("When other language selected does it auto refreshed and updates display language?\r\n" +
							"언어를 변경하면 페이지가 새로고침되면서 언어가 변경되는가?\r\n");
	        builder.append("=================================================================\r\n");
	        builder.append(successMsg + "\r\n");
	        out.write(builder.toString());

			if(Lisenter != null){
				Lisenter.onReportLisenter(builder.toString());
			}
			
	        out.close();
	        } catch (IOException e) {}

	}
}

