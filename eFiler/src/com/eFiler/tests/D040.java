package com.eFiler.tests;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.StringTokenizer;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

public class D040 extends BaseTestLogic {
	
	private static String menu_item = "", file_type = "", successMsg = "";
	int i = 0, j = 0;
	
	public D040(WebDriver webDriver, File fileConf, File fileReport) {
		super(webDriver, fileConf, fileReport);
		// TODO Auto-generated constructor stub
		fConf = fileConf;
		driver = webDriver;
	}

	void startTest() throws InterruptedException  {
		System.out.println("*****************************************************************");
		System.out.println("*                Infomration menu for MP3 files                 *");
		System.out.println("*****************************************************************");
		System.out.println("Test D040 - eFiler -> Infomration menu for MP3 files");
		System.out.println("Right mouse menu shows (Information) option only for mp3 files?\n" +
							"확장자가 mp3인 파일일 경우에만 드롭메뉴에 음악 정보(Information) 가 있는가?\n"+
							"----------------------------------------------------------");
		
		try {
			StringBuilder builder = new StringBuilder();
	        BufferedWriter out = new BufferedWriter(new FileWriter(fReport, true));
	        
	        builder.append("\r\n*****************************************************************\r\n");
	        builder.append("*                Infomration menu for MP3 files                 *\r\n");
	        builder.append("*****************************************************************\r\n");
	        builder.append("Test D040 - eFiler -> Infomration menu for MP3 files\r\n");
	        builder.append("Right mouse menu shows (Information) option only for mp3 files?\r\n" +
							"확장자가 mp3인 파일일 경우에만 드롭메뉴에 음악 정보(Information) 가 있는가?\r\n");
	        builder.append("=================================================================\r\n");
			
		
//		driver.findElement(By.name("icon_efiler")).click();		//go to eFiler from Main page
//		Thread.sleep(5000);
	
		if (isElementPresent(By.xpath("//div[@id='filelist_view']/table/tbody/tr/td[2]/span/a"))){
			//file/folder list
			WebElement list = driver.findElement(By.id("filelist_view"));
			
			Actions action = new Actions(driver);
			
			//get all items
			List<WebElement> allitems = list.findElements(By.className("container"));
			for (WebElement files : allitems) {
				
				String file_or_folder = files.findElement(By.xpath("span")).getAttribute("class");
				file_or_folder = file_or_folder.substring(0, 3);
				
				if (file_or_folder.equals("dir")){
					System.out.println("[Folder] " + files.getText());
					builder.append("[Folder]"+files.getText() + "\r\n");
				}else{
					file_type = files.findElement(By.xpath("span")).getAttribute("class");
					file_type = file_type.substring(file_type.length()-3, file_type.length());
					//System.out.println("File Type: " + file_type);
					if (file_type.equals("mp3"))
						i = i + 1;
					System.out.println("[File]"+files.getText());
					builder.append("[File]"+files.getText() + "\r\n");
				}
				
				action.contextClick(files).perform();
				//right mouse menu list
				WebElement menulist = driver.findElement(By.xpath("//body"));
				
				if (isElementPresent(By.id("dropmenu"))){		//if right menu options exists
					//successMsg = "Can show right mouse menu successfully.";
					List<WebElement> allmenus = menulist.findElements(By.id("dropmenu"));			
					for (WebElement menu : allmenus) {
						StringTokenizer str = new StringTokenizer(menu.getText(),"\n");
						while(str.hasMoreTokens()){
							menu_item = str.nextToken();
							if (file_type.equals("mp3") && menu_item.equals("Information"))
								j = j + 1;
								
							System.out.println("\t" + menu_item);
							builder.append("\t" + menu_item + "\r\n");
						}
						
					}
					System.out.println();
				}else{
					successMsg = "Can't show right mouse menu (FAIL)!";
					break;
				}
			}
		}else
			successMsg = "File/Folder list doesn't exists to test!";
		
		System.out.println("Total number of MP3 files: " + i);
		System.out.println("Total number of Information dropdoun menu: " + j);
		
		if (i == j)
			successMsg = "Right mouse menu shows (Information) option only for mp3 files (Success)";
		else
			successMsg = "Right mouse menu shows (Information) option not only for mp3 files (FAIL)";
		
		
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

