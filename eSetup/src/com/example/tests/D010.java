package com.example.tests;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class D010 extends Network_Service{
	static String[] ip = new String[4];
	static String[] subnet1 = new String[4];
	static String[] subnet2 = new String[4];
	static String[] network1 = new String[4];
	static String[] network2 = new String[4];
	
	public void D010(){
		System.out.println("*****************************************************************");
		System.out.println("*                            Firewall                           *");
		System.out.println("*****************************************************************");
		System.out.println("Test D010 - Firewall");
		System.out.println("Single IP, subnet mask, network coverage are normally activated according to the selection? \n" +
				"단일 아이피, 서브넷 마스크, 네트워크 범위 선택에 따른 활성화가 정상적으로 되는가?\n");

		//Click Firewall menu
		driver.findElement(By.xpath("//span[contains(text(), 'Firewall')]")).click();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

		try{
			Thread.sleep(3000);
		} catch(Exception e) {}
		// Click CheckBox
		WebElement fire = driver.findElement(By.xpath("//*[@name='secureEnable']"));
		if (!fire.isSelected())
			driver.findElement(By.xpath("//*[@name='secureEnable']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		try{
			Thread.sleep(1500);
		} catch(Exception e) {}
		// Click CheckBox
		driver.findElement(By.xpath("//*[@id='denylist']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		try{
			Thread.sleep(1500);
		} catch(Exception e) {}
		// Click Confirm
		driver.findElement(By.xpath("//button[contains(text(), 'Add')]")).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		try{
			Thread.sleep(3000);
		} catch(Exception e) {}

		
		System.out.println("------------------------------");
		System.out.println("Default Enabled");
		System.out.println("------------------------------");
		ip[0] = driver.findElement(By.xpath("//*[@id='networkSingle']")).getAttribute("class");
		subnet1[0] = driver.findElement(By.xpath("//*[@id='networkNetmask1']")).getAttribute("class");
		subnet2[0] = driver.findElement(By.xpath("//*[@id='networkNetmask2']")).getAttribute("class");
		network1[0] = driver.findElement(By.xpath("//*[@id='networkRange1']")).getAttribute("class");
		network2[0] = driver.findElement(By.xpath("//*[@id='networkRange2']")).getAttribute("class");

		Enabled(1);

		try{
			Thread.sleep(1000);
		} catch(Exception e) {}

		// Click SubnetMask
		driver.findElement(By.xpath("//*[@id='secureNetworkTypeNetwork']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		System.out.println("------------------------------");
		System.out.println("SubnetMask Click Enabled");
		System.out.println("------------------------------");
		ip[0] = driver.findElement(By.xpath("//*[@id='networkSingle']")).getAttribute("class");
		subnet1[0] = driver.findElement(By.xpath("//*[@id='networkNetmask1']")).getAttribute("class");
		subnet2[0] = driver.findElement(By.xpath("//*[@id='networkNetmask2']")).getAttribute("class");
		network1[0] = driver.findElement(By.xpath("//*[@id='networkRange1']")).getAttribute("class");
		network2[0] = driver.findElement(By.xpath("//*[@id='networkRange2']")).getAttribute("class");

		Enabled(2);

		try{
			Thread.sleep(1000);
		} catch(Exception e) {}

		// Click SubnetMask
		driver.findElement(By.xpath("//*[@id='secureNetworkTypeRange']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		System.out.println("------------------------------");
		System.out.println("Network Click Enabled");
		System.out.println("------------------------------");
		ip[0] = driver.findElement(By.xpath("//*[@id='networkSingle']")).getAttribute("class");
		subnet1[0] = driver.findElement(By.xpath("//*[@id='networkNetmask1']")).getAttribute("class");
		subnet2[0] = driver.findElement(By.xpath("//*[@id='networkNetmask2']")).getAttribute("class");
		network1[0] = driver.findElement(By.xpath("//*[@id='networkRange1']")).getAttribute("class");
		network2[0] = driver.findElement(By.xpath("//*[@id='networkRange2']")).getAttribute("class");

		Enabled(3);
		
		try {
	        BufferedWriter out = new BufferedWriter(new FileWriter("Nerwork_Service.txt", true));
	        	out.write("*****************************************************************\r\n");
		        out.write("*                             Firewall                          *\r\n");
		        out.write("*****************************************************************\r\n");
		        out.write("Test D010 - Firewall \r\n");
		        out.write("Single IP, subnet mask, network coverage are normally activated according to the selection? \r\n" +
						"단일 아이피, 서브넷 마스크, 네트워크 범위 선택에 따른 활성화가 정상적으로 되는가?\r\n");
		        out.write("=================================================================\r\n");
		        out.write("----------------------------Default Enabled----------------------\r\n");
		        out.write(ip[1] + "\r\n" + subnet1[1] + "\r\n" + subnet2[1] + "\r\n" + network1[1] + "\r\n" + network2[1] + "\r\n");
		        out.write("-----------------------SubnetMask Click Enabled------------------\r\n");
		        out.write(ip[2] + "\r\n" + subnet1[2] + "\r\n" + subnet2[2] + "\r\n" + network1[2] + "\r\n" + network2[2] + "\r\n");
		        out.write("-------------------------Network Click Enabled-------------------\r\n");
		        out.write(ip[3] + "\r\n" + subnet1[3] + "\r\n" + subnet2[3] + "\r\n" + network1[3] + "\r\n" + network2[3] + "\r\n");
	            out.close();
	        } catch (IOException e) {}
	}

	public static void Enabled(int i){
		if (ip[0].contains("disabled")) {
			ip[i] = "IP : \t\tDisabled";
			System.out.println("IP : \t\tDisabled");
		} else {
			ip[i] = "IP : \t\tEnabled";
			System.out.println("IP : \t\tEnabled");
		}
		
		if (subnet1[0].contains("disabled")) {
			subnet1[i] = "SubnetMask1 : \tDisabled";
			System.out.println("SubnetMask1 : \tDisabled");
		} else {
			subnet1[i] = "SubnetMask1 : \tEnabled";
			System.out.println("SubnetMask1 : \tEnabled");
		}

		if (subnet2[0].contains("disabled")) {
			subnet2[i] = "SubnetMask2 : \tDisabled";
			System.out.println("SubnetMask2 : \tDisabled");
		} else {
			subnet2[i] = "SubnetMask2 : \tEnabled";
			System.out.println("SubnetMask2 : \tEnabled");
		}

		if (network1[0].contains("disabled")) {
			network1[i] = "Network1 : \t\tDisabled";
			System.out.println("Network1 : \t\tDisabled");
		} else {
			network1[i] = "Network1 : \t\tEnabled";
			System.out.println("Network1 : \t\tEnabled");
		}

		if (network2[0].contains("disabled")) {
			network2[i] = "Network2 : \t\tDisabled";
			System.out.println("Network2 : \t\tDisabled");
		} else {
			network2[i] = "Network2 : \t\tEnabled";
			System.out.println("Network2 : \t\tEnabled");
		}
	}
}
