package com.eWizard.tests;

import java.io.*;

import static org.junit.Assert.*;
import org.openqa.selenium.*;

public class B003 extends BaseTestLogic {
	private static StringBuffer verificationErrors = new StringBuffer();
	private static String System_Out = "";
	private static String Num_of_share = "", share_name = "", share_desc = "";
	private static String [] share_list;
	
	public B003(WebDriver webDriver, File fileConf, File fileReport) {
		super(webDriver, fileConf, fileReport);
		fConf = fileConf;
	}
	
	void startTest() throws InterruptedException  {
		System.out.println("*****************************************************************");
		System.out.println("*                         Create Share                          *");
		System.out.println("*****************************************************************");
		System.out.println("Test B003 - Permission -> Share");
		System.out.println("Is it possible to create Share from eWizard like from eSetup?\n" +
							"공유폴더 생성은 관리자와 동일 한가?\n" + 
							"----------------------------------------------------------");
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(fConf));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
	        for (int i=1; i<=29; i++){
	        	String line = br.readLine();
	        	if (i > 26){
	        		//System.out.println(line + "\n");
		        	String[] tokens = line.split("=");
		        	if (tokens[0].equals("Num_of_share")){
		        		Num_of_share = tokens[1];
		        	}else if (tokens[0].equals("share_name")){
		        		share_name = tokens[1];
		        	}else if (tokens[0].equals("share_desc")){
		        		share_desc = tokens[1];
		        	}
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
		
//		BufferedReader br = new BufferedReader(new FileReader("D:\\eWizardConf.txt"));
//		try {
//	        for (int i=1; i<=29; i++){
//	        	String line = br.readLine();
//	        	if (i > 26){
//	        		//System.out.println(line);
//		        	String[] tokens = line.split("=");
//		        	if (tokens[0].equals("Num_of_share")){
//		        		Num_of_share = tokens[1];
//		        	}else if (tokens[0].equals("share_name")){
//		        		share_name = tokens[1];
//		        	}else if (tokens[0].equals("share_desc")){
//		        		share_desc = tokens[1];
//		        	}
//	        	}
//	        }
//	    } finally {
//	        br.close();
//	    }
		
		int Num_of_share1 = Integer.parseInt(Num_of_share);
		share_list = new String[Num_of_share1];

		for (int i=1; i<=Num_of_share1; i++){
			driver.findElement(By.name("Image8")).click();	//go to user menu
			Thread.sleep(1000);
				
			//Enter group informations (Name, desc)
			driver.findElement(By.id("cname")).sendKeys(share_name + i);
			Thread.sleep(1000);
			driver.findElement(By.id("cdesc")).sendKeys(share_desc + i);
			Thread.sleep(1000);
			//Click next--> next
			driver.findElement(By.xpath("//button[contains(text(), 'Next')]")).click();
			Thread.sleep(100);
			driver.findElement(By.xpath("//button[contains(text(), 'Next')]")).click();
			Thread.sleep(100);
			driver.findElement(By.xpath("//button[contains(text(), 'Next')]")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//button[contains(text(), 'Confirm')]")).click();			//Click Confirm
			
			Thread.sleep(5000);
			if (isElementPresent(By.xpath("//div[@class='ext-mb-content']"))){
				System_Out = driver.findElement(By.xpath("//div[@class='ext-mb-content']")).getText();
				//System.out.println("  System_Out---------------");
				share_list[i-1] = share_name + i + ": " + System_Out;
				driver.findElement(By.xpath("//button[contains(text(), 'OK')]")).click();
				if (System_Out.equals("Max number of share exceeded.")){
					System.out.println(share_list[i-1]);
					break;
				}
				//Thread.sleep(1000);
				//driver.findElement(By.xpath("//div[@id='userCreateWin']/div/div/div/div/div")).click();		//click cancel button
				//break;
			}
			System.out.println(share_list[i-1]);
		}

		
		
		try {
			StringBuilder builder = new StringBuilder();
	        BufferedWriter out = new BufferedWriter(new FileWriter(fReport, true));
	        
	        builder.append("\r\n*****************************************************************\r\n");
	        builder.append("*                         Create Group                          *\r\n");
	        builder.append("*****************************************************************\r\n");
	        builder.append("Test B003 - Permission -> Share\r\n");
	        builder.append("Is it possible to create Share from eWizard like from eSetup?\r\n" +
							"공유폴더 생성은 관리자와 동일 한가?\r\n");
	        builder.append("=================================================================\r\n");
	        for (int i=1; i<=Num_of_share1; i++){
	        	if (share_list[i-1] != null)			//to avoid null print to report file
	        		builder.append(share_list[i-1] + "\r\n");
	        }
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

