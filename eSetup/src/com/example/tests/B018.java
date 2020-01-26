//After selecting USB disk can it be formated normally?
//usb 디스크 선택후 포맷 설정은 정상적인가?

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

public class B018 extends System_Setting {
	private static String DiskNameBefore = "", DiskNameAfter = "", FileSystem = "", FileSystemModified, systemOut = "", successMsg = "", NoUSB = "";
	private static String [] USBInfo = {"", "", "", "", "", "", ""};
	private static String [] USBInfo1 = {"", "", "", "", "", "", ""};
	static int Number_of_USB;
	
	//public static void main(String [] args) throws InterruptedException {
	public void B018() throws InterruptedException{
		System.out.println("*****************************************************************");
		System.out.println("*                    USB Format                    *");
		System.out.println("*****************************************************************");
		System.out.println("Test B018 - System -> External Device ");
		System.out.println("After selecting USB disk can it be formated normally? \n" +
				"usb 디스크 선택후 포맷 설정은 정상적인가? \n" + 
				"--------------------------------------------------------\n");
		
		driver.findElement(By.xpath("//body/div/div[2]/div/div/div/div/ul/div/li[2]/ul/li[3]/div/a/span")).click();	// External Disk menu
		
		Thread.sleep(3000);
		//When can't fetch disk information
		if (isElementPresent(By.xpath("//body/div[16]/div[2]/div/div/div/div/div/div[2]/span"))){
			systemOut = driver.findElement(By.xpath("//body/div[16]/div[2]/div/div/div/div/div/div[2]/span")).getText();
			System.out.println(systemOut);
			Thread.sleep(3000);
//			if (isElementPresent(By.xpath("//button[contains(text(), 'OK')]"))){
//				driver.findElement(By.xpath("//button[contains(text(), 'OK')]")).click();
//			}
		}
		if (systemOut.equals("")){
			for (int i =1; i<=6; i++){
				Number_of_USB = i-1;
				if (!isElementPresent(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/form/div/div[2]/div[2]/div/div/div[2]/div/div[" + i + "]/table/tbody/tr/td/div"))){
					if (i==1)
						NoUSB = "-------------- No USB Connected ----------------";
					else
						NoUSB = "Total number of USB :" + Number_of_USB;
					break;
				}else{
					DiskNameBefore = driver.findElement(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/form/div/div[2]/div[2]/div/div/div[2]/div/div[" + i + "]/table/tbody/tr/td/div")).getText();
					FileSystem = driver.findElement(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/form/div/div[2]/div[2]/div/div/div[2]/div/div[" + i + "]/table/tbody/tr/td[7]/div")).getText();		
					System.out.println("DiskName \t File System" );	
//					System.out.println(DiskNameBefore + "\t\t" + FileSystem);
					USBInfo [i-1] =  DiskNameBefore + " \t\t " + FileSystem;
					System.out.println(USBInfo [i-1]);
					
					//select disk
					driver.findElement(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/form/div/div[2]/div[2]/div/div/div[2]/div/div[" + i + "]")).click();
					// Click format
					driver.findElement(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/form/div/div[2]/div/div/table/tbody/tr/td/table/tbody/tr/td[5]/table/tbody/tr[2]/td[2]/em/button")).click();
					Thread.sleep(1000);
					
					System.out.println("Going to format to EXT3");
					
					//Click File System
					driver.findElement(By.xpath("//body/div[20]/div[2]/div/div/div/div/div/div/form/div[2]/div/div/input[2]")).click();
					
					//Select File System
					driver.findElement(By.xpath("//body/div[22]/div/div[3]")).click(); // EXT3
					
					driver.findElement(By.xpath("//button[contains(text(), 'Confirm')]")).click();
					
					System.out.println("=======================================" );
					systemOut = driver.findElement(By.xpath("//body/div[21]/div[2]/div/div/div/div/div/div[2]/span")).getText();
					System.out.println("Web Output : " + systemOut);
									
					if (systemOut.equals("External disk format failed")){
						driver.findElement(By.xpath("//button[contains(text(), 'OK')]")).click();
						driver.findElement(By.xpath("//button[contains(text(), 'Cancel')]")).click();
					}else{
						driver.findElement(By.xpath("//button[contains(text(), 'OK')]")).click();
					}
					
					DiskNameAfter = driver.findElement(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/form/div/div[2]/div[2]/div/div/div[2]/div/div[" + i + "]/table/tbody/tr/td/div")).getText();
					FileSystemModified = driver.findElement(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/form/div/div[2]/div[2]/div/div/div[2]/div/div[" + i + "]/table/tbody/tr/td[7]/div")).getText();
					
					System.out.println("DiskName \t volume Assign " );	
//					System.out.println(DiskNameAfter + "\t\t" + FileSystemModified);
					USBInfo1 [i-1] =  DiskNameAfter + " \t\t " + FileSystemModified;
					System.out.println(USBInfo1 [i-1]);
					
					if (FileSystem.equals(FileSystemModified)){
						successMsg = "Disk format failed!";
					}else{
						successMsg = "Disk formated Successfully!";
					}
					System.out.println(successMsg);
				}
					//successMsg = driver.findElement(By.xpath("//body/div[21]/div[2]/div/div/div/div/div/div[2]/span")).getText();
					//System.out.println("Output : " + successMsg);
					//driver.findElement(By.xpath("//button[contains(text(), 'OK')]")).click();		
					
					Thread.sleep(3000);
					//FileSystem = driver.findElement(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/form/div/div[2]/div[2]/div/div/div[2]/div/div[" + i + "]/table/tbody/tr/td[8]/div")).getText();
					//if (FileSystem.equals("Yes"))
					//	System.out.println("USB activated SUCCESSFULLY.");
					//else
					//	System.out.println("USB activation FAILED.");	
				
			}
			System.out.println(NoUSB);
		}
			
		try {
	        BufferedWriter out = new BufferedWriter(new FileWriter("D:\\System_Setting.txt", true));
	            out.write("\r\n*****************************************************************\r\n");
		        out.write("*                        USB Format                    *\r\n");
		        out.write("*****************************************************************\r\n");
		        out.write("Test B018 - System -> External Device \r\n");
		        out.write("After selecting USB disk can it be formated normally? \r\n" +
							"usb 디스크 선택후 포맷 설정은 정상적인가?\r\n");
		        out.write("=================================================================\r\n");
                for (int j =0; j<Number_of_USB; j++){
                	out.write("DiskName \t File System \r\n" );
                	out.write(USBInfo[j] + "\r\n" + USBInfo1 [j] +"\r\n");
                	out.write("---------------------------------------------\r\n" );
                }
                out.write(systemOut + "\r\n" +NoUSB + "\r\n" + successMsg + "\r\n");
	            out.close();
	        } catch (IOException e) {}
		
		// Select(disk1)
		//driver.findElement(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/form/div/div[2]/div[2]/div/div/div[2]/div/div")).click();
		
		// Click Format
		//driver.findElement(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/form/div/div[2]/div/div/table/tbody/tr/td/table/tbody/tr/td[5]/table/tbody/tr[2]/td[2]/em/button")).click();		
//		driver.findElement(By.xpath("//body/div[18]/div[2]/div/div/div/div/div/div/form/div[2]/div/div/input[2]")).click();
		//driver.findElement(By.xpath("//button[contains(text(), 'Confirm')]")).click();
		

//		if(isElementPresent(By.xpath("//body/div[18]/div[2]/div[2]/div/div/div/div/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[2]/td[2]/em/button"))) {
//			System.out.println("È®ÀÎ¹öÆ°ÀÌ Á¸ÀçÇÕ´Ï´Ù.");			
//		}		
		
		//////////////////////////////////////////////////////////////////////
		// È®ÀÎ¹öÆ°, Ãë¼Ò¹öÆ° Å¬¸¯ÀÌ ¾ÈµÊ
		//////////////////////////////////////////////////////////////////////
		
//		driver.findElement(By.xpath("//body/div[19]/div[2]/div[2]/div/div/div/div/table/tbody/tr/td[2]/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[2]/td[2]/em/button")).click(); // È®ÀÎ ¹öÆ° Å¬¸¯
		//driver.findElement(By.id("ext-gen249")).click();
		//System.out.println("È®ÀÎ");

		
//		if (isElementPresent(By.xpath("//body/div[20]/div/div"))) {
//			driver.findElement(By.xpath("//body/div[20]/div/div")).click(); // XFS Å¬¸¯
//			driver.findElement(By.xpath("//body/div[18]/div[2]/div[2]/div/div/div/div/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[2]/td[2]/em/button")).click(); // È®ÀÎ ¹öÆ° Å¬¸¯
//		}
		
		//System.out.println("Á¤»óÀûÀ¸·Î Æ÷¸ËÇÏ¿´½À´Ï´Ù.");
		
//		driver.findElement(By.xpath("//body/div[18]/div[2]/div[2]/div/div/div/div/table/tbody/tr/td[2]/table/tbody/tr/td/table/tbody/tr/td[2]/table/tbody")).click(); // Ãë¼Ò ¹öÆ° Å¬¸¯
		// After
		//driver.quit();
		
	}

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
