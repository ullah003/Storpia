package com.example.tests;

import java.io.*;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;
import org.openqa.selenium.*;

public class C002_r extends UserAndShare {
	private static StringBuffer verificationErrors = new StringBuffer();
	private static String System_Out = "";
	private static String Num_of_group = "", group_name = "", group_desc = "";
	private static String [] group_list;
	
	@SuppressWarnings("null")
	public void C002_r() throws InterruptedException, IOException{
		System.out.println("*****************************************************************");
		System.out.println("*                         Create Group                          *");
		System.out.println("*****************************************************************");
		System.out.println("Test C002 - User and Share -> Group");
		System.out.println("Can add Group properly as a wizard style?\n" +
							"Group 추가가 wizard 형식으로 정상 동작 되는가? \n" + 
							"----------------------------------------------------------");
		
		BufferedReader br = new BufferedReader(new FileReader("C:\\UserShareConf.txt"));
		try {
	        for (int i=1; i<=13; i++){
	        	String line = br.readLine();
	        	if (i > 10){
	        		//System.out.println(line);
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

		int Num_of_group1 = Integer.parseInt(Num_of_group);
		group_list = new String[Num_of_group1];
		
		for (int i=1; i<=Num_of_group1; i++){
			driver.findElement(By.linkText("Group")).click();	//go to user menu
			Thread.sleep(1000);
			
			driver.findElement(By.xpath("//button[contains(text(), 'Add')]")).click();	//click Add user button
			Thread.sleep(2000);
			//check if Max user exceed 
			//if (isElementPresent(By.xpath("//body/div[28]/div[2]/div/div/div/div/div/div[2]"))){
			if (isElementPresent(By.xpath("//div[@class='ext-mb-content']"))){	
				System_Out = driver.findElement(By.xpath("//div[@class='ext-mb-content']")).getText();
				if (System_Out.equals("Can not create Group account.\nMaximum number of Group accounts has been exceeded.\n(Max number of Group accounts: 200)")){
					group_list[i-1] = group_name + i + ": " + System_Out;
					System.out.println(group_list[i-1] + "\n");
					//System.out.println("Exceed----> " + user_name + i + ": " + System_Out);
					driver.findElement(By.xpath("//button[contains(text(), 'OK')]")).click();
				break;
				}
			}
			
			//Enter user informations (Name, desc, email, password)
			driver.findElement(By.id("cgroupid")).sendKeys(group_name + i);
			driver.findElement(By.id("cgroupdesc")).sendKeys(group_desc + i);
			
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
			driver.findElement(By.xpath("//button[contains(text(), 'Confirm')]")).click();			//Click Confirm
			
			Thread.sleep(4000);
			//if (isElementPresent(By.xpath("//body/div[28]/div[2]/div/div/div/div/div/div[2]"))){
			//for (int j = 0; j<=120; j++){
				if (isElementPresent(By.xpath("//div[@class='ext-mb-content']")) 
						&& driver.findElement(By.xpath("//div[@class='ext-mb-content']")).getText().equals("Group added successfully.")){	
					//System_Out = driver.findElement(By.xpath("//body/div[28]/div[2]/div/div/div/div/div/div[2]")).getText();
					System_Out = driver.findElement(By.xpath("//div[@class='ext-mb-content']")).getText();
					System.out.println("Found----> " + group_name + i + ": " + System_Out);
					group_list[i-1] = group_name + i + ": " + System_Out;
					Thread.sleep(1000);
					driver.findElement(By.xpath("//button[contains(text(), 'OK')]")).click();
					break;
				}
			//}
			System.out.println(group_list[i-1]);
		}

		
		
		try {
	        BufferedWriter out = new BufferedWriter(new FileWriter("C:\\UserGroupShare.txt", true));
	        	out.write("\r\n*****************************************************************\r\n");
		        out.write("*                         Create Group                          *\r\n");
		        out.write("*****************************************************************\r\n");
		        out.write("Test C002 - User and Share -> Group\r\n");
		        out.write("Is it possible to create Group from eWizard like from eSetup?\r\n" +
							"Group 생성은 관리자와 동일 한가?\r\n");
		        out.write("=================================================================\r\n");
		        for (int i=1; i<=Num_of_group1; i++){
		        	if (group_list[i-1] != null)			//to avoid null print to report file
		        		out.write(group_list[i-1] + "\r\n");
		        }
	            out.close();
	        } catch (IOException e) {}
		 	
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}
}

