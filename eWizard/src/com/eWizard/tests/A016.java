package com.eWizard.tests;

import java.io.*;

import static org.junit.Assert.*;
import org.openqa.selenium.*;

public class A016 extends BaseTestLogic {

	private static StringBuffer verificationErrors = new StringBuffer();
	private static String DDNS = "", DDNS_eSetup = "", success_Msg = "", status = ""; 
	
	public A016(WebDriver webDriver, File fileConf, File fileReport) {
		super(webDriver, fileConf, fileReport);
		fConf = fileConf;
	}
	
	void startTest() throws InterruptedException  {
		System.out.println("*****************************************************************");
		System.out.println("*                               DDNS                            *");
		System.out.println("*****************************************************************");
		System.out.println("Test A016 - Quick Setup -> Network -> DDNS");
		System.out.println("Can it show current DDNS name? \n" +
							"설정되어 있는 DDNS가 정상적으로 출력되는가?\n" + 
							"----------------------------------------------------------");

		//Click Network menu
		driver.findElement(By.name("Image9")).click();
		Thread.sleep(1000);
		
		DDNS = driver.findElement(By.id("hostname")).getAttribute("value");
		if (DDNS.equals("")){
			status = "Can't display current DDNS!";
			driver.findElement(By.xpath("//input[@value='Cancel']")).click();
		}else{
			status = "Current DDNS name is: " + DDNS;
	
			driver.findElement(By.xpath("//input[@value='Cancel']")).click();
			driver.findElement(By.name("h_icon_esetup")).click();      			//go to eSetup
			
			Thread.sleep(1000);		//get Server Name
			DDNS_eSetup = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div/div/div[2]/div/div/div/div/div/div/form/div/div[2]/div/div/div/div[2]/div/div/table/tbody/tr/td[2]/div")).getText();
			System.out.println("Server name : " + DDNS_eSetup);
			//compare DDNS and server name
			if (DDNS.equals(DDNS_eSetup))
				success_Msg = "Can show current DDNS accurately.";
			else
				success_Msg = "Current DDNS displayed is not accurate!";
		}
		System.out.println(status + "\n" + success_Msg);
		
		driver.findElement(By.name("h_icon_ewizard")).click();      			//go back to eWizard
		
		try {
			StringBuilder builder = new StringBuilder();
	        BufferedWriter out = new BufferedWriter(new FileWriter(fReport, true));
	        builder.append("\r\n*****************************************************************\r\n");
	        builder.append("*                               DDNS                            *\r\n");
	        builder.append("*****************************************************************\r\n");
	        builder.append("Test A016 - Quick Setup -> Network -> DDNS\r\n");
	        builder.append("Can it show current DDNS name?\r\n" +
							"설정되어 있는 DDNS가 정상적으로 출력되는가?\r\n");
	        builder.append("=================================================================\r\n");
	        builder.append(status + "\r\n" + success_Msg + "\r\n");
	        
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

