package com.eFiler.tests;

import static org.junit.Assert.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

@SuppressWarnings({ "unused" })
public class A002 extends BaseTestLogic {

	private static String eFilerLogin = "", baseUrl="";
	
	public A002(WebDriver webDriver, File fileConf, File fileReport) {
		super(webDriver, fileConf, fileReport);
		// TODO Auto-generated constructor stub
		fConf = fileConf;
		driver = webDriver;
	}

	void startTest() throws InterruptedException  {
		System.out.println("*****************************************************************");
		System.out.println("*                             Login Status                      *");
		System.out.println("*****************************************************************");
		System.out.println("Test A002 - eFiler");
		System.out.println("If the device is not logged in, while trying to go to eFiler it redirects to login page?\n" +
							"로그인이 되어 있지 않을 경우 로그인 페이지로 가는가?\n"+
							"----------------------------------------------------------");
		
		
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(fConf));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
	        for (int i=0; i<=1; i++){
	        	String line = br.readLine();
	        		//System.out.println(line + "\n");
		        	String[] tokens = line.split("=");
		        	if (tokens[0].equals("url")){
	            		baseUrl = tokens[1];
	            		break;
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
		
		Thread.sleep(2000);		//wait for eFiler loading
		driver.findElement(By.className("logoutIcon")).click();
		Thread.sleep(2000);
		driver.get(baseUrl + "/efiler/");
		Thread.sleep(2000);
		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout");
			try { 
				if (isElementPresent(By.cssSelector("input.btn_login"))) {
					eFilerLogin = "Can redirect to Login page successfully";
					break; 	
				}else{
					eFilerLogin = "Redirect to Login page FAILED";
					break;
				}
			} catch (Exception e) {
				//System.out.println("baseUrl + /efiler/ : not search loginbutton -> index no");
			}
			Thread.sleep(500);
		}
		
		System.out.println(eFilerLogin);
		
		try {
			StringBuilder builder = new StringBuilder();
	        BufferedWriter out = new BufferedWriter(new FileWriter(fReport, true));
	        
	        builder.append("\r\n*****************************************************************\r\n");
	        builder.append("*                           Login Status                        *\r\n");
	        builder.append("*****************************************************************\r\n");
	        builder.append("Test A002 - eFiler\r\n");
	        builder.append("If the device is not logged in, while trying to go to eFiler it redirects to login page?\r\n" +
						"로그인이 되어 있지 않을 경우 로그인 페이지로 가는가?\r\n");
	        builder.append("=================================================================\r\n");
	        builder.append(eFilerLogin + "\r\n");
	        
	        out.write(builder.toString());

			if(Lisenter != null){
				Lisenter.onReportLisenter(builder.toString());
			}
            out.close();
	        } catch (IOException e) {}
	}
}

