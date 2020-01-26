package com.eWizard.tests;

import java.io.*;

import static org.junit.Assert.*;
import org.openqa.selenium.*;

public class A003 extends BaseTestLogic {

	private static StringBuffer verificationErrors = new StringBuffer();
	private static String admin_Desc = "", admin_email = "", admin_Pass = "", userID = "";
	private static String systemOut = "", fileManager = "", eApps = "", eMobile = "", MobileWeb = "", status = "";

	public A003(WebDriver webDriver, File fileConf, File fileReport) {
		super(webDriver, fileConf, fileReport);
		fConf = fileConf;
	}
	
	void startTest() throws InterruptedException  {
		System.out.println("*****************************************************************");
		System.out.println("*                           General Setting                     *");
		System.out.println("*****************************************************************");
		System.out.println("Test A003 - Quick Setup -> General Setting");
		System.out.println("User info (admin) setting can be done normally? \n" +
							"Email and password set here is same as Admin setting from eSetup?\n" + 
							"사용자 정보(관리자) 설정은 정상적으로 되는가?\n" + 
							"비밀번호 형식, 이메일형식은 동일한가? \n");

			
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(fConf));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
	        for (int i=1; i<=7; i++){
	        	String line = br.readLine();
	        		//System.out.println(line + "\n");
		        	String[] tokens = line.split("=");
		        	if (tokens[0].equals("ID")){
	            		userID = tokens[1];
		        	}else if (tokens[0].equals("admin_Desc")){
	            		admin_Desc = tokens[1];
		        	}else if (tokens[0].equals("admin_email")){
		        		admin_email = tokens[1];
		        	}else if(tokens[0].equals("admin_Pass")){
		        		admin_Pass = tokens[1];
		        	} 
	        }
	    } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
	        try {
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
		
		//Click Quick Start
		driver.findElement(By.name("Image3")).click();
		
		Thread.sleep(3000);		
		driver.findElement(By.id("userdesc")).clear();		
		driver.findElement(By.id("userdesc")).sendKeys(admin_Desc);
		
		driver.findElement(By.id("email")).clear();		
		driver.findElement(By.id("email")).sendKeys(admin_email);
		
		driver.findElement(By.id("password")).clear();		
		driver.findElement(By.id("password")).sendKeys(admin_Pass);
		
		driver.findElement(By.id("password1")).clear();		
		driver.findElement(By.id("password1")).sendKeys(admin_Pass);
		
		driver.findElement(By.xpath("//input[@value='Confirm']")).click();
		
		Thread.sleep(3000);
		if (isElementPresent(By.xpath("//body/div[10]/div[2]/div/div/div/div/div/div[2]/span"))){
			systemOut = driver.findElement(By.xpath("//body/div[10]/div[2]/div/div/div/div/div/div[2]/span")).getText();
			driver.findElement(By.xpath("//button[contains(text(), 'OK')]")).click();
		}
		
		System.out.println("System Output:" + systemOut);
		driver.findElement(By.xpath("//input[@value='Close']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[contains(text(), 'Logout')]")).click();
		
		
		//Login again with new Password
		Thread.sleep(4000);
		driver.findElement(By.id("login_userid")).clear();
		driver.findElement(By.id("login_userid")).sendKeys(userID);
		driver.findElement(By.id("login_password")).clear();
		driver.findElement(By.id("login_password")).sendKeys(admin_Pass);
		driver.findElement(By.cssSelector("input.btn_login")).click();
		Thread.sleep(4000);
		driver.findElement(By.name("icon_ewizard")).click();
		Thread.sleep(3000);
		driver.findElement(By.name("Image3")).click();
		
		Thread.sleep(2000);
//		String aaa = driver.findElement(By.xpath("//*[@id='userdesc']")).getAttribute("value");
//		String bbb = driver.findElement(By.id("email")).getAttribute("value");		
//		
//		System.out.println("aaa: " + aaa + "\nbbb: " + bbb);
		
		if (admin_Desc.equals(driver.findElement(By.id("userdesc")).getAttribute("value")) && admin_email.equals(driver.findElement(By.id("email")).getAttribute("value")))
			status = "Admin informaiton setting successfull.";
		else
			status = "Admin informaiton setting FAIL.";
		
		System.out.println(status);
		
		try {
			StringBuilder builder = new StringBuilder();
	        BufferedWriter out = new BufferedWriter(new FileWriter(fReport, true));
        
	        builder.append("\r\n*****************************************************************\r\n");
	        builder.append("*                          General Setting                      *\r\n");
	        builder.append("*****************************************************************\r\n");
	        builder.append("Test A003 - Quick Setup -> General Setting\r\n");
	        builder.append("User info (admin) setting can be done normally? \r\n" +
		        			"Email and password set here is same as Admin setting from eSetup?\r\n" + 
							"사용자 정보(관리자) 설정은 정상적으로 되는가?\r\n" + 
							"비밀번호 형식, 이메일형식은 동일한가?\r\n");
	        builder.append("=================================================================\r\n");
	        builder.append("System Output: " + systemOut + "\r\n"+ status + "\r\n");
	        out.write(builder.toString());

			if(Lisenter != null){
				Lisenter.onReportLisenter(builder.toString());
			}
	        out.close();
	        } catch (IOException e) {}

		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}

	}
		
}

