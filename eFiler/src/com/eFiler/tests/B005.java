package com.eFiler.tests;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.openqa.selenium.*;

public class B005 extends BaseTestLogic {
	
	private static String File_list = "";
	private static String G_user_ID = "", G_user_Pass = "", login_success = "";
	
	public B005(WebDriver webDriver, File fileConf, File fileReport) {
		super(webDriver, fileConf, fileReport);
		// TODO Auto-generated constructor stub
		fConf = fileConf;
		driver = webDriver;
	}

	void startTest() throws InterruptedException  {
		System.out.println("*****************************************************************");
		System.out.println("*                           File/Folder List                    *");
		System.out.println("*****************************************************************");
		System.out.println("Test B005 - eFiler");
		System.out.println("While logged-in as general user, it shows file/folder list view of the first share folder?\n" +
							"일반사용자가 로그인 했을 경우 파일리스트뷰에서도 최 상단은 공유리스트의 첫번째 내용이 나오는가? \n"+
							"----------------------------------------------------------");
		
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(fConf));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
	        for (int i=1; i<=6; i++){
	        	String line = br.readLine();
	        	if (i > 4){
	        		System.out.println(line);
		        	String[] tokens = line.split("=");
		        	if (tokens[0].equals("G_user_ID"))
		        		G_user_ID = tokens[1];
		        	else if (tokens[0].equals("G_user_Pass"))
		        		G_user_Pass = tokens[1];
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
		
//		BufferedReader br = new BufferedReader(new FileReader("D:\\eFilerConf.txt"));
//		try {
//	        for (int i=1; i<=7; i++){
//	        	String line = br.readLine();
//	        	if (i > 5){
//	        		//System.out.println(line);
//		        	String[] tokens = line.split("=");
//		        	if (tokens[0].equals("G_user_ID"))
//		        		G_user_ID = tokens[1];
//		        	else if (tokens[0].equals("G_user_Pass"))
//		        		G_user_Pass = tokens[1];
//	        	}
//	        }
//	    } finally {
//	        br.close();
//	    }
		
//		Thread.sleep(3000);
		//driver.findElement(By.xpath("//div[@id='dir-tree-view']/ul/li/ul/li/div/span")).click();	//go to 1st folder 
		
		driver.findElement(By.className("logoutIcon")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("login_userid")).clear();
		driver.findElement(By.id("login_userid")).sendKeys(G_user_ID);
		driver.findElement(By.id("login_password")).clear();
		driver.findElement(By.id("login_password")).sendKeys(G_user_Pass);
		driver.findElement(By.cssSelector("input.btn_login")).click();
		//driver.findElement(By.name("icon_efiler")).click();
		Thread.sleep(2000);
		
		if (isElementPresent(By.xpath("//span[@id='userInfo']"))){		//If login successful
			String G_user_login = driver.findElement(By.xpath("//span[@id='userInfo']")).getText();
			//System.out.println("Logged in as: " + G_user_login);
			if (G_user_ID.equals(G_user_login)){	//if General user login is successful 
				login_success = "Successfully logged in as General user: " + G_user_login;
				driver.findElement(By.name("icon_efiler")).click();	//Go to eFiler
				
				if (isElementPresent(By.id("diskname"))){		//If current listing is for Volume1
					String str = driver.findElement(By.xpath("//div[@id='dir-tree-view']/ul/li/div/span")).getText();	//get left panel 1st volume name 
					String str1 = driver.findElement(By.xpath("//div[@id='diskname']/span")).getText(); //get right panel 1st volume name
					//System.out.println("String Left: " + str + "\nRight: " + str1);
					if (str.equals(str1) && !isElementPresent(By.xpath("//div[@id='diskname']/span[2]")) && isElementPresent(By.id("filelist_view"))){
						File_list = "Showing File/Folder list for first Share Folder: " + str;
					}else{
						File_list = "Can't show File/Folder list for first Share Folder!"; 
					}
				}else{
					File_list = "Can't show File/Folder List!";
				}
			}else{
				login_success = "General user login Failed!";
			}
		}else{
			login_success = "Incorrect ID or Password Please try again!";
		}
		System.out.println(login_success);
		System.out.println(File_list);
		
		try {
			StringBuilder builder = new StringBuilder();
	        BufferedWriter out = new BufferedWriter(new FileWriter(fReport, true));
	        
	        builder.append("\r\n*****************************************************************\r\n");
	        builder.append("*                           File/Folder List                    *\r\n");
	        builder.append("*****************************************************************\r\n");
	        builder.append("Test B005 - eFiler\r\n");
	        builder.append("While logged-in as general user, it shows file/folder list view of the first share folder?\r\n" +
							"일반사용자가 로그인 했을 경우 파일리스트뷰에서도 최 상단은 공유리스트의 첫번째 내용이 나오는가? \r\n");
	        builder.append("=================================================================\r\n");
	        builder.append(login_success + "\r\n");
	        builder.append(File_list + "\r\n");
	        out.write(builder.toString());

			if(Lisenter != null){
				Lisenter.onReportLisenter(builder.toString());
			}
			
	        out.close();
	        } catch (IOException e) {}
	}
}

