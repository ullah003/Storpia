/*Is it shows lists accordingly to All accepted, Reserved List, Accepted list?
전체 허용, 목록내 리스트 불허, 목록내 리스트 허용 선택에 따른 리스트가 출력 되는가?
Can't "Add/Delete" (disabled) IP for "All Accepted" item? 
전체허용은 리스트의내용과 추가, 삭제 할수 없음
 
 */

package com.example.tests;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class D009 extends Network_Service{

	public void D009(){
		System.out.println("*****************************************************************");
		System.out.println("*                            Firewall                           *");
		System.out.println("*****************************************************************");
		System.out.println("Test D009 - Firewall");
		System.out.println("Is it shows lists accordingly to All accepted, Reserved List, Accepted list? \n" +
				"전체 허용, 목록내 리스트 불허, 목록내 리스트 허용 선택에 따른 리스트가 출력 되는가? \n");

		// Click Firewall menu
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

		// Click Reserved list
		driver.findElement(By.xpath("//*[@id='denylist']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		for (int i = 0; i < 10; i++) {
			try{
				Thread.sleep(1500);
			} catch(Exception e) {}
			// Click Add
			driver.findElement(By.xpath("//button[contains(text(), 'Add')]")).click();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

			String IP = "192.168.1.5" + i;

			// IP Input
			WebElement element_ip = driver.findElement(By.id("networkSingle"));
			element_ip.sendKeys(IP);

			WebElement element_dec = driver.findElement(By.id("secureNetworkDesc"));
			element_dec.sendKeys(IP);

			try{
				Thread.sleep(1000);
			} catch(Exception e) {}

			// Click Confirm
			driver.findElement(By.xpath("//button[contains(text(), 'Confirm')]")).click();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

			try{
				Thread.sleep(3000);
			} catch(Exception e) {}
			// Click Ok
			driver.findElement(By.xpath("//button[contains(text(), 'OK')]")).click();
		}

		try{
			Thread.sleep(1000);
		} catch(Exception e) {}		
		driver.findElement(By.xpath("//button[contains(text(), 'Save firewall settings')]")).click();

		try{
			Thread.sleep(2000);
		} catch(Exception e) {}
		driver.findElement(By.xpath("//button[contains(text(), 'OK')]")).click();

		// Click Accepted list
		driver.findElement(By.xpath("//*[@id='allowlist']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		for (int i = 0; i < 10; i++) {
			try{
				Thread.sleep(1500);
			} catch(Exception e) {}
			// Click Add
			driver.findElement(By.xpath("//button[contains(text(), 'Add')]")).click();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

			String IP = "192.168.1.6" + i;

			// IP Input
			WebElement element_ip = driver.findElement(By.id("networkSingle"));
			element_ip.sendKeys(IP);

			WebElement element_dec = driver.findElement(By.id("secureNetworkDesc"));
			element_dec.sendKeys(IP);

			try{
				Thread.sleep(1000);
			} catch(Exception e) {}

			// Click Confirm
			driver.findElement(By.xpath("//button[contains(text(), 'Confirm')]")).click();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

			try{
				Thread.sleep(3000);
			} catch(Exception e) {}
			// Click Ok
			driver.findElement(By.xpath("//button[contains(text(), 'OK')]")).click();
		}

		try{
			Thread.sleep(1000);
		} catch(Exception e) {}		
		driver.findElement(By.xpath("//button[contains(text(), 'Save firewall settings')]")).click();

		try{
			Thread.sleep(2000);
		} catch(Exception e) {}
		driver.findElement(By.xpath("//button[contains(text(), 'OK')]")).click();

		pageRefresh();

		// Click Firewall menu
		driver.findElement(By.xpath("//span[contains(text(), 'Firewall')]")).click();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

		try{
			Thread.sleep(2000);
		} catch(Exception e) {}

		// Click Reserved list
		driver.findElement(By.xpath("//*[@id='denylist']")).click();

		try{
			Thread.sleep(1000);
		} catch(Exception e) {}

		// Reserved List
		System.out.println("---------------Reserved list---------------");
		System.out.println("Network address\t\tDescription\t\tStatus");

		String[] listAddress = new String[10];
		String[] listDec = new String[10];
		String[] listStatus = new String[10];
		for (int i = 0; i<10; i++) {
			listAddress[i] = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/div/div/div/div/div[2]/div/div/div/div[2]/div[2]/div/div/div[2]/div/div[" + (i+1) + "]/table/tbody/tr/td/div")).getText();
			listDec[i] = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/div/div/div/div/div[2]/div/div/div/div[2]/div[2]/div/div/div[2]/div/div[" + (i+1) + "]/table/tbody/tr/td[2]/div")).getText();
			listStatus[i] = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/div/div/div/div/div[2]/div/div/div/div[2]/div[2]/div/div/div[2]/div/div[" + (i+1) + "]/table/tbody/tr/td[3]/div")).getText();

			System.out.println(listAddress[i] + "\t\t" + listDec[i] + "\t\t" + listStatus[i]);
		}

		// Click Accepted list
		driver.findElement(By.xpath("//*[@id='allowlist']")).click();

		try{
			Thread.sleep(1000);
		} catch(Exception e) {}

		// Accepted List
		System.out.println("---------------Accepted list---------------");
		System.out.println("Network address\t\tDescription\t\tStatus");

		String[] alistAddress = new String[10];
		String[] alistDec = new String[10];
		String[] alistStatus = new String[10];
		for (int i = 0; i<10; i++) {
			alistAddress[i] = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/div/div/div/div/div[2]/div/div/div/div[2]/div[2]/div/div/div[2]/div/div[" + (i+1) + "]/table/tbody/tr/td/div")).getText();
			alistDec[i] = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/div/div/div/div/div[2]/div/div/div/div[2]/div[2]/div/div/div[2]/div/div[" + (i+1) + "]/table/tbody/tr/td[2]/div")).getText();
			alistStatus[i] = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/div/div/div/div/div[2]/div/div/div/div[2]/div[2]/div/div/div[2]/div/div[" + (i+1) + "]/table/tbody/tr/td[3]/div")).getText();

			System.out.println(alistAddress[i] + "\t\t" + alistDec[i] + "\t\t" + alistStatus[i]);
		}

		// Click All accepted
		driver.findElement(By.xpath("//*[@id='allowlist']")).click();

		try{
			Thread.sleep(1000);
		} catch(Exception e) {}		
		driver.findElement(By.xpath("//button[contains(text(), 'Save firewall settings')]")).click();

		try{
			Thread.sleep(2000);
		} catch(Exception e) {}
		driver.findElement(By.xpath("//button[contains(text(), 'OK')]")).click();
		
		try {
	        BufferedWriter out = new BufferedWriter(new FileWriter("D:\\Nerwork_Service.txt", true));
	        	out.write("*****************************************************************\r\n");
		        out.write("*                             Firewall                          *\r\n");
		        out.write("*****************************************************************\r\n");
		        out.write("Test D009 - Firewall \r\n");
		        out.write("Is it shows lists accordingly to All accepted, Reserved List, Accepted list? \r\n" +
						"전체 허용, 목록내 리스트 불허, 목록내 리스트 허용 선택에 따른 리스트가 출력 되는가?\r\n");
		        out.write("=================================================================\r\n");
		        out.write("-----------------------------Reserved List-----------------------\r\n");
		        out.write("Network address\t\tDescription\t\tStatus");
		        for(int i = 0; i < 10; i++) {
		        	out.write(listAddress[i] + "\t\t" + listDec[i] + "\t\t" + listStatus[i] + "\r\n");
		        }
		        out.write("-----------------------------Accepted List-----------------------\r\n");
		        out.write("Network address\t\tDescription\t\tStatus");
		        for(int i = 0; i < 10; i++) {
		        	out.write(alistAddress[i] + "\t\t" + alistDec[i] + "\t\t" + alistStatus[i] + "\r\n");
		        }
	            out.close();
	        } catch (IOException e) {}
	}
}
