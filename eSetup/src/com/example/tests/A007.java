//Volume tab can show volume information normally?
//볼륨텝의 볼륨정보가 정상적으로 출력 되는가?

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


public class A007 extends System_Information {
	private static StringBuffer verificationErrors = new StringBuffer();
	private static String volumeName = "", totalSize = "", used = "", unused = "", rate = "", NoVol = "";
	private static String [] VolumeInfo = {"", "", "", "", "", "", ""};
	int Number_of_Volume;
		
	//public static void main(String []args) throws Exception {
	public void A007() throws InterruptedException{
		System.out.println("*****************************************************************");
		System.out.println("*                             Volume                            *");
		System.out.println("*****************************************************************");
		System.out.println("Test A007 - Resource Monitor -> Volume");
		System.out.println("Volume tab can show volume information normally? \n" +
				"볼륨텝의 볼륨정보가 정상적으로 출력 되는가? \n");	
		
		//driver.findElement(By.xpath("//ul[@id='ext-gen78']/div/li/ul/li[2]/div/a/span")).click();
		driver.findElement(By.linkText("Resource Monitor")).click();
		
		//driver.findElement(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div/div/div/ul/li[4]/a[2]/em/span/span")).click();
		driver.findElement(By.linkText("Volume")).click();


		System.out.println("----------------------------------------");
		System.out.println("Volume Usage");
		System.out.println("----------------------------------------");
		System.out.println("VolName \tSize \t\tUsed \t\tUnused \t\tRate");
		
		for (int i =1; i<=6; i++){
			Number_of_Volume = i;
			if (!isElementNotPresent(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[4]/div/div/div/div[2]/div/div/div/div[2]/div/div[" + i +"]/table/tbody/tr/td/div"))){
				if (i==1)
					NoVol = "-------------- No volume available ----------------";
				else
					NoVol = "-------------- No more volume available ----------------";
				break;
			}else{
				volumeName = driver.findElement(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[4]/div/div/div/div[2]/div/div/div/div[2]/div/div[" + i +"]/table/tbody/tr/td/div")).getText();
				totalSize = driver.findElement(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[4]/div/div/div/div[2]/div/div/div/div[2]/div/div[" + i +"]/table/tbody/tr/td[2]/div")).getText();		
				used = driver.findElement(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[4]/div/div/div/div[2]/div/div/div/div[2]/div/div[" + i +"]/table/tbody/tr/td[3]/div")).getText();
				unused = driver.findElement(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[4]/div/div/div/div[2]/div/div/div/div[2]/div/div[" + i +"]/table/tbody/tr/td[4]/div")).getText();
		//		rate = driver.findElement(By.id("ext-gen276")).getText();
				//rate = driver.findElement(By.xpath("//div[@class='x-progress-text x-progress-text-back']")).getText();
				rate = driver.findElement(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[4]/div/div/div/div[2]/div/div/div/div[2]/div/div[" + i +"]/table/tbody/tr/td[5]/div/div/div/div[2]")).getText();
				VolumeInfo [i-1] =  volumeName + " \t" + totalSize + " \t" + used + " \t" + unused + " \t" + rate;
				System.out.println(VolumeInfo [i-1]);
			}
		}
		System.out.println(NoVol);
		
		//volumeName = driver.findElement(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[4]/div/div/div/div[2]/div/div/div/div[2]/div/div[2]/table/tbody/tr/td/div")).getText();
		//totalSize = driver.findElement(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[4]/div/div/div/div[2]/div/div/div/div[2]/div/div[2]/table/tbody/tr/td[2]/div")).getText();		
		//used = driver.findElement(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[4]/div/div/div/div[2]/div/div/div/div[2]/div/div[2]/table/tbody/tr/td[3]/div")).getText();
		//unused = driver.findElement(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[4]/div/div/div/div[2]/div/div/div/div[2]/div/div[2]/table/tbody/tr/td[4]/div")).getText();
//		rate = driver.findElement(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div/div/div/ul/li[4]/a[2]/em/span/span")).getText();		
		//rate = driver.findElement(By.xpath("//div[@class='x-progress-text x-progress-text-back']")).getText();
		//System.out.println(volumeName + "\t\t" + totalSize + "\t" + used + "\t" + unused + "\t" + "rate");
		
		try {
	        BufferedWriter out = new BufferedWriter(new FileWriter("D:\\System_Information.txt", true));
	            out.write("\r\n*****************************************************************\r\n");
		        out.write("*                               Volume                          *\r\n");
		        out.write("*****************************************************************\r\n");
		        out.write("Test A007 - System Status -> Volume \r\n");
		        out.write("Volume tab can show volume information normally? \r\n" +
							"볼륨텝의 볼륨정보가 정상적으로 출력 되는가?\r\n");
		        out.write("=================================================================\r\n");
                out.write("VolName \tSize \t\tUsed \t\tUnused \t\tRate\r\n");
                for (int j =0; j<Number_of_Volume; j++){
                	out.write(VolumeInfo[j] + "\r\n");
                }
                out.write(NoVol + "\r\n");
	            out.close();
	        } catch (IOException e) {}
		
		
		// After
		//driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
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
}
