package com.example.tests;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Network_Service {
	
	protected static WebDriver driver;
	private static String baseUrl, userID, userPass;
	
	public void Login() throws IOException {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		BufferedReader br = new BufferedReader(new FileReader("D:\\ServiceConf.txt"));
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
		Network_Service objLogin = new Network_Service();
		objLogin.Login();
		
		D001 CIFS_Active = new D001();
		CIFS_Active.D001();
		pageRefresh();
		
		D002 CIFS2 = new D002();
		CIFS2.D002();
		pageRefresh();
		
		D003 ATalk = new D003();
		ATalk.D003();
		pageRefresh();
		
		D004 NFS = new D004();
		NFS.D004();
		pageRefresh();
		
		D005 FTP_Setting = new D005();
		FTP_Setting.D005();
		
		D006 FTP = new D006();
		FTP.D006();
		pageRefresh();
		
		D007 Telnet = new D007();
		Telnet.D007();
		pageRefresh();
//		
//		D009 Firewall1 = new D009();
//		Firewall1.D009();
//		pageRefresh();

//		D010 Firewall2 = new D010();
//		Firewall2.D010();
//		pageRefresh();
//		
//		D011 Firewall3 = new D011();
//		Firewall3.D011();
//		pageRefresh();
		
		E001 Storpia = new E001();
		Storpia.E001();
		pageRefresh();
//		
//		E002 Router1 = new E002();
//		Router1.E002();
//		pageRefresh();
//		
//		E003 Router2 = new E003();
//		Router2.E003();
//		pageRefresh();
//		
//		E006 Router3 = new E006();
//		Router3.E006();
//		pageRefresh();
//		
//		E007 Router4 = new E007();
//		Router4.E007();
//		pageRefresh();
//		
		driver.close();
	}
	
	protected static void pageRefresh() {
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

}
