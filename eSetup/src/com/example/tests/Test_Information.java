package com.example.tests;

import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Test_Information {
	private static WebDriver driver;
	private static String baseUrl;
	private static StringBuffer verificationErrors = new StringBuffer();

	public Test_Information() {
		driver = new FirefoxDriver();
		baseUrl = "http://192.168.1.9:9000/";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get(baseUrl + "/");
		driver.findElement(By.id("login_userid")).clear();
		driver.findElement(By.id("login_userid")).sendKeys("admin");
		driver.findElement(By.id("login_password")).clear();
		driver.findElement(By.id("login_password")).sendKeys("admin");
		driver.findElement(By.cssSelector("input.btn_login")).click();
		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout");
			try { if (isElementPresent(By.name("icon_esetup"))) break; } catch (Exception e) {}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {				
				e.printStackTrace();
			}
		}
		driver.findElement(By.name("icon_esetup")).click();

		System.out.println("*****************************************************************");
		System.out.println("*                         System Status                         *");
		System.out.println("*****************************************************************");
	}

	public static void main(String[] args) {
		Test_Information test = new Test_Information();
		test.A001();		
		test.A002();
		test.A003();
		test.A004();
		test.A005();
		test.A006();
		test.A007();
		test.A008();
//		test.A009();
		test.A010();
		test.A011();
		test.A012();
		test.A013();
		test.A014(); 
	}

	public void A001() {		
		System.out.println("⊙ A001 - System Information");
		System.out.println("It shows each and every information listed about the system? \n" +
				"시스템 정보 내용이 빠짐없이 출력이 되는가?\n" + 
				"(서버명, 모델명, 펌웨어버전, 펌웨어날짜)\n" +
				"모델명은 현재 존재하는 모델명으로 되어 있는가?\n");
		
		// Click System status menu
		System.out.println("Move System Status");
		driver.findElement(By.linkText("System Status")).click();

		// get Server Name
		String serverName= driver.findElement(By.xpath("//body/div[2]/div/div/div/div[2]/div/div/div[2]/div/div/div/div/div/div/form/div/div[2]/div/div/div/div[2]/div/div/table/tbody/tr/td[2]/div")).getText();
		System.out.println("Server name : " + serverName);

		// get model
		String model = driver.findElement(By.xpath("//body/div[2]/div/div/div/div[2]/div/div/div[2]/div/div/div/div/div/div/form/div/div[2]/div/div/div/div[2]/div/div[2]/table/tbody/tr/td[2]/div")).getText();
		System.out.println("Model : " + model);

		// get Firmware Version
		String firmwareVersion = driver.findElement(By.xpath("//body/div[2]/div/div/div/div[2]/div/div/div[2]/div/div/div/div/div/div/form/div/div[2]/div/div/div/div[2]/div/div[3]/table/tbody/tr/td[2]/div")).getText();
		System.out.println("FirmwareVersion : " + firmwareVersion);

		// get Firmware Date
		String firmwareDate = driver.findElement(By.xpath("//body/div[2]/div/div/div/div[2]/div/div/div[2]/div/div/div/div/div/div/form/div/div[2]/div/div/div/div[2]/div/div[4]/table/tbody/tr/td[2]/div")).getText();
		System.out.println("Firmware Date : " + firmwareDate);

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {			
			e.printStackTrace();
		}
		pageRefresh();
	}
	public void A002() {
		System.out.println("⊙ A002 - System Information - UI");
		System.out.println("판넬 show/hide 정상적으로 동작 하는가?\n" +
				"If  '<<' arrow clicked from left panel can it hide/show left panel and shows the right panel UI\n");
		// Left panel hide
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Click hide panel");
		driver.findElement(By.xpath("//body/div/div/div")).click();
		if (isElementPresent(By.xpath("//body/div/div[2]/div/div/div/div")))
			System.out.println("Left panel can hide Successfully");

		// Left panel show
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Click show panel");
		driver.findElement(By.xpath("//body/div[14]/div")).click();
		System.out.println("Left panel can show Successfully");

		pageRefresh();
	}
	public void A003() {
		System.out.println("⊙ A003 - System Information - HW");
		System.out.println("If any USB disk is connected to the device can it show USB information?\n" +
				"USB 장치정보는 USB가 있을경우에 출력 되는가?\n" +
				"다른 하드웨어 정보는 시스템에 맞는 정확한 값인가?\n");		

		// Click menu
		driver.findElement(By.xpath("//ul[@id='ext-gen78']/div/li/ul/li/div/a/span")).click();
		driver.findElement(By.cssSelector("html.ext-strict body#ext-gen11.ext-gecko div#content-panel.x-panel div#ext-gen28.x-panel-bwrap div#ext-gen29.x-panel-body div#systemInfo-panel.x-panel div#ext-gen32.x-panel-bwrap div#ext-gen33.x-panel-body div#ext-comp-1009.x-tab-panel div#ext-gen36.x-tab-panel-header div#ext-gen39.x-tab-strip-wrap ul#ext-gen41.x-tab-strip li#ext-comp-1009__ext-comp-1011 a#ext-gen47.x-tab-right em.x-tab-left span.x-tab-strip-inner span.x-tab-strip-text")).click();
		System.out.println("----------------------------------------");
		System.out.println("CPU");
		System.out.println("----------------------------------------");
		String deviceInfo = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div/div/div[2]/div/div[2]/div/div/div/div/form/div/div[2]/div/div/div/div[2]/div/div/table/tbody/tr/td[2]/div")).getText();
		System.out.println("cache : " + deviceInfo);

		deviceInfo = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div/div/div[2]/div/div[2]/div/div/div/div/form/div/div[2]/div/div/div/div[2]/div/div[2]/table/tbody/tr/td[2]/div")).getText();
		System.out.println("model : " + deviceInfo);

		deviceInfo = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div/div/div[2]/div/div[2]/div/div/div/div/form/div/div[2]/div/div/div/div[2]/div/div[3]/table/tbody/tr/td[2]/div")).getText();
		System.out.println("speed : " + deviceInfo);

		deviceInfo = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div/div/div[2]/div/div[2]/div/div/div/div/form/div/div[2]/div/div/div/div[2]/div/div[4]/table/tbody/tr/td[2]/div")).getText();
		System.out.println("physical_num : " + deviceInfo);

		deviceInfo = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div/div/div[2]/div/div[2]/div/div/div/div/form/div/div[2]/div/div/div/div[2]/div/div[5]/table/tbody/tr/td[2]/div")).getText();
		System.out.println("logical_num : " + deviceInfo);
		System.out.println();

		System.out.println("----------------------------------------");
		System.out.println("Memory");
		System.out.println("----------------------------------------");		

		deviceInfo = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div/div/div[2]/div/div[2]/div/div/div/div/form/div[2]/div[2]/div/div/div/div[2]/div/div/table/tbody/tr/td[2]/div")).getText();
		System.out.println("capacity : " + deviceInfo);
		System.out.println();


		System.out.println("----------------------------------------");
		System.out.println("Network");
		System.out.println("----------------------------------------");

		deviceInfo = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div/div/div[2]/div/div[2]/div/div/div/div/form/div[3]/div[2]/div/div/div/div[2]/div/div/table/tbody/tr/td/div")).getText();
		System.out.println("Network Interface : " + deviceInfo);

		deviceInfo = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div/div/div[2]/div/div[2]/div/div/div/div/form/div[3]/div[2]/div/div/div/div[2]/div/div/table/tbody/tr/td[2]/div")).getText();
		System.out.println("Active : " + deviceInfo);

		deviceInfo = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div/div/div[2]/div/div[2]/div/div/div/div/form/div[3]/div[2]/div/div/div/div[2]/div/div/table/tbody/tr/td[3]/div")).getText();
		System.out.println("Link : " + deviceInfo);

		deviceInfo = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div/div/div[2]/div/div[2]/div/div/div/div/form/div[3]/div[2]/div/div/div/div[2]/div/div/table/tbody/tr/td[4]/div")).getText();
		System.out.println("Physical : " + deviceInfo);

		deviceInfo = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div/div/div[2]/div/div[2]/div/div/div/div/form/div[3]/div[2]/div/div/div/div[2]/div/div/table/tbody/tr/td[5]/div")).getText();
		System.out.println("MAC Address : " + deviceInfo);

		deviceInfo = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div/div/div[2]/div/div[2]/div/div/div/div/form/div[3]/div[2]/div/div/div/div[2]/div/div/table/tbody/tr/td[6]/div")).getText();
		System.out.println("IP Address : " + deviceInfo);

		deviceInfo = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div/div/div[2]/div/div[2]/div/div/div/div/form/div[3]/div[2]/div/div/div/div[2]/div/div/table/tbody/tr/td[7]/div")).getText();
		System.out.println("Subnet Mask : " + deviceInfo);

		deviceInfo = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div/div/div[2]/div/div[2]/div/div/div/div/form/div[3]/div[2]/div/div/div/div[2]/div/div/table/tbody/tr/td[8]/div")).getText();
		System.out.println("MTU : " + deviceInfo);
		System.out.println();

		System.out.println("----------------------------------------");
		System.out.println("Other");
		System.out.println("----------------------------------------");

		deviceInfo = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div/div/div[2]/div/div[2]/div/div/div/div/form/div[4]/div[2]/div/div/div/div[2]/div/div/table/tbody/tr/td[2]/div")).getText();
		System.out.println("controllors : " + deviceInfo);

		deviceInfo = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div/div/div[2]/div/div[2]/div/div/div/div/form/div[4]/div[2]/div/div/div/div[2]/div/div[2]/table/tbody/tr/td[2]/div")).getText();
		System.out.println("IO ports : " + deviceInfo);

		deviceInfo = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div/div/div[2]/div/div[2]/div/div/div/div/form/div[4]/div[2]/div/div/div/div[2]/div/div[3]/table/tbody/tr/td[2]/div")).getText();
		System.out.println("gwaddr : " + deviceInfo);

		deviceInfo = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div/div/div[2]/div/div[2]/div/div/div/div/form/div[4]/div[2]/div/div/div/div[2]/div/div[4]/table/tbody/tr/td[2]/div")).getText();
		System.out.println("port : " + deviceInfo);

		deviceInfo = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div/div/div[2]/div/div[2]/div/div/div/div/form/div[4]/div[2]/div/div/div/div[2]/div/div[5]/table/tbody/tr/td[2]/div")).getText();
		System.out.println("DNS : " + deviceInfo);
		System.out.println();

		System.out.println("----------------------------------------");
		System.out.println("USB Device");
		System.out.println("----------------------------------------");

		deviceInfo = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div/div/div[2]/div/div[2]/div/div/div/div/form/div[5]/div[2]/div/div/div/div[2]/div/div/table/tbody/tr/td/div")).getText();
		System.out.println("ID [BUS:Device] : " + deviceInfo);

		deviceInfo = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div/div/div[2]/div/div[2]/div/div/div/div/form/div[5]/div[2]/div/div/div/div[2]/div/div/table/tbody/tr/td[2]/div")).getText();
		System.out.println("Contents : " + deviceInfo);
		System.out.println();
		pageRefresh();
	}
	public void A004() {
		System.out.println("⊙ A004 - System Information - System Status Information");
		System.out.println("It shows the status of each services successfully?\n"+
				"각 서비스의 상태정보가 정상적으로 출력 되는가?\n"+
				"서비스 상태정보가 현재 장비의 상태와 동일 한가?\n");

		// Click menu
		driver.findElement(By.xpath("//ul[@id='ext-gen78']/div/li/ul/li/div/a/span")).click();
		driver.findElement(By.cssSelector("html.ext-strict body#ext-gen11.ext-gecko div#content-panel.x-panel div#ext-gen28.x-panel-bwrap div#ext-gen29.x-panel-body div#systemInfo-panel.x-panel div#ext-gen32.x-panel-bwrap div#ext-gen33.x-panel-body div#ext-comp-1009.x-tab-panel div#ext-gen36.x-tab-panel-header div#ext-gen39.x-tab-strip-wrap ul#ext-gen41.x-tab-strip li#ext-comp-1009__ext-comp-1012 a#ext-gen49.x-tab-right em.x-tab-left span.x-tab-strip-inner span.x-tab-strip-text")).click();

		System.out.println("----------------------------------------");
		System.out.println("System Status");
		System.out.println("----------------------------------------");
		String Active = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div/div/div[2]/div/div[2]/div/div/div/div/form/div/div[2]/div/div/div/div[2]/div/div/table/tbody/tr/td[2]/div")).getText();
		String Status = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div/div/div[2]/div/div[2]/div/div/div/div/form/div/div[2]/div/div/div/div[2]/div/div/table/tbody/tr/td[3]/div")).getText();		
		System.out.println("cifs \t\t" + Active + "\t" + Status);

		Active = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div/div/div[2]/div/div[2]/div/div/div/div/form/div/div[2]/div/div/div/div[2]/div/div[2]/table/tbody/tr/td[2]/div")).getText();
		Status = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div/div/div[2]/div/div[2]/div/div/div/div/form/div/div[2]/div/div/div/div[2]/div/div[2]/table/tbody/tr/td[3]/div")).getText();
		System.out.println("cifs extension \t" + Active + "\t" + Status);

		Active = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div/div/div[2]/div/div[2]/div/div/div/div/form/div/div[2]/div/div/div/div[2]/div/div[3]/table/tbody/tr/td[2]/div")).getText();
		Status = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div/div/div[2]/div/div[2]/div/div/div/div/form/div/div[2]/div/div/div/div[2]/div/div[3]/table/tbody/tr/td[3]/div")).getText();
		System.out.println("nfs \t\t" + Active + "\t" + Status);

		Active = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div/div/div[2]/div/div[2]/div/div/div/div/form/div/div[2]/div/div/div/div[2]/div/div[4]/table/tbody/tr/td[2]/div")).getText();
		Status = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div/div/div[2]/div/div[2]/div/div/div/div/form/div/div[2]/div/div/div/div[2]/div/div[4]/table/tbody/tr/td[3]/div")).getText();
		System.out.println("ftp \t\t" + Active + "\t" + Status);

		Active = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div/div/div[2]/div/div[2]/div/div/div/div/form/div/div[2]/div/div/div/div[2]/div/div[5]/table/tbody/tr/td[2]/div")).getText();
		Status = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div/div/div[2]/div/div[2]/div/div/div/div/form/div/div[2]/div/div/div/div[2]/div/div[5]/table/tbody/tr/td[3]/div")).getText();
		System.out.println("atalk \t\t" + Active + "\t" + Status);

		Active = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div/div/div[2]/div/div[2]/div/div/div/div/form/div/div[2]/div/div/div/div[2]/div/div[6]/table/tbody/tr/td[2]/div")).getText();
		Status = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div/div/div[2]/div/div[2]/div/div/div/div/form/div/div[2]/div/div/div/div[2]/div/div[6]/table/tbody/tr/td[3]/div")).getText();
		System.out.println("ssh \t\t" + Active + "\t" + Status);

		Active = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div/div/div[2]/div/div[2]/div/div/div/div/form/div/div[2]/div/div/div/div[2]/div/div[7]/table/tbody/tr/td[2]/div")).getText();
		Status = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div/div/div[2]/div/div[2]/div/div/div/div/form/div/div[2]/div/div/div/div[2]/div/div[7]/table/tbody/tr/td[3]/div")).getText();
		System.out.println("telnet \t\t" + Active + "\t" + Status);
		
		pageRefresh();
	}
	public void A005() {
		System.out.println("⊙ A005 - System Information - System Status Information");
		System.out.println("It shows all software listing with its version successfully?\n" +
				"각 소프트웨어의 내용이 정상적으로 출력 되는가?\n");

		driver.findElement(By.xpath("//ul[@id='ext-gen78']/div/li/ul/li/div/a/span")).click();
		driver.findElement(By.cssSelector("html.ext-strict body#ext-gen11.ext-gecko div#content-panel.x-panel div#ext-gen28.x-panel-bwrap div#ext-gen29.x-panel-body div#systemInfo-panel.x-panel div#ext-gen32.x-panel-bwrap div#ext-gen33.x-panel-body div#ext-comp-1009.x-tab-panel div#ext-gen36.x-tab-panel-header div#ext-gen39.x-tab-strip-wrap ul#ext-gen41.x-tab-strip li#ext-comp-1009__ext-comp-1013 a#ext-gen51.x-tab-right em.x-tab-left span.x-tab-strip-inner span.x-tab-strip-text")).click();		

		System.out.println("----------------------------------------");
		System.out.println("Software");
		System.out.println("----------------------------------------");
		System.out.println("Category \t\tContents");


		String Contents = driver.findElement(By.xpath("//body/div[2]/div/div/div/div[2]/div/div/div[2]/div/div[2]/div/div/div/div/form/div/div[2]/div/div/div/div[2]/div/div/table/tbody/tr/td[2]/div")).getText();
		System.out.println("Lighttpd \t\t" + Contents);		

		Contents = driver.findElement(By.xpath("//body/div[2]/div/div/div/div[2]/div/div/div[2]/div/div[2]/div/div/div/div/form/div/div[2]/div/div/div/div[2]/div/div[2]/table/tbody/tr/td[2]/div")).getText();
		System.out.println("PHP      \t\t" + Contents);

		Contents = driver.findElement(By.xpath("//body/div[2]/div/div/div/div[2]/div/div/div[2]/div/div[2]/div/div/div/div/form/div/div[2]/div/div/div/div[2]/div/div[3]/table/tbody/tr/td[2]/div")).getText();
		System.out.println("Samba    \t\t" + Contents);

		Contents = driver.findElement(By.xpath("//body/div[2]/div/div/div/div[2]/div/div/div[2]/div/div[2]/div/div/div/div/form/div/div[2]/div/div/div/div[2]/div/div[4]/table/tbody/tr/td[2]/div")).getText();
		System.out.println("NFS      \t\t" + Contents);

		Contents = driver.findElement(By.xpath("//body/div[2]/div/div/div/div[2]/div/div/div[2]/div/div[2]/div/div/div/div/form/div/div[2]/div/div/div/div[2]/div/div[5]/table/tbody/tr/td[2]/div")).getText();
		System.out.println("ProFTPD  \t\t" + Contents);

		Contents = driver.findElement(By.xpath("//body/div[2]/div/div/div/div[2]/div/div/div[2]/div/div[2]/div/div/div/div/form/div/div[2]/div/div/div/div[2]/div/div[6]/table/tbody/tr/td[2]/div")).getText();
		System.out.println("AppleTalk\t\t" + Contents);
		
		pageRefresh();		
	}
	public void A006() {
		System.out.println("⊙ A006 - Resource Monitor");
		System.out.println("Resource monitoring shows information perfectly?\n" +
				"모니터링 관련 내용이 정상적으로 출력 되는가? \n");

		driver.findElement(By.xpath("//ul[@id='ext-gen78']/div/li/ul/li[2]/div/a/span")).click();
		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout");
			try {
				if (isElementPresent(By.id("cpu_chart"))) {
					System.out.println("CPU Chart is running successfully.");
					break;
				}
			} catch (Exception e) {}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		driver.findElement(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div/div/div/ul/li[2]/a[2]/em/span/span")).click();
		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout");
			try {
				if (isElementPresent(By.id("MEMORYCHART"))) {
					System.out.println("Memory Chart is running successfully.");
					break;
				}
			} catch (Exception e) {
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		driver.findElement(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div/div/div/ul/li[3]/a[2]/em/span/span")).click();
		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout");
			try {
				if (isElementPresent(By.id("network_chart"))) {
					System.out.println("Network Chart is running successfully.");
					break;
				}
			} catch (Exception e) {
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		pageRefresh();
	}
	public void A007() {
		System.out.println("⊙ A007 - Resource Monitor - Volume");
		System.out.println("Volume tab can show volume information normally?\n" +
				"볼륨텝의 볼륨정보가 정상적으로 출력 되는가?\n");

		driver.findElement(By.xpath("//ul[@id='ext-gen78']/div/li/ul/li[2]/div/a/span")).click();

		driver.findElement(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div/div/div/ul/li[4]/a[2]/em/span/span")).click();



		System.out.println("----------------------------------------");
		System.out.println("Volume Usage");
		System.out.println("----------------------------------------");
		System.out.println("Volume Name \tTotal Size \tUsed \tUnused \tRate");

		String volumeName = driver.findElement(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[4]/div/div/div/div[2]/div/div/div/div[2]/div/div/table/tbody/tr/td/div")).getText();
		String totalSize = driver.findElement(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[4]/div/div/div/div[2]/div/div/div/div[2]/div/div/table/tbody/tr/td[2]/div")).getText();		
		String used = driver.findElement(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[4]/div/div/div/div[2]/div/div/div/div[2]/div/div/table/tbody/tr/td[3]/div")).getText();
		String unused = driver.findElement(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[4]/div/div/div/div[2]/div/div/div/div[2]/div/div/table/tbody/tr/td[4]/div")).getText();
		String rate = "";
		//		rate = driver.findElement(By.id("ext-gen276")).getText();

		System.out.println(volumeName + "\t" + totalSize + "\t\t" + used + "\t" + unused + "\t" + rate);

		volumeName = driver.findElement(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[4]/div/div/div/div[2]/div/div/div/div[2]/div/div[2]/table/tbody/tr/td/div")).getText();
		totalSize = driver.findElement(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[4]/div/div/div/div[2]/div/div/div/div[2]/div/div[2]/table/tbody/tr/td[2]/div")).getText();		
		used = driver.findElement(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[4]/div/div/div/div[2]/div/div/div/div[2]/div/div[2]/table/tbody/tr/td[3]/div")).getText();
		unused = driver.findElement(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[4]/div/div/div/div[2]/div/div/div/div[2]/div/div[2]/table/tbody/tr/td[4]/div")).getText();
		//		rate = driver.findElement(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div/div/div/ul/li[4]/a[2]/em/span/span")).getText();		
		System.out.println(volumeName + "\t\t" + totalSize + "\t" + used + "\t" + unused + "\t" + rate);
		pageRefresh();
	}
	public void A008() {
		System.out.println("⊙ A008 - Log");
		System.out.println("For each event log is being saved properly? \n" +
				"각 이벤트에 대해 로그가 정상적으로 저장 되는가?\n");
		// get Server Name
		String serverName = driver.findElement(By.xpath("//body/div[2]/div/div/div/div[2]/div/div/div[2]/div/div/div/div/div/div/form/div/div[2]/div/div/div/div[2]/div/div/table/tbody/tr/td[2]/div")).getText();		

		// Network Menu Click
		driver.findElement(By.xpath("//body/div/div[2]/div/div/div/div/ul/div/li[2]/ul/li/div/a/span")).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		if(serverName.equals("gluesys01")) serverName = "gluesys02";
		else serverName = "gluesys01";

		// input hostname
		driver.findElement(By.name("hostname")).clear();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		driver.findElement(By.name("hostname")).sendKeys(serverName);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		driver.findElement(By.xpath("//button[contains(text(), 'Apply DDNS settings')]")).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		driver.findElement(By.xpath("//button[contains(text(), 'OK')]")).click();

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}	

		//Refresh
		try{
			Thread.sleep(2000);
		} catch(Exception e) {}
		String url = driver.getCurrentUrl();  
		driver.navigate().to(url);  
		try{
			Thread.sleep(2000);
		} catch(Exception e) {} 

		// Log Menu Click
		driver.findElement(By.xpath("//body/div/div[2]/div/div/div/div/ul/div/li/ul/li[3]/div/a/span")).click();

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Get log
		String temp = driver.findElement(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/div[2]/div/div/div[2]/div/div/table/tbody/tr/td[5]/div")).getText();


		if(temp.equals("[" + serverName + "] Device name registration")) {
			System.out.println("Log is saved successfully.");
		} else {
			System.out.println(temp);
		}
		pageRefresh();
	}
	public void A010() {
		System.out.println("⊙ A010 - Log");
		System.out.println("All logs can be deleetd at a time?\n" +
				"전체 삭제 버튼 클릭시 로그내용전체가 삭제 되는가? \n");

		driver.findElement(By.xpath("//body/div/div[2]/div/div/div/div/ul/div/li/ul/li[3]/div/a/span")).click();

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 전체 삭제 버튼 클릭
		driver.findElement(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/div/div/table/tbody/tr/td/table/tbody/tr/td[3]/table/tbody/tr[2]/td[2]/em/button")).click();

		driver.findElement(By.xpath("//body/div[18]/div[2]/div[2]/div/div/div/div/table/tbody/tr/td/table/tbody/tr/td[2]/table/tbody")).click(); // /tr[2]/td[2]

		String result = driver.findElement(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/div[2]/div/div/div[2]/div/div/table/tbody/tr/td[5]/div")).getText();
		if(result.equals("All logs has been deleted.")) {
			System.out.println("All logs has been deleted.");
			System.out.println("Delete all successfully.");
		}
		pageRefresh();
	}
	public void A011() {
		System.out.println("⊙ A011 - Log");
		System.out.println("After clicking Refresh button can it show the newly received log information?\n" +
				"새로고침 버튼 클릭시 로그내용을 새로 받아오는가?\n");

		WebDriver driver1;
		StringBuffer verificationErrors1 = new StringBuffer();

		driver1 = new FirefoxDriver();
		driver1.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);


//		// Test (driver)
//		driver.get(baseUrl + "/index.php");
//		driver.findElement(By.id("login_userid")).clear();
//		driver.findElement(By.id("login_userid")).sendKeys("admin");
//		driver.findElement(By.id("login_password")).clear();
//		driver.findElement(By.id("login_password")).sendKeys("admin");
//		driver.findElement(By.cssSelector("input.btn_login")).click();
//		try {
//			Thread.sleep(3000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		driver.findElement(By.name("icon_esetup")).click();

		System.out.println("Driver open");

		// Test (driver1)
		driver1.get(baseUrl + "/index.php");
		driver1.findElement(By.id("login_userid")).clear();
		driver1.findElement(By.id("login_userid")).sendKeys("admin");
		driver1.findElement(By.id("login_password")).clear();
		driver1.findElement(By.id("login_password")).sendKeys("admin");
		driver1.findElement(By.cssSelector("input.btn_login")).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		driver1.findElement(By.name("icon_esetup")).click();
		System.out.println("Driver1 open");


		// get Server Name
		String serverName = driver.findElement(By.xpath("//body/div[2]/div/div/div/div[2]/div/div/div[2]/div/div/div/div/div/div/form/div/div[2]/div/div/div/div[2]/div/div/table/tbody/tr/td[2]/div")).getText();		

		// Click Network Menu (driver)
		driver.findElement(By.xpath("//body/div/div[2]/div/div/div/div/ul/div/li[2]/ul/li/div/a/span")).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Driver -> Move Network menu");

		// Click Log Menu (driver1)
		driver1.findElement(By.xpath("//body/div/div[2]/div/div/div/div/ul/div/li/ul/li[3]/div/a/span")).click();
		System.out.println("Driver1 -> Move Log menu");

		if(serverName.equals("gluesys01")) serverName = "gluesys02";
		else serverName = "gluesys01";

		// input hostname
		driver.findElement(By.name("hostname")).clear();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.name("hostname")).sendKeys(serverName);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//button[contains(text(), 'Apply DDNS settings')]")).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		driver.findElement(By.xpath("//button[contains(text(), 'OK')]")).click();		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Driver -> Leave Log..");

		// Click Refresh button (driver1)
		driver1.findElement(By.xpath("//button[contains(text(), 'Refresh')]")).click();
		System.out.println("Driver1 -> Refresh button");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Get log
		String temp = driver1.findElement(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/div[2]/div/div/div[2]/div/div/table/tbody/tr/td[5]/div")).getText();

		if(temp.equals("[" + serverName + "] Device name registration")) {
			System.out.println("Log is saved successfully.");
		} else {
			System.out.println(temp);
		}
		pageRefresh();
	}
	public void A012() {
		System.out.println("⊙ A012 - Log - Log settings");
		System.out.println("로그 설정은 정상적으로 설정 되는가?\n" +
				"설정된 로그보관일 만큼의 로그만 출력되는가? \n");
		
		pageRefresh();
	}
	public void A013() {
		System.out.println("⊙ A013 - Legal");
		System.out.println("Normal output for Legal issues are displayed?\n" +
				"내용표시가 정상적으로 출력 되는가? \n");

		driver.findElement(By.xpath("//ul[@id='ext-gen78']/div/li/ul/li[4]/div/a/span")).click();

		String contents = driver.findElement(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div")).getText();
		if(contents != null) {
			System.out.println("정상적으로 메시지가 출력되었습니다.");
			System.out.println("----------------------------------------------------------------------------------------------------");
			System.out.println(contents);
		} else {
			System.out.println("메시지가 정상적으로 출력되지 않았습니다.");
		}
		pageRefresh();
	}
	public void A014() {
		System.out.println("⊙ A014 - Legal");
		System.out.println("각각의 프로덕트별 내용이 잘표기 되었는가?(회사명, 홈페이지주소…)");
		
		pageRefresh();
	}
	private void pageRefresh() {
		//Refresh
		try{
			Thread.sleep(2000);
		} catch(Exception e) {}
		String url = driver.getCurrentUrl();  
		driver.navigate().to(url);  
		try{
			Thread.sleep(2000);
		} catch(Exception e) {}

		System.out.println("*****************************************************************");
	}

	private static boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}
}
