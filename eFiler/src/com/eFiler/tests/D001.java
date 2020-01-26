package com.eFiler.tests;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import org.openqa.selenium.*;

public class D001 extends BaseTestLogic {
	
	private static String new_folder = "", folder_name = "", successMsg = "";

	
	public D001(WebDriver webDriver, File fileConf, File fileReport) {
		super(webDriver, fileConf, fileReport);
		// TODO Auto-generated constructor stub
		fConf = fileConf;
		driver = webDriver;
	}

	void startTest() throws InterruptedException  {
		System.out.println("*****************************************************************");
		System.out.println("*                          Create Folder                        *");
		System.out.println("*****************************************************************");
		System.out.println("Test D001 - eFiler -> Create Folder");
		System.out.println("Can you create new folder?\n" +
							"폴더 생성이 되는가?\n"+
							"----------------------------------------------------------");
		
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(fConf));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
	        for (int i=1; i<=10; i++){
	        	String line = br.readLine();
	        	if (i > 9){
	        		//System.out.println(line);
		        	String[] tokens = line.split("=");
		        	if (tokens[0].equals("new_folder"))
		        		new_folder = tokens[1];
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
		
		if (isElementPresent(By.id("newfolder_menu"))){
			//click Create folder button
			driver.findElement(By.id("newfolder_menu")).click();
			
			//enter folder name to create
			driver.findElement(By.id("dir_name_id")).clear();
			driver.findElement(By.id("dir_name_id")).sendKeys(new_folder);	//enter new folder name
			driver.findElement(By.xpath("//input[@value='OK']")).click();	//click OK
			Thread.sleep(4000);

			//get the first folder name after creation
			folder_name = driver.findElement(By.xpath("//div[@id='filelist_view']/table/tbody/tr/td[2]/span/a")).getText();
			//folder_name = "New folder name: " + folder_name;
			System.out.println("New folder name: " + folder_name);
			
			if (folder_name.equals(new_folder))
				successMsg = "Can create new folder successfully.";
			else
				successMsg = "Can't create new folder (FAIL).";
		}else
			successMsg = "Create folder option is not available";
		
		
		System.out.println(successMsg);
		
		try {
			StringBuilder builder = new StringBuilder();
	        BufferedWriter out = new BufferedWriter(new FileWriter(fReport, true));
			
	        builder.append("\r\n*****************************************************************\r\n");
	        builder.append("*                          Create Folder                        *\r\n");
	        builder.append("*****************************************************************\r\n");
	        builder.append("Test D001 - eFiler -> Create Folder\r\n");
	        builder.append("Can you create new folder?\r\n" +
							"폴더 생성이 되는가?\r\n");
	        builder.append("=================================================================\r\n");
	        builder.append("New folder name: " + folder_name + "\r\n");
			builder.append("\r\n" + successMsg + "\r\n");
			out.write(builder.toString());
	
			if(Lisenter != null){
				Lisenter.onReportLisenter(builder.toString());
			}
			
			out.close();
	        } catch (IOException e) {}

	}
}

