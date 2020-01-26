//Deactivation disables the CIFS service?
//활성화 제거시 설정정보 내용은 disable이 정상적으로 되는가? 

package com.example.tests;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

public class D002 extends Network_Service{
	private static String systemOut = "", successMsg = "";
	
	public void D002() throws InterruptedException{
		System.out.println("*****************************************************************");
		System.out.println("*                            CIFS Setting                       *");
		System.out.println("*****************************************************************");
		System.out.println("Test D002 - Network Services -> CIFS");
		System.out.println("Deactivation disables the CIFS service? \n" +
				"활성화 제거시 설정정보 내용은 disable이 정상적으로 되는가?\n");
				
		driver.findElement(By.linkText("System Status")).click();
		driver.findElement(By.linkText("Service Status")).click();		
		
		Thread.sleep(3000);
		System.out.println("----------------------------------------");
		System.out.println("System Status before change");
		System.out.println("----------------------------------------");
		String bActive = driver.findElement(By.xpath("//body/div[2]/div/div/div/div[2]/div/div/div[2]/div/div[2]/div/div/div/div/form/div/div[2]/div/div/div/div[2]/div/div/table/tbody/tr/td[2]/div")).getText();
		String bStatus = driver.findElement(By.xpath("//body/div[2]/div/div/div/div[2]/div/div/div[2]/div/div[2]/div/div/div/div/form/div/div[2]/div/div/div/div[2]/div/div/table/tbody/tr/td[3]/div")).getText();		
		System.out.println("cifs \t\t" + bActive + "\t" + bStatus);

		pageRefresh();
		
		// Click CIFS menu
		driver.findElement(By.xpath("//span[contains(text(), 'CIFS')]")).click();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

		try{
			Thread.sleep(1000);
		} catch(Exception e) {}
		
		// Click CheckBox
		if (driver.findElement(By.xpath("//*[@id='cifsenable']")).isSelected()){
			driver.findElement(By.xpath("//*[@id='cifsenable']")).click();
		
		
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
			try{
				Thread.sleep(1000);
			} catch(Exception e) {}
			// Click Confirm
			driver.findElement(By.xpath("//button[contains(text(), 'Confirm')]")).click();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			
			Thread.sleep(3000);
			
			if (isElementPresent(By.xpath("//body/div[13]/div[2]/div/div/div/div/div/div[2]/span"))){
				systemOut = driver.findElement(By.xpath("//body/div[13]/div[2]/div/div/div/div/div/div[2]/span")).getText();		
			}
			
			// Click Ok
			driver.findElement(By.xpath("//button[contains(text(), 'OK')]")).click();
		}else{
			systemOut = "CIFS service is already disabled!";
		}
		System.out.println(systemOut);
		
		pageRefresh();

		//System status
		driver.findElement(By.xpath("//span[contains(text(), 'System Status')]")).click();
		driver.findElement(By.cssSelector(".ext-strict body#ext-gen11.ext-gecko div#content-panel.x-panel div#ext-gen28.x-panel-bwrap div#ext-gen29.x-panel-body div#systemInfo-panel.x-panel div#ext-gen32.x-panel-bwrap div#ext-gen33.x-panel-body div#ext-comp-1009.x-tab-panel div#ext-gen36.x-tab-panel-header div#ext-gen39.x-tab-strip-wrap ul#ext-gen41.x-tab-strip li#ext-comp-1009__ext-comp-1012 a#ext-gen49.x-tab-right em.x-tab-left span.x-tab-strip-inner span.x-tab-strip-text")).click();		
		
		Thread.sleep(3000);
		System.out.println("----------------------------------------");
		System.out.println("After System Status");
		System.out.println("----------------------------------------");
		String aActive = driver.findElement(By.xpath("//body/div[2]/div/div/div/div[2]/div/div/div[2]/div/div[2]/div/div/div/div/form/div/div[2]/div/div/div/div[2]/div/div/table/tbody/tr/td[2]/div")).getText();
		String aStatus = driver.findElement(By.xpath("//body/div[2]/div/div/div/div[2]/div/div/div[2]/div/div[2]/div/div/div/div/form/div/div[2]/div/div/div/div[2]/div/div/table/tbody/tr/td[3]/div")).getText();		
		System.out.println("cifs \t\t" + aActive + "\t" + aStatus);
		
		if (!systemOut.equals("CIFS service is already disabled!")){
			if (bActive.equals(aActive) & bStatus.equals(aStatus)){
				successMsg = "CIFS deactivation failed";
			}else{
				successMsg = "CIFS deactivation Successfull";
			}
		}
		System.out.println(successMsg);
		
		try {
	        BufferedWriter out = new BufferedWriter(new FileWriter("D:\\Nerwork_Service.txt", true));
	        	out.write("*****************************************************************\r\n");
		        out.write("*                            CIFS Setting                       *\r\n");
		        out.write("*****************************************************************\r\n");
		        out.write("Test D002 - Network Services -> CIFS \r\n");
		        out.write("Deactivation disables the CIFS service? \r\n" +
						"활성화 제거시 설정정보 내용은 disable이 정상적으로 되는가?\r\n");
		        out.write("=================================================================\r\n");
		        out.write("--------------------------System Status before Update-------------------\r\n");
		        out.write("cifs \t\t" + bActive + "\t" + bStatus + "\r\n");
		        out.write("System Output: " + systemOut + "\r\n");
		        out.write("--------------------------System Status after Update--------------------\r\n");
		        out.write("cifs \t\t" + aActive + "\t" + aStatus + "\r\n");
		        out.write(successMsg + "\r\n");
	            out.close();
	        } catch (IOException e) {}
	}
}
