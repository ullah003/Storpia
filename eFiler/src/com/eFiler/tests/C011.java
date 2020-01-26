package com.eFiler.tests;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import org.openqa.selenium.*;


public class C011 extends BaseTestLogic {
	
	private static String search_key = "", successMsg = "", upload_class = "", newFolder_class = "";

	
	public C011(WebDriver webDriver, File fileConf, File fileReport) {
		super(webDriver, fileConf, fileReport);
		// TODO Auto-generated constructor stub
		fConf = fileConf;
		driver = webDriver;
	}

	void startTest() throws InterruptedException  {
		System.out.println("*****************************************************************");
		System.out.println("*                    Disabled buttons after search              *");
		System.out.println("*****************************************************************");
		System.out.println("Test C011 - eFiler -> Disabled buttons after search");
		System.out.println("While showing search list can it disable File upload and Create folder menu?\n" +
							"검색시 검색된 리스트에 대해서 메뉴가 업로드, 파일 생성이 disable 되는가?\n"+
							"----------------------------------------------------------");
		
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(fConf));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
	        for (int i=1; i<=8; i++){
	        	String line = br.readLine();
	        	if (i > 7){
	        		//System.out.println(line);
		        	String[] tokens = line.split("=");
		        	if (tokens[0].equals("search_key"))
		        		search_key = tokens[1];
	        	}
	        }
	    } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
	        try {
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
		
		
		if (isElementPresent(By.id("searchTxt"))){
			driver.findElement(By.id("searchTxt")).clear();
			Thread.sleep(2000);
			driver.findElement(By.id("searchTxt")).sendKeys(search_key);	//enter search key word
			driver.findElement(By.xpath("//div[@id='SearchForm']/span")).click();	//click search button
			Thread.sleep(3000);
			
			if (isElementPresent(By.id("upload_menu")) && isElementPresent(By.id("newfolder_menu"))){

				upload_class = driver.findElement(By.id("upload_menu")).getAttribute("class");
				newFolder_class = driver.findElement(By.id("newfolder_menu")).getAttribute("class");
				
//				System.out.println("AAAAA: " + upload_class + "  BBBB: " + newFolder_class);
				
				if(upload_class.equals("menu-icon menu-icon-upload-disable") 
						&& newFolder_class.equals("menu-icon menu-icon-newfolder-disable")){
					successMsg = "Upload and New Folder menu are disables (success).";
				}else
					successMsg = "Upload and New Folder menu are not disables (FAIL).";
				
			}else
				successMsg = "Upload and New Folder option is not found.";
		}else
			successMsg = "Search option is not found";
		
		System.out.println(successMsg);
		
		try {
			StringBuilder builder = new StringBuilder();
	        BufferedWriter out = new BufferedWriter(new FileWriter(fReport, true));

	        builder.append("\r\n*****************************************************************\r\n");
	        builder.append("*                    Disabled buttons after search              *\r\n");
	        builder.append("*****************************************************************\r\n");
	        builder.append("Test C011 - eFiler -> Disabled buttons after search\r\n");
	        builder.append("While showing search list can it disable File upload and Create folder menu?\r\n" +
							"검색시 검색된 리스트에 대해서 메뉴가 업로드, 파일 생성이 disable 되는가?\r\n");
	        builder.append("=================================================================\r\n");

			builder.append("\r\n" + successMsg + "\r\n");
			out.write(builder.toString());
	
			if(Lisenter != null){
				Lisenter.onReportLisenter(builder.toString());
			}
			
			out.close();
	        } catch (IOException e) {}

	}
}

