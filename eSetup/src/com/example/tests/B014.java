//디스크 리스트가 정상적으로 출력되는가?
//Can it show list of Disks properly? 
//--------------Marvell------------

package com.example.tests;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class B014 extends System_Setting {
	private static String diskName = "", deviceName = "", model = "", capacity = "", partition = "",
			partitionSize = "", fileSystem = "", volumeAssign = "", NoDisk = "";
	private static String [] DiskInfo = {"", "", "", "", "",};
	int Number_of_Disk;
	
	//public static void main(String [] args) throws InterruptedException {
	public void B014() throws InterruptedException{
		System.out.println("*****************************************************************");
		System.out.println("*                       Disk Information                      *");
		System.out.println("*****************************************************************");
		System.out.println("Test B014 - System -> Disk ");
		System.out.println("Can it show disk information properly? \n" +
				"디스크 리스트가 정상적으로 출력되는가? \n" + 
				"----------------------------Marvell----------------------------\n");
		
		//driver.findElement(By.xpath("//body/div/div[2]/div/div/div/div/ul/div/li[2]/ul/li[2]/div/a/span")).click();
		driver.findElement(By.linkText("Disk")).click();
		Thread.sleep(3000);
		//driver.findElement(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div/div/div/ul/li[2]/a[2]/em/span/span")).click();
		//driver.findElement(By.linkText("Disk Status")).click();
		
		System.out.println("Disk Name\tDevice\tModel\t\t\tCapacity\tPartition\tPartition Size\tFile System\tVol Assign\n");
		for (int i =1; i<=4; i++){
			Number_of_Disk = i;
			if (!isElementPresent(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/div/div/div/form/div/div/div/div/div[2]/div[2]/div/div/div[2]/div/div["+ i +"]/table/tbody/tr/td/div"))){
				if (i==1)
					NoDisk = "-------------- No Disk available ----------------";
				else
					NoDisk = "Total number of Disk :" + (i-1);
				break;
			}else{
				diskName = driver.findElement(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/div/div/div/form/div/div/div/div/div[2]/div[2]/div/div/div[2]/div/div["+ i +"]/table/tbody/tr/td/div")).getText();
				deviceName = driver.findElement(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/div/div/div/form/div/div/div/div/div[2]/div[2]/div/div/div[2]/div/div["+ i +"]/table/tbody/tr/td[2]/div")).getText();
				model = driver.findElement(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/div/div/div/form/div/div/div/div/div[2]/div[2]/div/div/div[2]/div/div["+ i +"]/table/tbody/tr/td[3]/div")).getText();
				capacity = driver.findElement(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/div/div/div/form/div/div/div/div/div[2]/div[2]/div/div/div[2]/div/div["+ i +"]/table/tbody/tr/td[4]/div")).getText();
				partition = driver.findElement(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/div/div/div/form/div/div/div/div/div[2]/div[2]/div/div/div[2]/div/div["+ i +"]/table/tbody/tr/td[5]/div")).getText();
				partitionSize = driver.findElement(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/div/div/div/form/div/div/div/div/div[2]/div[2]/div/div/div[2]/div/div["+ i +"]/table/tbody/tr/td[6]/div")).getText();
				fileSystem = driver.findElement(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/div/div/div/form/div/div/div/div/div[2]/div[2]/div/div/div[2]/div/div["+ i +"]/table/tbody/tr/td[7]/div")).getText();
				volumeAssign = driver.findElement(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/div/div/div/form/div/div/div/div/div[2]/div[2]/div/div/div[2]/div/div["+ i +"]/table/tbody/tr/td[8]/div")).getText();
				
//				String diskName = driver.findElement(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[2]/div/div/div/div/div/div/div/form/div/div/div/div/div[2]/div[2]/div/div/div[2]/div/div[" + i +"]/table/tbody/tr/td/div")).getText();
//				String deviceName = driver.findElement(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[2]/div/div/div/div/div/div/div/form/div/div/div/div/div[2]/div[2]/div/div/div[2]/div/div[" + i +"]/table/tbody/tr/td[2]/div")).getText();
//				String model = driver.findElement(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[2]/div/div/div/div/div/div/div/form/div/div/div/div/div[2]/div[2]/div/div/div[2]/div/div[" + i +"]/table/tbody/tr/td[3]/div")).getText();
//				String capacity = driver.findElement(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[2]/div/div/div/div/div/div/div/form/div/div/div/div/div[2]/div[2]/div/div/div[2]/div/div[" + i +"]/table/tbody/tr/td[4]/div")).getText();
//				String partition = driver.findElement(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[2]/div/div/div/div/div/div/div/form/div/div/div/div/div[2]/div[2]/div/div/div[2]/div/div[" + i +"]/table/tbody/tr/td[5]/div")).getText();
//				String partitionSize = driver.findElement(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[2]/div/div/div/div/div/div/div/form/div/div/div/div/div[2]/div[2]/div/div/div[2]/div/div[" + i +"]/table/tbody/tr/td[6]/div")).getText();
//				String fileSystem = driver.findElement(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[2]/div/div/div/div/div/div/div/form/div/div/div/div/div[2]/div[2]/div/div/div[2]/div/div[" + i +"]/table/tbody/tr/td[7]/div")).getText();
//				String volumeAssign = driver.findElement(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[2]/div/div/div/div/div/div/div/form/div/div/div/div/div[2]/div[2]/div/div/div[2]/div/div[" + i +"]/table/tbody/tr/td[8]/div")).getText();
				
				DiskInfo [i-1] =  diskName + "\t\t" + deviceName + "\t" + model + "\t\t" + capacity + "\t\t" + partition + "\t\t" + partitionSize + "\t\t" + fileSystem + "\t\t" + volumeAssign;
				System.out.println(DiskInfo [i-1]);
//				System.out.println("Disk Name : " + diskName);
//				System.out.println("Device Name : " + deviceName);
//				System.out.println("Model : " + model);
//				System.out.println("Capacity : " + capacity);
//				System.out.println("Partition : " + partition);
//				System.out.println("Partition Size : " + partitionSize);
//				System.out.println("File System : " + fileSystem);
//				System.out.println("Volume Assign : " + volumeAssign);
//				System.out.println("=========================================================" );
			}
		}
		System.out.println(NoDisk);
		
		try {
	        BufferedWriter out = new BufferedWriter(new FileWriter("D:\\System_Setting.txt", true));
	            out.write("\r\n*****************************************************************\r\n");
		        out.write("*                           Disk Information                      *\r\n");
		        out.write("*****************************************************************\r\n");
		        out.write("Test B014 - System -> Disk \r\n");
		        out.write("Can it show Disk information properly? \r\n" +
							"디스크 리스트가 정상적으로 출력되는가?\r\n");
		        out.write("=================================================================\r\n");
                out.write("Disk Name\tDevice\tModel\t\t\tCapacity\tPartition\tPartition Size\tFile System\tVol Assign\r\n");
                for (int j =0; j<Number_of_Disk; j++){
                	out.write(DiskInfo[j] + "\r\n");
                }
                out.write(NoDisk + "\r\n");
	            out.close();
	        } catch (IOException e) {}
		
	}

//	private static boolean isElementPresent(By by) {
//		try {
//			driver.findElement(by);
//			return true;
//		} catch (NoSuchElementException e) {
//			return false;
//		}
//	}
	
	public static boolean isElementPresent(By by) {
	    boolean flag = true;
	    driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	    if (!(driver.findElements(by).size() > 0)) {
	        flag = false;
	    } 
	    driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
	    return flag;
	}
}
