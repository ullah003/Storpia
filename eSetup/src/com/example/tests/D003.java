//Is setting option saved properly?
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

public class D003 extends Network_Service{
	private static String systemOut = "", TimeMachinePass = "", status1 = "", successMsg = "";
	
	public void D003() throws IOException, InterruptedException{
		System.out.println("*****************************************************************");
		System.out.println("*                            AppleTalk                          *");
		System.out.println("*****************************************************************");
		System.out.println("Test D003 - Network Services->AppleTalk");
		System.out.println("Can it activate/deactivate AppleTalk Service? \n" +
				"입력한 정보가 정상적으로 저장 되는가?\n");
		
		BufferedReader br = new BufferedReader(new FileReader("D:\\ServiceConf.txt"));
		try {
	        for (int i=1; i<=9; i++){
	        	String line = br.readLine();
	        	if (i > 8){
		        	//System.out.println(line + "\n");
		        	String[] tokens = line.split("=");
	            	if (tokens[0].equals("TimeMachinePass")){
	            		TimeMachinePass = tokens[1];
		        	}
	            	//System.out.println(TimeMachinePass + "----------------\n");
	        	}
	        }
	    } finally {
	        br.close();
	    }
		
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter("D:\\Nerwork_Service.txt", true));
	    	out.write("*****************************************************************\r\n");
	        out.write("*                             AppleTalk                         *\r\n");
	        out.write("*****************************************************************\r\n");
	        out.write("Test D003 - Network Services->AppleTalk \r\n");
	        out.write("Can it activate/deactivate AppleTalk Service? \r\n" +
					"입력한 정보가 정상적으로 저장 되는가?\r\n");
	        out.write("=================================================================\r\n");
	//        out.write("--------------------------Before System Status-------------------\r\n");
	//        out.write("atalk \t\t" + bActive + "\t" + bStatus + "\r\n" + status1 + "\r\n" + systemOut + "\r\n");
	//        out.write("--------------------------After System Status--------------------\r\n");
	//        out.write("atalk \t\t" + aActive + "\t" + aStatus + "\r\n" + status1 + "\r\n" + systemOut + "\r\n");
	        out.close();
    	} catch (IOException e) {}
        
		for (int i =1; i<=2; i++){	
			//System status
			driver.findElement(By.xpath("//span[contains(text(), 'System Status')]")).click();
			driver.findElement(By.cssSelector(".ext-strict body#ext-gen11.ext-gecko div#content-panel.x-panel div#ext-gen28.x-panel-bwrap div#ext-gen29.x-panel-body div#systemInfo-panel.x-panel div#ext-gen32.x-panel-bwrap div#ext-gen33.x-panel-body div#ext-comp-1009.x-tab-panel div#ext-gen36.x-tab-panel-header div#ext-gen39.x-tab-strip-wrap ul#ext-gen41.x-tab-strip li#ext-comp-1009__ext-comp-1012 a#ext-gen49.x-tab-right em.x-tab-left span.x-tab-strip-inner span.x-tab-strip-text")).click();		
	
			try{
				Thread.sleep(1000);
			} catch(Exception e) {}
			
			System.out.println("----------------------------------------");
			System.out.println("Before System Status");
			System.out.println("----------------------------------------");
			String bActive = driver.findElement(By.xpath("//body/div[2]/div/div/div/div[2]/div/div/div[2]/div/div[2]/div/div/div/div/form/div/div[2]/div/div/div/div[2]/div/div[5]/table/tbody/tr/td[2]/div")).getText();
			String bStatus = driver.findElement(By.xpath("//body/div[2]/div/div/div/div[2]/div/div/div[2]/div/div[2]/div/div/div/div/form/div/div[2]/div/div/div/div[2]/div/div[5]/table/tbody/tr/td[3]/div")).getText();
			System.out.println("atalk \t\t" + bActive + "\t" + bStatus);
	
			pageRefresh();
	
			// Click AppleTalk menu
			driver.findElement(By.linkText("AppleTalk")).click();
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	
			try{
				Thread.sleep(2000);
			} catch(Exception e) {}
			
			try{
				Thread.sleep(2000);
			} catch(Exception e) {}
			// Click CheckBox
			WebElement timeMachineEnable = driver.findElement(By.id("timeMachineEnable"));
			
			if(!driver.findElement(By.id("atalkenable")).isSelected()) {
				status1 = "Apple File Service is not Enabled currently. Will Enable it";
				driver.findElement(By.id("atalkenable")).click(); // enable Apple File Service
				
				Thread.sleep(3000);
	
				if(!timeMachineEnable.isSelected()){
					//System.out.println("1111111111111111 ");
					driver.findElement(By.id("timeMachineEnable")).click();
					//timeMachineEnable.click(); // enable Apple File Service
				}
				
				//WebElement passwd = driver.findElement(By.id("timeMachinePassword"));
				driver.findElement(By.id("timeMachinePassword")).sendKeys(TimeMachinePass);
		
				try{
					Thread.sleep(1000);
				} catch(Exception e) {}
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
				//System.out.println("System Output: " + systemOut);
			}else{
				status1 = "Apple File Service is Enabled currently. Will Disable it";
				driver.findElement(By.id("atalkenable")).click(); // enable Apple File Service
				
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				
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
				//System.out.println("System Output: " + systemOut);
			}
			System.out.println(status1 + "\nSystem Output: " + systemOut);
			
			pageRefresh();
			
			//System status
			driver.findElement(By.xpath("//span[contains(text(), 'System Status')]")).click();
			driver.findElement(By.cssSelector(".ext-strict body#ext-gen11.ext-gecko div#content-panel.x-panel div#ext-gen28.x-panel-bwrap div#ext-gen29.x-panel-body div#systemInfo-panel.x-panel div#ext-gen32.x-panel-bwrap div#ext-gen33.x-panel-body div#ext-comp-1009.x-tab-panel div#ext-gen36.x-tab-panel-header div#ext-gen39.x-tab-strip-wrap ul#ext-gen41.x-tab-strip li#ext-comp-1009__ext-comp-1012 a#ext-gen49.x-tab-right em.x-tab-left span.x-tab-strip-inner span.x-tab-strip-text")).click();		
	
			try{
				Thread.sleep(1000);
			} catch(Exception e) {}
			
			System.out.println("----------------------------------------");
			System.out.println("After System Status");
			System.out.println("----------------------------------------");
			String aActive = driver.findElement(By.xpath("//body/div[2]/div/div/div/div[2]/div/div/div[2]/div/div[2]/div/div/div/div/form/div/div[2]/div/div/div/div[2]/div/div[5]/table/tbody/tr/td[2]/div")).getText();
			String aStatus = driver.findElement(By.xpath("//body/div[2]/div/div/div/div[2]/div/div/div[2]/div/div[2]/div/div/div/div/form/div/div[2]/div/div/div/div[2]/div/div[5]/table/tbody/tr/td[3]/div")).getText();
			System.out.println("atalk \t\t" + aActive + "\t" + aStatus);
			
			if (bActive.equals(aActive) & bStatus.equals(aStatus)){
				successMsg = "AppleTalk deactivation failed";
			}else{
				successMsg = "AppleTalk deactivation Successfull";
			}
			System.out.println(successMsg);
			
			try {
		        BufferedWriter out = new BufferedWriter(new FileWriter("D:\\Nerwork_Service.txt", true));
//		        	out.write("*****************************************************************\r\n");
//			        out.write("*                             AppleTalk                         *\r\n");
//			        out.write("*****************************************************************\r\n");
//			        out.write("Test D003 - Network Services->AppleTalk \r\n");
//			        out.write("Can it activate/deactivate AppleTalk Service? \r\n" +
//							"입력한 정보가 정상적으로 저장 되는가?\r\n");
//			        out.write("=================================================================\r\n");
			        out.write("--------------------------Before System Status-------------------\r\n");
			        out.write("atalk \t\t" + bActive + "\t" + bStatus + "\r\n" + status1 + "\r\n");
			        out.write("System Output: " + systemOut + "\r\n");
			        out.write("--------------------------After System Status--------------------\r\n");
			        out.write("atalk \t\t" + aActive + "\t" + aStatus + "\r\n" + status1 + "\r\n");
			        out.write(successMsg + "\r\n");
		            out.close();
		        } catch (IOException e) {}
		}//end for
	}

}
