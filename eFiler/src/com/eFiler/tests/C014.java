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

public class C014 extends BaseTestLogic {
	
	private static String file_name = "", filename_title = "", successMsg = "";

	
	public C014(WebDriver webDriver, File fileConf, File fileReport) {
		super(webDriver, fileConf, fileReport);
		// TODO Auto-generated constructor stub
		fConf = fileConf;
		driver = webDriver;
	}

	void startTest() throws InterruptedException  {
		System.out.println("*****************************************************************");
		System.out.println("*                         Search blank list  (not used, done with C013)                   *");
		System.out.println("*****************************************************************");
		System.out.println("Test C014 - eFiler -> Search blank list");
		System.out.println("If you enter file/folder name which is not exists can it show blank list properly?\n" +
							"폴더 안에서 존재하지 않는 검색어를 입력하고 검색 시 정상 동작 하는가? \n"+
							"----------------------------------------------------------");
		
		if (isElementPresent(By.xpath("//div[@id='filelist_view']/table/tbody/tr/td[2]/span/span"))){
			//get the folder name of first searched folder
			file_name = driver.findElement(By.xpath("//div[@id='filelist_view']/table/tbody/tr/td[2]/span/span")).getText();
			System.out.println("First folder from search list: " + file_name);
			//redirect to first searched folder
			driver.findElement(By.xpath("//div[@id='filelist_view']/table/tbody/tr/td[2]/span/span")).click();
			Thread.sleep(2000);
			//get the folder name from Title bar after redirection
			filename_title = driver.findElement(By.xpath("//div[@id='filelist_body']/div/div[2]/span[2]")).getText();
			System.out.println("Folder name after redirection: " + filename_title);
			
			if (file_name.equals(filename_title))
				successMsg = "Can redirect inside searched folder successfully.";
			else
				successMsg = "Can't redirect inside searched folder (FAIL).";
		}else
			successMsg = "No searched folder found";
		
		
		System.out.println(successMsg);
		
		try {
			StringBuilder builder = new StringBuilder();
	        BufferedWriter out = new BufferedWriter(new FileWriter(fReport, true));
	        
	        builder.append("\r\n*****************************************************************\r\n");
	        builder.append("*                    Redirect to Search folder              *\r\n");
	        builder.append("*****************************************************************\r\n");
	        builder.append("Test C012 - eFiler -> Redirect to Search folder\r\n");
	        builder.append("If you click searched folder can it redirect inside that folder?\r\n" +
							"검색된 폴더 클릭시 해당 폴더로 이동되는가?\r\n");
	        builder.append("=================================================================\r\n");
	        builder.append(file_name + "\r\n" + filename_title);
			builder.append("\r\n" + successMsg + "\r\n");
			out.write(builder.toString());
	
			if(Lisenter != null){
				Lisenter.onReportLisenter(builder.toString());
			}
			
			out.close();
	        } catch (IOException e) {}

	}
}

