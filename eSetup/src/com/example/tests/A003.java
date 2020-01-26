//If any USB disk is connected to the device can it show USB information?
//Can it show other Hardware informations?
//USB 장치정보는 USB가 있을경우에 출력 되는가? 
//다른 하드웨어 정보는 시스템에 맞는 정확한 값인가?

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

public class A003 extends System_Information{
//	private static WebDriver driver;
//	private static String baseUrl;
	private static StringBuffer verificationErrors = new StringBuffer();
	private static String strCache = "", strModel = "", strSpeed = "", strPhyNum = "", strLogicNum = "";
	private static String strMemCapacity = "";
	private static String strNetInterface = "", strActive = "", strLink = "", strPhysical = "", strMAC = "", strIP = "", strSubNet = "", strMTU = "";
	private static String strController = "", strIOPort = "", strGwaddr = "", strPort = "", strDNS = "";
	private static String USBInfo1 = "", USBInfo2 = "", NoUSB = "";
	int USB_Number;
	private static String [] USB = {"", "", "", "", ""};
	
	//public static void main(String[] args) throws Exception {
	public void A003(){
		System.out.println("*****************************************************************");
		System.out.println("*                          HW Information                       *");
		System.out.println("*****************************************************************");
		System.out.println("Test A003 - System Status -> Hardware \n");
		System.out.println("If any USB disk is connected to the device can it show USB information? \n" +
				"USB 장치정보는 USB가 있을경우에 출력 되는가? \n" + 
				"다른 하드웨어 정보는 시스템에 맞는 정확한 값인가? \n");
		
		//driver.findElement(By.linkText("System Status")).click();
		//driver.findElement(By.cssSelector("html.ext-strict body#ext-gen11.ext-gecko div#content-panel.x-panel div#ext-gen28.x-panel-bwrap div#ext-gen29.x-panel-body div#systemInfo-panel.x-panel div#ext-gen32.x-panel-bwrap div#ext-gen33.x-panel-body div#ext-comp-1009.x-tab-panel div#ext-gen36.x-tab-panel-header div#ext-gen39.x-tab-strip-wrap ul#ext-gen41.x-tab-strip li#ext-comp-1009__ext-comp-1011 a#ext-gen47.x-tab-right em.x-tab-left span.x-tab-strip-inner span.x-tab-strip-text")).click();
		driver.findElement(By.linkText("Hardware")).click();
		
		System.out.println("----------------------------------------");
		System.out.println("CPU");
		System.out.println("----------------------------------------");
		strCache = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div/div/div[2]/div/div[2]/div/div/div/div/form/div/div[2]/div/div/div/div[2]/div/div/table/tbody/tr/td[2]/div")).getText();
		System.out.println("cache : " + strCache);

		strModel = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div/div/div[2]/div/div[2]/div/div/div/div/form/div/div[2]/div/div/div/div[2]/div/div[2]/table/tbody/tr/td[2]/div")).getText();
		System.out.println("model : " + strModel);
		
		strSpeed = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div/div/div[2]/div/div[2]/div/div/div/div/form/div/div[2]/div/div/div/div[2]/div/div[3]/table/tbody/tr/td[2]/div")).getText();
		System.out.println("speed : " + strSpeed);
		
		strPhyNum = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div/div/div[2]/div/div[2]/div/div/div/div/form/div/div[2]/div/div/div/div[2]/div/div[4]/table/tbody/tr/td[2]/div")).getText();
		System.out.println("physical_num : " + strPhyNum);
		
		strLogicNum = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div/div/div[2]/div/div[2]/div/div/div/div/form/div/div[2]/div/div/div/div[2]/div/div[5]/table/tbody/tr/td[2]/div")).getText();
		System.out.println("logical_num : " + strLogicNum);
		System.out.println();
		
		System.out.println("----------------------------------------");
		System.out.println("Memory");
		System.out.println("----------------------------------------");		
		
		strMemCapacity = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div/div/div[2]/div/div[2]/div/div/div/div/form/div[2]/div[2]/div/div/div/div[2]/div/div/table/tbody/tr/td[2]/div")).getText();
		System.out.println("capacity : " + strMemCapacity);
		System.out.println();
		
		
		System.out.println("----------------------------------------");
		System.out.println("Network");
		System.out.println("----------------------------------------");
		
		strNetInterface = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div/div/div[2]/div/div[2]/div/div/div/div/form/div[3]/div[2]/div/div/div/div[2]/div/div/table/tbody/tr/td/div")).getText();
		System.out.println("Network Interface : " + strNetInterface);
		
		strActive = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div/div/div[2]/div/div[2]/div/div/div/div/form/div[3]/div[2]/div/div/div/div[2]/div/div/table/tbody/tr/td[2]/div")).getText();
		System.out.println("Active : " + strActive);
		
		strLink = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div/div/div[2]/div/div[2]/div/div/div/div/form/div[3]/div[2]/div/div/div/div[2]/div/div/table/tbody/tr/td[3]/div")).getText();
		System.out.println("Link : " + strLink);
		
		strPhysical = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div/div/div[2]/div/div[2]/div/div/div/div/form/div[3]/div[2]/div/div/div/div[2]/div/div/table/tbody/tr/td[4]/div")).getText();
		System.out.println("Physical : " + strPhysical);
		
		strMAC = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div/div/div[2]/div/div[2]/div/div/div/div/form/div[3]/div[2]/div/div/div/div[2]/div/div/table/tbody/tr/td[5]/div")).getText();
		System.out.println("MAC Address : " + strMAC);
		
		strIP = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div/div/div[2]/div/div[2]/div/div/div/div/form/div[3]/div[2]/div/div/div/div[2]/div/div/table/tbody/tr/td[6]/div")).getText();
		System.out.println("IP Address : " + strIP);
		
		strSubNet = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div/div/div[2]/div/div[2]/div/div/div/div/form/div[3]/div[2]/div/div/div/div[2]/div/div/table/tbody/tr/td[7]/div")).getText();
		System.out.println("Subnet Mask : " + strSubNet);
		
		strMTU = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div/div/div[2]/div/div[2]/div/div/div/div/form/div[3]/div[2]/div/div/div/div[2]/div/div/table/tbody/tr/td[8]/div")).getText();
		System.out.println("MTU : " + strMTU);
		System.out.println();
		
		System.out.println("----------------------------------------");
		System.out.println("Other");
		System.out.println("----------------------------------------");
		
		strController = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div/div/div[2]/div/div[2]/div/div/div/div/form/div[4]/div[2]/div/div/div/div[2]/div/div/table/tbody/tr/td[2]/div")).getText();
		System.out.println("controllors : " + strController);
		
		strIOPort = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div/div/div[2]/div/div[2]/div/div/div/div/form/div[4]/div[2]/div/div/div/div[2]/div/div[2]/table/tbody/tr/td[2]/div")).getText();
		System.out.println("IO ports : " + strIOPort);
		
		strGwaddr = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div/div/div[2]/div/div[2]/div/div/div/div/form/div[4]/div[2]/div/div/div/div[2]/div/div[3]/table/tbody/tr/td[2]/div")).getText();
		System.out.println("gwaddr : " + strGwaddr);
		
		strPort = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div/div/div[2]/div/div[2]/div/div/div/div/form/div[4]/div[2]/div/div/div/div[2]/div/div[4]/table/tbody/tr/td[2]/div")).getText();
		System.out.println("port : " + strPort);
		
		strDNS = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div/div/div[2]/div/div[2]/div/div/div/div/form/div[4]/div[2]/div/div/div/div[2]/div/div[5]/table/tbody/tr/td[2]/div")).getText();
		System.out.println("DNS : " + strDNS);
		System.out.println();
		
		System.out.println("----------------------------------------");
		System.out.println("USB Device");
		System.out.println("----------------------------------------");
		
		System.out.println("ID [BUS:Device] \t Contents");
		for (int i =1; i<=5; i++){
			USB_Number = i;
			if (!isElementPresent(By.xpath("/html/body/div[2]/div/div/div/div[2]/div/div/div[2]/div/div[2]/div/div/div/div/form/div[5]/div[2]/div/div/div/div[2]/div/div[" + i + "]/table/tbody/tr/td/div"))){
				if (i==1){
					NoUSB = "-------------- No USB Connected ----------------";
					System.out.println("-------------- No USB Connected ----------------");
				}else{
					NoUSB = "-------------- No more USB Connected ----------------";
					System.out.println("-------------- No more USB Connected ----------------");
				}
				break;
			}else{
				USBInfo1 = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div/div/div[2]/div/div[2]/div/div/div/div/form/div[5]/div[2]/div/div/div/div[2]/div/div[" + i + "]/table/tbody/tr/td/div")).getText();
				//System.out.println("ID [BUS:Device] : " + USBInfo);
				
				USBInfo2 = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div/div/div[2]/div/div[2]/div/div/div/div/form/div[5]/div[2]/div/div/div/div[2]/div/div[" + i + "]/table/tbody/tr/td[2]/div")).getText();
				//System.out.println("Contents : " + USBInfo2);
				//System.out.println();	
				//System.out.println("ID [BUS:Device] \t Contents");
				USB[i-1] = USBInfo1 + "\t\t\t" + USBInfo2;
				System.out.println(USB[i-1] + "\n");
			}
		}
		
		try {
	        BufferedWriter out = new BufferedWriter(new FileWriter("D:\\System_Information.txt", true));
	            out.write("*****************************************************************\r\n");
		        out.write("*                           HW Information                      *\r\n");
		        out.write("*****************************************************************\r\n");
		        out.write("Test A003 - System Status -> Hardware \r\n");
		        out.write("If any USB disk is connected to the device can it show USB information? \r\n" +
							"USB 장치정보는 USB가 있을경우에 출력 되는가?\r\n" + 
							"다른 하드웨어 정보는 시스템에 맞는 정확한 값인가?\r\n");
		        out.write("=================================================================\r\n");
                out.write("--------------------- CPU --------------- \r\n" +
                		"Cache:\r\t" + strCache + "\r\n" + 
                		"Model:\r\t" + strModel + "\r\n" + 
                		"Speed:\r\t" + strSpeed + "\r\n" + 
                		"Physical Num:\r\t" + strPhyNum + "\r\n" +
                		"Logical Num:\r\t" + strLogicNum + "\r\n");
                out.write("--------------------- Memory --------------- \r\n" + 
                		"Capacity:\r\t" + strMemCapacity + "\r\n");
                out.write("--------------------- Network --------------- \r\n" +
                		"Net Interface:\r\t" + strNetInterface + "\r\n" + 
                		"Active:\r\t" + strActive + "\r\n" + 
                		"Link:\r\t" + strLink + "\r\n" + 
                		"Physical:\r\t" + strPhysical + "\r\n" +
                		"MAC:\r\t" + strMAC + "\r\n" +
                		"IP:\r\t" + strIP + "\r\n" +
                		"Subnet:\r\t" + strSubNet + "\r\n" +
                		"MTU:\r\t" + strMTU + "\r\n");
                out.write("--------------------- Other --------------- \r\n" +
                		"Controller:\r\t" + strController + "\r\n" + 
                		"IO ports:\r\t" + strIOPort + "\r\n" + 
                		"Gwaddr:\r\t" + strGwaddr + "\r\n" + 
                		"Port:\r\t" + strPort + "\r\n" +
                		"DNS:\r\t" + strDNS + "\r\n");
                out.write("--------------------- USB ---------------\r\n" + 
                		"ID [BUS:Device] \t Contents \r\n");
                for (int j =0; j<USB_Number; j++){
                	out.write(USB[j] + "\r\n");
                }
                out.write(NoUSB + "\r\n");
//                if (ServerName != null && ServerModel != null && FWVersion != null & FWDate != null )
//                	out.write("Test A001 ----------------------------> PASS \r\n");
//                else
//                	out.write("Test A001 ----------------------------> FAIL \r\n");
           
                //out.flush();	
	            out.close();
	        } catch (IOException e) {}
		
		// After
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
