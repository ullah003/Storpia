package com.eFiler.tests;

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
		driver.findElement(By.name("icon_efiler")).click();
	}
	
	public void Admin_Login() throws IOException, InterruptedException {
		driver.findElement(By.className("logoutIcon")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("login_userid")).clear();
		driver.findElement(By.id("login_userid")).sendKeys(userID);
		driver.findElement(By.id("login_password")).clear();
		driver.findElement(By.id("login_password")).sendKeys(userPass);
		driver.findElement(By.cssSelector("input.btn_login")).click();
		//driver.findElement(By.name("icon_efiler")).click();
	}

	public void startAutoTest() throws Exception {
		Login();
		
		A001 eFiler_login = new A001(driver, fConf, fReport);
		eFiler_login.setLisenter(lisenter);
		eFiler_login.startTest();

		A002 login_redirect = new A002(driver, fConf, fReport);
		login_redirect.setLisenter(lisenter);
		login_redirect.startTest();
		
		driver.findElement(By.id("login_userid")).sendKeys(userID);
		driver.findElement(By.id("login_password")).sendKeys(userPass);
		driver.findElement(By.cssSelector("input.btn_login")).click();
		driver.findElement(By.name("icon_efiler")).click();
		
		B001 Dir_Tree = new B001(driver, fConf, fReport);
		Dir_Tree.setLisenter(lisenter);
		Dir_Tree.startTest();
		
		B002 First_Volume = new B002(driver, fConf, fReport);
		First_Volume.setLisenter(lisenter);
		First_Volume.startTest();
		
		B003 permission = new B003(driver, fConf, fReport);
		permission.setLisenter(lisenter);
		permission.startTest();
		
		B005 general_folder_list = new B005(driver, fConf, fReport);
		general_folder_list.setLisenter(lisenter);
		general_folder_list.startTest();
		
		Admin_Login();
		C001 Storpia_logo = new C001(driver, fConf, fReport);
		Storpia_logo.setLisenter(lisenter);
		Storpia_logo.startTest();
		
		
		C001_1 Home_redirect = new C001_1(driver, fConf, fReport);
		Home_redirect.setLisenter(lisenter);
		Home_redirect.startTest();
		
		C001_2 Home_redirect_title = new C001_2(driver, fConf, fReport);
		Home_redirect_title.setLisenter(lisenter);
		Home_redirect_title.startTest();
		
		C001_3 eFiler_redirect_title = new C001_3(driver, fConf, fReport);
		eFiler_redirect_title.setLisenter(lisenter);
		eFiler_redirect_title.startTest();
		
		C001_4 eWizard_redirect_title = new C001_4(driver, fConf, fReport);
		eWizard_redirect_title.setLisenter(lisenter);
		eWizard_redirect_title.startTest();
		
		C001_5 eSetup_redirect_title = new C001_5(driver, fConf, fReport);
		eSetup_redirect_title.setLisenter(lisenter);
		eSetup_redirect_title.startTest();
		
		C001_6 eFiler_Language = new C001_6(driver, fConf, fReport);
		eFiler_Language.setLisenter(lisenter);
		eFiler_Language.startTest();
		
		C001_7 Disk_Usage = new C001_7(driver, fConf, fReport);
		Disk_Usage.setLisenter(lisenter);
		Disk_Usage.startTest();
		
		C002 right_menu = new C002(driver, fConf, fReport);
		right_menu.setLisenter(lisenter);
		right_menu.startTest();
		
//		pageRefresh();
		C003 details_info = new C003(driver, fConf, fReport);
		details_info.setLisenter(lisenter);
		details_info.startTest();

		pageRefresh();
		C011 disabled_menu_aftrSearch = new C011(driver, fConf, fReport);
		disabled_menu_aftrSearch.setLisenter(lisenter);
		disabled_menu_aftrSearch.startTest();
	
		//No need, merged with C013
//		C012 redirect_search_folder = new C012(driver, fConf, fReport);
//		redirect_search_folder.setLisenter(lisenter);
//		redirect_search_folder.startTest();
		
		C013 search_folder_details = new C013(driver, fConf, fReport);
		search_folder_details.setLisenter(lisenter);
		search_folder_details.startTest();
		
		//can't handle popup window for duplicate folder
		pageRefresh();
		D001 create_folder = new D001(driver, fConf, fReport);
		create_folder.setLisenter(lisenter);
		create_folder.startTest();
		
		D002 rename = new D002(driver, fConf, fReport);
		rename.setLisenter(lisenter);
		rename.startTest();
		
		D040 mp3_information = new D040(driver, fConf, fReport);
		mp3_information.setLisenter(lisenter);
		mp3_information.startTest();
		
		D043 ID3_Tag = new D043(driver, fConf, fReport);
		ID3_Tag.setLisenter(lisenter);
		ID3_Tag.startTest();
		
/*		
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
		
		
//		driver.findElement(By.xpath("//li[@class='logoutIcon']")).click();
//		
//		Thread.sleep(3000);
//		driver.quit();
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
