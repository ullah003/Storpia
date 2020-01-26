package com.example.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.io.*;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class A001_1 extends System_Information {
	
	public void A001_1(){
		System.out.println("*****************************************************************");
		System.out.println("*                         System Status                         *");
		System.out.println("*****************************************************************");
		System.out.println("Test A001 - System Information");
		System.out.println("It shows each and every information listed about the system? \n" +
				"시스템 정보 내용이 빠짐없이 출력이 되는가?\n" + 
				"(서버명, 모델명, 펌웨어버전, 펌웨어날짜)\n" +
				"모델명은 현재 존재하는 모델명으로 되어 있는가?\n");
		
		// Click System status menu
		System_Information.driver.findElement(By.linkText("System Status")).click();
	
		// get Server Name
		String serverName= System_Information.driver.findElement(By.xpath("//body/div[2]/div/div/div/div[2]" +
				"/div/div/div[2]/div/div/div/div/div/div/form/div/div[2]/div/div/div/div[2]/div/div" +
				"/table/tbody/tr/td[2]/div")).getText();
		System.out.println("Server name : " + serverName);
	
		// get model
		String model = System_Information.driver.findElement(By.xpath("//body/div[2]/div/div/div/div[2]/div/div" +
				"/div[2]/div/div/div/div/div/div/form/div/div[2]/div/div/div/div[2]/div/div[2]" +
				"/table/tbody/tr/td[2]/div")).getText();
		System.out.println("Model : " + model);
	
		// get Firmware Version
		String firmwareVersion = System_Information.driver.findElement(By.xpath("//body/div[2]/div/div/div/div[2]" +
				"/div/div/div[2]/div/div/div/div/div/div/form/div/div[2]/div/div/div/div[2]/div/div[3]" +
				"/table/tbody/tr/td[2]/div")).getText();
		System.out.println("FirmwareVersion : " + firmwareVersion);
	
		// get Firmware Date
		String firmwareDate = System_Information.driver.findElement(By.xpath("//body/div[2]/div/div/div/div[2]/div" +
				"/div/div[2]/div/div/div/div/div/div/form/div/div[2]/div/div/div/div[2]/div/div[4]" +
				"/table/tbody/tr/td[2]/div")).getText();
		System.out.println("Firmware Date : " + firmwareDate);
	}
}