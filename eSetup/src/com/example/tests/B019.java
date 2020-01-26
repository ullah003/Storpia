//USB disks and volumes are normally displayed?
//usb 디스크와 볼륨은 정상적으로 표시 되는가?

package com.example.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class B019 {
	private static WebDriver driver;
	private static String baseUrl, systemOut = "";
	private static StringBuffer verificationErrors = new StringBuffer();	
	
	public static void main(String[] args) throws InterruptedException {
		// Before
		driver = new FirefoxDriver();
		baseUrl = "http://192.168.1.84:9000/";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		// Test
		driver.get(baseUrl + "/");
		driver.findElement(By.id("login_userid")).clear();
		driver.findElement(By.id("login_userid")).sendKeys("admin");
		driver.findElement(By.id("login_password")).clear();
		driver.findElement(By.id("login_password")).sendKeys("admin");
		driver.findElement(By.cssSelector("input.btn_login")).click();
		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout");
			try { if (isElementPresent(By.name("icon_esetup"))) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}

		driver.findElement(By.name("icon_esetup")).click();
		
		driver.findElement(By.xpath("//body/div/div[2]/div/div/div/div/ul/div/li[2]/ul/li[3]/div/a/span")).click();	
		
		//When can't fetch disk information
		if (isElementPresent(By.xpath("//body/div[16]/div[2]/div/div/div/div/div/div[2]/span"))){
			systemOut = driver.findElement(By.xpath("//body/div[16]/div[2]/div/div/div/div/div/div[2]/span")).getText();
			System.out.println("Output : " + systemOut);
			Thread.sleep(3000);
			if (isElementPresent(By.xpath("//button[contains(text(), 'OK')]"))){
				driver.findElement(By.xpath("//button[contains(text(), 'OK')]")).click();
			}
		}else{
			for (int i =1; i<=6; i++){
				if (!isElementPresent(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/form/div/div[2]/div[2]/div/div/div[2]/div/div[" + i + "]/table/tbody/tr/td/div"))){
					if (i==1)
						System.out.println("-------------- No USB Connected ----------------");
					else
						System.out.println("-------------- No more USB Connected ----------------");
					break;
				}else{
					String diskName = driver.findElement(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/form/div/div[2]/div[2]/div/div/div[2]/div/div[" + i + "]/table/tbody/tr/td/div")).getText();
					String deviceName = driver.findElement(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/form/div/div[2]/div[2]/div/div/div[2]/div/div[" + i + "]/table/tbody/tr/td[2]/div")).getText();
					String model = driver.findElement(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/form/div/div[2]/div[2]/div/div/div[2]/div/div[" + i + "]/table/tbody/tr/td[3]/div")).getText();
					String capacity = driver.findElement(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/form/div/div[2]/div[2]/div/div/div[2]/div/div[" + i + "]/table/tbody/tr/td[4]/div")).getText();
					String partition = driver.findElement(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/form/div/div[2]/div[2]/div/div/div[2]/div/div[" + i + "]/table/tbody/tr/td[5]/div")).getText();
					String partitionSize = driver.findElement(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/form/div/div[2]/div[2]/div/div/div[2]/div/div[" + i + "]/table/tbody/tr/td[6]/div")).getText();
					String fileSystem = driver.findElement(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/form/div/div[2]/div[2]/div/div/div[2]/div/div[" + i + "]/table/tbody/tr/td[7]/div")).getText();
					String volumeAssign = driver.findElement(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/form/div/div[2]/div[2]/div/div/div[2]/div/div[" + i + "]/table/tbody/tr/td[8]/div")).getText();
					
					System.out.println("Disk Name : " + diskName);
					System.out.println("Device Name : " + deviceName);
					System.out.println("Model : " + model);
					System.out.println("Capacity : " + capacity);
					System.out.println("Partition : " + partition);
					System.out.println("Partition Size : " + partitionSize);
					System.out.println("File System : " + fileSystem);
					System.out.println("Volume Assign : " + volumeAssign);
					System.out.println();
				}
				
			}
		}
			
		for (int i =1; i<=6; i++){
			if (!isElementPresent(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/form/div[2]/div[2]/div/div/div/div[2]/div/div[" + i + "]/table/tbody/tr/td/div"))){
				if (i==1)
					System.out.println("-------------- No usbvolume available ----------------");
				else
					System.out.println("-------------- No more usbvolume available ----------------");
				break;
			}else{
				String volumeName = driver.findElement(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/form/div[2]/div[2]/div/div/div/div[2]/div/div[" + i + "]/table/tbody/tr/td/div")).getText();
				String volumeFileSystem = driver.findElement(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/form/div[2]/div[2]/div/div/div/div[2]/div/div[" + i + "]/table/tbody/tr/td[2]/div")).getText();
				String volumeTotalSize = driver.findElement(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/form/div[2]/div[2]/div/div/div/div[2]/div/div[" + i + "]/table/tbody/tr/td[3]/div")).getText();
				String volumeSpaceLeft = driver.findElement(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/form/div[2]/div[2]/div/div/div/div[2]/div/div[" + i + "]/table/tbody/tr/td[4]/div")).getText();
				String volumeMountStatus = driver.findElement(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/form/div[2]/div[2]/div/div/div/div[2]/div/div[" + i + "]/table/tbody/tr/td[5]/div")).getText();
				String volumeDisk = driver.findElement(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/form/div[2]/div[2]/div/div/div/div[2]/div/div[" + i + "]/table/tbody/tr/td[6]/div")).getText();
				String volumeStatus = driver.findElement(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/form/div[2]/div[2]/div/div/div/div[2]/div/div[" + i + "]/table/tbody/tr/td[7]/div")).getText();
				
				System.out.println("Volume Name : " + volumeName);
				System.out.println("File System : " + volumeFileSystem);
				System.out.println("Total Size : " + volumeTotalSize);
				System.out.println("Space Left : " + volumeSpaceLeft);
				System.out.println("Mount status : " + volumeMountStatus);
				System.out.println("Disk : " + volumeDisk);
				System.out.println("Status : " + volumeStatus);	
			}
		}
				
		//After
		//driver.quit();
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
