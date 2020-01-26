package com.example.tests;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

public class E003 extends Network_Service{

	public void E003(){
		System.out.println("*****************************************************************");
		System.out.println("*                           Auto Router                         *");
		System.out.println("*****************************************************************");
		System.out.println("Test E003 - Auto Router");
		System.out.println("It shows available UPnP router information perfectly? \n" +
				"UPNP 설정정보는 정상적으로 출력 되는가?\n" +
				"-----------------------------------------------------------");

		//Click Auto Router menu
		driver.findElement(By.xpath("//span[contains(text(), 'Auto router')]")).click();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

		try{
			Thread.sleep(6000);
		} catch(Exception e) {}

		// isSelected
		String exIP = driver.findElement(By.xpath("//div[@id='externalip']")).getText();
		String gateWay = driver.findElement(By.xpath("//div[@id='gatewayip']")).getText();
		String inIP = driver.findElement(By.xpath("//div[@id='localip']")).getText();
		String st = driver.findElement(By.xpath("//div[@id='upnpconnect']")).getText();

		System.out.println(exIP);
		System.out.println(gateWay);
		System.out.println(inIP);
		System.out.println(st);

		try {
			BufferedWriter out = new BufferedWriter(new FileWriter("Nerwork_Service.txt", true));
			out.write("*****************************************************************\r\n");
			out.write("*                           Auto Router                         *\r\n");
			out.write("*****************************************************************\r\n");
			out.write("Test E003 - Auto Router \r\n");
			out.write("It shows available UPnP router information perfectly? \r\n" +
					"UPNP 설정정보는 정상적으로 출력 되는가?\r\n");
			out.write("=================================================================\r\n");
			out.write("--------------------------router information---------------------\r\n");
			out.write("exIP : " + exIP + "\r\n");
			out.write("gateWay : " + gateWay + "\r\n");
			out.write("inIP : " + inIP + "\r\n");
			out.write("st : " + st + "\r\n");
			out.close();
		} catch (IOException e) {}
	}
}
