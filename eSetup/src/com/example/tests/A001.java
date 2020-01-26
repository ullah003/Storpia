//It shows each and every information listed about the system?
//시스템 정보 내용이 빠짐없이 출력이 되는가? 
//(서버명, 모델명, 펌웨어버전, 펌웨어날짜)
//모델명은 현재 존재하는 모델명으로 되어 있는가?

package com.example.tests;

import java.io.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;

public class A001 extends System_Information {

	//private static WebDriver driver;
	//private static String baseUrl, userID, userPass;
	private static StringBuffer verificationErrors = new StringBuffer();
	private static String ServerName = "", ServerModel = "", FWVersion = "", FWDate = "";

	
	public void A001() throws InterruptedException{
		System.out.println("*****************************************************************");
		System.out.println("*                         System Information                    *");
		System.out.println("*****************************************************************");
		System.out.println("Test A001 - System Status -> Product");
		System.out.println("It shows each and every information listed about the system? \n" +
				"시스템 정보 내용이 빠짐없이 출력이 되는가?\n" + 
				"(서버명, 모델명, 펌웨어버전, 펌웨어날짜)\n" +
				"모델명은 현재 존재하는 모델명으로 되어 있는가?\n");
		
		
//		BufferedReader br = new BufferedReader(new FileReader("C:\\Temp\\config.txt"));
//	    try {
//	        for (int i=0; i<=2; i++){
//	        	String line = br.readLine();
//	        	String[] tokens = line.split("=");
//            	if (tokens[0].equals("url")){
//	        		baseUrl = tokens[1];
//	        		System.out.println("url" + baseUrl);
//	        	}else if (tokens[0].equals("ID")){
//	        		userID = tokens[1];
//	        		System.out.println("ID" + userID);
//	        	}else if (tokens[0].equals("passwd")){
//	        		userPass = tokens[1];
//	        		System.out.println("pass" + userPass);
//	        	}
//	        }
//	    } finally {
//	        br.close();
//	    }
		
		
		// Test
//		driver.get(baseUrl);
//		driver.findElement(By.id("login_userid")).clear();
//		driver.findElement(By.id("login_userid")).sendKeys(userID);
//		driver.findElement(By.id("login_password")).clear();
//		driver.findElement(By.id("login_password")).sendKeys(userPass);
//		driver.findElement(By.cssSelector("input.btn_login")).click();
//		for (int second = 0;; second++) {
//			if (second >= 60) fail("timeout");
//			try { if (isElementPresent(By.name("icon_esetup"))) break; } catch (Exception e) {}
//			Thread.sleep(1000);
//		}
		
		//System.out.println("Successfully logged in.");
		
		//go to eSetup menu
//		driver.findElement(By.name("icon_esetup")).click();
//		//driver.findElement(By.xpath("//ul[@id='ext-gen78']/div/li/ul/li/div/a/span")).click();
//		
//		System.out.println("-Moved to eSetup.");
		
		//Click System Status
		driver.findElement(By.linkText("System Status")).click();
		//driver.findElement(By.cssSelector("span.x-tab-strip-text.")).click();

		System.out.println("--Checking system status.");
		System.out.println("--------------------------");
		
		Thread.sleep(3000);
		
		//strParam = driver.findElement(By.xpath("//div[@class='x-grid3-row x-grid3-row-first']/table/tbody/tr/td[@class='x-grid3-col x-grid3-cell x-grid3-td-1 x-grid3-cell-last ']")).getText();
		//System.out.println("Server name : " + strParam);
				
		ServerName = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div/div/div[2]/div/div/div/div/div/div/form/div/div[2]/div/div/div/div[2]/div/div/table/tbody/tr/td[2]/div")).getText();
		System.out.println("Server name : " + ServerName);
		
		ServerModel = driver.findElement(By.xpath("//div[@class='x-grid3-row x-grid3-row-alt']/table/tbody/tr/td[@class='x-grid3-col x-grid3-cell x-grid3-td-1 x-grid3-cell-last ']")).getText();
		System.out.println("Model : " + ServerModel);
		
		//strParam = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div/div/div[2]/div/div/div/div/div/div/form/div/div[2]/div/div/div/div[2]/div/div[2]/table/tbody/tr/td[2]/div")).getText();
		//System.out.println("Model : " + strParam);

		//strParam = driver.findElement(By.xpath("//div[@class='x-grid3-row']/table/tbody/tr/td[@class='x-grid3-col x-grid3-cell x-grid3-td-1 x-grid3-cell-last ']")).getText();
		//System.out.println("FirmwareVersion : " + strParam);
		
		FWVersion = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div/div/div[2]/div/div/div/div/div/div/form/div/div[2]/div/div/div/div[2]/div/div[3]/table/tbody/tr/td[2]/div")).getText();
		System.out.println("FirmwareVersion : " + FWVersion);
		
		FWDate = driver.findElement(By.xpath("//div[@class='x-grid3-row x-grid3-row-alt x-grid3-row-last']/table/tbody/tr/td[@class='x-grid3-col x-grid3-cell x-grid3-td-1 x-grid3-cell-last ']")).getText();
		System.out.println("Firmware Date : " + FWDate);
		//Thread.sleep(1000);
		
		try {
	        BufferedWriter out = new BufferedWriter(new FileWriter("D:\\System_Information.txt"));
	            out.write("*****************************************************************\r\n");
		        out.write("*                         System Information                    *\r\n");
		        out.write("*****************************************************************\r\n");
		        out.write("Test A001 - System Status -> Product\r\n");
		        out.write("It shows each and every information listed about the system? \r\n" +
							"시스템 정보 내용이 빠짐없이 출력이 되는가?\r\n" + 
							"(서버명, 모델명, 펌웨어버전, 펌웨어날짜)\r\n" +
							"모델명은 현재 존재하는 모델명으로 되어 있는가?\r\n");
		        out.write("=================================================================\r\n");
                out.write("Server Name:\r\t" + ServerName + "\r\n" + 
                		"Server Model:\r\t" + ServerModel + "\r\n" + 
                		"FW Version:\r\t" + FWVersion + "\r\n" + 
                		"FW Date:\r\t" + FWDate + "\r\n");
                if (ServerName != null && ServerModel != null && FWVersion != null & FWDate != null )
                	out.write("Test A001 ----------------------------> PASS \r\n");
                else
                	out.write("Test A001 ----------------------------> FAIL \r\n");
           
                //out.flush();	
	            out.close();
	        } catch (IOException e) {}

		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}


	}


	private static boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}
		
}
