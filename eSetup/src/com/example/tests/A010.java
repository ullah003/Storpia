//All logs can be deleted at a time?
//전체 삭제 버튼 클릭시 로그내용전체가 삭제 되는가?
							
package com.example.tests;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
//import java.util.regex.Pattern;
//import java.util.concurrent.TimeUnit;
//import org.junit.*;
//import static org.junit.Assert.*;
//import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.support.ui.Select;

public class A010 extends System_Information {
	private static String Success = "";
	
	//public static void main(String [] args) throws InterruptedException {
	public void A010() throws InterruptedException{
		System.out.println("*****************************************************************");
		System.out.println("*                           Delete Log                          *");
		System.out.println("*****************************************************************");
		System.out.println("Test A010 - Information -> Log Delete");
		System.out.println("All logs can be deleted at a time? \n" +
				"전체 삭제 버튼 클릭시 로그내용전체가 삭제 되는가? \n" +
				"------------------------------------------------------------------------");
		
		driver.findElement(By.xpath("//body/div/div[2]/div/div/div/div/ul/div/li/ul/li[3]/div/a/span")).click();
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/div/div/table/tbody/tr/td/table/tbody/tr/td[3]/table/tbody/tr[2]/td[2]/em/button")).click();
		driver.findElement(By.xpath("//body/div[18]/div[2]/div[2]/div/div/div/div/table/tbody/tr/td/table/tbody/tr/td[2]/table/tbody")).click(); // /tr[2]/td[2]

		Thread.sleep(3000);
		String result = driver.findElement(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/div[2]/div/div/div[2]/div/div/table/tbody/tr/td[5]/div")).getText();
		if(result.equals("All logs has been deleted.")) {
			Success = result + "\n Log deletion Successfull.";
		}else{
			Success = "Can't delete All logs. \n Log deletion FAIL.";
		}
		System.out.println(Success);
		
		try {
	        BufferedWriter out = new BufferedWriter(new FileWriter("D:\\System_Information.txt", true));
	            out.write("\r\n*****************************************************************\r\n");
		        out.write("*                             Delete Log                        *\r\n");
		        out.write("*****************************************************************\r\n");
		        out.write("Test A010 - Information -> Log Delete \r\n");
		        out.write("All logs can be deleted at a time? \r\n" +
							"전체 삭제 버튼 클릭시 로그내용전체가 삭제 되는가? \r\n");
		        out.write("=================================================================\r\n");
                out.write(Success + "\r\n");
	            out.close();
	        } catch (IOException e) {}
	}
}
