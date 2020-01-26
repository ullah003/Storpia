//Activation/Deactivation setting works properly?
//설정적용이 정상적으로 동작하는가? 

package com.example.tests;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

public class D007 extends Network_Service{
	private static String systemOut = "", successMsg1 = "", successMsg2 = "";
	private static String TelnetPort = "", SSHPort = "";
			
	public void D007() throws InterruptedException, IOException{
		System.out.println("*****************************************************************");
		System.out.println("*                           Telnet/SSH                          *");
		System.out.println("*****************************************************************");
		System.out.println("Test D007 - Telnet/SSH");
		System.out.println("Activation/Deactivation setting works properly? \n" +
				"설정적용이 정상적으로 동작하는가?\n" +
				"-----------------------------------------------");
		BufferedReader br = new BufferedReader(new FileReader("D:\\ServiceConf.txt"));
		try {
	        for (int i=1; i<=21; i++){
	        	String line = br.readLine();
	        	if (i > 19){
		        	//System.out.println(line + "\n");
		        	String[] tokens = line.split("=");
	            	if (tokens[0].equals("TelnetPort")){
	            		TelnetPort = tokens[1];
		        	}else if (tokens[0].equals("SSHPort")){
		        		SSHPort = tokens[1];
		        	}
	        	}
	        }
	    } finally {
	        br.close();
	    }
		
		try {
	        BufferedWriter out = new BufferedWriter(new FileWriter("D:\\Nerwork_Service.txt", true));
	        	out.write("*****************************************************************\r\n");
		        out.write("*                            Telnet/SSH                         *\r\n");
		        out.write("*****************************************************************\r\n");
		        out.write("Test D007 - Telnet/SSH \r\n");
		        out.write("Activation/Deactivation setting works properly?\r\n" +
						"설정적용이 정상적으로 동작하는가?\r\n");
		        out.write("=================================================================\r\n");
//		        out.write("--------------------------Before System Status-------------------\r\n");
//		        out.write("ssh \t\t" + bActive1 + "\t" + bStatus1 + "\r\n");
//		        out.write("telnet \t\t" + bActive2 + "\t" + bStatus2 + "\r\n");
//		        out.write("System Output: " + systemOut + "\r\n");
//		        out.write("--------------------------After System Status--------------------\r\n");
//		        out.write("ssh \t\t" + aActive1 + "\t" + aStatus1 + "\r\n");
//		        out.write("telnet \t\t" + aActive2 + "\t" + aStatus2 + "\r\n");
//		        out.write(successMsg1 + "\r\n" + successMsg2 + "\r\n");
	            out.close();
	        } catch (IOException e) {}
		
		for (int i =1; i<=2; i++){
			System.out.println("Test: " + i);
			
			//System status
			driver.findElement(By.xpath("//span[contains(text(), 'System Status')]")).click();
			driver.findElement(By.cssSelector(".ext-strict body#ext-gen11.ext-gecko div#content-panel.x-panel div#ext-gen28.x-panel-bwrap div#ext-gen29.x-panel-body div#systemInfo-panel.x-panel div#ext-gen32.x-panel-bwrap div#ext-gen33.x-panel-body div#ext-comp-1009.x-tab-panel div#ext-gen36.x-tab-panel-header div#ext-gen39.x-tab-strip-wrap ul#ext-gen41.x-tab-strip li#ext-comp-1009__ext-comp-1012 a#ext-gen49.x-tab-right em.x-tab-left span.x-tab-strip-inner span.x-tab-strip-text")).click();		
			Thread.sleep(2000);
			System.out.println("----------------------------------------");
			System.out.println("Before System Status");
			System.out.println("----------------------------------------");
			String bActive1 = driver.findElement(By.xpath("//body/div[2]/div/div/div/div[2]/div/div/div[2]/div/div[2]/div/div/div/div/form/div/div[2]/div/div/div/div[2]/div/div[6]/table/tbody/tr/td[2]/div")).getText();
			String bStatus1 = driver.findElement(By.xpath("//body/div[2]/div/div/div/div[2]/div/div/div[2]/div/div[2]/div/div/div/div/form/div/div[2]/div/div/div/div[2]/div/div[6]/table/tbody/tr/td[3]/div")).getText();
			System.out.println("ssh \t\t" + bActive1 + "\t" + bStatus1);
	
			String bActive2 = driver.findElement(By.xpath("//body/div[2]/div/div/div/div[2]/div/div/div[2]/div/div[2]/div/div/div/div/form/div/div[2]/div/div/div/div[2]/div/div[7]/table/tbody/tr/td[2]/div")).getText();
			String bStatus2 = driver.findElement(By.xpath("//body/div[2]/div/div/div/div[2]/div/div/div[2]/div/div[2]/div/div/div/div/form/div/div[2]/div/div/div/div[2]/div/div[7]/table/tbody/tr/td[3]/div")).getText();
			System.out.println("telnet \t\t" + bActive2 + "\t" + bStatus2);
			
			pageRefresh();
			
			// Click Telnet/SSH menu
			driver.findElement(By.xpath("//span[contains(text(), 'Telnet/SSH')]")).click();
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	
			Thread.sleep(2000);
			
			// Click CheckBox
			driver.findElement(By.xpath("//*[@name='telnetenable']")).click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			if (driver.findElement(By.xpath("//*[@name='telnetenable']")).isSelected()){
				driver.findElement(By.id("tport")).clear();
				driver.findElement(By.id("tport")).sendKeys(TelnetPort);
			}
			
			Thread.sleep(1000);
			
			// Click CheckBox
			driver.findElement(By.xpath("//*[@name='sshenable']")).click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			if (driver.findElement(By.xpath("//*[@name='sshenable']")).isSelected()){
				driver.findElement(By.id("sport")).clear();
				driver.findElement(By.id("sport")).sendKeys(SSHPort);
			}
			
			Thread.sleep(1000);
	
			// Click Confirm
			driver.findElement(By.xpath("//button[contains(text(), 'Confirm')]")).click();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	
			Thread.sleep(3000);
			
			if (isElementPresent(By.xpath("//body/div[13]/div[2]/div/div/div/div/div/div[2]/span"))){
				systemOut = driver.findElement(By.xpath("//body/div[13]/div[2]/div/div/div/div/div/div[2]/span")).getText();		
			}
			// Click Ok
			driver.findElement(By.xpath("//button[contains(text(), 'OK')]")).click();
			System.out.println("System Output: " + systemOut);
			
			pageRefresh();
			
			driver.findElement(By.xpath("//span[contains(text(), 'Telnet/SSH')]")).click();
			
			Thread.sleep(2000);
			
			String Telnet = driver.findElement(By.id("tport")).getAttribute("value").toString();
			String SSH = driver.findElement(By.id("sport")).getAttribute("value").toString();
			
			if (driver.findElement(By.xpath("//*[@name='telnetenable']")).isSelected()){
				if (TelnetPort.equals(Telnet)){
					Telnet = "Telnet port setting is OK (" + Telnet + ")";
				} else {
					Telnet = "Telnet port setting Fail";
				}
			}else{
				Telnet = "Telnet option is disabled";
			}
			System.out.println(Telnet);
			
			if (driver.findElement(By.xpath("//*[@name='sshenable']")).isSelected()){
				if (SSHPort.equals(SSH)){
					SSH = "SSH port setting is OK (" + SSH + ")";
				} else {
					SSH = "SSH port setting Fail";
				}
			}else{
				SSH = "SSH option is disabled";
			}System.out.println(SSH);
			
			pageRefresh();
			
			//System status
			driver.findElement(By.xpath("//span[contains(text(), 'System Status')]")).click();
			driver.findElement(By.cssSelector(".ext-strict body#ext-gen11.ext-gecko div#content-panel.x-panel div#ext-gen28.x-panel-bwrap div#ext-gen29.x-panel-body div#systemInfo-panel.x-panel div#ext-gen32.x-panel-bwrap div#ext-gen33.x-panel-body div#ext-comp-1009.x-tab-panel div#ext-gen36.x-tab-panel-header div#ext-gen39.x-tab-strip-wrap ul#ext-gen41.x-tab-strip li#ext-comp-1009__ext-comp-1012 a#ext-gen49.x-tab-right em.x-tab-left span.x-tab-strip-inner span.x-tab-strip-text")).click();		
			Thread.sleep(2000);
			System.out.println("----------------------------------------");
			System.out.println("After System Status");
			System.out.println("----------------------------------------");
			String aActive1 = driver.findElement(By.xpath("//body/div[2]/div/div/div/div[2]/div/div/div[2]/div/div[2]/div/div/div/div/form/div/div[2]/div/div/div/div[2]/div/div[6]/table/tbody/tr/td[2]/div")).getText();
			String aStatus1 = driver.findElement(By.xpath("//body/div[2]/div/div/div/div[2]/div/div/div[2]/div/div[2]/div/div/div/div/form/div/div[2]/div/div/div/div[2]/div/div[6]/table/tbody/tr/td[3]/div")).getText();
			System.out.println("ssh \t\t" + aActive1 + "\t" + aStatus1);
	
			String aActive2 = driver.findElement(By.xpath("//body/div[2]/div/div/div/div[2]/div/div/div[2]/div/div[2]/div/div/div/div/form/div/div[2]/div/div/div/div[2]/div/div[7]/table/tbody/tr/td[2]/div")).getText();
			String aStatus2 = driver.findElement(By.xpath("//body/div[2]/div/div/div/div[2]/div/div/div[2]/div/div[2]/div/div/div/div/form/div/div[2]/div/div/div/div[2]/div/div[7]/table/tbody/tr/td[3]/div")).getText();
			System.out.println("telnet \t\t" + aActive2 + "\t" + aStatus2);
			
			if (bActive1.equals(aActive1) & bStatus1.equals(aStatus1)){
				successMsg1 = "SSH setting failed";
			}else{
				successMsg1 = "SSH setting Successfull";
			}
			System.out.println(successMsg1);
			
			if (bActive2.equals(aActive2) & bStatus2.equals(aStatus2)){
				successMsg2 = "Telnet setting failed";
			}else{
				successMsg2 = "Telnet setting Successfull";
			}
			System.out.println(successMsg2);
			
			try {
		        BufferedWriter out = new BufferedWriter(new FileWriter("D:\\Nerwork_Service.txt", true));
//		        	out.write("*****************************************************************\r\n");
//			        out.write("*                            Telnet/SSH                         *\r\n");
//			        out.write("*****************************************************************\r\n");
//			        out.write("Test D007 - Telnet/SSH \r\n");
//			        out.write("Activation/Deactivation setting works properly?\r\n" +
//							"설정적용이 정상적으로 동작하는가?\r\n");
//			        out.write("=================================================================\r\n");
			        out.write("--------------------------Before System Status-------------------\r\n");
			        out.write("ssh \t\t" + bActive1 + "\t" + bStatus1 + "\r\n");
			        out.write("telnet \t\t" + bActive2 + "\t" + bStatus2 + "\r\n");
			        out.write("System Output: " + systemOut + "\r\n");
			        out.write("--------------------------After System Status--------------------\r\n");
			        out.write("ssh \t\t" + aActive1 + "\t" + aStatus1 + "\r\n");
			        out.write("telnet \t\t" + aActive2 + "\t" + aStatus2 + "\r\n");
			        out.write(Telnet + "\r\n" + SSH + "\r\n");
			        out.write(successMsg1 + "\r\n" + successMsg2 + "\r\n");
		            out.close();
		        } catch (IOException e) {}
		}//end for
	}
}
