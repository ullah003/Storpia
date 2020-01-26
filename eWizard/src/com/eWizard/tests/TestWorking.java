package com.eWizard.tests;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestWorking {
	protected static WebDriver driver;
	private static String baseUrl, userID, userPass;
	private BaseTestLogic.TestReportLisenter lisenter;
	
	File fConf, fReport;
	
	public TestWorking(File fileConf, File fileReport) {
		// TODO Auto-generated constructor stub
		fConf = fileConf;
		fReport = fileReport;
		lisenter = null;
	}
	
	public void Login() throws IOException {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		BufferedReader br = new BufferedReader(new FileReader(fConf));
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
		driver.findElement(By.name("icon_ewizard")).click();
	}
	

	public void startAutoTest() throws Exception {
		Login();

		A001 QuickStart = new A001(driver, fConf, fReport);
		QuickStart.setLisenter(lisenter);
		QuickStart.startTest();

		pageRefresh();
		A003 General_Setting = new A003(driver, fConf, fReport);
		General_Setting.setLisenter(lisenter);
		General_Setting.startTest();
		
		pageRefresh();
		A006 Volume_INfo = new A006(driver, fConf, fReport);
		Volume_INfo.setLisenter(lisenter);
		Volume_INfo.startTest();
		
		pageRefresh();
		A008 Volume_Create = new A008(driver, fConf, fReport);
		Volume_Create.setLisenter(lisenter);
		Volume_Create.startTest();
		
		pageRefresh();
		A009 Volume_Delete = new A009(driver, fConf, fReport);
		Volume_Delete.setLisenter(lisenter);
		Volume_Delete.startTest();

  		pageRefresh();
  		A010 Volume_Type_Info = new A010(driver, fConf, fReport);
  		Volume_Type_Info.setLisenter(lisenter);
  		Volume_Type_Info.startTest();
		
		
//		pageRefresh();
// 		A016 DDNS_Info = new A016(driver, fConf, fReport);
// 		DDNS_Info.setLisenter(lisenter);
// 		DDNS_Info.startTest();
		
		
//		pageRefresh();
//		A017 DDNS_Update = new A017();
//		DDNS_Update.A017();
		
  		pageRefresh();
  		A018 Network_Info = new A018(driver, fConf, fReport);
  		Network_Info.setLisenter(lisenter);
  		Network_Info.startTest();
  		
//  		pageRefresh();
//  		A019 Network_Setting = new A019(driver, fConf, fReport);
//  		Network_Setting.setLisenter(lisenter);
//  		Network_Setting.startTest();
//  		Currently excluded to continue test as IP may changed white testing above case

  		pageRefresh();
  		B001 Create_User = new B001(driver, fConf, fReport);
  		Create_User.setLisenter(lisenter);
  		Create_User.startTest();
  		
  		pageRefresh();
  		B002 Create_Group = new B002(driver, fConf, fReport);
  		Create_Group.setLisenter(lisenter);
  		Create_Group.startTest();
  		
  		pageRefresh();
  		B003 Create_Share = new B003(driver, fConf, fReport);
  		Create_Share.setLisenter(lisenter);
  		Create_Share.startTest();

		driver.findElement(By.xpath("//span[contains(text(), 'Logout')]")).click();
		Thread.sleep(3000);
		driver.quit();
	}

	public void setLisenter(BaseTestLogic.TestReportLisenter lisenter) {
		this.lisenter = lisenter;
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
		
}
