//E-mail setting can be done properly?
//메일설정이 정상적으로 저장 되는가?

package com.example.tests;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
//import java.util.concurrent.TimeUnit;
//import static org.junit.Assert.*;
import org.openqa.selenium.*;
//import org.openqa.selenium.firefox.FirefoxDriver;


public class B022 extends System_Setting {
//	private static WebDriver driver;
//	private static String baseUrl;
	private static StringBuffer verificationErrors = new StringBuffer();
	private static String sentSuccess = "", settingSuccess = "";
	private static String SMTPserver = "", SMTPport = "", MailName = "", MailPass = "", PrimaryMail = "", SeconderyMail = "";
	
	//public static void main(String [] args) throws IOException, InterruptedException {
	public void B022() throws InterruptedException, IOException{
		System.out.println("*****************************************************************");
		System.out.println("*                    E-mail and Notification                    *");
		System.out.println("*****************************************************************");
		System.out.println("Test B022 - System -> E-mail and Notification ");
		System.out.println("E-mail setting can be done properly? \n" +
				"메일설정이 정상적으로 저장 되는가? \n" + 
				"--------------------------------------------------------\n");
		
		// Before
//		driver = new FirefoxDriver();
//		baseUrl = "http://192.168.1.84:9000/";
//		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		BufferedReader br = new BufferedReader(new FileReader("D:\\SystemConf.txt"));
		//LineNumberReader br = new LineNumberReader(new FileReader("D:\\SystemConf.txt"));
		try {
	        for (int i=0; i<=9; i++){
	        	String line = br.readLine();
	        	if (i > 3){
		        	//System.out.println(line + "\n");
		        	String[] tokens = line.split("=");
	            	if (tokens[0].equals("SMTPserver")){
	            		SMTPserver = tokens[1];
		        	}else if (tokens[0].equals("SMTPport")){
		        		SMTPport = tokens[1];
		        	}else if (tokens[0].equals("MailName")){
		        		MailName = tokens[1];
		        	}else if (tokens[0].equals("MailPass")){
		        		MailPass = tokens[1];
		        	}else if (tokens[0].equals("PrimaryMail")){
		        		PrimaryMail = tokens[1];
		        	}else if (tokens[0].equals("SeconderyMail")){
		        		SeconderyMail = tokens[1];
		        	}
	        	}
	        }
	    } finally {
	        br.close();
	    }
	
		// Test
//		driver.get(baseUrl + "/index.php");
//		driver.findElement(By.id("login_userid")).clear();
//		driver.findElement(By.id("login_userid")).sendKeys("admin");
//		driver.findElement(By.id("login_password")).clear();
//		driver.findElement(By.id("login_password")).sendKeys("admin");
//		driver.findElement(By.cssSelector("input.btn_login")).click();
//		for (int second = 0;; second++) {
//			if (second >= 60) fail("timeout");
//			try { if (isElementPresent(By.name("icon_esetup"))) break; } catch (Exception e) {}
//			Thread.sleep(1000);
//		}
//
//		driver.findElement(By.name("icon_esetup")).click();
		//go to E-mail and Notification
		driver.findElement(By.xpath("//body/div/div[2]/div/div/div/div/ul/div/li[2]/ul/li[5]/div/a/span")).click();		
		
		Thread.sleep(3000);		
		driver.findElement(By.name("smtpserver")).clear();		
		//driver.findElement(By.name("smtpserver")).sendKeys("mail.gluesys.com");
		driver.findElement(By.name("smtpserver")).sendKeys(SMTPserver);
		
		Thread.sleep(1000);
		driver.findElement(By.name("port")).clear();
		//driver.findElement(By.name("port")).sendKeys("25");
		driver.findElement(By.name("port")).sendKeys(SMTPport);
		
		Thread.sleep(1000);
		if(!driver.findElement(By.name("tls_enable")).isSelected()) {
			driver.findElement(By.name("tls_enable")).click();
		}
		
		
		Thread.sleep(1000);
		if(!driver.findElement(By.name("auth_enable")).isSelected()){
			driver.findElement(By.name("auth_enable")).click();
		}
		
		
		Thread.sleep(1000);
		driver.findElement(By.name("auth_user")).clear();
		//driver.findElement(By.name("auth_user")).sendKeys("storpia.support@gluesys.com");
		driver.findElement(By.name("auth_user")).sendKeys(MailName);
		
		Thread.sleep(1000);
		driver.findElement(By.name("auth_passwd")).clear();
		//driver.findElement(By.name("auth_passwd")).sendKeys("rajuraju");
		driver.findElement(By.name("auth_passwd")).sendKeys(MailPass);
		
		Thread.sleep(1000);
		driver.findElement(By.name("auth_passwd1")).clear();
		//driver.findElement(By.name("auth_passwd1")).sendKeys("rajuraju");
		driver.findElement(By.name("auth_passwd1")).sendKeys(MailPass);
		
		Thread.sleep(1000);
		driver.findElement(By.name("to1")).clear();
		//driver.findElement(By.name("to1")).sendKeys("storpia.support@gluesys.com");
		driver.findElement(By.name("to1")).sendKeys(PrimaryMail);
		
		Thread.sleep(1000);
		driver.findElement(By.name("to2")).clear();
		//driver.findElement(By.name("to2")).sendKeys("support@storpia.com");		
		driver.findElement(By.name("to2")).sendKeys(SeconderyMail);
		
		Thread.sleep(10000);
		
		driver.findElement(By.xpath("//button[contains(text(), 'Sending test e-Mail')]")).click();		
		Thread.sleep(3000);
		
												   //body/div[13]/div[2]/div/div/div/div/div/div[2]
		sentSuccess = driver.findElement(By.xpath("//body/div[13]/div[2]/div/div/div/div/div/div[2]/span")).getText();
		driver.findElement(By.xpath("//button[contains(text(), 'OK')]")).click();
		System.out.println(sentSuccess);
		
		Thread.sleep(3000);
		if (sentSuccess.equals("Test e-mail sent successfully.")){
			driver.findElement(By.xpath("//button[contains(text(), 'Confirm')]")).click();
			Thread.sleep(3000);
			settingSuccess = driver.findElement(By.xpath("//body/div[13]/div[2]/div/div/div/div/div/div[2]/span")).getText();
			driver.findElement(By.xpath("//button[contains(text(), 'OK')]")).click();
			System.out.println(settingSuccess);
		}
		
//		String temp = driver.findElement(By.name("smtpserver")).getText();	
//		System.out.println("temp : " + temp);
		
		try {
	        BufferedWriter out = new BufferedWriter(new FileWriter("D:\\System_Setting.txt", true));
	            out.write("\r\n*****************************************************************\r\n");
		        out.write("*                        E-mail and Notification                    *\r\n");
		        out.write("*****************************************************************\r\n");
		        out.write("Test B022 - System -> E-mail and Notification \r\n");
		        out.write("E-mail setting can be done properly? \r\n" +
							"메일설정이 정상적으로 저장 되는가?\r\n");
		        out.write("=================================================================\r\n");
            	out.write(sentSuccess + "\r\n" + settingSuccess +"\r\n");
	            out.close();
	        } catch (IOException e) {}
		
		// After
		//driver.quit();
//		String verificationErrorString = verificationErrors.toString();
//		if (!"".equals(verificationErrorString)) {
//			fail(verificationErrorString);
//		}
		
	}

	private static boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}
}
