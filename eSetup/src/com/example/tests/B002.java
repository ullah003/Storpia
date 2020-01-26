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

public class B002 extends System_Setting {
//	private static WebDriver driver;
//	private static String baseUrl;
//	private static StringBuffer verificationErrors = new StringBuffer();
	private static String DNS = "", DNS1 = "", Success = "";
	
	//public static void main(String []args) throws Exception {
	public void B002() throws InterruptedException{
		System.out.println("*****************************************************************");
		System.out.println("*                             DNS Change                            *");
		System.out.println("*****************************************************************");
		System.out.println("Test B002 - System -> Network -> Modify(DNS)");
		System.out.println("Is Wired network setup information and modification works normally? \n" +
				"유선 네트워크의 설정정보및 수정이 정상 동작 되는가? +\n" + 
				"----------------------------------------------------------\n");
		
		//Click Network 
		//driver.findElement(By.xpath("//ul[@id='ext-gen119']/li/div/a/span")).click();
		driver.findElement(By.linkText("Network")).click();
		//Select eth0
		driver.findElement(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/div/div/div[2]/div[2]/div/div/div[2]/div/div/table/tbody/tr/td/div")).click();
		//Get DNS value
		DNS = driver.findElement(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/div/div/div[2]/div[2]/div/div/div[2]/div/div/table/tbody/tr/td[7]/div")).getText();
		System.out.println("Current DNS : " + DNS);
		
		driver.findElement(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/div/div/div[2]/div[2]/div/div/div[2]/div/div")).click();
		//Click Modify
		driver.findElement(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/div/div/div[2]/div/div/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[2]/td[2]/em/button")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("wdns1")).clear();
		Thread.sleep(1000);
		driver.findElement(By.id("wdns1")).sendKeys("8.8.8.8");
		//driver.findElement(By.xpath("//table[@id='ext-comp-1132']/tbody/tr[2]/td[2]")).click();
		driver.findElement(By.xpath("//button[contains(text(), 'Confirm')]")).click();
		Thread.sleep(20000);
		DNS1 = driver.findElement(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/div/div/div[2]/div[2]/div/div/div[2]/div/div/table/tbody/tr/td[7]/div")).getText();
		System.out.println("DNS after update : " + DNS1);
		
		if(DNS.equals(DNS1)) {
			Success = "-----------------------> FAIL";
		} else {
			Success = "-----------------------> PASS";
		}
		System.out.println(Success);
		
		try {
	        BufferedWriter out = new BufferedWriter(new FileWriter("D:\\System_Setting.txt", true));
	            out.write("\r\n*****************************************************************\r\n");
		        out.write("*                               DNS Change                          *\r\n");
		        out.write("*****************************************************************\r\n");
		        out.write("Test B002 - System -> Network -> Modify(DNS) \r\n");
		        out.write("Is Wired network setup information and modification works normally? \r\n" +
							"유선 네트워크의 설정정보및 수정이 정상 동작 되는가?\r\n");
		        out.write("=================================================================\r\n");
                out.write("Current DNS : " + DNS + "\r\n" + "DNS after update : " + DNS1 + "\r\n");
                out.write(Success + "\r\n");
	            out.close();
	        } catch (IOException e) {}

	}
		
}
