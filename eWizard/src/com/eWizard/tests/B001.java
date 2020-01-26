package com.eWizard.tests;

import java.io.*;

import static org.junit.Assert.*;
import org.openqa.selenium.*;

public class B001 extends BaseTestLogic {
	private static StringBuffer verificationErrors = new StringBuffer();
	private static String System_Out = "";
	private static String Num_of_user = "", user_name = "", user_desc = "", user_email = "", select_grp = "";
	private static String [] user_list;
	
	@SuppressWarnings("null")
	public B001(WebDriver webDriver, File fileConf, File fileReport) {
		super(webDriver, fileConf, fileReport);
		fConf = fileConf;
	}
	
	void startTest() throws InterruptedException  {
		System.out.println("*****************************************************************");
		System.out.println("*                         Create Usert                          *");
		System.out.println("*****************************************************************");
		System.out.println("Test B001 - Permission -> User");
		System.out.println("Is it possible to create new User from eWizard like from eSetup?\n" +
							"사용자 생성은 관리자와 동일 한가?\n" + 
							"----------------------------------------------------------");
		
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(fConf));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
	        for (int i=1; i<=21; i++){
	        	String line = br.readLine();
	        	if (i > 16){
	        		//System.out.println(line + "\n");
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
//	        for (int i=1; i<=21; i++){
//	        	String line = br.readLine();
//	        	if (i > 16){
//	        		//System.out.println(line);
//		        	String[] tokens = line.split("=");
//		        	if (tokens[0].equals("Num_of_user")){
//		        		Num_of_user = tokens[1];
//		        	}else if (tokens[0].equals("user_name")){
//		        		user_name = tokens[1];
//		        	}else if (tokens[0].equals("user_desc")){
//		        		user_desc = tokens[1];
//		        	}else if(tokens[0].equals("user_email")){
//		        		user_email = tokens[1];
//		        	}else if(tokens[0].equals("select_grp")){
//		        		select_grp = tokens[1];
//		        	}
//	        	}
//	        }
//	    } finally {
//	        br.close();
//	    }
		
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

//		//eSetup
//		driver.findElement(By.name("h_icon_esetup")).click();	//go to eSetup menu
//		Thread.sleep(1000);
//		driver.findElement(By.linkText("User")).click();	//go to user menu
//		Thread.sleep(1000);
//		driver.findElement(By.id("userGridPagingCombo")).click();
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("//body/div[17]/div/div[4]")).click();		//select All
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/div[2]/div/div/div/div/div/table/thead/tr/td/div")).click();	//sort
//		Thread.sleep(1000);
//		for (int i=2; i<=Num_of_user1; i++){
//			if (isElementPresent(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/div[2]/div/div/div[2]/div/div[" + i + "]/table/tbody/tr/td/div"))){
//				user_list[i-2] = driver.findElement(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/div[2]/div/div/div[2]/div/div[" + i + "]/table/tbody/tr/td/div")).getText();
//				System.out.println(user_list[i-2]);
//			}else{
//				System.out.println("-------------------->" + i);
//				break;
//			}
//		}
		
		
		for (int i=1; i<=Num_of_user1; i++){
			driver.findElement(By.name("Image6")).click();	//go to user menu
			Thread.sleep(1000);
				
			//Enter user informations (Name, desc, email, password)
			driver.findElement(By.id("cuserid")).sendKeys(user_name + i);
			driver.findElement(By.id("cuname")).sendKeys(user_desc + i);
			driver.findElement(By.id("cemail")).sendKeys(user_name + i + user_email);
			driver.findElement(By.id("cpassword")).sendKeys(user_name + i);
			driver.findElement(By.id("cpassword1")).sendKeys(user_name + i);
			
			//Click next--> next
			driver.findElement(By.xpath("//button[contains(text(), 'Next')]")).click();
			Thread.sleep(3000);
			
			if (tokens[0].equals("All")){
				driver.findElement(By.id("createGroupAddCheckAllCheck")).click();
			}else{
				for (int j=0; j<tokens.length; j++){
					if (isElementPresent(By.id("createGroupAddCheck-" + tokens[j]))){
						//System.out.println("fround.... createGroupAddCheck-" + tokens[j]);
						driver.findElement(By.id("createGroupAddCheck-" + tokens[j])).click();
					}else
						System.out.println(tokens[j] + ": Group name doesn't exixts!");
				}
			}
			
			Thread.sleep(3000);
			
			driver.findElement(By.xpath("//button[contains(text(), 'Next')]")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//button[contains(text(), 'Confirm')]")).click();			//Click Confirm
			
			Thread.sleep(2000);
			if (isElementPresent(By.xpath("//body/div[17]/div[2]/div/div/div/div/div/div[2]"))){
				System_Out = driver.findElement(By.xpath("//body/div[17]/div[2]/div/div/div/div/div/div[2]")).getText();
				//System.out.println(user_name + i + ": " + System_Out);
				user_list[i-1] = user_name + i + ": " + System_Out;
				driver.findElement(By.xpath("//button[contains(text(), 'OK')]")).click();
				if (System_Out.equals("Max number of User exceeded.")){
					System.out.println(user_list[i-1] + "\n");
					break;
				}
				//Thread.sleep(1000);
				//driver.findElement(By.xpath("//div[@id='userCreateWin']/div/div/div/div/div")).click();		//click cancel button
				//break;
			}
			System.out.println(user_list[i-1]);
		}

		
		
		try {
			StringBuilder builder = new StringBuilder();
	        BufferedWriter out = new BufferedWriter(new FileWriter(fReport, true));
	        
	        builder.append("\r\n*****************************************************************\r\n");
	        builder.append("*                         Create Usert                          *\r\n");
	        builder.append("*****************************************************************\r\n");
	        builder.append("Test B001 - Permission -> User\r\n");
	        builder.append("Is it possible to create new User from eWizard like from eSetup?\r\n" +
						"사용자 생성은 관리자와 동일 한가?\r\n");
	        builder.append("=================================================================\r\n");
	        for (int i=1; i<=Num_of_user1; i++){
	        	if (user_list[i-1] != null)			//to avoid null print to report file
	        		builder.append(user_list[i-1] + "\r\n");
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

