package com.eFiler.tests;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.openqa.selenium.*;

public class C001_3 extends BaseTestLogic {
	
	private static String successMsg = "";
//	private static String G_user_ID = "", G_user_Pass = "", login_success = "";
	
	public C001_3(WebDriver webDriver, File fileConf, File fileReport) {
		super(webDriver, fileConf, fileReport);
		// TODO Auto-generated constructor stub
		fConf = fileConf;
		driver = webDriver;
	}

	void startTest() throws InterruptedException  {
		System.out.println("*****************************************************************");
		System.out.println("*                          eFiler Icon Click                    *");
		System.out.println("*****************************************************************");
		System.out.println("Test C001_3 - eFiler");
		System.out.println("Does it redirects to eFiler when eFiler icon located at Title bar clicked?\n" +
							"타이틀에 있는 eFiler 아이콘을 클릭시 eFiler로 이동하는가?\n"+
							"----------------------------------------------------------");
		
		driver.findElement(By.name("icon_efiler")).click();		//go to eFiler from Main page
		Thread.sleep(2000);
		driver.findElement(By.name("h_icon_efiler")).click();		//click eFiler icon located at title bar
		
		Thread.sleep(2000);
		
		String efiler_title = driver.findElement(By.xpath("//span[@id='treeName']")).getText();
					 
		//If eFiler title and file tree exists
		if (efiler_title.equals("eFiler") && isElementPresent(By.id("fileTree"))){		
			successMsg = "When eFiler icon (Title bar) clicked it can redirect to eFiler successfully.";
		}else
			successMsg = "Can't redirect to eFiler (FAIL)!";
		
		System.out.println(successMsg);
		
		
		try {
			StringBuilder builder = new StringBuilder();
	        BufferedWriter out = new BufferedWriter(new FileWriter(fReport, true));
	        
	        builder.append("\r\n*****************************************************************\r\n");
	        builder.append("*                          eFiler Icon Click                    *\r\n");
	        builder.append("*****************************************************************\r\n");
	        builder.append("Test C001_3 - eFiler\r\n");
	        builder.append("Does it redirects to eFiler when eFiler icon located at Title bar clicked?\r\n" +
							"타이틀에 있는 eFiler 아이콘을 클릭시 eFiler로 이동하는가?\r\n");
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

