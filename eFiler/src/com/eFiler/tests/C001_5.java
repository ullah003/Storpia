package com.eFiler.tests;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.openqa.selenium.*;

public class C001_5 extends BaseTestLogic {
	
	private static String successMsg = "";
	
	public C001_5(WebDriver webDriver, File fileConf, File fileReport) {
		super(webDriver, fileConf, fileReport);
		// TODO Auto-generated constructor stub
		fConf = fileConf;
		driver = webDriver;
	}

	void startTest() throws InterruptedException  {
		System.out.println("*****************************************************************");
		System.out.println("*                          eSetup Icon Click                    *");
		System.out.println("*****************************************************************");
		System.out.println("Test C001_5 - eFiler");
		System.out.println("Does it redirects to eSetup when eSetup icon located at Title bar clicked?\n" +
							"타이틀에 있는 eSetup 아이콘을 클릭시 eSetup으로 이동하는가?\n"+
							"----------------------------------------------------------");
		
		driver.findElement(By.name("h_icon_efiler")).click();		//go to eFiler from eWizard page
		Thread.sleep(2000);
		driver.findElement(By.name("h_icon_esetup")).click();		//click eSetup icon located at title bar
		Thread.sleep(2000);
		
		//If eSetup Menu items exists 
		if (isElementPresent(By.linkText("CIFS")) && isElementPresent(By.linkText("AppleTalk"))){
			successMsg = "When eSetup icon (Title bar) clicked it can redirect to eSetup successfully.";
		}else
			successMsg = "Can't redirect to eSetup (FAIL)!";
		
		System.out.println(successMsg);
		
		try {
			StringBuilder builder = new StringBuilder();
	        BufferedWriter out = new BufferedWriter(new FileWriter(fReport, true));
	        
	        builder.append("\r\n*****************************************************************\r\n");
	        builder.append("*                          eSetup Icon Click                    *\r\n");
	        builder.append("*****************************************************************\r\n");
	        builder.append("Test C001_5 - eFiler\r\n");
	        builder.append("Does it redirects to eSetup when eSetup icon located at Title bar clicked?\r\n" +
							"타이틀에 있는 eSetup 아이콘을 클릭시 eSetup으로 이동하는가?\r\n");
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

