package com.eFiler.tests;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.openqa.selenium.*;

public class B003 extends BaseTestLogic {
	
	private static String permission = "";
	
	public B003(WebDriver webDriver, File fileConf, File fileReport) {
		super(webDriver, fileConf, fileReport);
		// TODO Auto-generated constructor stub
		fConf = fileConf;
		driver = webDriver;
	}

	void startTest() throws InterruptedException  {
		System.out.println("*****************************************************************");
		System.out.println("*                              Permission                       *");
		System.out.println("*****************************************************************");
		System.out.println("Test B003 - eFiler");
		System.out.println("While logged-in as Admin you have R/W permission?\n" +
							"관리자가 로그인했을 경우 읽기/쓰기 모드로 동작 되는가? \n"+
							"----------------------------------------------------------");
		
//		Thread.sleep(3000);
		
		if (isElementPresent(By.cssSelector("span.icon_detail"))){
			driver.findElement(By.cssSelector("span.icon_detail")).click();			//Click details view
			String str = driver.findElement(By.id("info_permission")).getText(); //Get File/Folder permission
			//System.out.println("String Left: " + str);
			if (str.equals("Read/Write")){
				permission = "Current file/folder permission is: " + str + "(Success)";
			}else{
				permission = "While logged in as admin, permission is not R/W (FAIL)!"; 
			}
		}else{
			permission = "Permission information not available!";
		}
		System.out.println(permission);
		
		try {
			StringBuilder builder = new StringBuilder();
	        BufferedWriter out = new BufferedWriter(new FileWriter(fReport, true));
	        
	        builder.append("\r\n*****************************************************************\r\n");
	        builder.append("*                              Permission                       *\r\n");
	        builder.append("*****************************************************************\r\n");
	        builder.append("Test B003 - eFiler\r\n");
	        builder.append("While logged-in as Admin you have R/W permission?\r\n" +
							"관리자가 로그인했을 경우 읽기/쓰기 모드로 동작 되는가?\r\n");
	        builder.append("=================================================================\r\n");
	        builder.append(permission + "\r\n");
	        out.write(builder.toString());

			if(Lisenter != null){
				Lisenter.onReportLisenter(builder.toString());
			}
			
	        out.close();
	        } catch (IOException e) {}
	}
}


