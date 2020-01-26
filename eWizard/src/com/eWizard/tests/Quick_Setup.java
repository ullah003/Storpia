package com.eWizard.tests;


//import java.io.BufferedReader;
//import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
//import javax.swing.JFileChooser;
//import javax.swing.filechooser.FileFilter;
//import javax.swing.filechooser.FileNameExtensionFilter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;

import com.eWizard.bhc.viewer.MainViewer;



public class Quick_Setup {
	
	protected static WebDriver driver;
//	private static String baseUrl, userID, userPass;
/*	
	public void Login() throws IOException {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		BufferedReader br = new BufferedReader(new FileReader("D://eWizardConf.txt"));
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
*/	
	public static void main(String[] args) throws IOException, InterruptedException{
		MainViewer mainView = new MainViewer();
		mainView.setVisible(true);
		
		
		/*Quick_Setup objLogin = new Quick_Setup();
		objLogin.Login();
		
		/*A001 Quick_Start = new A001();
		Quick_Start.A001();
		
		pageRefresh();
		A003 General_Setting = new A003();
		General_Setting.A003();
		
		pageRefresh();
		A006 Volume_INfo = new A006();
		Volume_INfo.A006();
		
		pageRefresh();
		A009 Volume_Delete = new A009();
		Volume_Delete.A009();
		
//		pageRefresh();
//		A008 Volume_Create = new A008();
//		Volume_Create.A008();
		
		pageRefresh();
		A006 Volume_INfo1 = new A006();
		Volume_INfo1.A006();
		
		pageRefresh();
		A010 Volume_Type_Info = new A010();
		Volume_Type_Info.A010();
		
		pageRefresh();
		A016 DDNS_Info = new A016();
		DDNS_Info.A016();
		
		pageRefresh();
		A017 DDNS_Update = new A017();
		DDNS_Update.A017();
		
		pageRefresh();
		A018 Network_Info = new A018();
		Network_Info.A018();
		
		pageRefresh();
		A019 Network_Setting = new A019();
		Network_Setting.A019();
		
		pageRefresh();
		B001 Create_User = new B001();
		Create_User.B001();
		
		pageRefresh();
		B002 Create_Group = new B002();
		Create_Group.B002();
		
		pageRefresh();
		B003 Create_Share = new B003();
		Create_Share.B003();
		
		driver.findElement(By.xpath("//span[contains(text(), 'Logout')]")).click();
		Thread.sleep(3000);
		driver.quit();*/
	}
	
//	private static void pageRefresh() {
//		//Refresh
//		try{
//			Thread.sleep(2000);
//		} catch(Exception e) {}
//		String url = driver.getCurrentUrl();  
//		driver.navigate().to(url);  
//		try{
//			Thread.sleep(2000);
//		} catch(Exception e) {}
//	}
	
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
