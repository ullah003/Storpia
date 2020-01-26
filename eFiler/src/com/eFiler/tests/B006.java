package com.eFiler.tests;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import org.openqa.selenium.*;

public class B006 extends BaseTestLogic {
	
	private static String permission = "";
	
	public B006(WebDriver webDriver, File fileConf, File fileReport) {
		super(webDriver, fileConf, fileReport);
		// TODO Auto-generated constructor stub
		fConf = fileConf;
		driver = webDriver;
	}

	void startTest() throws InterruptedException  {
		System.out.println("*****************************************************************");
		System.out.println("*                             Disabled Menu(Not Done)                     *");
		System.out.println("*****************************************************************");
		System.out.println("Test B006 - eFiler");
		System.out.println("While logged-in as general user the unsupported menu are disabled?\n" +
							"(ex: Upload, Move, Create folder, Rename, delete menu are disabled?)\n" + 
							"일반사용자의 권한에 맞도록 공유를 클릭시 메뉴가 표시 되는가? \n"+
							"(읽기 : 업로드, 이동, 새폴더생성, 이름변경, 삭제 메뉴가 disable 된다.)" + 
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
	        builder.append("*                             Disabled Menu                     *\r\n");
	        builder.append("*****************************************************************\r\n");
	        builder.append("Test B006 - eFiler\r\n");
	        builder.append("While logged-in as general user the unsupported menu are disabled?\r\n" +
		        			"(ex: Upload, Move, Create folder, Rename, delete menu are disabled?)\r\n" +
							"일반사용자의 권한에 맞도록 공유를 클릭시 메뉴가 표시 되는가?\r\n" +
		        			"(읽기 : 업로드, 이동, 새폴더생성, 이름변경, 삭제 메뉴가 disable 된다.)\r\n");
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


