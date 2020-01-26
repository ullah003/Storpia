package com.example.tests;

import java.io.*;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;
import org.openqa.selenium.*;

public class C003_r extends UserAndShare {
	private static StringBuffer verificationErrors = new StringBuffer();
	private static String System_Out = "";
	private static String Num_of_share = "", share_name = "", share_desc = "";
	private static String [] share_list;
	
	@SuppressWarnings("null")
	public void C003_r() throws InterruptedException, IOException{
		System.out.println("*****************************************************************");
		System.out.println("*                         Create Share                          *");
		System.out.println("*****************************************************************");
		System.out.println("Test C003 - User and Share -> Share");
		System.out.println("Can add Share properly as a wizard style?\n" +
							"Share 추가가 wizard 형식으로 정상 동작 되는가? \n" + 
							"----------------------------------------------------------");
		
		BufferedReader br = new BufferedReader(new FileReader("C:\\UserShareConf.txt"));
		try {
	        for (int i=1; i<=17; i++){
	        	String line = br.readLine();
	        	if (i > 14){
	        		//System.out.println(line);
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
	    } finally {
	        br.close();
	    }
		
		//createGroupAddCheck-group40
//		String[] tokens = select_grp.split(",");
//		int grp_number[] = new int[tokens.length];
//		for (int i=0; i<tokens.length; i++){
//			System.out.println(tokens[i].trim());
//			grp_number[i] = Integer.parseInt(tokens[i].trim());
//			System.out.println(grp_number[i]);
//		}

		int Num_of_share1 = Integer.parseInt(Num_of_share);
		share_list = new String[Num_of_share1];
		
		for (int i=1; i<=Num_of_share1; i++){
			driver.findElement(By.linkText("Share Folder")).click();	//go to user menu
			Thread.sleep(1000);
			
			driver.findElement(By.xpath("//button[contains(text(), 'Add')]")).click();	//click Add user button
			Thread.sleep(2000);
			//check if Max user exceed 
			//if (isElementPresent(By.xpath("//body/div[28]/div[2]/div/div/div/div/div/div[2]"))){
			if (isElementPresent(By.xpath("//div[@class='ext-mb-content']"))){	
				System_Out = driver.findElement(By.xpath("//div[@class='ext-mb-content']")).getText();
				if (System_Out.equals("Can not create Share account.\nMaximum number of Share accounts has been exceeded.\n(Max number of Share accounts: 200)")){
					share_list[i-1] = share_name + i + ": " + System_Out;
					System.out.println(share_list[i-1] + "\n");
					//System.out.println("Exceed----> " + user_name + i + ": " + System_Out);
					driver.findElement(By.xpath("//button[contains(text(), 'OK')]")).click();
				break;
				}
			}
			
			//Enter user informations (Name, desc, email, password)
			driver.findElement(By.id("cname")).sendKeys(share_name + i);
			driver.findElement(By.id("cdesc")).sendKeys(share_desc + i);
			
			//Click next--> next
			driver.findElement(By.xpath("//button[contains(text(), 'Next')]")).click();
			Thread.sleep(1000);
			
//			if (tokens[0].equals("All")){
//				driver.findElement(By.id("createGroupAddCheckAllCheck")).click();
//			}else{
//				for (int j=0; j<tokens.length; j++){
//					if (isElementPresent(By.id("createGroupAddCheck-" + tokens[j]))){
//						//System.out.println("found.... createGroupAddCheck-" + tokens[j]);
//						driver.findElement(By.id("createGroupAddCheck-" + tokens[j])).click();
//					}else
//						System.out.println(tokens[j] + ": Group name doesn't exixts!");
//				}
//			}
			
			Thread.sleep(1000);
			
			driver.findElement(By.xpath("//button[contains(text(), 'Next')]")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//button[contains(text(), 'Next')]")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//button[contains(text(), 'Confirm')]")).click();			//Click Confirm
			
			Thread.sleep(6000);
			//if (isElementPresent(By.xpath("//body/div[28]/div[2]/div/div/div/div/div/div[2]"))){
			if (isElementPresent(By.xpath("//div[@class='ext-mb-content']"))){	
				//System_Out = driver.findElement(By.xpath("//body/div[28]/div[2]/div/div/div/div/div/div[2]")).getText();
				System_Out = driver.findElement(By.xpath("//div[@class='ext-mb-content']")).getText();
				//System.out.println("Found----> " + user_name + i + ": " + System_Out);
				share_list[i-1] = share_name + i + ": " + System_Out;
				driver.findElement(By.xpath("//button[contains(text(), 'OK')]")).click();
			}
			System.out.println(share_list[i-1]);
		}

		
		
		try {
	        BufferedWriter out = new BufferedWriter(new FileWriter("C:\\UserGroupShare.txt", true));
	        	out.write("\r\n*****************************************************************\r\n");
		        out.write("*                         Create Share                          *\r\n");
		        out.write("*****************************************************************\r\n");
		        out.write("Test C003 - User and Share -> Share\r\n");
		        out.write("Is it possible to create Share from eWizard like from eSetup?\r\n" +
							"Share 생성은 관리자와 동일 한가?\r\n");
		        out.write("=================================================================\r\n");
		        for (int i=1; i<=Num_of_share1; i++){
		        	if (share_list[i-1] != null)			//to avoid null print to report file
		        		out.write(share_list[i-1] + "\r\n");
		        }
	            out.close();
	        } catch (IOException e) {}
		 	
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}
}

