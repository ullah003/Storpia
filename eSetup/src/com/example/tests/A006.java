//Resource monitoring shows information perfectly?
//모니터링 관련 내용이 정상적으로 출력 되는가? 

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

public class A006 extends System_Information {
	private static StringBuffer verificationErrors = new StringBuffer();
	private static String strCPUChart = "", strMemoryChart = "", strNetworkChart = "";
	
	//public static void main(String []args) throws Exception {
	public void A006() throws InterruptedException{
		System.out.println("*****************************************************************");
		System.out.println("*                         Resource MOnitor                      *");
		System.out.println("*****************************************************************");
		System.out.println("Test A006 - Resource Monitor -> CPU, Memory, Netrowk");
		System.out.println("Resource monitoring shows information perfectly? \n" +
				"모니터링 관련 내용이 정상적으로 출력 되는가? \n");	

//		driver.findElement(By.xpath("//ul[@id='ext-gen78']/div/li/ul/li[2]/div/a/span")).click();
		driver.findElement(By.linkText("Resource Monitor")).click();
		Thread.sleep(2000);
		if (isElementPresent(By.id("cpu_chart"))) 
			strCPUChart = "CPU Chart is running successfully.";
		else
			strCPUChart = "CPU Chart is not available.";
			

		//driver.findElement(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div/div/div/ul/li[2]/a[2]/em/span/span")).click();
		driver.findElement(By.linkText("Memory")).click();
		Thread.sleep(2000);
		if (isElementPresent(By.id("MEMORYCHART")))
			strMemoryChart = "Memory Chart is running successfully.";
		else
			strMemoryChart = "Memory Chart is not available.";
				
		driver.findElement(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div/div/div/ul/li[3]/a[2]/em/span/span")).click();
		Thread.sleep(2000);
		if (isElementPresent(By.id("network_chart")))
			strNetworkChart = "Network Chart is running successfully.";
		else
			strNetworkChart = "Network Chart is not available.";
			
		System.out.println(strCPUChart + "\n" + strMemoryChart + "\n" + strNetworkChart);
		
		try {
	        BufferedWriter out = new BufferedWriter(new FileWriter("D:\\System_Information.txt", true));
	        	out.write("*****************************************************************\r\n");
		        out.write("*                          Resource MOnitor                     *\r\n");
		        out.write("*****************************************************************\r\n");
		        out.write("Test A006 - Resource Monitor -> CPU, Memory, Netrowk \r\n");
		        out.write("Resource monitoring shows information perfectly? \r\n" +
							"모니터링 관련 내용이 정상적으로 출력 되는가?\r\n");
		        out.write("=================================================================\r\n");
                out.write(strCPUChart + "\r\n" + strMemoryChart + "\r\n" + strNetworkChart + "\r\n");
	            out.close();
	        } catch (IOException e) {}
		
		// After
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}
	
	private static boolean isElementPresent(By by) {
	    boolean flag = true;
	    driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	    if (!(driver.findElements(by).size() > 0)) {
	        flag = false;
	    } 
	    driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
	    return flag;
	}
}
