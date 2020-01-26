package com.eFiler.tests;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.eFiler.tests.MainViewer;


public class eFiler_All {
	
	protected static WebDriver driver;
//	protected static String baseUrl = "", userID = "", userPass = "", report_file_path = "";
	
//	public void Login() throws IOException {
//		driver = new FirefoxDriver();
//		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//
//		BufferedReader br = new BufferedReader(new FileReader("D:\\eFilerConf.txt"));
//	    try {
//	        for (int i=1; i<=4; i++){
//	        	String line = br.readLine();
//	        	String[] tokens = line.split("=");
//            	if (tokens[0].equals("url")){
//	        		baseUrl = tokens[1];
//	        	}else if (tokens[0].equals("ID")){
//	        		userID = tokens[1];
//	        	}else if (tokens[0].equals("passwd")){
//	        		userPass = tokens[1];
//	        	}else if (tokens[0].equals("report_file")){
//	        		report_file_path = tokens[1];
//	        	}
//	        }
//	    } finally {
//	        br.close();
//	    }
//		
//		driver.get(baseUrl);
//		driver.findElement(By.id("login_userid")).clear();
//		driver.findElement(By.id("login_userid")).sendKeys(userID);
//		driver.findElement(By.id("login_password")).clear();
//		driver.findElement(By.id("login_password")).sendKeys(userPass);
//		driver.findElement(By.cssSelector("input.btn_login")).click();
//		driver.findElement(By.name("icon_efiler")).click();
//	}
	
//	public void Admin_Login() throws IOException, InterruptedException {
//		driver.findElement(By.className("logoutIcon")).click();
//		Thread.sleep(3000);
//		driver.findElement(By.id("login_userid")).clear();
//		driver.findElement(By.id("login_userid")).sendKeys(userID);
//		driver.findElement(By.id("login_password")).clear();
//		driver.findElement(By.id("login_password")).sendKeys(userPass);
//		driver.findElement(By.cssSelector("input.btn_login")).click();
//		//driver.findElement(By.name("icon_efiler")).click();
//	}
	
	//public static void main(String[] args) throws IOException, InterruptedException {
	public static void main(String[] args) throws IOException, InterruptedException{
		MainViewer mainView = new MainViewer();
		mainView.setVisible(true);
		
/*		
		eFiler_All objLogin = new eFiler_All();
		objLogin.Login();
		
		A001 eFiler_login = new A001();
		eFiler_login.A001();
		
//		pageRefresh();
		A002 login_redirect = new A002();
		login_redirect.A002();
		
//		pageRefresh();
		driver.findElement(By.id("login_userid")).sendKeys(userID);
		driver.findElement(By.id("login_password")).sendKeys(userPass);
		driver.findElement(By.cssSelector("input.btn_login")).click();
		driver.findElement(By.name("icon_efiler")).click();
		
		B001 Dir_Tree = new B001();
		Dir_Tree.B001();

//		pageRefresh();
		B002 First_Volume = new B002();
		First_Volume.B002();
		
//		pageRefresh();
		B003 permission = new B003();
		permission.B003();

//		pageRefresh();
		B005 general_folder_list = new B005();
		general_folder_list.B005();
		
//		pageRefresh();
		C001 Storpia_logo = new C001();
		Storpia_logo.C001();

//		pageRefresh();
		C001_1 Home_redirect = new C001_1();
		Home_redirect.C001_1();
		
		C001_2 Home_redirect_title = new C001_2();
		Home_redirect_title.C001_2();

		C001_3 eFiler_redirect_title = new C001_3();
		eFiler_redirect_title.C001_3();
		
		C001_4 eWizard_redirect_title = new C001_4();
		eWizard_redirect_title.C001_4();
		
		C001_5 eSetup_redirect_title = new C001_5();
		eSetup_redirect_title.C001_5();
		
		C001_6 eFiler_Language = new C001_6();
		eFiler_Language.C001_6();
		
		C001_7 Disk_Usage = new C001_7();
		Disk_Usage.C001_7();

		C002 right_menu = new C002();
		right_menu.C002();
		
		C003 details_info = new C003();
		details_info.C003();
		
		driver.findElement(By.xpath("//li[@class='logoutIcon']")).click();
		Thread.sleep(3000);
		driver.quit();
*/		
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
