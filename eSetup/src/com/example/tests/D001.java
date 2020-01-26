//Is CIFS activation setting option saved properly?
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

public class D001 extends Network_Service{
	private static String systemOut = "";
	private static String CIFSdevice = "", CIFSWorkgroup = "", WINSServer = "";
//	private static StringBuffer verificationErrors = new StringBuffer();
	
	public void D001() throws IOException{
		System.out.println("*****************************************************************");
		System.out.println("*                          CIFS Settings                        *");
		System.out.println("*****************************************************************");
		System.out.println("Test D001 - Network Services -> CIFS");
		System.out.println("Is CIFS activation setting option saved properly? \n" +
				"입력한 정보가 정상적으로 저장 되는가? \n" + 
				"----------------------------------------------------------\n");
		
		BufferedReader br = new BufferedReader(new FileReader("D:\\ServiceConf.txt"));
		try {
	        for (int i=1; i<=7; i++){
	        	String line = br.readLine();
	        	if (i > 4){
		        	//System.out.println(line + "\n");
		        	String[] tokens = line.split("=");
	            	if (tokens[0].equals("CIFSdevice")){
	            		CIFSdevice = tokens[1];
		        	}else if (tokens[0].equals("CIFSWorkgroup")){
		        		CIFSWorkgroup = tokens[1];
		        	}else if (tokens[0].equals("WINSServer")){
		        		WINSServer = tokens[1];
		        	}
	        	}
	        }
	    } finally {
	        br.close();
	    }
		
		// Click CIFS menu
		driver.findElement(By.xpath("//span[contains(text(), 'CIFS')]")).click();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		
		try{
			Thread.sleep(2000);
			} catch(Exception e) {}
		
		// Click CheckBox
		if (!driver.findElement(By.xpath("//*[@id='cifsenable']")).isSelected()){
			driver.findElement(By.xpath("//*[@id='cifsenable']")).click();
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		WebElement device = driver.findElement(By.id("serverdesc"));
		device.clear();
		device.sendKeys(CIFSdevice);

		WebElement group = driver.findElement(By.id("workgroup"));
		group.clear();
		group.sendKeys(CIFSWorkgroup);
		
		WebElement server = driver.findElement(By.id("winsserver"));
		server.clear();
		server.sendKeys(WINSServer);
		
		try{
			Thread.sleep(1000);
			} catch(Exception e) {}
		// Click Confirm
		driver.findElement(By.xpath("//button[contains(text(), 'Confirm')]")).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		try{
			Thread.sleep(3000);
			} catch(Exception e) {}
		
		if (isElementPresent(By.xpath("//body/div[13]/div[2]/div/div/div/div/div/div[2]/span"))){
			systemOut = driver.findElement(By.xpath("//body/div[13]/div[2]/div/div/div/div/div/div[2]/span")).getText();		
		}
		
		// Click Ok
		driver.findElement(By.xpath("//button[contains(text(), 'OK')]")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("System Output: " + systemOut);
		
		try{
			Thread.sleep(3000);
			} catch(Exception e) {}
		String dev = driver.findElement(By.xpath("//*[@id='serverdesc']")).getAttribute("value").toString();
		String grp = driver.findElement(By.xpath("//*[@id='workgroup']")).getAttribute("value").toString();
		String win = driver.findElement(By.xpath("//*[@id='winsserver']")).getAttribute("value").toString();
		
		if (CIFSdevice.equals(dev)){
			dev = "Description of Device Info OK (" + CIFSdevice + ")";
		} else {
			dev = "Description of Device Info Fail";
		}
		System.out.println(dev);
		
		if (CIFSWorkgroup.equals(grp)) {
			grp = "Workgroup Info OK (" + CIFSWorkgroup + ")";
		} else {
			grp = "Workgroup Info Fail";
		}
		System.out.println(grp);
		
		if (WINSServer.equals(win)) {
			win = "WINS server Info OK (" + WINSServer + ")";
		} else {
			win = "WINS server Info Fail";
		}
		System.out.println(win);
		
		try {
	        BufferedWriter out = new BufferedWriter(new FileWriter("D:\\Nerwork_Service.txt"));
	        	out.write("*****************************************************************\r\n");
		        out.write("*                             CIFS Setting                      *\r\n");
		        out.write("*****************************************************************\r\n");
		        out.write("Test D001 - Network Services -> CIFS \r\n");
		        out.write("Is CIFS activation setting option saved properly? \r\n" +
						"입력한 정보가 정상적으로 저장 되는가? \r\n");
		        out.write("=================================================================\r\n");
                out.write("System Output: " + systemOut + "\r\n" + dev + "\r\n"
                		+ grp + "\r\n" 
                		+ win + "\r\n");
	            out.close();
	        } catch (IOException e) {}
		
		// After
//		String verificationErrorString = verificationErrors.toString();
//		if (!"".equals(verificationErrorString)) {
//			fail(verificationErrorString);
//		}
	}
	
}
