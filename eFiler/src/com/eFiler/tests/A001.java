package com.eFiler.tests;

import static org.junit.Assert.*;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.openqa.selenium.*;

public class A001 extends BaseTestLogic {
	
	private static String eFilerLogin = "";
	
	public A001(WebDriver webDriver, File fileConf, File fileReport) {
		super(webDriver, fileConf, fileReport);
		// TODO Auto-generated constructor stub
	}

	void startTest() throws InterruptedException  {
		System.out.println("*****************************************************************");
		System.out.println("*                             Login Status                      *");
		System.out.println("*****************************************************************");
		System.out.println("Test A001 - eFiler");
		System.out.println("Login status maintained when logged-in from main page while going to eFiler?\n" +
							"메인페이지에서 로그인 되었을 경우 로그인이 유지되어 동작 되는가? \n"+
							"----------------------------------------------------------");

		if (isElementPresent(By.id("treeName"))){		//If eFiler logo present
			String str = driver.findElement(By.id("treeName")).getText();
			if (str.equals("eFiler"))			//If eFiler present, login status to eFiler is successful
				eFilerLogin = "Login status maintained for eFiler";
			else
				eFilerLogin = "Login status for eFiler FAILED";
		}else
			eFilerLogin = "Login status for eFiler FAILED";
		
		System.out.println(eFilerLogin);
		
		try {
			StringBuilder builder = new StringBuilder();
	        BufferedWriter out = new BufferedWriter(new FileWriter(fReport));
	        builder.append("\r\n*****************************************************************\r\n");
	        builder.append("*                           Login Status                        *\r\n");
	        builder.append("*****************************************************************\r\n");
	        builder.append("Test A001 - eFiler\r\n");
	        builder.append("Login status maintained when logged-in from main page while going to eFiler? \r\n" +
						"메인페이지에서 로그인 되었을 경우 로그인이 유지되어 동작 되는가?\r\n");
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
