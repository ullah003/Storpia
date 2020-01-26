package com.example.tests;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class UserAndShare {
	protected static WebDriver driver;
	private static String baseUrl, userID, userPass;
	
	public void Login() throws IOException {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		BufferedReader br = new BufferedReader(new FileReader("C:\\UserShareConf.txt"));
		try {
			for (int i=0; i<=2; i++){
				String line = br.readLine();
				String[] tokens = line.split("=");
				if (tokens[0].equals("url")){
					baseUrl = tokens[1];
				}else if (tokens[0].equals("ID")){
					userID = tokens[1];
				}else if (tokens[0].equals("passwd")){
					userPass = tokens[1];
				}
			}
		} finally {
			br.close();
		}	    

		driver.get(baseUrl);
		driver.findElement(By.id("login_userid")).clear();
		driver.findElement(By.id("login_userid")).sendKeys(userID);
		driver.findElement(By.id("login_password")).clear();
		driver.findElement(By.id("login_password")).sendKeys(userPass);
		driver.findElement(By.cssSelector("input.btn_login")).click();
		driver.findElement(By.name("icon_esetup")).click();
	}

	public static void main(String[] args) throws IOException, InterruptedException {
		UserAndShare objLogin = new UserAndShare();
		objLogin.Login();
		
//		C001_r Create_User = new C001_r();
//		Create_User.C001_r();
//		
//		pageRefresh();
		C002_r Create_Group = new C002_r();
		Create_Group.C002_r();
		
		pageRefresh();
		C003_r Create_Share = new C003_r();
		Create_Share.C003_r();
		
//		System.out.println("============================================");
//		
//		pageRefresh();
//		
//		C001_1 exceptionAddUser = new C001_1();
//		exceptionAddUser.C001_1();
//		
//		System.out.println("============================================");
//		
//		C003_1 searchUser = new C003_1();
//		searchUser.C003_1();
//		
//		System.out.println("============================================");
//		
//		pageRefresh();
//		
//		C006 sort = new C006();
//		sort.C006();
//		
//		System.out.println("============================================");
//		
//		C007 sortAfterSearching = new C007();
//		sortAfterSearching.C007();
//		
//		System.out.println("============================================");
//		
////		C009 showModifyPage = new C009();
////		showModifyPage.C009();
////		
////		System.out.println("============================================");
//		
//		pageRefresh();
//		
//		C010 modifyAdminInfo = new C010();
//		modifyAdminInfo.C010();
//		
//		System.out.println("============================================");
//		
//		C011 cannotDeleteAdmin = new C011();
//		cannotDeleteAdmin.C011();
//		
//		System.out.println("============================================");
//		
//		pageRefresh();
//		
////		C012 createGroup = new C012();
////		createGroup.C012();
////		
////		System.out.println("============================================");
//		
//		C013 defaultGroup = new C013();
//		defaultGroup.C013();
//		
//		System.out.println("============================================");
//		
//		pageRefresh();
//		
//		C014 createShareFolder = new C014();
//		createShareFolder.C014();
//		
//		System.out.println("============================================");
//		
//		C015 addShareInfomation = new C015();
//		addShareInfomation.C015();	
//		
//		System.out.println("============================================");
		
		driver.quit();		
	}

	private static void pageRefresh() {
		//Refresh
		try{
			Thread.sleep(2000);
		} catch(Exception e) {}
		String url = driver.getCurrentUrl();  
		driver.navigate().to(url);  
		try{
			Thread.sleep(2000);
		} catch(Exception e) {}
	}
	
	public static boolean isElementPresent(By by) {
	    boolean flag = true;
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	    if (!(driver.findElements(by).size() > 0)) {
	        flag = false;
	    } 
	    driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
	    return flag;
	}
	
	public static boolean isElementVisible(By by){
		return driver.findElement(by).isDisplayed();
	}
}
