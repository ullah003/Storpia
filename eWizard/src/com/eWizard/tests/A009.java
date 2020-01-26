package com.eWizard.tests;

import java.io.*;

import static org.junit.Assert.*;
import org.openqa.selenium.*;

public class A009 extends BaseTestLogic {

	private static StringBuffer verificationErrors = new StringBuffer();
	private static String Del_Vol_No = "", Confirm = "", System_out = "", Status = "", Status1 = "";
	
	public A009(WebDriver webDriver, File fileConf, File fileReport) {
		super(webDriver, fileConf, fileReport);
		fConf = fileConf;
	}
	
	void startTest() throws InterruptedException  {
		System.out.println("*****************************************************************");
		System.out.println("*                            Delete Volume                      *");
		System.out.println("*****************************************************************");
		System.out.println("Test A009 - Quick Setup -> Disk");
		System.out.println("Can it delete volume successfully? \n" +
							"볼륨삭제는 정상적으로 실행 되는가?\n" + 
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
	        	String line = null;
				try {
					line = br.readLine();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        	if (i > 8){
	        		//System.out.println(line + "\n");
		        	String[] tokens = line.split("=");
		        	if (tokens[0].equals("Del_Vol_No"))
		        		Del_Vol_No = tokens[1];
		        	else if (tokens[0].equals("Confirm"))
		        		Confirm = tokens[1];
	        	}
	        }
	    } finally {
	        try {
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
		
		//Click Disk menu
		driver.findElement(By.name("Image4")).click();
		
		Thread.sleep(3000);
		
		
		if (!isElementPresent(By.xpath("//body/div[6]/div[2]/div/div/div/div/div/div/div/div/div/div[2]/div/div/div/div/div/div/div/div/div/div/div/div/div[2]/div/div[" + Del_Vol_No + "]/table/tbody/tr/td/div"))){
			Status1 = "-------------- Volume" + Del_Vol_No +  " not available to delete!----------------";
		}else{
			driver.findElement(By.xpath("//body/div[6]/div[2]/div/div/div/div/div/div/div/div/div/div[2]/div/div/div/div/div/div/div/div/div/div/div/div/div[2]/div/div[" + Del_Vol_No + "]/table/tbody/tr/td/div/img")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//button[contains(text(), 'Delete Volume')]")).click();
			Thread.sleep(1000);
			if (Confirm.equals("Yes")){
				driver.findElement(By.xpath("//button[contains(text(), 'Confirm')]")).click();
				Status1 = "Volume will be deleted";
			}else{
				driver.findElement(By.xpath("//button[contains(text(), 'Cancel')]")).click();
				Status1 = "Volume will not be deleted";
			}
			Thread.sleep(10000);
			
			if (isElementVisible(By.xpath("//table[@id='ext-comp-1359']/tbody/tr[2]/td[2]"))){
				driver.findElement(By.xpath("//table[@id='ext-comp-1359']/tbody/tr[2]/td[2]")).click();
			}
			
			Thread.sleep(3000);
			driver.findElement(By.xpath("//input[@value='Close']")).click();
			
			driver.findElement(By.name("Image4")).click();
			
			Thread.sleep(2000);
			
			if (!isElementPresent(By.xpath("//body/div[6]/div[2]/div/div/div/div/div/div/div/div/div/div[2]/div/div/div/div/div/div/div/div/div/div/div/div/div[2]/div/div[" + Del_Vol_No + "]/table/tbody/tr/td/div"))){
				Status = "Volume" + Del_Vol_No +  " deleted successfully.";
			}else{
				Status = "Volume" + Del_Vol_No +  " delete Fail.";			
			}
		}
		
		System.out.println(Status1);
		
//		Thread.sleep(3000);
//		driver.findElement(By.xpath("//input[@value='Close']")).click();
//		
//		driver.findElement(By.name("Image4")).click();
//		
//		Thread.sleep(2000);
//		
//		if (!isElementPresent(By.xpath("//body/div[6]/div[2]/div/div/div/div/div/div/div/div/div/div[2]/div/div/div/div/div/div/div/div/div/div/div/div/div[2]/div/div[" + Del_Vol_No + "]/table/tbody/tr/td/div"))){
//			Status = "Volume" + Del_Vol_No +  " deleted successfully.";
//		}else{
//			Status = "Volume" + Del_Vol_No +  " delete Fail.";			
//		}
		
		System.out.println(Status);
		
		try {
			StringBuilder builder = new StringBuilder();
	        BufferedWriter out = new BufferedWriter(new FileWriter(fReport, true));
	        builder.append("\r\n*****************************************************************\r\n");
	        builder.append("*                            Delete Volume                      *\r\n");
	        builder.append("*****************************************************************\r\n");
	        builder.append("Test A009 - Quick Setup -> Disk \r\n");
	        builder.append("Can it delete volume successfully? \r\n" +
						"볼륨삭제는 정상적으로 실행 되는가?\r\n");
	        builder.append("=================================================================\r\n");
	        builder.append(Status1 + "\r\n" + Status + "\r\n");
            
	        out.write(builder.toString());

			if(Lisenter != null){
				Lisenter.onReportLisenter(builder.toString());
			}
            out.close();
	        } catch (IOException e) {}
		 	
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}


	}
		
}

