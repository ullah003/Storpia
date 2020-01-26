package com.eFiler.tests;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.StringTokenizer;
//import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

public class C002 extends BaseTestLogic {
	
	private static String menu_item = "", successMsg = "";

	
	public C002(WebDriver webDriver, File fileConf, File fileReport) {
		super(webDriver, fileConf, fileReport);
		// TODO Auto-generated constructor stub
		fConf = fileConf;
		driver = webDriver;
	}

	void startTest() throws InterruptedException  {
		System.out.println("*****************************************************************");
		System.out.println("*                          Right Mouse Menu                     *");
		System.out.println("*****************************************************************");
		System.out.println("Test C002 - eFiler -> Right Mouse Click");
		System.out.println("When right mouse clicked can it show appropriate options menu?\n" +
							"마우스 오른쪽 버튼 클릭시 해당 메뉴가 보여지는가?\n"+
							"----------------------------------------------------------");
		
		try {
			StringBuilder builder = new StringBuilder();
	        BufferedWriter out = new BufferedWriter(new FileWriter(fReport, true));
	        
	        builder.append("\r\n*****************************************************************\r\n");
	        builder.append("*                          Right Mouse Menu                     *\r\n");
	        builder.append("*****************************************************************\r\n");
	        builder.append("Test C002 - eFiler -> Right Mouse Click\r\n");
	        builder.append("When right mouse clicked can it show appropriate options menu?\r\n" +
							"마우스 오른쪽 버튼 클릭시 해당 메뉴가 보여지는가?\r\n");
	        builder.append("=================================================================\r\n");
			
		
		driver.findElement(By.name("icon_efiler")).click();		//go to eFiler from Main page
		Thread.sleep(5000);
	
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
					System.out.println("[Folder]"+files.getText());
					builder.append("[Folder]"+files.getText() + "\r\n");
				}else{
					System.out.println("[File]"+files.getText());
					builder.append("[File]"+files.getText() + "\r\n");
				}
				
				action.contextClick(files).perform();
				//right mouse menu list
				WebElement menulist = driver.findElement(By.xpath("//body"));
				
				if (isElementPresent(By.id("dropmenu"))){		//if right menu options exists
					successMsg = "Can show right mouse menu successfully.";
					List<WebElement> allmenus = menulist.findElements(By.id("dropmenu"));			
					for (WebElement menu : allmenus) {
						StringTokenizer str = new StringTokenizer(menu.getText(),"\n");
						while(str.hasMoreTokens()){
							menu_item = str.nextToken();
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

