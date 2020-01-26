//볼륨정보가 정상적으로 출력 되는가?

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

public class B008 extends System_Setting {
	private static String VolumeName = "", VolumeType = "", FileSystem = "", TotalSize = "", SpaceLeft = "",
			MountStatus = "", DeviceName = "", PartitionStatus = "", Status = "", NoVol = "";
	private static String [] VolumeInfo = {"", "", "", "", "", "", ""};
	int Number_of_Volume;
	
	//public static void main(String []args) throws Exception {
	public void B008() throws InterruptedException{
		System.out.println("*****************************************************************");
		System.out.println("*                       Volume Information                      *");
		System.out.println("*****************************************************************");
		System.out.println("Test B008 - System -> Disk -> Volume Management");
		System.out.println("Can it show volume information properly? \n" +
				"볼륨정보가 정상적으로 출력 되는가? \n" + 
				"----------------------------------------------------------\n");

		//driver.findElement(By.xpath("//ul[@id='ext-gen119']/li[2]/div/a/span")).click();
		driver.findElement(By.linkText("Disk")).click();
		Thread.sleep(3000);
		System.out.println("Volume Name\tVol Type\tFile System\tTotal Size\tSpace Left\tMount status\tDevice name\tPartition status\tStatus");
		
		for (int i =1; i<=6; i++){
			Number_of_Volume = i;
			if (!isElementNotPresent(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/div/div[2]/div/form/div/div/div/div/div[2]/div[2]/div/div/div[2]/div/div["+ i +"]/table/tbody/tr/td/div"))){
				if (i==1)
					NoVol = "-------------- No volume available ----------------";
				else
					NoVol = "Total number of volume :" + (i-1);
				break;
			}else{
				VolumeName = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/div/div[2]/div/form/div/div/div/div/div[2]/div[2]/div/div/div[2]/div/div["+ i +"]/table/tbody/tr/td/div")).getText();
				VolumeType = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/div/div[2]/div/form/div/div/div/div/div[2]/div[2]/div/div/div[2]/div/div["+ i +"]/table/tbody/tr/td[2]/div")).getText();
				FileSystem = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/div/div[2]/div/form/div/div/div/div/div[2]/div[2]/div/div/div[2]/div/div["+ i +"]/table/tbody/tr/td[3]/div")).getText();
				TotalSize = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/div/div[2]/div/form/div/div/div/div/div[2]/div[2]/div/div/div[2]/div/div["+ i +"]/table/tbody/tr/td[4]/div")).getText();
				SpaceLeft = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/div/div[2]/div/form/div/div/div/div/div[2]/div[2]/div/div/div[2]/div/div["+ i +"]/table/tbody/tr/td[5]/div")).getText();
				MountStatus = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/div/div[2]/div/form/div/div/div/div/div[2]/div[2]/div/div/div[2]/div/div["+ i +"]/table/tbody/tr/td[6]/div")).getText();
				DeviceName = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/div/div[2]/div/form/div/div/div/div/div[2]/div[2]/div/div/div[2]/div/div["+ i +"]/table/tbody/tr/td[7]/div")).getText();
				PartitionStatus = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/div/div[2]/div/form/div/div/div/div/div[2]/div[2]/div/div/div[2]/div/div["+ i +"]/table/tbody/tr/td[8]/div")).getText();
				Status = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/div/div[2]/div/form/div/div/div/div/div[2]/div[2]/div/div/div[2]/div/div["+ i +"]/table/tbody/tr/td[9]/div")).getText();
				//System.out.println(VolumeName + "\t\t" + VolumeType + "\t" + FileSystem + "\t\t" + TotalSize + "\t\t" + SpaceLeft + "\t" + MountStatus + "\t\t" + DeviceName + "\t\t" + PartitionStatus + "\t\t\t" + Status);
				VolumeInfo [i-1] =  VolumeName + "\t\t" + VolumeType + "\t\t" + FileSystem + "\t\t" + TotalSize + "\t\t" + SpaceLeft + "\t\t" + MountStatus + "\t\t" + DeviceName + "\t\t" + PartitionStatus + "\t\t" + Status;
				System.out.println(VolumeInfo [i-1]);
			}
		}	
		System.out.println(NoVol);
		
		try {
	        BufferedWriter out = new BufferedWriter(new FileWriter("D:\\System_Setting.txt", true));
	            out.write("\r\n*****************************************************************\r\n");
		        out.write("*                           Volume Information                      *\r\n");
		        out.write("*****************************************************************\r\n");
		        out.write("Test B008 - System -> Disk -> Volume Management \r\n");
		        out.write("Can it show volume information properly? \r\n" +
							"볼륨정보가 정상적으로 출력 되는가?\r\n");
		        out.write("=================================================================\r\n");
                out.write("Volume Name\tVol Type\tFile System\tTotal Size\tSpace Left\tMount status\tDevice name\tPartition status\tStatus\r\n");
                for (int j =0; j<Number_of_Volume; j++){
                	out.write(VolumeInfo[j] + "\r\n");
                }
                out.write(NoVol + "\r\n");
	            out.close();
	        } catch (IOException e) {}
		
		
		// After
		//driver.quit();
		
	}

	public static boolean isElementNotPresent(By by) {
	    boolean flag = true;
	    driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	    if (!(driver.findElements(by).size() > 0)) {
	        flag = false;
	    } 
	    driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
	    return flag;
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
