//Can change language normally?
//언어 변경이 정상적으로 적용 되는가? 

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


import com.thoughtworks.selenium.Selenium;

public class B020 extends System_Setting {
	private static String currentLang = "", currentLang1 = "", successMsg = "", status = "";
		
	//public static void main(String[] args) throws InterruptedException {
	public void B020() throws InterruptedException{
		System.out.println("*****************************************************************");
		System.out.println("*                    Change Language                    *");
		System.out.println("*****************************************************************");
		System.out.println("Test B020 - System -> Language and Time ");
		System.out.println("Can change language normally? \n" +
				"언어 변경이 정상적으로 적용 되는가? \n" + 
				"--------------------------------------------------------\n");
		
		try {
	        BufferedWriter out = new BufferedWriter(new FileWriter("D:\\System_Setting.txt", true));
	        	out.write("\r\n*****************************************************************\r\n");
		        out.write("*                        Change Language                    *\r\n");
		        out.write("*****************************************************************\r\n");
		        out.write("Test B020 - System -> Language and Time \r\n");
		        out.write("Can change language normally? \r\n" +
							"언어 변경이 정상적으로 적용 되는가?\r\n");
		        out.write("=================================================================\r\n");
//                out.write(status + "\r\n" + successMsg + "\r\n=============================================");
	            out.close();
	        } catch (IOException e) {}
		
		driver.findElement(By.xpath("//body/div/div[2]/div/div/div/div/ul/div/li[2]/ul/li[4]/div/a/span")).click();
		System.out.println("Language and Time menu......");
		
		for (int i =1; i<=4; i++){
			System.out.println("Test :" + i);
			//Changing system language
			//String currentLang = driver.findElement(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/div/div/div[2]/div/div[2]/label")).getText();
			currentLang = driver.findElement(By.id("languageWebView")).getAttribute("value");
			if (currentLang.equals("English")){
				status = "Current system language : " + currentLang +  "\r\nChanging to Korean...";
				//System.out.println("Current system language : " + currentLang +  "\nChanging to Korean...");
				
				driver.findElement(By.id("languageWebView")).click(); // Click display language
				Thread.sleep(2000);
				
				driver.findElement(By.xpath("//body/div[14]/div/div[2]")).click(); // choose Korean lang
				//driver.findElement(By.xpath("//div[@class,'x-combo-list-item x-combo-selected']")).click(); // Korean ¼±ÅÃ
				//driver.findElement(By.xpath("//*[@id,'ext-gen215']/div/div[2]")).click(); // Korean ¼±ÅÃ
			}else{
				status = "Current system language : " + currentLang +  "\r\nChanging to English...";
				//System.out.println("Current system language : " + currentLang +  "\nChanging to English...");
				
				driver.findElement(By.id("languageWebView")).click(); // Click display language
				Thread.sleep(2000);
				
				driver.findElement(By.xpath("//body/div[14]/div/div")).click(); // choose English lang
			}
			System.out.println(status);		
			
			Thread.sleep(2000);		
			driver.findElement(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/div/table/tbody/tr[2]/td[2]")).click(); //confirm
			Thread.sleep(3000);
			//String currentLang1 = driver.findElement(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/div/div/div[2]/div/div[2]/label")).getText();
			currentLang1 = driver.findElement(By.id("languageWebView")).getAttribute("value");
			
			if(currentLang1.equals(currentLang)) {
				successMsg = "Display language change failed.";
			}else{
	//			if(currentLang1.equals("Display Language:")) {
	//				System.out.println("Updated Language : English");
	//				System.out.println("Display language changed successfully.");
	//			} else if(currentLang1.equals("표시 언어:")) {
	//				System.out.println("Updated Language : Korean");
	//				System.out.println("Display language changed successfully.");
	//			}
				successMsg = "Updated Language : " + currentLang1 + "\r\nDisplay language changed successfully.";
	//			System.out.println("Updated Language : " + currentLang1);
	//			System.out.println("Display language changed successfully.");
			}
			System.out.println(successMsg + "\r\n=============================================");
		
			try {
		        BufferedWriter out = new BufferedWriter(new FileWriter("D:\\System_Setting.txt", true));
//		        	out.write("\r\n*****************************************************************\r\n");
//			        out.write("*                        Change Language                    *\r\n");
//			        out.write("*****************************************************************\r\n");
//			        out.write("Test B020 - System -> Language and Time \r\n");
//			        out.write("Can change language normally? \r\n" +
//								"언어 변경이 정상적으로 적용 되는가?\r\n");
//			        out.write("=================================================================\r\n");
	                out.write(status + "\r\n" + successMsg + "\r\n=============================================\r\n");
		            out.close();
		        } catch (IOException e) {}
			
		} //end loop
	
	}

//	private static boolean isElementPresent(By by) {
//		try {
//			driver.findElement(by);
//			return true;
//		} catch (NoSuchElementException e) {
//			return false;
//		}
//	}
}
