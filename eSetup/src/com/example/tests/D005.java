//Can it save all FTP setting value properly?
//입력한 정보가 정상적으로 저장 되는가?
		
package com.example.tests;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class D005 extends Network_Service{
	private static String systemOut = "", successMsg = "";
	private static String PassivePortFrom = "", PassivePortTo = "", FTPport = "", MaxConn = "", MaxConnUser = "", DownRate = "", UpRate = "", AnonymousLogin = "";
	
	public void D005() throws InterruptedException, IOException{
		System.out.println("*****************************************************************");
		System.out.println("*                          FTP Setting                          *");
		System.out.println("*****************************************************************");
		System.out.println("Test D005 - Network Settings->FTP");
		System.out.println("Can it save all FTP setting value properly?\n" +
				"입력한 정보가 정상적으로 저장 되는가?\n" +
				"---------------------------------------------------------------");
		
		BufferedReader br = new BufferedReader(new FileReader("D:\\ServiceConf.txt"));
		try {
	        for (int i=1; i<=18; i++){
	        	String line = br.readLine();
	        	if (i > 10){
		        	//System.out.println(line + "\n");
		        	String[] tokens = line.split("=");
	            	if (tokens[0].equals("PassivePortFrom")){
	            		PassivePortFrom = tokens[1];
		        	}else if (tokens[0].equals("PassivePortTo")){
		        		PassivePortTo = tokens[1];
		        	}else if (tokens[0].equals("FTPport")){
		        		FTPport = tokens[1];
		        	}else if (tokens[0].equals("MaxConn")){
		        		MaxConn = tokens[1];
		        	}else if (tokens[0].equals("MaxConnUser")){
		        		MaxConnUser = tokens[1];
		        	}else if (tokens[0].equals("DownRate")){
		        		DownRate = tokens[1];
		        	}else if (tokens[0].equals("UpRate")){
		        		UpRate = tokens[1];
		        	}else if (tokens[0].equals("AnonymousLogin")){
		        		AnonymousLogin = tokens[1];
		        	}
	        	}
	        }
	    } finally {
	        br.close();
	    }
		

//		try {
//	        BufferedWriter out = new BufferedWriter(new FileWriter("D:\\Nerwork_Service.txt", true));
//	        	out.write("*****************************************************************\r\n");
//		        out.write("*                                FTP                            *\r\n");
//		        out.write("*****************************************************************\r\n");
//		        out.write("Test D006 - Network Settings->FTP \r\n");
//		        out.write("Can it save all FTP setting value properly? \r\n" +
//						"입력한 정보가 정상적으로 저장 되는가?\r\n");
//		        out.write("=================================================================\r\n");
//		        out.write("--------------------------Before System Status-------------------\r\n");
//		        out.write("FTP \t\t" + bActive + "\t" + bStatus + "\r\n");
//		        out.write("System Output: " + systemOut + "\r\n");
//		        out.write("--------------------------After System Status--------------------\r\n");
//		        out.write("FTP \t\t" + aActive + "\t" + aStatus + "\r\n");
//		        out.write(successMsg + "\r\n");
//	            out.close();
//	        } catch (IOException e) {}

				
		//System status
//		driver.findElement(By.xpath("//span[contains(text(), 'System Status')]")).click();
//		driver.findElement(By.cssSelector(".ext-strict body#ext-gen11.ext-gecko div#content-panel.x-panel div#ext-gen28.x-panel-bwrap div#ext-gen29.x-panel-body div#systemInfo-panel.x-panel div#ext-gen32.x-panel-bwrap div#ext-gen33.x-panel-body div#ext-comp-1009.x-tab-panel div#ext-gen36.x-tab-panel-header div#ext-gen39.x-tab-strip-wrap ul#ext-gen41.x-tab-strip li#ext-comp-1009__ext-comp-1012 a#ext-gen49.x-tab-right em.x-tab-left span.x-tab-strip-inner span.x-tab-strip-text")).click();		
//		Thread.sleep(2000);
//		System.out.println("----------------------------------------");
//		System.out.println("Before System Status");
//		System.out.println("----------------------------------------");
//		String bActive = driver.findElement(By.xpath("//body/div[2]/div/div/div/div[2]/div/div/div[2]/div/div[2]/div/div/div/div/form/div/div[2]/div/div/div/div[2]/div/div[4]/table/tbody/tr/td[2]/div")).getText();
//		String bStatus = driver.findElement(By.xpath("//body/div[2]/div/div/div/div[2]/div/div/div[2]/div/div[2]/div/div/div/div/form/div/div[2]/div/div/div/div[2]/div/div[4]/table/tbody/tr/td[3]/div")).getText();
//		System.out.println("ftp \t\t" + bActive + "\t" + bStatus);
//
//		pageRefresh();
		
		// Click FTP menu
		driver.findElement(By.xpath("//span[contains(text(), 'FTP')]")).click();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

		try{
			Thread.sleep(3000);
		} catch(Exception e) {}
		
		// Click CheckBox
		if (!driver.findElement(By.xpath("//*[@name='ftpenable']")).isSelected())
			driver.findElement(By.xpath("//*[@name='ftpenable']")).click();
		
		Thread.sleep(2000);
		
		if (!driver.findElement(By.id("passiveEnable")).isSelected())
			driver.findElement(By.id("passiveEnable")).click();
		
		Thread.sleep(2000);
		driver.findElement(By.id("passiveportstart")).clear();
		driver.findElement(By.id("passiveportstart")).sendKeys(PassivePortFrom);
		
		driver.findElement(By.id("passiveportend")).clear();
		driver.findElement(By.id("passiveportend")).sendKeys(PassivePortTo);
		
		if (!driver.findElement(By.id("ssltls")).isSelected())
			driver.findElement(By.id("ssltls")).click();
		
		if (AnonymousLogin.equals("Yes") & !driver.findElement(By.id("anonymous")).isSelected())
			driver.findElement(By.id("anonymous")).click();
		
		driver.findElement(By.id("port")).clear();
		driver.findElement(By.id("port")).sendKeys(FTPport);
		
		driver.findElement(By.id("maxconnect")).clear();
		driver.findElement(By.id("maxconnect")).sendKeys(MaxConn);
		
		driver.findElement(By.id("maxuserconnect")).clear();
		driver.findElement(By.id("maxuserconnect")).sendKeys(MaxConnUser);
		
		driver.findElement(By.id("downloadlimit")).clear();
		driver.findElement(By.id("downloadlimit")).sendKeys(DownRate);
		
		driver.findElement(By.id("uploadlimit")).clear();
		driver.findElement(By.id("uploadlimit")).sendKeys(UpRate);
		
		// Click Confirm
		driver.findElement(By.xpath("//button[contains(text(), 'Confirm')]")).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		try{
			Thread.sleep(3000);
		} catch(Exception e) {}
		
		Thread.sleep(3000);
		
		if (isElementPresent(By.xpath("//body/div[13]/div[2]/div/div/div/div/div/div[2]/span"))){
			systemOut = driver.findElement(By.xpath("//body/div[13]/div[2]/div/div/div/div/div/div[2]/span")).getText();		
		}
		// Click Ok
		driver.findElement(By.xpath("//button[contains(text(), 'OK')]")).click();
		System.out.println("System Output: " + systemOut);
		
		pageRefresh();
		Thread.sleep(3000);
		
		
		driver.findElement(By.xpath("//span[contains(text(), 'FTP')]")).click();
		
		Thread.sleep(2000);
		
		String passiveportstart = driver.findElement(By.id("passiveportstart")).getAttribute("value").toString();
		String passiveportend = driver.findElement(By.id("passiveportend")).getAttribute("value").toString();
		String port = driver.findElement(By.id("port")).getAttribute("value").toString();
		String maxconnect = driver.findElement(By.id("maxconnect")).getAttribute("value").toString();
		String maxuserconnect = driver.findElement(By.id("maxuserconnect")).getAttribute("value").toString();
		String downloadlimit = driver.findElement(By.id("downloadlimit")).getAttribute("value").toString();
		String uploadlimit = driver.findElement(By.id("uploadlimit")).getAttribute("value").toString();
		
		
		if (PassivePortFrom.equals(passiveportstart) & PassivePortTo.equals(passiveportend)){
			passiveportstart = "Passive port range setting is OK (" + passiveportstart + "~" + passiveportend + ")";
		} else {
			passiveportstart = "Passive port range setting Fail";
		}
		System.out.println(passiveportstart);
		
		if (FTPport.equals(port)){
			port = "FTP Port setting is OK (" + port + ")";
		} else {
			port = "FTP port setting Fail";
		}
		System.out.println(port);
		
		if (MaxConn.equals(maxconnect)) {
			maxconnect = "Max number of connection setting is OK (" + maxconnect + ")";
		} else {
			maxconnect = "Max number of connection setting Fail";
		}
		System.out.println(maxconnect);

		if (MaxConnUser.equals(maxuserconnect)) {
			maxuserconnect = "Max connection per user setting is OK (" + maxuserconnect + ")";
		} else {
			maxuserconnect = "Max connection per user setting Fail";
		}
		System.out.println(maxuserconnect);
		
		if (DownRate.equals(downloadlimit)) {
			downloadlimit = "Max download per connection setting is OK (" + downloadlimit + ")";
		} else {
			downloadlimit = "Max download per connection setting Fail";
		}
		System.out.println(downloadlimit);
		
		if (UpRate.equals(uploadlimit)) {
			uploadlimit = "Max upload per connection setting is OK (" + uploadlimit + ")";
		} else {
			uploadlimit = "Max upload per connection setting Fail";
		}
		System.out.println(uploadlimit);

		
		
		
		
//
//		//System status
//		driver.findElement(By.xpath("//span[contains(text(), 'System Status')]")).click();
//		driver.findElement(By.cssSelector(".ext-strict body#ext-gen11.ext-gecko div#content-panel.x-panel div#ext-gen28.x-panel-bwrap div#ext-gen29.x-panel-body div#systemInfo-panel.x-panel div#ext-gen32.x-panel-bwrap div#ext-gen33.x-panel-body div#ext-comp-1009.x-tab-panel div#ext-gen36.x-tab-panel-header div#ext-gen39.x-tab-strip-wrap ul#ext-gen41.x-tab-strip li#ext-comp-1009__ext-comp-1012 a#ext-gen49.x-tab-right em.x-tab-left span.x-tab-strip-inner span.x-tab-strip-text")).click();		
//
//		System.out.println("----------------------------------------");
//		System.out.println("After System Status");
//		System.out.println("----------------------------------------");
//		String aActive = driver.findElement(By.xpath("//body/div[2]/div/div/div/div[2]/div/div/div[2]/div/div[2]/div/div/div/div/form/div/div[2]/div/div/div/div[2]/div/div[4]/table/tbody/tr/td[2]/div")).getText();
//		String aStatus = driver.findElement(By.xpath("//body/div[2]/div/div/div/div[2]/div/div/div[2]/div/div[2]/div/div/div/div/form/div/div[2]/div/div/div/div[2]/div/div[4]/table/tbody/tr/td[3]/div")).getText();
//		System.out.println("ftp \t\t" + aActive + "\t" + aStatus);
//		
//		if (bActive.equals(aActive) & bStatus.equals(aStatus)){
//			successMsg = "FFP setting failed";
//		}else{
//			successMsg = "FTP setting Successfull";
//		}
//		System.out.println(successMsg);
		
		try {
	        BufferedWriter out = new BufferedWriter(new FileWriter("D:\\Nerwork_Service.txt", true));
	        	out.write("*****************************************************************\r\n");
		        out.write("*                            FTP Setting                        *\r\n");
		        out.write("*****************************************************************\r\n");
		        out.write("Test D005 - Network Settings->FTP \r\n");
		        out.write("Can it save all FTP setting value properly? \r\n" +
						"입력한 정보가 정상적으로 저장 되는가?\r\n");
		        out.write("=================================================================\r\n");
//		        out.write("--------------------------Before System Status-------------------\r\n");
//		        out.write("FTP \t\t" + bActive + "\t" + bStatus + "\r\n");
		        out.write("System Output: " + systemOut + "\r\n" + passiveportstart + "\r\n" + port + "\r\n" 
		        		+ maxconnect + "\r\n" + maxuserconnect + "\r\n" + downloadlimit + "\r\n" + uploadlimit + "\r\n");
//		        out.write("--------------------------After System Status--------------------\r\n");
//		        out.write("FTP \t\t" + aActive + "\t" + aStatus + "\r\n");
//		        out.write(successMsg + "\r\n");
	            out.close();
	        } catch (IOException e) {}

	}
}

