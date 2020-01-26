package com.example.tests;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class System_Setting {
	
	protected static WebDriver driver;
	private static String baseUrl, userID, userPass;
	
	public void Login() throws IOException {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		BufferedReader br = new BufferedReader(new FileReader("D:\\SystemConf.txt"));
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
		System_Setting objLogin = new System_Setting();
		objLogin.Login();
		
//		B001 Network = new B001();
//		Network.B001();
		
//		B002 DNS_Change = new B002();
//		DNS_Change.B002();
		
//		B003 Static_DHCP = new B003(); //remove
//		Static_DHCP.B003();
		
//		B007 DDNS = new B007();
//		DDNS.B007();
		
		//B008, B014, B015
//		pageRefresh();
//		B008 Volume_Info = new B008(); //remove
//		Volume_Info.B008();
//		
//		pageRefresh();
//		B014 Disk_Info = new B014(); //remove
//		Disk_Info.B014();
//		
//		pageRefresh();
//		B015 Disk_Write_Cache = new B015(); //remove
//		Disk_Write_Cache.B015();
		
//		pageRefresh();
//		B017 USB_Activate = new B017();
//		USB_Activate.B017();
//		
//		pageRefresh();
//		B018 USB_Format = new B018();  // currently removed
//		USB_Format.B018();
		
		//B020, B022
//		pageRefresh();
		B020 Language_Change = new B020();  //remove  
		Language_Change.B020();
		
		pageRefresh();
		B022 Mail_Setting = new B022();  //remove
		Mail_Setting.B022();
		
//		pageRefresh();
//		B026 Power_Setting = new B026();  //remove
//		Power_Setting.B026();
		
//		pageRefresh();
//		B030 SmartFan_Setting = new B030();  
//		SmartFan_Setting.B030();
		
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

}
