package com.eFiler.tests;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.openqa.selenium.*;

public class B002 extends BaseTestLogic {
	
	private static String File_list = "";
	
	public B002(WebDriver webDriver, File fileConf, File fileReport) {
		super(webDriver, fileConf, fileReport);
		// TODO Auto-generated constructor stub
		fConf = fileConf;
		driver = webDriver;
	}

	void startTest() throws InterruptedException  {
		System.out.println("*****************************************************************");
		System.out.println("*                           File/Folder List                    *");
		System.out.println("*****************************************************************");
		System.out.println("Test B002 - eFiler");
		System.out.println("While logged-in as Admin, it shows file/folder list view of the first volume?\n" +
							"관리자가 로그인했을 경우 리스트 뷰는 첫번째 볼륨의 내용이 보여지는가?\n"+
							"----------------------------------------------------------");
		
//		Thread.sleep(3000);
		//driver.findElement(By.xpath("//div[@id='dir-tree-view']/ul/li/ul/li/div/span")).click();	//go to 1st folder 
		
		if (isElementPresent(By.id("diskname"))){		//If current listing is for Volume1
			String str = driver.findElement(By.xpath("//div[@id='dir-tree-view']/ul/li/div/span")).getText();	//get left panel 1st volume name 
			String str1 = driver.findElement(By.xpath("//div[@id='diskname']/span")).getText(); //get right panel 1st volume name
			//System.out.println("String Left: " + str + "\nRight: " + str1);
			if (str.equals(str1) && !isElementPresent(By.xpath("//div[@id='diskname']/span[2]")) && isElementPresent(By.id("filelist_view"))){
				File_list = "Showing File/Folder list for first Volume: " + str;
			}else{
				File_list = "Can't show File/Folder list for first volume!"; 
			}
		}else{
			File_list = "Can't show File/Folder List!";
		}
		System.out.println(File_list);
		
		try {
			StringBuilder builder = new StringBuilder();
	        BufferedWriter out = new BufferedWriter(new FileWriter(fReport, true));
	        
	        builder.append("\r\n*****************************************************************\r\n");
	        builder.append("*                           File/Folder List                    *\r\n");
	        builder.append("*****************************************************************\r\n");
	        builder.append("Test B002 - eFiler\r\n");
	        builder.append("While logged-in as Admin, it shows file/folder list view of the first volume?\r\n" +
							"관리자가 로그인했을 경우 리스트 뷰는 첫번째 볼륨의 내용이 보여지는가?\r\n");
	        builder.append("=================================================================\r\n");
	        builder.append(File_list + "\r\n");
	        out.write(builder.toString());

			if(Lisenter != null){
				Lisenter.onReportLisenter(builder.toString());
			}
			
	        out.close();
	        } catch (IOException e) {}
	}
}

