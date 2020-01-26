package com.example.tests;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class E007 extends Network_Service{

	public void E007(){
		System.out.println("*****************************************************************");
		System.out.println("*                           Auto Router                         *");
		System.out.println("*****************************************************************");
		System.out.println("Test E007 - Auto Router");
		System.out.println("Status updates after port forwarding accordingly for each service? \n" +
				"�ㅼ젙 �섏뼱吏��쒕퉬�ㅼ뿉 ��빐 �ы듃 蹂�꼍��UPNP�ы듃���숈떆���묒슜�섎뒗媛� \n");

		//Click Auto Router menu
		driver.findElement(By.xpath("//span[contains(text(), 'Auto router')]")).click();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

		try{
			Thread.sleep(1500);
		} catch(Exception e) {}

		// Print port
		String bservice = driver.findElement(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/div/div[4]/div/div/div/div[2]/div[2]/div/div/div[2]/div/div[4]/table/tbody/tr/td[2]/div")).getText();
		String bport = driver.findElement(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/div/div[4]/div/div/div/div[2]/div[2]/div/div/div[2]/div/div[4]/table/tbody/tr/td[3]/div")).getText();
		System.out.println("--------------------------Before port--------------------");
		System.out.println("service : " + bservice + "\tport : " + bport);

		//Refresh
		try{
			Thread.sleep(2000);
		} catch(Exception e) {}
		String url = driver.getCurrentUrl();		
		driver.navigate().to(url);
		try{
			Thread.sleep(2000);
		} catch(Exception e) {}

		// Click Telnet/SSH menu
		driver.findElement(By.xpath("//span[contains(text(), 'Telnet/SSH')]")).click();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

		try{
			Thread.sleep(3000);
		} catch(Exception e) {}

		WebElement ssh = driver.findElement(By.xpath("//*[@name='sshenable']"));
		if (!ssh.isSelected())
			ssh.click();

		try{
			Thread.sleep(1000);
		} catch(Exception e) {}

		// Change PortNumber
		WebElement element_port = driver.findElement(By.id("sport"));
		element_port.clear();
		element_port.sendKeys("24");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		try{
			Thread.sleep(1500);
		} catch(Exception e) {}

		// Click Confirm
		driver.findElement(By.xpath("//button[contains(text(), 'Confirm')]")).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		try{
			Thread.sleep(3000);
		} catch(Exception e) {}
		// Click Ok
		driver.findElement(By.xpath("//button[contains(text(), 'OK')]")).click();

		//Refresh
		try{
			Thread.sleep(2000);
		} catch(Exception e) {}
		url = driver.getCurrentUrl();		
		driver.navigate().to(url);
		try{
			Thread.sleep(2000);
		} catch(Exception e) {}

		// Click Auto Router menu
		driver.findElement(By.xpath("//span[contains(text(), 'Auto router')]")).click();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

		try{
			Thread.sleep(1500);
		} catch(Exception e) {}

		// Print port
		String aservice = driver.findElement(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/div/div[4]/div/div/div/div[2]/div[2]/div/div/div[2]/div/div[4]/table/tbody/tr/td[2]/div")).getText();
		String aport = driver.findElement(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/div/div[4]/div/div/div/div[2]/div[2]/div/div/div[2]/div/div[4]/table/tbody/tr/td[3]/div")).getText();

		System.out.println("--------------------------After port--------------------");
		System.out.println("service : " + aservice + "\tport : " + aport);

		try {
			BufferedWriter out = new BufferedWriter(new FileWriter("Nerwork_Service.txt", true));
			out.write("*****************************************************************\r\n");
			out.write("*                           Auto Router                         *\r\n");
			out.write("*****************************************************************\r\n");
			out.write("Test E007 - Auto Router \r\n");
			out.write("Status updates after port forwarding accordingly for each service? \r\n" +
					"�ㅼ젙 �섏뼱吏��쒕퉬�ㅼ뿉 ��빐 �ы듃 蹂�꼍��UPNP�ы듃���숈떆���묒슜�섎뒗媛� \r\n");
			out.write("=================================================================\r\n");
			out.write("--------------------------Before Port-------------------\r\n");
			out.write("service : " + bservice + "\tport : " + bport + "\r\n");
			out.write("--------------------------After Port-------------------\r\n");
			out.write("service : " + aservice + "\tport : " + aport + "\r\n");
			out.close();
		} catch (IOException e) {}
	}
}
