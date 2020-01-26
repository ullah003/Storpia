package com.eFiler.tests;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.openqa.selenium.*;

public class C001 extends BaseTestLogic {
	
	private static String successMsg = "";
//	private static String G_user_ID = "", G_user_Pass = "", login_success = "";
	
	public C001(WebDriver webDriver, File fileConf, File fileReport) {
		super(webDriver, fileConf, fileReport);
		// TODO Auto-generated constructor stub
		fConf = fileConf;
		driver = webDriver;
	}

	void startTest() throws InterruptedException  {
		System.out.println("*****************************************************************");
		System.out.println("*                             STORPIA LOGO                      *");
		System.out.println("*****************************************************************");
		System.out.println("Test C001 - eFiler");
		System.out.println("Does it shows same storpia logo as like in main page?\n" +
							"장비의 기본 타이틀을 그대로 유지하여 가져오는가?\n"+
							"----------------------------------------------------------");
		
		//Admin_Login();
		//driver.findElement(By.name("icon_efiler")).click();
		//Thread.sleep(2000);
		
		
//		String str = driver.findElement(By.id("logoImg")).getAttribute("src");
//		System.out.println(str);
		
		if (isElementPresent(By.id("logoImg"))){		//If Storpia logo exists in main page
			WebElement element1 = driver.findElement(By.id("logoImg"));
			String home_logo = ((JavascriptExecutor)driver).executeScript("return arguments[0].attributes['src'].value;", element1).toString();
			//System.out.println("Image source: " + home_logo);
			
			driver.findElement(By.name("icon_efiler")).click();
			Thread.sleep(1000);
			
			if (isElementPresent(By.id("logoImg"))){		//If Storpia logo exists in eFiler page
				WebElement element2 = driver.findElement(By.id("logoImg"));
				String eFiler_logo = ((JavascriptExecutor)driver).executeScript("return arguments[0].attributes['src'].value;", element2).toString();
				//System.out.println("Image source: " + eFiler_logo);
				
				if (home_logo.equals(eFiler_logo))
					successMsg = "Can show default logo for Home and eFiler menu successfully.";
				else
					successMsg = "Can't show default logo for Home and eFiler menu(FAIL).";
				
			}else
				successMsg = "No logo available for eFiler section";
		}else
			successMsg = "No logo available for Main page";
		
		System.out.println(successMsg);
		
		
		try {
			StringBuilder builder = new StringBuilder();
	        BufferedWriter out = new BufferedWriter(new FileWriter(fReport, true));
	        
	        builder.append("\r\n*****************************************************************\r\n");
	        builder.append("*                             STORPIA LOGO                      *\r\n");
	        builder.append("*****************************************************************\r\n");
	        builder.append("Test C001 - eFiler\r\n");
	        builder.append("Does it shows same storpia logo as like in main page?\r\n" +
							"장비의 기본 타이틀을 그대로 유지하여 가져오는가?\r\n");
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

