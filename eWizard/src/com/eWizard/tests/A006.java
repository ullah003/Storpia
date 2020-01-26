package com.eWizard.tests;

import java.io.*;

import static org.junit.Assert.*;
import org.openqa.selenium.*;

public class A006 extends BaseTestLogic {

	private static StringBuffer verificationErrors = new StringBuffer();
	private static String VolumeName = "", VolumeType = "", FileSystem = "", TotalSize = "", 
			SpaceLeft = "", Status = "", NoVol = "",
			DiskName = "", Model = "", DeviceName = "", Capacity = "", DStatus = ""; 
	private static String [] VolumeInfo = {"", "", "", "", "", "", ""}, DiskInfo = {"", "", "", "", "", "", ""};
	int No_of_Volume = 0, No_of_Disk = 0;

	
	public A006(WebDriver webDriver, File fileConf, File fileReport) {
		super(webDriver, fileConf, fileReport);
//		fConf = fileConf;
	}
	
	void startTest() throws InterruptedException  {
		System.out.println("*****************************************************************");
		System.out.println("*                      Volume and Disk Information              *");
		System.out.println("*****************************************************************");
		System.out.println("Test A006 - Quick Setup -> Disk");
		System.out.println("Can it show currently existing volume? \n" +
							"현재 설정되어 있는 볼륨이 정상적으로 출력 되는가?\n" + 
							"----------------------------------------------------------");
		
		StringBuilder builder = new StringBuilder();
		BufferedWriter out = null;
		try {
			out = new BufferedWriter(new FileWriter(fReport, true));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		builder.append("\r\n*****************************************************************\r\n");
		builder.append("*                      Volume and Disk Information              *\r\n");
		builder.append("*****************************************************************\r\n");
		builder.append("Test A006 - Quick Setup -> Disk \r\n");
		builder.append("Can it show currently existing volume? \r\n" +
					"현재 설정되어 있는 볼륨이 정상적으로 출력 되는가?\r\n");
		builder.append("=================================================================\r\n");
		
		//Click Disk menu
		driver.findElement(By.name("Image4")).click();
		
		Thread.sleep(2000);
//		System.out.println("Volume Name\tVol Type\tFile System\tTotal Size\tSpace Left\tStatus");
//		System.out.println("\tDisk Name\tModel\t\tDevice Name\tCapacity\tStatus");
		
		for (int i =1; i<=4; i++){
			if (!isElementPresent(By.xpath("//body/div[6]/div[2]/div/div/div/div/div/div/div/div/div/div[2]/div/div/div/div/div/div/div/div/div/div/div/div/div[2]/div/div[" + i + "]/table/tbody/tr/td/div"))){
				break;
			}else{
				No_of_Volume = No_of_Volume+1;
				driver.findElement(By.xpath("//body/div[6]/div[2]/div/div/div/div/div/div/div/div/div/div[2]/div/div/div/div/div/div/div/div/div/div/div/div/div[2]/div/div[" + i + "]/table/tbody/tr/td/div/img")).click();
				Thread.sleep(2000);
				//get volume information
				VolumeName = driver.findElement(By.xpath("//*[@id='wizardDiskVolumeInfoName']")).getText();
				VolumeType = driver.findElement(By.id("wizardDiskVolumeInfoMode")).getText();
				FileSystem = driver.findElement(By.id("wizardDiskVolumeInfoFileSystem")).getText();
				TotalSize = driver.findElement(By.id("wizardDiskVolumeInfoCapacity")).getText();
				SpaceLeft = driver.findElement(By.id("wizardDiskVolumeInfoAvail")).getText();
				Status = driver.findElement(By.id("wizardDiskVolumeInfoStatus")).getText();
				
				System.out.println("Volume Name\tVolume Type\tFile System\tTotal Size\tSpace Left\tStatus");
				VolumeInfo [i-1] =  VolumeName + "\t\t" + VolumeType + "\t" + FileSystem + "\t\t" + TotalSize + "\t\t" + SpaceLeft + "\t\t" + Status;
				System.out.println(VolumeInfo [i-1] + "\n");
				
				builder.append("Volume Name\tVolume Type\tFile System\tTotal Size\tSpace Left\tStatus\r\n");
				builder.append(VolumeInfo[i-1] + "\r\n\r\n");
				
				//get disk information
				System.out.println("Disk Name\tModel\t\t\tDevice Name\tCapacity\tStatus");
				builder.append("Disk Name\tModel\t\t\tDevice Name\tCapacity\tStatus\r\n");
				for (int j =1; j<=4; j++){
					if (!isElementPresent(By.xpath("//body/div[6]/div[2]/div/div/div/div/div/div/div/div/div/div[2]/div/div/div/div/div[3]/div/div/div[2]/div/div/div[2]/div/div/div/div/div[2]/div/div[" + j + "]/table/tbody/tr/td/div"))){
						break;
					}else{
						No_of_Disk = No_of_Disk+1;
						DiskName = driver.findElement(By.xpath("//body/div[6]/div[2]/div/div/div/div/div/div/div/div/div/div[2]/div/div/div/div/div[3]/div/div/div[2]/div/div/div[2]/div/div/div/div/div[2]/div/div[" + j + "]/table/tbody/tr/td/div")).getText();
						Model = driver.findElement(By.xpath("/html/body/div[6]/div[2]/div/div/div/div/div/div/div/div/div/div[2]/div/div/div/div/div[3]/div/div/div[2]/div/div/div[2]/div/div/div/div/div[2]/div/div[" + j + "]/table/tbody/tr/td[2]/div")).getText();
						DeviceName = driver.findElement(By.xpath("/html/body/div[6]/div[2]/div/div/div/div/div/div/div/div/div/div[2]/div/div/div/div/div[3]/div/div/div[2]/div/div/div[2]/div/div/div/div/div[2]/div/div[" + j + "]/table/tbody/tr/td[3]/div")).getText();
						Capacity = driver.findElement(By.xpath("/html/body/div[6]/div[2]/div/div/div/div/div/div/div/div/div/div[2]/div/div/div/div/div[3]/div/div/div[2]/div/div/div[2]/div/div/div/div/div[2]/div/div[" + j + "]/table/tbody/tr/td[4]/div")).getText();
						DStatus = driver.findElement(By.xpath("/html/body/div[6]/div[2]/div/div/div/div/div/div/div/div/div/div[2]/div/div/div/div/div[3]/div/div/div[2]/div/div/div[2]/div/div/div/div/div[2]/div/div[" + j + "]/table/tbody/tr/td[5]/div")).getText();
					
						DiskInfo [j-1] =  DiskName + "\t" + Model + "\t\t" + DeviceName + "\t\t" + Capacity + "\t\t" + DStatus;
						System.out.println(DiskInfo [j-1]);
						
						builder.append(DiskInfo[j-1] + "\r\n");
					}
				}
				builder.append("------------------------------------------------------------------------------\r\n");
				System.out.println("------------------------------------------------------------------------------------");
			}
		}	
		System.out.println("Total number of Volume:" + No_of_Volume + 
							"\nTotal number of Disk:" + No_of_Disk);
		
		builder.append("Total number of Volume: " + No_of_Volume + 
        		"\r\nTotal number of Disk: " + No_of_Disk + "\r\n");
		
		try {
			out.write(builder.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if(Lisenter != null){
			Lisenter.onReportLisenter(builder.toString());
		}
        try {
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.findElement(By.xpath("//input[@value='Close']")).click();
		
//		try {
//	        BufferedWriter out = new BufferedWriter(new FileWriter("D:\\eWizard_Report.txt", true));
//	            out.write("\r\n*****************************************************************\r\n");
//		        out.write("*                      Volume and Disk Information              *\r\n");
//		        out.write("*****************************************************************\r\n");
//		        out.write("Test A006 - Quick Setup -> Disk \r\n");
//		        out.write("Can it show currently existing volume? \r\n" +
//							"현재 설정되어 있는 볼륨이 정상적으로 출력 되는가?\r\n");
//		        out.write("=================================================================\r\n");
//                //out.write("Volume Name\tVol Type\tFile System\tTotal Size\tSpace Left\tMount status\tDevice name\tPartition status\tStatus\r\n");
//                for (int i =0; i<No_of_Volume; i++){
//                	out.write("Volume Name\tVolume Type\tFile System\tTotal Size\tSpace Left\tStatus\r\n");
//                	out.write(VolumeInfo[i] + "\r\n\r\n");
//                	out.write("Disk Name\tModel\t\t\tDevice Name\tCapacity\tStatus\r\n");
//                	for (int j =0; j<No_of_Disk; j++){
//	                	out.write(DiskInfo[j] + "\r\n");
//                	}
//                	out.write("------------------------------------------------------------------------------\r\n");
//                }
//                out.write("Total number of Volume: " + No_of_Volume + 
//                		"\r\nTotal number of Disk: " + No_of_Disk);
//	            out.close();
//	        } catch (IOException e) {}
		 	
		
		// After
//		driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}


	}


//	private static boolean isElementPresent(By by) {
//		try {
//			driver.findElement(by);
//			return true;
//		} catch (NoSuchElementException e) {
//			return false;
//		}
//	}
		
}

