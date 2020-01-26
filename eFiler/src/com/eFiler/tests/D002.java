package com.eFiler.tests;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import org.openqa.selenium.*;

public class D002 extends BaseTestLogic {
	
	private static String new_name = "", folder_name = "", successMsg = "";

	
	public D002(WebDriver webDriver, File fileConf, File fileReport) {
		super(webDriver, fileConf, fileReport);
		// TODO Auto-generated constructor stub
		fConf = fileConf;
		driver = webDriver;
	}

	void startTest() throws InterruptedException  {
		System.out.println("*****************************************************************");
		System.out.println("*                       Rename File/Folder                      *");
		System.out.println("*****************************************************************");
		System.out.println("Test D002 - eFiler -> Rename File/Folder");
		System.out.println("Is it possible to rename file/folder?\n" +
							"파일명 변경이 되는가?\n"+
							"----------------------------------------------------------");
		
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(fConf));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
	        for (int i=1; i<=12; i++){
	        	String line = br.readLine();
	        	if (i > 11){
	        		//System.out.println(line);
		        	String[] tokens = line.split("=");
		        	if (tokens[0].equals("rename_key"))
		        		new_name = tokens[1];
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
		
		if (isElementPresent(By.xpath("//div[@id='filelist_view']/table/tbody/tr/td[2]/span/a"))){
			//check first file/folder
			driver.findElement(By.xpath("//div[@id='filelist_view']/table/tbody/tr/td/input")).click();
			
			//click Rename button
			driver.findElement(By.id("rename_menu")).click();
			
			
			//enter new name to rename
			driver.findElement(By.id("new_name_id")).clear();
			driver.findElement(By.id("new_name_id")).sendKeys(new_name);	//enter new folder name
			driver.findElement(By.xpath("//input[@value='Change']")).click();	//click Change
			Thread.sleep(4000);

			if (isElementVisible(By.id("rename_error_msg"))){
				successMsg = "Folder or file with same name already exists. Try again later.";
				//driver.findElement(By.xpath("//input[@value='Cancel']")).click();	//click Change
				driver.findElement(By.xpath("html/body/form/div[6]/div[2]/div[2]/div[4]/input[2]")).click();	//click Change
			}else{
				//get the first folder name after rename
				folder_name = driver.findElement(By.xpath("//div[@id='filelist_view']/table/tbody/tr/td[2]/span/a")).getText();
				System.out.println("File/Folder name after rename: " + folder_name);
				successMsg = "File/Folder name renamed successfully.";
			}
				
		}else
			successMsg = "No file/folder list exists to rename.";
		
		
		System.out.println(successMsg);
		
		try {
			StringBuilder builder = new StringBuilder();
	        BufferedWriter out = new BufferedWriter(new FileWriter(fReport, true));
			
	        builder.append("\r\n*****************************************************************\r\n");
	        builder.append("*                       Rename File/Folder                      *\r\n");
	        builder.append("*****************************************************************\r\n");
	        builder.append("Test D002 - eFiler -> Rename File/Folder\r\n");
	        builder.append("Is it possible to rename file/folder?\r\n" +
							"파일명 변경이 되는가?\r\n");
	        builder.append("=================================================================\r\n");
	        builder.append("File/Folder name (to rename): " + folder_name + "\r\n");
			builder.append("\r\n" + successMsg + "\r\n");
			out.write(builder.toString());
	
			if(Lisenter != null){
				Lisenter.onReportLisenter(builder.toString());
			}
			
			out.close();
	        } catch (IOException e) {}

	}
}

