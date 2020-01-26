//Can it show network information normally?
//네트워크 설정정보를 정상적으로 받아 오는가? 

package com.example.tests;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class B001 extends System_Setting {
	private static StringBuffer verificationErrors = new StringBuffer();
	private static String NetworkInterface = "", MACAddress = "", AddressAssign = "", IPAddress = "", SubnetMask = "", Gateway = "", DNS = "", NoEth = "", DDNS = "";
	private static String [] NetworkInfo = {"", "", ""};
	int Number_of_Eth;
	
	//public static void main(String []args) throws Exception {
	public void B001() throws InterruptedException{
		System.out.println("*****************************************************************");
		System.out.println("*                             Network                            *");
		System.out.println("*****************************************************************");
		System.out.println("Test B001 - System -> Network");
		System.out.println("Can it show network information normally? \n" +
				"네트워크 설정정보를 정상적으로 받아 오는가? \n");

		driver.findElement(By.linkText("Network")).click();
		
		System.out.println("System Network information");
		System.out.println("Interface \tMac Address\t\tAddress Assign\tIP Address\tSubnet Mask\tGateway\t\tDNS");
		for (int i =1; i<=3; i++){
			Number_of_Eth = i;
			if (!isElementNotPresent(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div/div[2]" +
					"/div/div/div/div/div/div/div/div/div[2]/div[2]/div/div/div[2]/div" +
					"/div[" + i +"]/table/tbody/tr/td/div"))){
				if (i==1)
					NoEth = "-------------- No Network Interface available, Test FAIL ----------------";
				else
					NoEth = "-------------- No more Network Interface available ----------------";
				break;
			}else{
				NetworkInterface = driver.findElement(By.xpath("//body/div[2]/div/div/div[2]/div[2]" +
						"/div/div/div[2]/div/div/div/div/div/div/div/div/div[2]/div[2]/div/div/div[2]" +
						"/div/div[" + i +"]/table/tbody/tr/td/div")).getText();
				MACAddress = driver.findElement(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div" +
						"/div[2]/div/div/div/div/div/div/div/div/div[2]/div[2]/div/div/div[2]/div" +
						"/div[" + i +"]/table/tbody/tr/td[2]/div")).getText();
				AddressAssign = driver.findElement(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div" +
						"/div/div[2]/div/div/div/div/div/div/div/div/div[2]/div[2]/div/div/div[2]/div" +
						"/div[" + i +"]/table/tbody/tr/td[3]/div")).getText();
				IPAddress = driver.findElement(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div" +
						"/div/div[2]/div/div/div/div/div/div/div/div/div[2]/div[2]/div/div/div[2]" +
						"/div/div[" + i +"]/table/tbody/tr/td[4]/div")).getText();
				SubnetMask = driver.findElement(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div" +
						"/div/div[2]/div/div/div/div/div/div/div/div/div[2]/div[2]/div/div/div[2]" +
						"/div/div[" + i +"]/table/tbody/tr/td[5]/div")).getText();
				Gateway = driver.findElement(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div" +
						"/div[2]/div/div/div/div/div/div/div/div/div[2]/div[2]/div/div/div[2]/div" +
						"/div[" + i +"]/table/tbody/tr/td[6]/div")).getText();
				DNS = driver.findElement(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div/div[2]" +
						"/div/div/div/div/div/div/div/div/div[2]/div[2]/div/div/div[2]/div" +
						"/div[" + i +"]/table/tbody/tr/td[7]/div")).getText();
				NetworkInfo [i-1] = NetworkInterface + "\t\t" + MACAddress + "\t" + AddressAssign 
						+ "\t\t" + IPAddress + "\t" + SubnetMask + "\t" + Gateway + "\t" + DNS;
				System.out.println(NetworkInfo [i-1]);
			}
		}	
		System.out.println(NoEth);
		DDNS = driver.findElement(By.id("hostname")).getAttribute("value");
		System.out.println("Hostname (DDNS) :" + DDNS);
		
		try {
	        BufferedWriter out = new BufferedWriter(new FileWriter("D:\\System_Setting.txt"));
			//BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("D:\\System_Setting.xls"),Charset.forName("UTF-8").newEncoder()));
	            out.write("\r\n*****************************************************************\r\n");
		        out.write("*                               Network                          *\r\n");
		        out.write("*****************************************************************\r\n");
		        out.write("Test B001 - System -> Network \r\n");
		        out.write("Can it show network information normally? \r\n" +
							"네트워크 설정정보를 정상적으로 받아 오는가?\r\n");
		        out.write("=================================================================\r\n");
                out.write("Interface \tMac Address\t\tAddress Assign\tIP Address\tSubnet Mask\tGateway\t\tDNS\r\n");
                for (int j =0; j<Number_of_Eth; j++){
                	out.write(NetworkInfo [j] + "\r\n");
                }
                out.write(NoEth + "\r\n" + "Hostname (DDNS) :" + DDNS + "\r\n");
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
