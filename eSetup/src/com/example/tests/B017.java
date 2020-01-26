//After selecting usb disk "Activate", "De-activate" can be done normally?
//usb 디스크를 선택후 활성화, 비활성화 동작이 정상적인가? 

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

public class B017 extends System_Setting {
//	private static WebDriver driver;
//	private static String baseUrl;
//	private static StringBuffer verificationErrors = new StringBuffer();
	
	private static String DiskName = "", VolAssign = "", successMsg = "", NoUSB = "", status = "", result = "";
	private static String [] USBInfo = {"", "", "", "", "", "", ""};
	private static String [] USBStatus = {"", "", "", "", "", "", ""};
	static int Number_of_USB;


	
	//public static void main(String[] args) throws InterruptedException {
	public void B017() throws InterruptedException{
		System.out.println("*****************************************************************");
		System.out.println("*                    USB Activate/Deactivate                    *");
		System.out.println("*****************************************************************");
		System.out.println("Test B017 - System -> External Device ");
		System.out.println("After selecting usb disk 'Activate', 'De-activate' can be done normally? \n" +
				"usb 디스크를 선택후 활성화, 비활성화 동작이 정상적인가? \n" + 
				"--------------------------------------------------------\n");
		// Before
//		driver = new FirefoxDriver();
//		baseUrl = "http://192.168.1.9:9000";
//		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//		
//		// Test
//		driver.get(baseUrl + "/");
//		driver.findElement(By.id("login_userid")).clear();
//		driver.findElement(By.id("login_userid")).sendKeys("admin");
//		driver.findElement(By.id("login_password")).clear();
//		driver.findElement(By.id("login_password")).sendKeys("admin");
//		driver.findElement(By.cssSelector("input.btn_login")).click();
//		for (int second = 0;; second++) {
//			if (second >= 60) fail("timeout");
//			try { if (isElementPresent(By.name("icon_esetup"))) break; } catch (Exception e) {}
//			Thread.sleep(1000);
//		}

//		driver.findElement(By.name("icon_esetup")).click();
		
		driver.findElement(By.xpath("//body/div/div[2]/div/div/div/div/ul/div/li[2]/ul/li[3]/div/a/span")).click();	// External Disk menu
		Thread.sleep(3000);
		
		//When can't fetch disk information
		if (isElementPresent(By.xpath("//body/div[16]/div[2]/div/div/div/div/div/div[2]/span"))){
			successMsg = driver.findElement(By.xpath("//body/div[16]/div[2]/div/div/div/div/div/div[2]/span")).getText();
			System.out.println("Output : " + successMsg);
			driver.findElement(By.xpath("//button[contains(text(), 'OK')]")).click();
		}
		
		for (int i =1; i<=6; i++){
			Number_of_USB = i-1;
			if (!isElementPresent(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/form/div/div[2]/div[2]/div/div/div[2]/div/div[" + i + "]/table/tbody/tr/td/div"))){
				if (i==1)
					NoUSB = "-------------- No USB Connected ----------------";
				else
					NoUSB = "Total number of USB :" + Number_of_USB;
				break;
			}else{
				DiskName = driver.findElement(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/form/div/div[2]/div[2]/div/div/div[2]/div/div[" + i + "]/table/tbody/tr/td/div")).getText();
				VolAssign = driver.findElement(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/form/div/div[2]/div[2]/div/div/div[2]/div/div[" + i + "]/table/tbody/tr/td[8]/div")).getText();		
				System.out.println("DiskName \t volume Assign " );	
				//System.out.println(DiskName + "\t\t" + VolAssign);
				USBInfo [i-1] =  DiskName + " \t\t " + VolAssign;
				System.out.println(USBInfo [i-1]);
				if (VolAssign.equals("No")){
					status = "USB is not activated currently.";
					
					//select disk
					driver.findElement(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/form/div/div[2]/div[2]/div/div/div[2]/div/div[" + i + "]")).click();
					// Click activate
					driver.findElement(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/form/div/div[2]/div/div/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[2]/td[2]/em/button")).click();
					Thread.sleep(1000);
					
					//successMsg = driver.findElement(By.xpath("//body/div[21]/div[2]/div/div/div/div/div/div[2]/span")).getText();
					//System.out.println("Output : " + successMsg);
					driver.findElement(By.xpath("//button[contains(text(), 'OK')]")).click();		
					
					Thread.sleep(3000);
					VolAssign = driver.findElement(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/form/div/div[2]/div[2]/div/div/div[2]/div/div[" + i + "]/table/tbody/tr/td[8]/div")).getText();
					Thread.sleep(3000);
					if (VolAssign.equals("Yes"))
						result = "USB activated SUCCESSFULLY.";
					else
						result = "USB activation FAILED.";
					
					USBStatus [i-1] = status +"\r\n"+ result;
				}else if (VolAssign.equals("Yes")){
					status = "USB is activated currently.";
					//select disk
					driver.findElement(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/form/div/div[2]/div[2]/div/div/div[2]/div/div[" + i + "]")).click();
					// Click Deactivate
					driver.findElement(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/form/div/div[2]/div/div/table/tbody/tr/td/table/tbody/tr/td[3]/table/tbody/tr[2]/td[2]/em/button")).click();	
					Thread.sleep(1000);
					
					//successMsg = driver.findElement(By.xpath("/html/body/div[21]/div[2]/div/div/div/div/div/div[2]/span")).getText();
					//System.out.println("Output : " + successMsg);
					driver.findElement(By.xpath("//button[contains(text(), 'OK')]")).click();
					
					Thread.sleep(3000);
					VolAssign = driver.findElement(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/form/div/div[2]/div[2]/div/div/div[2]/div/div[" + i + "]/table/tbody/tr/td[8]/div")).getText();
					//System.out.println("=========" + VolAssign);
					Thread.sleep(3000);
					if (VolAssign.equals("No"))
						result = "USB diactivated SUCCESSFULLY.";
					else
						result = "USB Diactivation FAILED.";
					USBStatus [i-1] = status +"\r\n"+ result;
				}
				System.out.println(USBStatus [i-1] +"\n"+
				"------------------------------------------------");
			}
		}
		System.out.println(NoUSB);
		
		try {
	        BufferedWriter out = new BufferedWriter(new FileWriter("D:\\System_Setting.txt", true));
	            out.write("\r\n*****************************************************************\r\n");
		        out.write("*                        USB Activate/Deactivate                    *\r\n");
		        out.write("*****************************************************************\r\n");
		        out.write("Test B017 - System -> External Device \r\n");
		        out.write("After selecting usb disk 'Activate', 'De-activate' can be done normally? \r\n" +
							"usb 디스크를 선택후 활성화, 비활성화 동작이 정상적인가?\r\n");
		        out.write("=================================================================\r\n");
                for (int j =0; j<Number_of_USB; j++){
                	out.write("DiskName \t volume Assign \r\n" );
                	out.write(USBInfo[j] + "\r\n" + USBStatus [j] +"\r\n");
                	out.write("---------------------------------------------\r\n" );
                }
                out.write(NoUSB + "\r\n");
	            out.close();
	        } catch (IOException e) {}
		
		//After
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
