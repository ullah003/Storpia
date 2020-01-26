package com.eWizard.tests;

import java.io.*;

import static org.junit.Assert.*;
import org.openqa.selenium.*;

public class A008 extends BaseTestLogic {

	private static StringBuffer verificationErrors = new StringBuffer();
	private static String create_Mode = "", vol_Type = "", error = "", SusseccMsg = "";
	int Volume_no_before, Volume_no_after;
	
	public A008(WebDriver webDriver, File fileConf, File fileReport) {
		super(webDriver, fileConf, fileReport);
		fConf = fileConf;
	}
	
	void startTest() throws InterruptedException  {
		System.out.println("*****************************************************************");
		System.out.println("*                              Create Volume                    *");
		System.out.println("*****************************************************************");
		System.out.println("Test A008 - Quick Setup -> Disk");
		System.out.println("Can it create volume successfully? \n" +
							"볼륨생성시 관리자의 볼륨생성과 동일하게 진행 되는가?\n" + 
							"----------------------------------------------------------");
		
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(fConf));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
	        for (int i=1; i<=13; i++){
	        	String line = br.readLine();
	        	if (i > 11){
	        		//System.out.println(line + "\n");
		        	String[] tokens = line.split("=");
		        	if (tokens[0].equals("create_Mode"))
		        		create_Mode = tokens[1];
		        	else if (tokens[0].equals("vol_Type"))
		        		vol_Type = tokens[1];
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
		
		//Click Disk menu
		driver.findElement(By.name("Image4")).click();
		
		Thread.sleep(1000);
		
		//get number of volume before creation
		for (int i =1; i<=6; i++){
			if (!isElementPresent(By.xpath("//body/div[6]/div[2]/div/div/div/div/div/div/div/div/div/div[2]/div/div/div/div/div/div/div/div/div/div/div/div/div[2]/div/div[" + i + "]/table/tbody/tr/td/div"))){
				Volume_no_before = i-1;
				break;
			}
		}
		System.out.println("Number of Volume before creation: " + Volume_no_before);
		
		
		if (isElementPresent(By.xpath("//button[contains(text(), 'Create Volume')]"))){
			driver.findElement(By.xpath("//button[contains(text(), 'Create Volume')]")).click();
			Thread.sleep(1000);
			
			if (create_Mode.equals("Quick")){
				driver.findElement(By.id("volumeCreateModeGeneral")).click();   //Select Quick Mode
				driver.findElement(By.xpath("//button[contains(text(), 'Next')]")).click();   //Click Next
				Thread.sleep(1000);
				if (isElementVisible(By.xpath("//button[contains(text(), 'OK')]"))){   //if No disk available
					driver.findElement(By.xpath("//button[contains(text(), 'OK')]")).click();
					error = "No disk available to create volume.";
					driver.findElement(By.xpath("//body/div[17]/div/div/div/div/div")).click(); //cancel button
				}else if (isElementVisible(By.xpath("//button[contains(text(), 'Confirm')]"))){  //if possible to proceed
					driver.findElement(By.xpath("//button[contains(text(), 'Confirm')]")).click();
					Thread.sleep(1000);
					driver.findElement(By.xpath("//button[contains(text(), 'Yes')]")).click();
					Thread.sleep(16000);
				}
			}else if (create_Mode.equals("Advanced")){
				driver.findElement(By.id("volumeCreateModeHigh")).click();   //Select Advanced Mode
				driver.findElement(By.xpath("//button[contains(text(), 'Next')]")).click();   //Click Next
				Thread.sleep(1000);

				if (isElementVisible(By.xpath("//button[contains(text(), 'OK')]"))){   //if No disk available
					driver.findElement(By.xpath("//button[contains(text(), 'OK')]")).click();
					error = "No disk available to create volume.";
					driver.findElement(By.xpath("//body/div[17]/div/div/div/div/div")).click(); //cancel button
				}else if (isElementVisible(By.id("volumeCreateSingle"))){  //if possible to proceed
					if (vol_Type.equals("Single"))
						driver.findElement(By.id("volumeCreateSingle")).click();   // select Single disk mode
					else if (vol_Type.equals("JBOD"))
						driver.findElement(By.id("volumeCreateJbod")).click();
					else if (vol_Type.equals("RAID0"))
						driver.findElement(By.id("volumeCreateRaid0")).click();
					else if (vol_Type.equals("RAID1"))
						driver.findElement(By.id("volumeCreateRaid1")).click();
					
					
					driver.findElement(By.xpath("//button[contains(text(), 'Next')]")).click();
					Thread.sleep(1000);
					
					if (isElementVisible(By.xpath("//button[contains(text(), 'OK')]"))){   //if invalid volume type
						driver.findElement(By.xpath("//button[contains(text(), 'OK')]")).click();
						error = driver.findElement(By.xpath("//div[@class='ext-mb-content')]/span")).getText();
						
						//error = "Invalid volume type entered! Please try again...";
						driver.findElement(By.xpath("//body/div[17]/div/div/div/div/div")).click(); //cancel button
//						driver.findElement(By.xpath("//input[@value='Close']")).click();	//close button
					}else if (vol_Type.equals("Single")){  //select 1st disk for single volume
						driver.findElement(By.xpath("//div[@class='x-grid3-scroller']/div/div/table/tbody/tr/td/div/div")).click();   //select 1st Disk
						
						driver.findElement(By.xpath("//button[contains(text(), 'Next')]")).click();
						Thread.sleep(1000);
						driver.findElement(By.xpath("//button[contains(text(), 'Confirm')]")).click();
						Thread.sleep(1000);
						driver.findElement(By.xpath("//button[contains(text(), 'Yes')]")).click();
						Thread.sleep(16000);
					}else{
						for (int i =1; i<=2; i++){
							driver.findElement(By.xpath("//div[@class='x-grid3-scroller']/div/div[" + i + "]/table/tbody/tr/td/div/div")).click();
						}
						driver.findElement(By.xpath("//button[contains(text(), 'Next')]")).click();
						Thread.sleep(1000);
						driver.findElement(By.xpath("//button[contains(text(), 'Confirm')]")).click();
						Thread.sleep(1000);
						driver.findElement(By.xpath("//button[contains(text(), 'Yes')]")).click();
						Thread.sleep(16000);
					}	
//					driver.findElement(By.xpath("//button[contains(text(), 'Next')]")).click();
//					Thread.sleep(1000);
//					driver.findElement(By.xpath("//button[contains(text(), 'Confirm')]")).click();
//					Thread.sleep(1000);
//					driver.findElement(By.xpath("//button[contains(text(), 'Yes')]")).click();
//					Thread.sleep(16000);
					
				}
			}else{
				error = "Incorrect Volume creation mode. Please try again";
			}
		}else{
			error = "Can't find Volume Create option. Please try again";
		}
			
		System.out.println(error);
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@value='Close']")).click();
		
		driver.findElement(By.name("Image4")).click();
		
		Thread.sleep(1000);
		
		//get number of volume after creation
		for (int i =1; i<=6; i++){
			if (!isElementPresent(By.xpath("//body/div[6]/div[2]/div/div/div/div/div/div/div/div/div/div[2]/div/div/div/div/div/div/div/div/div/div/div/div/div[2]/div/div[" + i + "]/table/tbody/tr/td/div"))){
				Volume_no_after = i-1;
				break;
			}
		}
		System.out.println("Number of Volume after creation: " + Volume_no_after);
		
		driver.findElement(By.xpath("//input[@value='Close']")).click();
		
		if (Volume_no_before >= Volume_no_after){
			SusseccMsg = "Volume creation failed!";
		}else
			SusseccMsg = "Volume created successfully.";
		
		System.out.println("Final Output: " + SusseccMsg);
		
		try {
			StringBuilder builder = new StringBuilder();
	        BufferedWriter out = new BufferedWriter(new FileWriter(fReport, true));
	        
            builder.append("\r\n*****************************************************************\r\n");
            builder.append("*                             Create Volume                     *\r\n");
            builder.append("*****************************************************************\r\n");
            builder.append("Test A008 - Quick Setup -> Disk \r\n");
            builder.append("Can it create volume successfully?\r\n" +
						"볼륨생성시 관리자의 볼륨생성과 동일하게 진행 되는가?\r\n");
            builder.append("=================================================================\r\n");
            builder.append(error + "\r\nNumber of Volume before creation: " + Volume_no_before + 
            			"\r\nNumber of Volume after creation: " + Volume_no_after + "\r\nFinal Output: " + SusseccMsg + "\r\n");
            
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

