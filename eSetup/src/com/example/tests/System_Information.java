package com.example.tests;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class System_Information {
	
	protected static WebDriver driver;
	private static String baseUrl, userID, userPass;
	
	public void Login() throws IOException {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		BufferedReader br = new BufferedReader(new FileReader("D:\\SysInfoConf.txt"));
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
		System_Information objLogin = new System_Information();
		objLogin.Login();
		
		A001 Product = new A001();
		Product.A001();
		
		A002 LeftPanel = new A002();
		LeftPanel.A002();
		
		A003 HWInfo = new A003();
		HWInfo.A003();
		
		pageRefresh();
		A004 ServiceStatus = new A004();
		ServiceStatus.A004();
		
		pageRefresh();
		A005 Software = new A005();
		Software.A005();
		
		A006 ResourceMonitor = new A006();
		ResourceMonitor.A006();
		
		A007 Volume = new A007();
		Volume.A007();
		
		A008 Log = new A008();
		Log.A008();
		
		A010 DeleteLog = new A010();
		DeleteLog.A010();
		
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
