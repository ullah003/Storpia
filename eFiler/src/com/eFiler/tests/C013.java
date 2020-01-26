package com.eFiler.tests;

//import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import org.openqa.selenium.*;
//import org.openqa.selenium.interactions.Actions;

public class C013 extends BaseTestLogic {
	
	private static String file_name = "", folder_details = "", filename_title = "", successMsg = "", successMsg1 = "";

	
	public C013(WebDriver webDriver, File fileConf, File fileReport) {
		super(webDriver, fileConf, fileReport);
		// TODO Auto-generated constructor stub
		fConf = fileConf;
		driver = webDriver;
	}

	void startTest() throws InterruptedException  {
		System.out.println("*****************************************************************");
		System.out.println("*              Redirect & details info of searched item         *");
		System.out.println("*****************************************************************");
		System.out.println("Test C012 & C013 - eFiler -> Redirect & details info of searched item");
		System.out.println("Is it possible to redirect and to see details information for file from search list?\n" +
							"검색된 파일을 클릭하여 자세히 보기가 정상 동작 하는가?\n"+
							"----------------------------------------------------------");
		
		if (isElementPresent(By.xpath("//div[@id='filelist_view']/table/tbody/tr/td[2]/span/span"))){
			//System.out.println("BBBBBBBBBBBBBBBBBB");
			//get the folder name of first searched folder
			file_name = driver.findElement(By.xpath("//div[@id='filelist_view']/table/tbody/tr/td[2]/span/span")).getText();
			//file_name = "First folder from search list: " + file_name;
			System.out.println("First folder from search list: " + file_name);
			//redirect to first searched folder
			driver.findElement(By.xpath("//div[@id='filelist_view']/table/tbody/tr/td[2]/span/span")).click();
			Thread.sleep(2000);
			//get the folder name from Title bar after redirection
			filename_title = driver.findElement(By.xpath("//div[@id='filelist_body']/div/div[2]/span[2]")).getText();
			//filename_title = "Folder name after redirection: " + filename_title;
			System.out.println("Folder name after redirection: " + filename_title);
			
			driver.findElement(By.id("link-add-tab")).click();		//click details tab
			
			if (isElementPresent(By.id("info_name"))){
				successMsg = "It can show details information at the bottom.";
				folder_details = driver.findElement(By.id("info_name")).getText();
				System.out.println("Details: " + folder_details);
			}else
				successMsg = "It can't show details information at the bottom (FAIL).";
			
			
			if (file_name.equals(filename_title))
				successMsg1 = "Can redirect inside searched folder successfully.";
			else
				successMsg1 = "Can't redirect inside searched folder (FAIL).";
		}else{
			//System.out.println("CCCCCCCCCCCCCCCCC");
			successMsg = "No searched folder found";
		}
		
		System.out.println(successMsg + "\n" + successMsg1);
		
		try {
			StringBuilder builder = new StringBuilder();
	        BufferedWriter out = new BufferedWriter(new FileWriter(fReport, true));
	        
	        builder.append("\r\n*****************************************************************\r\n");
	        builder.append("*              Redirect & details info of searched item         *\r\n");
	        builder.append("*****************************************************************\r\n");
	        builder.append("Test C012 & C013 - eFiler -> Redirect & details info of searched item\r\n");
	        builder.append("Is it possible to redirect and to see details information for file from search list?\r\n" +
							"검색된 파일을 클릭하여 자세히 보기가 정상 동작 하는가?\r\n");
	        builder.append("=================================================================\r\n");
	        builder.append(file_name + "\r\n" + filename_title);
			builder.append("\r\n" + successMsg + "\r\n" + successMsg1 + "\r\n");
			out.write(builder.toString());
	
			if(Lisenter != null){
				Lisenter.onReportLisenter(builder.toString());
			}
			
			out.close();
	        } catch (IOException e) {}

	}
}

