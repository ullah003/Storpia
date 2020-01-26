package com.eFiler.tests;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.openqa.selenium.*;

public class C001_4 extends BaseTestLogic {
	
	private static String successMsg = "";
//	private static String G_user_ID = "", G_user_Pass = "", login_success = "";
	
	public C001_4(WebDriver webDriver, File fileConf, File fileReport) {
		super(webDriver, fileConf, fileReport);
		// TODO Auto-generated constructor stub
		fConf = fileConf;
		driver = webDriver;
	}

	void startTest() throws InterruptedException  {
		System.out.println("*****************************************************************");
		System.out.println("*                          eWizard Icon Click                    *");
		System.out.println("*****************************************************************");
		System.out.println("Test C001_4 - eFiler");
		System.out.println("Does it redirects to eWizard when eWizard icon located at Title bar clicked?\n" +
							"타이틀에 있는 eWizard 아이콘을 클릭시 eWizard로 이동하는가?\n"+
							"----------------------------------------------------------");
		
//		driver.findElement(By.name("icon_efiler")).click();		//go to eFiler from Main page
//		Thread.sleep(2000);
		driver.findElement(By.name("h_icon_ewizard")).click();		//click eWizard icon located at title bar
		
		Thread.sleep(2000);
		
		//String efiler_title = driver.findElement(By.xpath("//span[@id='treeName']")).getText();
					 
		//If eWizard title and file tree exists 
		if (isElementPresent(By.id("wizardMain")) && isElementPresent(By.name("Image2")) && isElementPresent(By.name("Image4"))){		
		
			successMsg = "When eWizard icon (Title bar) clicked it can redirect to eWizard successfully.";
		}else
			successMsg = "Can't redirect to eWizard (FAIL)!";
		
		System.out.println(successMsg);
		
		
		try {
			StringBuilder builder = new StringBuilder();
	        BufferedWriter out = new BufferedWriter(new FileWriter(fReport, true));
	        
	        builder.append("\r\n*****************************************************************\r\n");
	        builder.append("*                          eWizard Icon Click                    *\r\n");
	        builder.append("*****************************************************************\r\n");
	        builder.append("Test C001_4 - eFiler\r\n");
	        builder.append("Does it redirects to eWizard when eWizard icon located at Title bar clicked?\r\n" +
							"타이틀에 있는 eWizard 아이콘을 클릭시 eWizard로 이동하는가?\r\n");
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

