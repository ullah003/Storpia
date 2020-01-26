package com.eWizard.tests;

import java.io.*;

import static org.junit.Assert.*;
import org.openqa.selenium.*;

public class B002 extends BaseTestLogic {
	private static StringBuffer verificationErrors = new StringBuffer();
	private static String System_Out = "";
	private static String Num_of_group = "", group_name = "", group_desc = "";
	private static String [] group_list;
	
	public B002(WebDriver webDriver, File fileConf, File fileReport) {
		super(webDriver, fileConf, fileReport);
		fConf = fileConf;
	}
	
	void startTest() throws InterruptedException  {
		System.out.println("*****************************************************************");
		System.out.println("*                         Create Group                          *");
		System.out.println("*****************************************************************");
		System.out.println("Test B002 - Permission -> Group");
		System.out.println("Is it possible to create Group from eWizard like from eSetup?\n" +
							"그룹 생성은 관리자와 동일 한가?\n" + 
							"----------------------------------------------------------");
		
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(fConf));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
	        for (int i=1; i<=25; i++){
	        	String line = br.readLine();
	        	if (i > 22){
	        		//System.out.println(line + "\n");
		        	String[] tokens = line.split("=");
		        	if (tokens[0].equals("Num_of_group")){
		        		Num_of_group = tokens[1];
		        	}else if (tokens[0].equals("group_name")){
		        		group_name = tokens[1];
		        	}else if (tokens[0].equals("group_desc")){
		        		group_desc = tokens[1];
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
//	        for (int i=1; i<=25; i++){
//	        	String line = br.readLine();
//	        	if (i > 22){
//	        		//System.out.println(line);
//		        	String[] tokens = line.split("=");
//		        	if (tokens[0].equals("Num_of_group")){
//		        		Num_of_group = tokens[1];
//		        	}else if (tokens[0].equals("group_name")){
//		        		group_name = tokens[1];
//		        	}else if (tokens[0].equals("group_desc")){
//		        		group_desc = tokens[1];
//		        	}
//	        	}
//	        }
//	    } finally {
//	        br.close();
//	    }
		
		int Num_of_group1 = Integer.parseInt(Num_of_group);
		group_list = new String[Num_of_group1];

		for (int i=1; i<=Num_of_group1; i++){
			driver.findElement(By.name("Image7")).click();	//go to user menu
			Thread.sleep(1000);
				
			//Enter group informations (Name, desc)
			driver.findElement(By.id("cgroupid")).sendKeys(group_name + i);
			driver.findElement(By.id("cgroupdesc")).sendKeys(group_desc + i);
			
			//Click next--> next
			driver.findElement(By.xpath("//button[contains(text(), 'Next')]")).click();
			Thread.sleep(100);
			driver.findElement(By.xpath("//button[contains(text(), 'Next')]")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//button[contains(text(), 'Confirm')]")).click();			//Click Confirm
			
			Thread.sleep(2000);
			if (isElementPresent(By.xpath("//body/div[17]/div[2]/div/div/div/div/div/div[2]"))){
				System_Out = driver.findElement(By.xpath("//body/div[17]/div[2]/div/div/div/div/div/div[2]")).getText();
				//System.out.println(user_name + i + ": " + System_Out);
				group_list[i-1] = group_name + i + ": " + System_Out;
				driver.findElement(By.xpath("//button[contains(text(), 'OK')]")).click();
				if (System_Out.equals("Max number of Group exceeded.")){
					System.out.println(group_list[i-1] + "\n");
					break;
				}
				//Thread.sleep(1000);
				//driver.findElement(By.xpath("//div[@id='userCreateWin']/div/div/div/div/div")).click();		//click cancel button
				//break;
			}
			System.out.println(group_list[i-1]);
		}

		
		
		try {
			StringBuilder builder = new StringBuilder();
	        BufferedWriter out = new BufferedWriter(new FileWriter(fReport, true));
	        
	        builder.append("\r\n*****************************************************************\r\n");
	        builder.append("*                         Create Group                          *\r\n");
	        builder.append("*****************************************************************\r\n");
	        builder.append("Test B002 - Permission -> Group\r\n");
	        builder.append("Is it possible to create Group from eWizard like from eSetup?\r\n" +
						"그룹 생성은 관리자와 동일 한가?\r\n");
	        builder.append("=================================================================\r\n");
	        for (int i=1; i<=Num_of_group1; i++){
	        	if (group_list[i-1] != null)			//to avoid null print to report file
	        		builder.append(group_list[i-1] + "\r\n");
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

