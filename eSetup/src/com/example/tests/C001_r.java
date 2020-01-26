package com.example.tests;

import java.io.*;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;
import org.openqa.selenium.*;

public class C001_r extends UserAndShare {
	private static StringBuffer verificationErrors = new StringBuffer();
	private static String System_Out = "";
	private static String Num_of_user = "", user_name = "", user_desc = "", user_email = "", select_grp = "";
	private static String [] user_list;
	
	@SuppressWarnings("null")
	public void C001_r() throws InterruptedException, IOException{
		System.out.println("*****************************************************************");
		System.out.println("*                         Create Usert                          *");
		System.out.println("*****************************************************************");
		System.out.println("Test C001 - User and Share -> User");
		System.out.println("Can add user properly as a wizard style?\n" +
							"사용자 추가가 wizard 형식으로 정상 동작 되는가? \n" + 
							"----------------------------------------------------------");
		
		BufferedReader br = new BufferedReader(new FileReader("C:\\UserShareConf.txt"));
		try {
	        for (int i=1; i<=9; i++){
	        	String line = br.readLine();
	        	if (i > 4){
	        		//System.out.println(line);
		        	String[] tokens = line.split("=");
		        	if (tokens[0].equals("Num_of_user")){
		        		Num_of_user = tokens[1];
		        	}else if (tokens[0].equals("user_name")){
		        		user_name = tokens[1];
		        	}else if (tokens[0].equals("user_desc")){
		        		user_desc = tokens[1];
		        	}else if(tokens[0].equals("user_email")){
		        		user_email = tokens[1];
		        	}else if(tokens[0].equals("select_grp")){
		        		select_grp = tokens[1];
		        	}
	        	}
	        }
	    } finally {
	        br.close();
	    }
		
		//createGroupAddCheck-group40
		String[] tokens = select_grp.split(",");
//		int grp_number[] = new int[tokens.length];
//		for (int i=0; i<tokens.length; i++){
//			System.out.println(tokens[i].trim());
//			grp_number[i] = Integer.parseInt(tokens[i].trim());
//			System.out.println(grp_number[i]);
//		}

		int Num_of_user1 = Integer.parseInt(Num_of_user);
		user_list = new String[Num_of_user1];
		
		for (int i=1; i<=Num_of_user1; i++){
			driver.findElement(By.linkText("User")).click();	//go to user menu
			Thread.sleep(1000);
			
			driver.findElement(By.xpath("//button[contains(text(), 'Add')]")).click();	//click Add user button
			Thread.sleep(3000);
			//check if Max user exceed 
			//if (isElementPresent(By.xpath("//body/div[28]/div[2]/div/div/div/div/div/div[2]"))){
			if (isElementPresent(By.xpath("//div[@class='ext-mb-content']"))){	
				System_Out = driver.findElement(By.xpath("//div[@class='ext-mb-content']")).getText();
				if (System_Out.equals("Can not create User account.\nMaximum number of User accounts has been exceeded.\n(Max number of user accounts: 200)")){
					user_list[i-1] = user_name + i + ": " + System_Out;
					System.out.println(user_list[i-1] + "\n");
					//System.out.println("Exceed----> " + user_name + i + ": " + System_Out);
					driver.findElement(By.xpath("//button[contains(text(), 'OK')]")).click();
				break;
				}
			}
			
			//Enter user informations (Name, desc, email, password)
			driver.findElement(By.id("cuserid")).sendKeys(user_name + i);
			driver.findElement(By.id("cuname")).sendKeys(user_desc + i);
			driver.findElement(By.id("cemail")).sendKeys(user_name + i + user_email);
			driver.findElement(By.id("cpassword")).sendKeys(user_name + i);
			driver.findElement(By.id("cpassword1")).sendKeys(user_name + i);
			
			//Click next--> next
			driver.findElement(By.xpath("//button[contains(text(), 'Next')]")).click();
			Thread.sleep(3000);
			
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
			if (isElementPresent(By.xpath("//div[@class='ext-mb-content']"))){	
				//System_Out = driver.findElement(By.xpath("//body/div[28]/div[2]/div/div/div/div/div/div[2]")).getText();
				System_Out = driver.findElement(By.xpath("//div[@class='ext-mb-content']")).getText();
				//System.out.println("Found----> " + user_name + i + ": " + System_Out);
				user_list[i-1] = user_name + i + ": " + System_Out;
				Thread.sleep(1000);
				driver.findElement(By.xpath("//button[contains(text(), 'OK')]")).click();
			}
			System.out.println(user_list[i-1]);
		}

		
		
		try {
	        BufferedWriter out = new BufferedWriter(new FileWriter("C:\\UserGroupShare.txt"));
	        	out.write("\r\n*****************************************************************\r\n");
		        out.write("*                         Create Usert                          *\r\n");
		        out.write("*****************************************************************\r\n");
		        out.write("Test C001 - User and Share -> User\r\n");
		        out.write("Is it possible to create new User from eWizard like from eSetup?\r\n" +
							"사용자 생성은 관리자와 동일 한가?\r\n");
		        out.write("=================================================================\r\n");
		        for (int i=1; i<=Num_of_user1; i++){
		        	if (user_list[i-1] != null)			//to avoid null print to report file
		        		out.write(user_list[i-1] + "\r\n");
		        }
	            out.close();
	        } catch (IOException e) {}
		 	
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}
}

