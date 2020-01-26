package com.eWizard.tests;

import java.io.*;

import static org.junit.Assert.*;
import org.openqa.selenium.*;

public class A017 extends BaseTestLogic {

	private static StringBuffer verificationErrors = new StringBuffer();
	private static String DDNS = "", DDNS_eSetup = "", success_Msg = "", status = ""; 
	
	public A017(WebDriver webDriver, File fileConf, File fileReport) {
		super(webDriver, fileConf, fileReport);
		fConf = fileConf;
	}
	
	void startTest() throws InterruptedException  {
		System.out.println("*****************************************************************");
		System.out.println("*                           DDNS Change                         *");
		System.out.println("*****************************************************************");
		System.out.println("Test A017 - Quick Setup -> Network -> DDNS");
		System.out.println("If you change DDNS from here does it take effect properly to change DDNS & device name?\n" +
							"DDNS변경시 정상적으로 설정 되는가?\n" + 
							"----------------------------------------------------------");

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
		        	if (tokens[0].equals("DDNS"))
		        		DDNS = tokens[1];
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
		
//		BufferedReader br = new BufferedReader(new FileReader("D:\\eWizardConf.txt"));
//		try {
//	        for (int i=1; i<=15; i++){
//	        	String line = br.readLine();
//	        	if (i > 14){
//	        		//System.out.println(line + "\n");
//		        	String[] tokens = line.split("=");
//		        	if (tokens[0].equals("DDNS"))
//		        		DDNS = tokens[1];
//	        	}
//	        }
//	    } finally {
//	        br.close();
//	    }
		
		//Click Network menu
		driver.findElement(By.name("Image9")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.id("hostname")).clear();
		driver.findElement(By.id("hostname")).sendKeys(DDNS);		//enter DDNS
		driver.findElement(By.xpath("//input[@value='OK']")).click();
		Thread.sleep(3000);
		
		if (isElementVisible(By.xpath("//table[@id='ext-comp-1359']/tbody/tr[2]/td[2]"))){   //checking success msg
			driver.findElement(By.xpath("//table[@id='ext-comp-1359']/tbody/tr[2]/td[2]")).click(); //click notification OK button
		}
		
		driver.findElement(By.xpath("//input[@value='Cancel']")).click();		//click Cancel to close popup
		driver.findElement(By.name("h_icon_esetup")).click();      			//go to eSetup
		
		Thread.sleep(1000);		//get Server Name
		DDNS_eSetup = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div/div/div[2]/div/div/div/div/div/div/form/div/div[2]/div/div/div/div[2]/div/div/table/tbody/tr/td[2]/div")).getText();
		System.out.println("Server name : " + DDNS_eSetup);
		//compare DDNS and server name
		if (DDNS.equals(DDNS_eSetup))
			success_Msg = "DDNS updated successfully.";
		else
			success_Msg = "DDNS update FAILED!";

		System.out.println(success_Msg);
		
		driver.findElement(By.name("h_icon_ewizard")).click();      			//go back to eWizard
		
		try {
			StringBuilder builder = new StringBuilder();
	        BufferedWriter out = new BufferedWriter(new FileWriter(fReport, true));
	        
	        builder.append("\r\n*****************************************************************\r\n");
	        builder.append("*                           DDNS Change                         *\r\n");
	        builder.append("*****************************************************************\r\n");
	        builder.append("Test A017 - Quick Setup -> Network -> DDNS\r\n");
	        builder.append("If you change DDNS from here does it take effect properly to change DDNS & device name?\r\n" +
						"DDNS변경시 정상적으로 설정 되는가?\r\n");
	        builder.append("=================================================================\r\n");
	        builder.append(success_Msg + "\r\n");
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

