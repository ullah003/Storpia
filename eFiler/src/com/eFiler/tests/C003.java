package com.eFiler.tests;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
//import java.util.List;
//import java.util.StringTokenizer;
//import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
//import org.openqa.selenium.interactions.Actions;

public class C003 extends BaseTestLogic {
	
	private static String menu_item = "", successMsg = "", folder_name = "", folder_details = "";

	
	public C003(WebDriver webDriver, File fileConf, File fileReport) {
		super(webDriver, fileConf, fileReport);
		// TODO Auto-generated constructor stub
		fConf = fileConf;
		driver = webDriver;
	}

	void startTest() throws InterruptedException  {
		System.out.println("*****************************************************************");
		System.out.println("*                        File/Folder Details                    *");
		System.out.println("*****************************************************************");
		System.out.println("Test C003 - eFiler -> Details Information");
		System.out.println("When you click any file/folder can it show details information at the bottom?\n" +
							"파일,폴더 클릭시 하단 상세 정보가 나오는가?\n"+
							"----------------------------------------------------------");
		
		try {
			StringBuilder builder = new StringBuilder();
	        BufferedWriter out = new BufferedWriter(new FileWriter(fReport, true));
	        builder.append("\r\n*****************************************************************\r\n");
	        builder.append("*                        File/Folder Details                    *\r\n");
	        builder.append("*****************************************************************\r\n");
	        builder.append("Test C003 - eFiler -> Details Information\r\n");
	        builder.append("When you click any file/folder can it show details information at the bottom?\r\n" +
							"파일,폴더 클릭시 하단 상세 정보가 나오는가?\r\n");
	        builder.append("=================================================================\r\n");
			
		
//		driver.findElement(By.name("icon_efiler")).click();		//go to eFiler from Main page
//		Thread.sleep(5000);
	        
        driver.findElement(By.id("link-add-tab")).click();		//click details tab
		Thread.sleep(2000);

		if (isElementPresent(By.xpath("//ul[@id='fileTree']/li/ul/li[1]/div/span"))){
			driver.findElement(By.xpath("//ul[@id='fileTree']/li/ul/li[1]/div/span")).click();	//click folder
			Thread.sleep(3000);
			if (isElementPresent(By.id("info_name"))){
				successMsg = "It can show details information at the bottom.";
				folder_details = driver.findElement(By.id("info_name")).getText();
				System.out.println("Details: " + folder_details);
			}else
				successMsg = "It can't show details information at the bottom.";
		}else
			successMsg = "Folder not found to test.";
		
/*
		if (isElementPresent(By.xpath("//div[@id='filelist_view']/table/tbody/tr/td[2]/span/a"))){
			//file/folder list
			WebElement list = driver.findElement(By.id("dir-tree-view"));
			
			//get all items
			List<WebElement> allitems = list.findElements(By.className("fileTree"));
			
			for (WebElement files : allitems) {
				
				folder_name = files.getText();
				System.out.println("Folder Name: " + folder_name);
				builder.append(folder_name + "\r\n");
				
				StringTokenizer str = new StringTokenizer(files.getText(),"\n");
				while(str.hasMoreTokens()){
					
					menu_item = str.nextToken();
					System.out.println("\t" + menu_item);
					builder.append("\t" + menu_item + "\r\n");
				
					//details_info
					folder_details = driver.findElement(By.id("info_name")).getText();
					System.out.println("Details: " + folder_details);
				}
				
			}
		}else
			successMsg = "File/Folder list doesn't exists to test!";
*/		
		System.out.println(successMsg);
		builder.append("\r\n" + successMsg + "\r\n");
		out.write(builder.toString());

		if(Lisenter != null){
			Lisenter.onReportLisenter(builder.toString());
		}
		
		out.close();
        } catch (IOException e) {}

	}
}

