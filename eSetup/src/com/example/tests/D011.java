package com.example.tests;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

public class D011 extends Network_Service{

	public void D011(){
		System.out.println("*****************************************************************");
		System.out.println("*                            Firewall                           *");
		System.out.println("*****************************************************************");
		System.out.println("Test D011 - Firewall");
		System.out.println("Setting window can accept and save input value to activate Firewall successfully? \n" +
				"설정저정은 정상적으로 이루어 지는가?\n");

		//Click Firewall menu
		driver.findElement(By.xpath("//span[contains(text(), 'Firewall')]")).click();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

		try{
			Thread.sleep(3000);
		} catch(Exception e) {}

		// Click CheckBox
		if (!driver.findElement(By.xpath("//*[@name='secureEnable']")).isSelected())
			driver.findElement(By.xpath("//*[@name='secureEnable']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		try{
			Thread.sleep(1500);
		} catch(Exception e) {}

		// Click RadioButton
		driver.findElement(By.xpath("//*[@id='denylist']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		try{
			Thread.sleep(1500);
		} catch(Exception e) {}

		// Click Save...
		driver.findElement(By.xpath("//button[contains(text(), 'Save firewall settings')]")).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		try{
			Thread.sleep(2000);
		} catch(Exception e) {}
		// Click Ok
		driver.findElement(By.xpath("//button[contains(text(), 'OK')]")).click();

		pageRefresh();
		
		// Click Firewall menu
		driver.findElement(By.xpath("//span[contains(text(), 'Firewall')]")).click();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

		try{
			Thread.sleep(2000);
		} catch(Exception e) {}

		String resualt;
		// isSelected
		if (driver.findElement(By.xpath("//*[@id='denylist']")).isSelected()) {
			resualt = "Successfully";
			System.out.println("Successfully");
		} else {
			resualt = "Failed";
			System.out.println("Failed");
		}

		try {
			BufferedWriter out = new BufferedWriter(new FileWriter("Nerwork_Service.txt", true));
			out.write("*****************************************************************\r\n");
			out.write("*                             Firewall                          *\r\n");
			out.write("*****************************************************************\r\n");
			out.write("Test D011 - Firewall \r\n");
			out.write("Setting window can accept and save input value to activate Firewall successfully? \r\n" +
					"설정저정은 정상적으로 이루어 지는가?\r\n");
			out.write("=================================================================\r\n");
			out.write("--------------------------------Resualt--------------------------\r\n");
			out.write("activate Firewall : " + resualt + "\r\n");
			out.close();
		} catch (IOException e) {}
	}
}
