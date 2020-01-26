package com.eFiler.tests;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.openqa.selenium.*;

public class C001_1 extends BaseTestLogic {
	
	private static String successMsg = "";
//	private static String G_user_ID = "", G_user_Pass = "", login_success = "";
	
	public C001_1(WebDriver webDriver, File fileConf, File fileReport) {
		super(webDriver, fileConf, fileReport);
		// TODO Auto-generated constructor stub
		fConf = fileConf;
		driver = webDriver;
	}

	void startTest() throws InterruptedException  {
		System.out.println("*****************************************************************");
		System.out.println("*                          STORPIA LOGO Click                   *");
		System.out.println("*****************************************************************");
		System.out.println("Test C001_1 - eFiler");
		System.out.println("Does it redirects to Home page when Storpia logo clicked?\n" +
							"로고를 클릭시 홈으로 이동하는가?\n"+
							"----------------------------------------------------------");
		
		driver.findElement(By.id("logoImg")).click();
		Thread.sleep(1000);
		
		//If main page status buttons exists
//		if (isElementPresent(By.id("state_btn")) && isElementPresent(By.id("info_btn")) 
//				&& isElementPresent(By.id("usage_btn")) && isElementPresent(By.id("time_btn"))){		
		if (isElementPresent(By.id("info_btn")) && isElementPresent(By.id("usage_btn")) 
				&& isElementPresent(By.id("time_btn"))){		
			successMsg = "When Storpia logo clicked it can redirect to home page successfully.";
		}else
			successMsg = "Can't redirect to home page (FAIL)!";
		
		System.out.println(successMsg);
		
		
		try {
			StringBuilder builder = new StringBuilder();
	        BufferedWriter out = new BufferedWriter(new FileWriter(fReport, true));
	        
	        builder.append("\r\n*****************************************************************\r\n");
	        builder.append("*                          STORPIA LOGO Click                   *\r\n");
	        builder.append("*****************************************************************\r\n");
	        builder.append("Test C001_1 - eFiler\r\n");
	        builder.append("Does it redirects to Home page when Storpia logo clicked?\r\n" +
							"로고를 클릭시 홈으로 이동하는가?\r\n");
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

