package com.eFiler.tests;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.openqa.selenium.*;

public class C001_2 extends BaseTestLogic {
	
	private static String successMsg = "";
//	private static String G_user_ID = "", G_user_Pass = "", login_success = "";
	
	public C001_2(WebDriver webDriver, File fileConf, File fileReport) {
		super(webDriver, fileConf, fileReport);
		// TODO Auto-generated constructor stub
		fConf = fileConf;
		driver = webDriver;
	}

	void startTest() throws InterruptedException  {
		System.out.println("*****************************************************************");
		System.out.println("*                           Home Icon Click                     *");
		System.out.println("*****************************************************************");
		System.out.println("Test C001_2 - eFiler");
		System.out.println("Does it redirects to Home page when Home icon located at Title bar clicked?\n" +
							"타이틀에 있는 홈 아이콘을 클릭시 홈으로 이동하는가?\n"+
							"----------------------------------------------------------");
		
		driver.findElement(By.name("icon_efiler")).click();		//go to eFiler from Main page
		Thread.sleep(2000);
		driver.findElement(By.name("h_icon_home")).click();		//click Home logo located at title bar
		
		Thread.sleep(1000);
		//If main page status buttons exists
		if (isElementPresent(By.id("info_btn")) && isElementPresent(By.id("usage_btn")) 
				&& isElementPresent(By.id("time_btn"))){		
				
			successMsg = "When Home icon (Title bar) clicked it can redirect to home page successfully.";
		}else
			successMsg = "Can't redirect to home page (FAIL)!";
		
		System.out.println(successMsg);
		
		
		try {
			StringBuilder builder = new StringBuilder();
	        BufferedWriter out = new BufferedWriter(new FileWriter(fReport, true));
	        
	        builder.append("\r\n*****************************************************************\r\n");
	        builder.append("*                           Home Icon Click                     *\r\n");
	        builder.append("*****************************************************************\r\n");
	        builder.append("Test C001_2 - eFiler\r\n");
	        builder.append("Does it redirects to Home page when Home icon located at Title bar clicked?\r\n" +
							"타이틀에 있는 홈 아이콘을 클릭시 홈으로 이동하는가?\r\n");
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

