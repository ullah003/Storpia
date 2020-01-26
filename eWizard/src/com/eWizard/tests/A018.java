package com.eWizard.tests;

import java.io.*;

import static org.junit.Assert.*;
import org.openqa.selenium.*;

public class A018 extends BaseTestLogic {
	private static StringBuffer verificationErrors = new StringBuffer();
	private static String NetworkInterface = "", MACAddress = "", AddressAssign = "", 
							IPAddress = "", SubnetMask = "", Gateway = "", 
							DNSAssign = "", DNS1 = "", DNS2 = "", NoEth = "", DDNS = "";
	private static String [] NetworkInfo = {"", "", ""};
	int Number_of_Eth;
	
	public A018(WebDriver webDriver, File fileConf, File fileReport) {
		super(webDriver, fileConf, fileReport);
		fConf = fileConf;
	}
	
	void startTest() throws InterruptedException  {
		System.out.println("*****************************************************************");
		System.out.println("*                       Network Information                     *");
		System.out.println("*****************************************************************");
		System.out.println("Test A018 - Quick Setup -> Network -> Wired Network");
		System.out.println("Can it show wired network information correctly?\n" +
							"유선네트워크의 정보는 정상적으로 출력 되는가?\n" + 
							"----------------------------------------------------------");
		
		//Click Network menu
		driver.findElement(By.name("Image9")).click();	//go to network menu
		Thread.sleep(1000);
		driver.findElement(By.xpath("//body/div[6]/div[2]/div/div/div/form/div/div/div/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[3]/td[2]")).click();	//go to Wired Network menu
		//driver.findElement(By.xpath("//div[@id='networkstep0'/div/div/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[3]/td[2]]")).click();	//go to Wired Network menu
		
		System.out.println("System Network information");
		
//		boolean abc = true;
//				
//		//test enable disabled  selenium.isEditable(elemnetLocator)
//		abc = driver.findElement(By.id("wip")).getAttribute("disabled") != null;
//		if (driver.findElement(By.id("wip")).getAttribute("disabled") != null)
//			System.out.println("1111111111111" + abc);
//		else
//			System.out.println("22222222222222" + abc);
		
		NetworkInterface = driver.findElement(By.id("wlanlistSelect")).getAttribute("value");
		//System.out.println(NetworkInterface);
		
		System.out.println("Interface \tAddress Assign\tIP Address\tSubnet Mask\tGateway\t\tDNS Assign\tDNS1\t\tDNS2");
		for (int i =1; i<=1; i++){
			Number_of_Eth = i;
			if (NetworkInterface.equals("")){
				NoEth = "-------------- No Network Interface available, Test FAIL ----------------";
				break;
			}else{
				//driver.findElement(By.xpath("//select[@id='wlanlistSelect']/option[@value='eth'" + i + "]")).click();
				
				//NetworkInterface = driver.findElement(By.id("wlanlistSelect")).getAttribute("value");
				if (driver.findElement(By.id("wdhcp")).isSelected())
					AddressAssign = "DHCP";
				else if (driver.findElement(By.id("wstatic")).isSelected())
					AddressAssign = "STATIC";
				else
					AddressAssign = "error";
				
				IPAddress = driver.findElement(By.id("wip")).getAttribute("value");
				SubnetMask = driver.findElement(By.id("wsubnet")).getAttribute("value");
				Gateway = driver.findElement(By.id("wgateway")).getAttribute("value");
				
				if (driver.findElement(By.id("wdnsdhcp")).isSelected())
					DNSAssign = "DHCP";
				else if (driver.findElement(By.id("wdnsstatic")).isSelected())
					DNSAssign = "STATIC";
				else
					DNSAssign = "error";
				
				DNS1 = driver.findElement(By.id("wdns1")).getAttribute("value");
				DNS2 = driver.findElement(By.id("wdns2")).getAttribute("value");
				
				NetworkInfo [i-1] = NetworkInterface + "\t\t" + AddressAssign + "\t\t" + IPAddress + 
						"\t" + SubnetMask + "\t" + Gateway + "\t" + DNSAssign+ "\t\t" + DNS1 + "\t" + DNS2;
				System.out.println(NetworkInfo [i-1]);
			}
		}	
		System.out.println(NoEth);
		
		try {
			StringBuilder builder = new StringBuilder();
	        BufferedWriter out = new BufferedWriter(new FileWriter(fReport, true));
	        
	        builder.append("\r\n*****************************************************************\r\n");
	        builder.append("*                       Network Information                     *\r\n");
	        builder.append("*****************************************************************\r\n");
	        builder.append("Test A018 - Quick Setup -> Network -> Wired Network\r\n");
	        builder.append("Can it show wired network information correctly?\r\n" +
						"유선네트워크의 정보는 정상적으로 출력 되는가?\r\n");
	        builder.append("=================================================================\r\n");
	        builder.append("Interface \tAddress Assign\tIP Address\tSubnet Mask\tGateway\t\tDNS Assign\tDNS1\t\tDNS2\r\n");
            for (int j =0; j<Number_of_Eth; j++){
            	builder.append(NetworkInfo [j] + "\r\n");
            }
            builder.append(NoEth + "\r\n");
            out.write(builder.toString());

			if(Lisenter != null){
				Lisenter.onReportLisenter(builder.toString());
			}
            
            out.close();
	        } catch (IOException e) {}
		 	
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}
}

