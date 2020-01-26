package com.example.tests;

import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Test_System {
	private static WebDriver driver;
	private static String baseUrl;
	private static StringBuffer verificationErrors = new StringBuffer();
	
	private static WebDriver driver1;
	private static String baseUrl1 = "http://192.168.1.9:58007/";
	private static boolean acceptNextAlert = true;
	
	
	public static void main(String []args) {
		Test_System test = new Test_System();		
		test.B001();
		test.B002();
		test.B003();
		test.B004();
		test.B005();
		test.B006();
		test.B007();
		test.B008(); // 안됨
		test.B009();
		test.B010();
		test.B011();
		test.B012();
		test.B013();
		test.B014();
		test.B015();
		test.B016();
		test.B017();
		test.B018();
		test.B019();
		test.B020();
		test.B021();
		test.B022();
		test.B023();
//*		test.B024(); // 전원이 꺼지기 때문에 주석 */

		test.B025(); // * webdev가 꺼져있음
		test.B026(); // *
		test.B027(); // *
		test.B028(); // *
		test.B029(); // *

		test.B030();
		test.B031();
		test.B032();
		test.B033();
//		test.B034(); // 설정 초기화로 인한 주석
		test.B035();
		test.B036();		
	}
	
	public Test_System() {
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
		System.out.println("*                            System                             *");
		System.out.println("*****************************************************************");
	}

	public void B001() {
		System.out.println("⊙ B001 - Network - wired network");
		System.out.println("Can it show network information normally?\n" +
				"네트워크 설정정보를 정상적으로 받아 오는가? \n");
		
		driver.findElement(By.linkText("Network")).click();
		
		System.out.println("네트워크 설정");
		System.out.println("Interface\tMac Address\t\tAddress Assign\tIP Address\tSubnet Mask\tGateway\t\tDNS");
		String NetworkInterface = driver.findElement(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/div/div/div[2]/div[2]/div/div/div[2]/div/div/table/tbody/tr/td/div")).getText();
		String MACAddress = driver.findElement(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/div/div/div[2]/div[2]/div/div/div[2]/div/div/table/tbody/tr/td[2]/div")).getText();
		String AddressAssign = driver.findElement(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/div/div/div[2]/div[2]/div/div/div[2]/div/div/table/tbody/tr/td[3]/div")).getText();
		String IPAddress = driver.findElement(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/div/div/div[2]/div[2]/div/div/div[2]/div/div/table/tbody/tr/td[4]/div")).getText();
		String SubnetMask = driver.findElement(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/div/div/div[2]/div[2]/div/div/div[2]/div/div/table/tbody/tr/td[5]/div")).getText();
		String Gateway = driver.findElement(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/div/div/div[2]/div[2]/div/div/div[2]/div/div/table/tbody/tr/td[6]/div")).getText();
		String DNS = driver.findElement(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/div/div/div[2]/div[2]/div/div/div[2]/div/div/table/tbody/tr/td[7]/div")).getText();
		System.out.println(NetworkInterface + "\t\t" + MACAddress + "\t" + AddressAssign + "\t\t" + IPAddress + "\t" + SubnetMask + "\t" + Gateway + "\t" + DNS);
		
		pageRefresh();
	}
	public void B002() {
		System.out.println("⊙ B002 - Network - wired network");
		System.out.println("Is Wired network setup information and modification works normally?\n" +
				"유선 네트워크의 설정정보 및 수정이 정상 동작 되는가? \n" +
				"If you change Wired network IP, can it connect using new IP automatically?\n" +
				"유선네트워크의 아이피를 변경하면 자동으로 변경아이피로 연결 되는가?\n");
		
		// Click Network menu
		driver.findElement(By.linkText("Network")).click();
		
		// get DNS
		String DNS = driver.findElement(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/div/div/div[2]/div[2]/div/div/div[2]/div/div/table/tbody/tr/td[7]/div")).getText();
		System.out.println("before : " + DNS);
		
		// Select Network Interface
		driver.findElement(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/div/div/div[2]/div[2]/div/div/div[2]/div/div/table/tbody/tr/td/div")).click();
		
				
		// Click Modify button
		driver.findElement(By.xpath("//button[contains(text(), 'Modify')]")).click();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {		
			e.printStackTrace();
		}
		
		driver.findElement(By.xpath("//input[@id='wdns1']")).clear();
		driver.findElement(By.xpath("//input[@id='wdns1']")).sendKeys("168.126.63.2");

		// Click Confirm button
		driver.findElement(By.xpath("//button[contains(text(), 'Confirm')]")).click();

		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {		
			e.printStackTrace();
		}		
		
		// get DNS
		String DNS1 = driver.findElement(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/div/div/div[2]/div[2]/div/div/div[2]/div/div/table/tbody/tr/td[7]/div")).getText();
		System.out.println("after : " + DNS1);
		
		if(DNS.equals(DNS1)) {
			System.out.println("Wired network setup information is not changed successfully.");
		} else {
			System.out.println("Wired network setup information is changed successfully.");
		}		
		
		pageRefresh();
	}
	public void B003() {
		System.out.println("⊙ B003 - Network - wired network");
		System.out.println("수동주소(static), 자동주소(dhcp) 설정에 따른 UI는 정상동작 하는가?\n");
		
		// Click Network menu
		driver.findElement(By.xpath("//body/div/div[2]/div/div/div/div/ul/div/li[2]/ul/li/div/a/span")).click();

		// Network Device select
		driver.findElement(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/div/div/div[2]/div[2]/div/div/div[2]/div/div/table/tbody/tr/td/div")).click();

		// Click Modify Button
		driver.findElement(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/div/div/div[2]/div/div/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[2]/td[2]/em/button")).click();

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

		// Click 'STATIC' radio button
		driver.findElement(By.xpath("//label[@for='wstatic']")).click();


		driver.findElement(By.xpath("//button[contains(text(), 'Confirm')]")).click();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

		String addressAssign = driver.findElement(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/div/div/div[2]/div[2]/div/div/div[2]/div/div/table/tbody/tr/td[3]/div")).getText();

		if(addressAssign.equals("static")) {
			System.out.println("static setting is completed successfully.");
		} else {	
			System.out.println("static setting is failed.");
		}


		// Network Device select
		driver.findElement(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/div/div/div[2]/div[2]/div/div/div[2]/div/div/table/tbody/tr/td/div")).click();

		// Click Modify Button
		driver.findElement(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/div/div/div[2]/div/div/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[2]/td[2]/em/button")).click();

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

		// Click 'DHCP' radio button
		driver.findElement(By.xpath("//label[@for='wdhcp']")).click();


		driver.findElement(By.xpath("//button[contains(text(), 'Confirm')]")).click();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

		addressAssign = driver.findElement(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/div/div/div[2]/div[2]/div/div/div[2]/div/div/table/tbody/tr/td[3]/div")).getText();

		if(addressAssign.equals("dhcp")) {
			System.out.println("dhcp setting is completed successfully.");
		} else {
			System.out.println("dhcp setting is failed.");
		}

		pageRefresh();
	}
	public void B004() {
		System.out.println("⊙ B004 - Network - wireless network");
		System.out.println("Can it save wireless network setting information and modified information normally?\n" +
				"무선 네트워크의 설정정보및 수정이 정상 동작 되는가? \n" +
				"Can it produce information of selected SSID perfectly?\n" +
				"선택한 SSID의 정보를 정상적으로 출력 하는가?\n");
		
		pageRefresh();
	}
	public void B005() {
		System.out.println("⊙ B005 - Network - wireless network");
		System.out.println("It can save all network setting informaiton normally? \n" +
				"네트워크 설정정보 저장이 정상적으로 되는가? \n" +
				"무선네트워크의 아이피를 변경하면 자동으로 변경아이피로 연결 되는가?\n");
		
		pageRefresh();
	}
	public void B006() {
		System.out.println("⊙ B006 - Network - wireless network");
		System.out.println("수동주소(static), 자동주소(dhcp) 설정에 따른 UI는 정상동작 하는가?\n");
		
		pageRefresh();
	}
	public void B007() {
		System.out.println("⊙ B007 - Network - wired network");
		System.out.println("Can it update DDNS name successfully?\n" + 
				"DDNS 설정이 정상적으로 저장 되는가?\n");
		
		pageRefresh();
		// System Status menu		
		// get server name before changing server name
		driver.findElement(By.linkText("System Status")).click();
		String ServerName = driver.findElement(By.xpath("//body/div[2]/div/div/div/div[2]/div/div/div[2]/div/div/div/div/div/div/form/div/div[2]/div/div/div/div[2]/div/div/table/tbody/tr/td[2]/div")).getText();
		System.out.println("변경 전 : " + ServerName);

		String DDNS_Name = "";
		if(ServerName.equals("gluesys01"))
			DDNS_Name = "gluesys02";
		else
			DDNS_Name = "gluesys01";		

		// Click Network menu
		driver.findElement(By.xpath("//body/div/div[2]/div/div/div/div/ul/div/li[2]/ul/li/div/a/span")).click();
		driver.findElement(By.id("hostname")).clear();
		driver.findElement(By.id("hostname")).sendKeys(DDNS_Name);
		driver.findElement(By.xpath("//button[contains(text(), 'Apply DDNS settings')]")).click();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e2) {

			e2.printStackTrace();
		}

		// Click OK
		driver.findElement(By.xpath("//button[contains(text(), 'OK')]")).click();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {

			e1.printStackTrace();
		}

		// Click System Status menu
		driver.findElement(By.xpath("//body/div/div[2]/div/div/div/div/ul/div/li/ul/li/div/a/span")).click();		
		System.out.println("Move System status Menu");

		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout");
			try { if (isElementPresent(By.xpath("//body/div[2]/div/div/div/div[2]/div/div/div[2]/div/div/div/div/div/div/form/div/div[2]/div/div/div/div[2]/div/div/table/tbody/tr/td[2]/div"))) break; } catch (Exception e) {}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
		}

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		String ServerName1 = driver.findElement(By.xpath("//body/div[2]/div/div/div/div[2]/div/div/div[2]/div/div/div/div/div/div/form/div/div[2]/div/div/div/div[2]/div/div/table/tbody/tr/td[2]/div")).getText();		
		System.out.println("변경 후 : " + ServerName1);

		if(ServerName.equals(ServerName1)) { 
			System.out.println("Changing DDNS name is failed.");
		} else {
			System.out.println("DDNS name is changed successfully.");
		}
		
		pageRefresh();
	}
	public void B008() {
		System.out.println("⊙ B008 - Disk - Volume Management");
		System.out.println("볼륨정보가 정상적으로 출력 되는가?\n");
		
		driver.findElement(By.linkText("Disk")).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {		
			e.printStackTrace();
		}
		
		pageRefresh();
		
		if(isElementPresent(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/div/div/div/form/div/div/div/div/div[2]/div[2]/div/div/div[2]/div/div/table/tbody/tr/td/div"))) {									  
			System.out.println("Volume Name\tVolume Type\tFile System\tTotal Size\tSpace Left\tMount status\tDevice name\tPartition status\tStatus");		
			String VolumeName = driver.findElement(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/div/div/div/form/div/div/div/div/div[2]/div[2]/div/div/div[2]/div/div/table/tbody/tr/td/div")).getText();		
			String VolumeType = driver.findElement(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/div/div/div/form/div/div/div/div/div[2]/div[2]/div/div/div[2]/div/div/table/tbody/tr/td[2]/div")).getText();
			
			String FileSystem = driver.findElement(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/div/div/div/form/div/div/div/div/div[2]/div[2]/div/div/div[2]/div/div/table/tbody/tr/td[3]/div")).getText();
			String TotalSize = driver.findElement(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/div/div/div/form/div/div/div/div/div[2]/div[2]/div/div/div[2]/div/div/table/tbody/tr/td[4]/div")).getText();
			String SpaceLeft = driver.findElement(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/div/div/div/form/div/div/div/div/div[2]/div[2]/div/div/div[2]/div/div/table/tbody/tr/td[5]/div")).getText();
			String MountStatus = driver.findElement(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/div/div/div/form/div/div/div/div/div[2]/div[2]/div/div/div[2]/div/div/table/tbody/tr/td[6]/div")).getText();
			String DeviceName = driver.findElement(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/div/div/div/form/div/div/div/div/div[2]/div[2]/div/div/div[2]/div/div/table/tbody/tr/td[7]/div")).getText();
			String PartitionStatus = driver.findElement(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/div/div/div/form/div/div/div/div/div[2]/div[2]/div/div/div[2]/div/div/table/tbody/tr/td[8]/div")).getText();
			String Status = driver.findElement(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/div/div/div/form/div/div/div/div/div[2]/div[2]/div/div/div[2]/div/div/table/tbody/tr/td[9]/div")).getText();
			
			System.out.println(VolumeName + "\t\t" + VolumeType + "\t" + FileSystem + "\t\t" + TotalSize + "\t\t" + SpaceLeft + "\t" + MountStatus + "\t\t" + DeviceName + "\t\t" + PartitionStatus + "\t\t\t" + Status);

		} else {
			System.out.println("Can't get Volume Information");
		}

		
		
		pageRefresh();
	}
	public void B009() {
		System.out.println("⊙ B009 - Disk - Volume Management");
		System.out.println("볼륨 복구시 주기적으로 볼륨 복구정보를 갱신하는가?\n" +
				"(hot swap 지원시 볼륨 복구중 볼륨복구정보를 주기적으로 갱신함)\n");
		
		pageRefresh();
	}
	public void B010() {
		System.out.println("⊙ B010 - Disk - Volume Management");
		System.out.println("볼륨생성은 정상적으로 동작 하는가?\n" +
				"(디스크개수에 따라 생성 할 수있는 볼륨타입이 정상적으로 설정되는가?)\n");
		
		pageRefresh();
	}
	public void B011() {
		System.out.println("⊙ B011 - Disk - Volume Management");
		System.out.println("볼륨삭제는 정상적으로 동작하는가?\n" +
				"(프로세스가 볼륨을 사용중일때 볼륨 삭제 되지 않음)\n");
		
		pageRefresh();
	}
	public void B012() {
		System.out.println("⊙ B012 - Disk - Volume Management");
		System.out.println("비트맵설정은 정상적으로 수행 되는가?\n" +
				"(볼륨이 RAID1 일경우에만 지원)\n");
		
		pageRefresh();
	}
	public void B013() {
		System.out.println("⊙ B013 - Disk - Volume Management");
		System.out.println("볼륨타입 정보는 정상적으로 출력 되는가?");
		
		//Refresh
		try{
			Thread.sleep(2000);
		} catch(Exception e) {}
		String url = driver.getCurrentUrl();  
		driver.navigate().to(url);  
		try{
			Thread.sleep(2000);
		} catch(Exception e) {}

		// Click Disk
		driver.findElement(By.linkText("Disk")).click();		
		
		if(isElementPresent(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/div/div/div/form/div/div/div/div/div[2]/div[2]/div/div/div[2]/div/div/table/tbody/tr/td[2]/div"))) {									  
			String VolumeType = driver.findElement(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/div/div/div/form/div/div/div/div/div[2]/div[2]/div/div/div[2]/div/div/table/tbody/tr/td[2]/div")).getText();
			System.out.println("Volume Type : " + VolumeType);
		} else {
			System.out.println("Can't get Volume Type");
		}
		
		
		pageRefresh();
	}
	public void B014() {
		System.out.println("⊙ B014 - Disk - Disk Status");
		System.out.println("디스크 리스트가 정상적으로 출력되는가?");
		
		driver.findElement(By.linkText("Disk")).click();
		driver.findElement(By.linkText("Disk Status")).click();
		
		if(isElementPresent(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[2]/div/div/div/div/div/div/div/form/div/div/div/div/div[2]/div[2]/div/div/div[2]/div/div/table/tbody/tr/td/div"))) {									  
			String diskName = driver.findElement(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[2]/div/div/div/div/div/div/div/form/div/div/div/div/div[2]/div[2]/div/div/div[2]/div/div/table/tbody/tr/td/div")).getText();
			String deviceName = driver.findElement(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[2]/div/div/div/div/div/div/div/form/div/div/div/div/div[2]/div[2]/div/div/div[2]/div/div/table/tbody/tr/td[2]/div")).getText();
			String model = driver.findElement(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[2]/div/div/div/div/div/div/div/form/div/div/div/div/div[2]/div[2]/div/div/div[2]/div/div/table/tbody/tr/td[3]/div")).getText();
			String capacity = driver.findElement(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[2]/div/div/div/div/div/div/div/form/div/div/div/div/div[2]/div[2]/div/div/div[2]/div/div/table/tbody/tr/td[4]/div")).getText();
			String partition = driver.findElement(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[2]/div/div/div/div/div/div/div/form/div/div/div/div/div[2]/div[2]/div/div/div[2]/div/div/table/tbody/tr/td[5]/div")).getText();
			String partitionSize = driver.findElement(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[2]/div/div/div/div/div/div/div/form/div/div/div/div/div[2]/div[2]/div/div/div[2]/div/div/table/tbody/tr/td[6]/div")).getText();
			String fileSystem = driver.findElement(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[2]/div/div/div/div/div/div/div/form/div/div/div/div/div[2]/div[2]/div/div/div[2]/div/div/table/tbody/tr/td[7]/div")).getText();
			String volumeAssign = driver.findElement(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[2]/div/div/div/div/div/div/div/form/div/div/div/div/div[2]/div[2]/div/div/div[2]/div/div/table/tbody/tr/td[8]/div")).getText();

			System.out.println("Disk Name : " + diskName);
			System.out.println("Device Name : " + deviceName);
			System.out.println("Model : " + model);
			System.out.println("Capacity : " + capacity);
			System.out.println("Partition : " + partition);
			System.out.println("Partition Size : " + partitionSize);
			System.out.println("File System : " + fileSystem);
			System.out.println("Volume Assign : " + volumeAssign);
		} else { 
			System.out.println("Can't print Disk List ");
		}
		
		
		pageRefresh();
	}
	public void B015() {
		System.out.println("⊙ B015 - Disk - Disk Status");
		System.out.println("쓰기캐쉬지원 동작이 정상적인가?\n" +
				"(writecache_available 값이 1일 경우에만 지원)\n");
		
		// Click Disk menu
		driver.findElement(By.linkText("Disk")).click();

		// Click Disk Status
		driver.findElement(By.linkText("Disk Status")).click();

		if(isElementPresent(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[2]/div/div/div/div/div/div/div/form/div/div/div/div/div[2]/div[2]/div/div/div[2]/div/div/table/tbody/tr/td/div"))) {									  
			// Click Disk
			driver.findElement(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[2]/div/div/div/div/div/div/div/form/div/div/div/div/div[2]/div[2]/div/div/div[2]/div/div/table/tbody/tr/td/div")).click();

			// Click Write Cache support button
			driver.findElement(By.xpath("//button[contains(text(), 'Write Cache support')]")).click();

			// Check Enable Cache
			driver.findElement(By.id("CacheEnable")).click();

			// Click Confirm button
			driver.findElement(By.xpath("//button[contains(text(), 'Confirm')]")).click();
			driver.findElement(By.xpath("//button[contains(text(), 'OK')]")).click();		

			System.out.println("Write cache successfully.");
		} else { 
			System.out.println("Can't write cache");
		}
		

		pageRefresh();
	}
	public void B016() {
		System.out.println("⊙ B016 - Disk - Disk Status");
		System.out.println("SMART test can be done successfully?\n" +
				"SMART 테스트의 동작이 정상적인가?\n");
		
		pageRefresh();
	}
	public void B017() {
		System.out.println("⊙ B017 - External Device");
		System.out.println("After selecting usb disk 'Activate', 'De-activate' can be done normally?\n" +
				"usb 디스크를 선택후 활성화, 비활성화 동작이 정상적인가? \n");
		
		// Click External Device menu
		driver.findElement(By.linkText("External Device")).click();
		
		String DiskName = "";
		if(isElementPresent(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/form/div/div[2]/div[2]/div/div/div[2]/div/div/table/tbody/tr/td/div"))) {
			// Disk Name
			driver.findElement(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/form/div/div[2]/div[2]/div/div/div[2]/div/div/table/tbody/tr/td/div")).getText();
			
			boolean status = false; // De-activate : false, activate : true
			// if Disk is De-activate
			if(!isElementPresent(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/form/div[2]/div[2]/div/div/div/div[2]/div"))) {									  
				status = true;
			} else { // case Activate
				status = false;
			}
			
			System.out.println(DiskName + "이 있습니다.");
			
			// USB가 꽂혀 있을 때
			if(!DiskName.equals("")) {
				if(status) {
					System.out.println("Status : Activate");
					// Click disk1
					driver.findElement(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/form/div/div[2]/div[2]/div/div/div[2]/div/div")).click();
					// Click Deactivate Button
					driver.findElement(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/form/div/div[2]/div/div/table/tbody/tr/td/table/tbody/tr/td[3]/table/tbody/tr[2]/td[2]/em/button")).click();
					
					if(isElementPresent(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/form/div[2]/div[2]/div/div/div/div[2]/div"))) {
						System.out.println("Disk is De-activate successfully.");
					}
				} else {			
					// Click disk1
					driver.findElement(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/form/div/div[2]/div[2]/div/div/div[2]/div/div")).click();
					// Click Activate Button
					driver.findElement(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/form/div/div[2]/div/div/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[2]/td[2]/em/button")).click();
					
					String VolumeName = driver.findElement(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/form/div[2]/div[2]/div/div/div/div[2]/div/div/table/tbody/tr/td/div")).getText();
					System.out.println("Volume Name : " + VolumeName); // null이 아니면 활성화 상태
					
					if(!VolumeName.equals("")) {
						System.out.println("Disk isActivate");
					}				
				}
			}
		} else {
			System.out.println("Disks don't exist.");
		}		
		
		
		
		pageRefresh();
	}
	public void B018() {
		System.out.println("⊙ B018 - External Device");
		System.out.println("After selecting USB disk can it be formated normally?\n" +
				"usb 디스크 선택후 포맷 설정은 정상적인가?\n");
		
		// Click External Device menu
		driver.findElement(By.linkText("External Device")).click();	
		
		if(isElementPresent(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/form/div/div[2]/div[2]/div/div/div[2]/div/div"))) {
		// Click Disk (disk1)
		driver.findElement(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/form/div/div[2]/div[2]/div/div/div[2]/div/div")).click();
		
		// Click format button
		driver.findElement(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/form/div/div[2]/div/div/table/tbody/tr/td/table/tbody/tr/td[5]/table/tbody/tr[2]/td[2]/em/button")).click();		
		driver.findElement(By.xpath("//button[contains(text(), 'Confirm')]")).click();
		
		System.out.println("OK");
	
		System.out.println("format successfully.");
		} else {
			System.out.println("format failed");
		}
		
		
		pageRefresh();
	}
	public void B019() {
		System.out.println("⊙ B019 - External Device");
		System.out.println("USB disks and volumes are normally displayed?\n" + 
				"usb 디스크와 볼륨은 정상적으로 표시 되는가?\n");
		
		// Click External Device menu
		driver.findElement(By.linkText("External Device")).click();	
		
		if(isElementPresent(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/form/div/div[2]/div[2]/div/div/div[2]/div/div/table/tbody/tr/td/div"))) {
		// 디스크명
			String diskName = driver.findElement(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/form/div/div[2]/div[2]/div/div/div[2]/div/div/table/tbody/tr/td/div")).getText();
			String deviceName = driver.findElement(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/form/div/div[2]/div[2]/div/div/div[2]/div/div/table/tbody/tr/td[2]/div")).getText();
			String model = driver.findElement(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/form/div/div[2]/div[2]/div/div/div[2]/div/div/table/tbody/tr/td[3]/div")).getText();
			String capacity = driver.findElement(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/form/div/div[2]/div[2]/div/div/div[2]/div/div/table/tbody/tr/td[4]/div")).getText();
			String partition = driver.findElement(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/form/div/div[2]/div[2]/div/div/div[2]/div/div/table/tbody/tr/td[5]/div")).getText();
			String partitionSize = driver.findElement(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/form/div/div[2]/div[2]/div/div/div[2]/div/div/table/tbody/tr/td[6]/div")).getText();
			String fileSystem = driver.findElement(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/form/div/div[2]/div[2]/div/div/div[2]/div/div/table/tbody/tr/td[7]/div")).getText();
			String volumeAssign = driver.findElement(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/form/div/div[2]/div[2]/div/div/div[2]/div/div/table/tbody/tr/td[8]/div")).getText();

			System.out.println("Disk Name : " + diskName);
			System.out.println("Device Name : " + deviceName);
			System.out.println("Model : " + model);
			System.out.println("Capacity : " + capacity);
			System.out.println("Partition : " + partition);
			System.out.println("Partition Size : " + partitionSize);
			System.out.println("File System : " + fileSystem);
			System.out.println("Volume Assign : " + volumeAssign);
			System.out.println();

			String volumeName = driver.findElement(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/form/div[2]/div[2]/div/div/div/div[2]/div/div/table/tbody/tr/td/div")).getText();
			String volumeFileSystem = driver.findElement(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/form/div[2]/div[2]/div/div/div/div[2]/div/div/table/tbody/tr/td[2]/div")).getText();
			String volumeTotalSize = driver.findElement(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/form/div[2]/div[2]/div/div/div/div[2]/div/div/table/tbody/tr/td[3]/div")).getText();
			String volumeSpaceLeft = driver.findElement(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/form/div[2]/div[2]/div/div/div/div[2]/div/div/table/tbody/tr/td[4]/div")).getText();
			String volumeMountStatus = driver.findElement(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/form/div[2]/div[2]/div/div/div/div[2]/div/div/table/tbody/tr/td[5]/div")).getText();
			String volumeDisk = driver.findElement(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/form/div[2]/div[2]/div/div/div/div[2]/div/div/table/tbody/tr/td[6]/div")).getText();
			String volumeStatus = driver.findElement(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/form/div[2]/div[2]/div/div/div/div[2]/div/div/table/tbody/tr/td[7]/div")).getText();

			System.out.println("Volume Name : " + volumeName);
			System.out.println("File System : " + volumeFileSystem);
			System.out.println("Total Size : " + volumeTotalSize);
			System.out.println("Space Left : " + volumeSpaceLeft);
			System.out.println("Mount status : " + volumeMountStatus);
			System.out.println("Disk : " + volumeDisk);
			System.out.println("Status : " + volumeStatus);		
		} else {
			System.out.println("Can't get Disk Information and Volume Information");
		}
		pageRefresh();
	}
	public void B020() {
		System.out.println("⊙ B020 - Language & Time - Language");
		System.out.println("Can change language normally?\n" +
				"언어 변경이 정상적으로 적용 되는가? \n");
		
		// Click Language and Time menu
		driver.findElement(By.linkText("Language and Time")).click();


		driver.findElement(By.id("languageWebView")).click(); // ▽ 선택
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		if(isElementPresent(By.xpath("//body/div[14]/div/div[2]"))) {
			driver.findElement(By.xpath("//body/div[14]/div/div[2]")).click(); // Korean 선택
			System.out.println("Select Korean");
		} else {
			System.out.println("Can't select Korean");
		}
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}		
		// Click Confirm button
		driver.findElement(By.xpath("//button[contains(text(), 'Confirm')]")).click();		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}		


		String temp = "";		
		temp = driver.findElement(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/div/div/div[2]/div/div[2]/label")).getText();

		if(temp.equals("Display Language:")) {
			System.out.println("Language : English");
			System.out.println("Language is not changed.");
		} else if(temp.equals("표시 언어:")) {
			System.out.println("Language : Korean");
			System.out.println("Language is changed successfully.");		
		} else {
			System.out.println("Error..................");
		}
		
		pageRefresh();
	}
	public void B021() {
		System.out.println("⊙ B021 - Language & Time - Time");
		System.out.println("Time setting (Manual, Sync with time zone) works normally?\n" +
				"시간설정은 정상적으로 동작 하는가? \n");
		
		pageRefresh();
	}
	public void B022() {
		System.out.println("⊙ B022 - E-mail & Notification");
		System.out.println("E-mail setting can be done properly?\n" +
				"메일설정이 정상적으로 저장 되는가?\n" +
				"After sending test mail mail setting done properly?\n" +
				"테스트메일발송후 메일설정이 되는가?\n");
		
		driver.findElement(By.linkText("E-Mail and Notification")).click();		
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}		
		driver.findElement(By.name("smtpserver")).clear();		
		driver.findElement(By.name("smtpserver")).sendKeys("smtp.naver.com");
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		driver.findElement(By.name("port")).clear();
		driver.findElement(By.name("port")).sendKeys("465");

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		if(!driver.findElement(By.name("tls_enable")).isSelected()) {
			driver.findElement(By.name("tls_enable")).click();
		}
		
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		if(!driver.findElement(By.name("auth_enable")).isSelected()){
			driver.findElement(By.name("auth_enable")).click();
		}
		
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		driver.findElement(By.name("auth_user")).clear();
		driver.findElement(By.name("auth_user")).sendKeys("bjm5468");
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		driver.findElement(By.name("auth_passwd")).clear();
		driver.findElement(By.name("auth_passwd")).sendKeys("akdh12");
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		driver.findElement(By.name("auth_passwd1")).clear();
		driver.findElement(By.name("auth_passwd1")).sendKeys("akdh12");
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		driver.findElement(By.name("to1")).clear();
		driver.findElement(By.name("to1")).sendKeys("bjm5468@naver.com");
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		driver.findElement(By.name("to2")).clear();
		driver.findElement(By.name("to2")).sendKeys("killsia@tistory.com");		
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
		driver.findElement(By.xpath("//button[contains(text(), 'Sending test e-Mail')]")).click();		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		System.out.println("Send E-Mail successfully.");
		
		driver.findElement(By.xpath("//button[contains(text(), 'OK')]")).click();
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		driver.findElement(By.xpath("//body/div[2]/div/div/div[3]/div[2]/div/div/div[2]/div/div/div/div/div/div/div/div/div/div/table/tbody/tr[2]/td[2]/em/button")).click();
		System.out.println("Setting successfully.");
		
		pageRefresh();
	}
	public void B023() {
		System.out.println("⊙ B023 - E-mail & Notification");
		System.out.println("Can it send mail to Primary and Secondary email address?\n" +
				"테스트 메일이 '기본 이메일 주소','보조 이메일 주소'로 전송이 되는가?\n");
		
		pageRefresh();
	}
	public void B024() {
		System.out.println("⊙ B024 - Power");
		System.out.println("Power Off, system restart works normally?\n" +
				"전원 끄기,절전모드,시스템 재시작은 정상 동작 되는가?\n");
		
		// Click Power menu
		driver.findElement(By.linkText("Power")).click();
		

		// Select Power Off RadioButton
		driver.findElement(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/div/div/div/div/div/div/div/div/div[2]/form/div/div/div/div/div/div/div/div/input")).click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			
			e1.printStackTrace();
		}				
		driver.findElement(By.xpath("//button[contains(text(), 'Confirm')]")).click();		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			
			e1.printStackTrace();
		}	
		driver.findElement(By.xpath("//button[contains(text(), 'Yes')]")).click();
		
		driver.findElement(By.xpath("//button[contains(text(), 'OK')]")).click();
		
		System.out.println("Shutdown.....");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			
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

		// Check url
		driver.get(baseUrl + "/index.php");		
		try {
			if (!isElementPresent(By.cssSelector("input.btn_login")))
				System.out.println("Device is turned off successfully.");
			else
				System.out.println("Device is not turned off.");
		} catch (Exception e) {
		}		
		
		pageRefresh();
	}
	public void B025() {
		System.out.println("⊙ B025 - Power");
		System.out.println("Power Options settings are stored properly?\n" +
				"전원옵션 설정이 정상적으로 저장 되는가? \n");
		
		// Before
		driver1 = new FirefoxDriver();		
		driver1.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		// Test
		driver1.get(baseUrl1 + "/");
		driver1.findElement(By.id("login_userid")).clear();
		driver1.findElement(By.id("login_userid")).sendKeys("admin");
		driver1.findElement(By.id("login_password")).clear();
		driver1.findElement(By.id("login_password")).sendKeys("admin");
		driver1.findElement(By.cssSelector("input.btn_login")).click();
//		for (int second = 0;; second++) {
//			if (second >= 60) fail("timeout");
//			try { if (isElementPresent(By.name("icon_esetup"))) break; } catch (Exception e) {}
//			try {
//				Thread.sleep(1000);
//			} catch (InterruptedException e) {				
//				e.printStackTrace();
//			}
//		}

		driver1.findElement(By.name("icon_esetup")).click();		

		// Click Power menu
		driver1.findElement(By.linkText("Power")).click();
		System.out.println("Move Power menu");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e5) {

			e5.printStackTrace();
		}

		// Click Wake on LAN		
		WebElement wakeOnLAN = driver1.findElement(By.name("wol_enable"));
		if(!wakeOnLAN.isSelected()) {
			wakeOnLAN.click();
			System.out.println("Click Wake on LAN");
		}

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e4) {

			e4.printStackTrace();
		}

		// Click Scheduled Power On
		WebElement scheduledPowerOn = driver1.findElement(By.name("turnon_enable"));
		if(!scheduledPowerOn.isSelected()) {
			scheduledPowerOn.click();
			System.out.println("Click Scheduled Power On");
		}

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e3) {

			e3.printStackTrace();
		}

		// Click Scheduled Shutdown
		WebElement scheduledShutdown = driver1.findElement(By.name("shutdown_enable"));
		if(!scheduledShutdown.isSelected()) {
			scheduledShutdown.click();
			System.out.println("Click Scheduled Shutdown");
		}

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e3) {

			e3.printStackTrace();
		}

		// Click Confirm Button
		driver1.findElement(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div[2]/div/div/div/div/div/div/div/div/table/tbody/tr[2]/td[2]/em/button")).click();
		try {
			Thread.sleep(500);
		} catch (InterruptedException e3) {

			e3.printStackTrace();
		}
		driver1.findElement(By.xpath("//button[contains(text(), 'OK')]")).click();

		//Refresh
		System.out.println("Refresh Page");
		try{
			Thread.sleep(2000);
		} catch(Exception e) {}
		String url = driver1.getCurrentUrl();  
		driver1.navigate().to(url);  
		try{
			Thread.sleep(2000);
		} catch(Exception e) {}

		// Click Power menu
		driver1.findElement(By.xpath("//body/div/div[2]/div/div/div/div/ul/div/li[2]/ul/li[6]/div/a/span")).click();

		// get status
		wakeOnLAN = driver1.findElement(By.name("wol_enable"));
		scheduledPowerOn = driver1.findElement(By.name("turnon_enable"));
		scheduledShutdown = driver1.findElement(By.name("shutdown_enable"));

		boolean status_wakeOnLAN = false;
		boolean status_scheduledPowerOn = false;
		boolean status_scheduledShutdown = false;

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e2) {

			e2.printStackTrace();
		}

		// Check Wake on LAN
		if(wakeOnLAN.isSelected()) {
			status_wakeOnLAN = true;
			System.out.println("Wake on LAN is selected");			
		} else {
			System.out.println("isn't chosen");
		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e2) {

			e2.printStackTrace();
		}

		// Check Scheduled Power On
		if(scheduledPowerOn.isSelected()) {
			status_scheduledPowerOn = true;
			System.out.println("Scheduled Power On is selected");
		} else {
			System.out.println("isn't chosen");
		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {

			e1.printStackTrace();
		}

		// Check Scheduled Shutdown
		if(scheduledShutdown.isSelected()) {
			status_scheduledShutdown = true;
			System.out.println("Scheduled Shutdown is selected");
		} else {
			System.out.println("isn't chosen");
		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

		if(status_wakeOnLAN && status_scheduledPowerOn && status_scheduledShutdown) {
			System.out.println("Power Option settings are stored successfully.");
		} else {
			System.out.println("Power Option settings are failed.");
		}

		pageRefresh1();
	}
	public void B026() {
		System.out.println("⊙ B026 - Power");
		System.out.println("The contents of the power option setting operates normally?\n" +
				"전원옵션 설정의 내용이 정상적으로 동작 되는가? \n");
		
		// Click Power menu
		driver1.findElement(By.xpath("//body/div/div[2]/div/div/div/div/ul/div/li[2]/ul/li[6]/div/a/span")).click();
		System.out.println("Move Power menu");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e1) {
			
			e1.printStackTrace();
		}

		// Click Wake on LAN		
		WebElement wakeOnLAN = driver1.findElement(By.name("wol_enable"));
		if(!wakeOnLAN.isSelected()) {
			wakeOnLAN.click();
			System.out.println("Click Wake on LAN");
		}

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			
			e1.printStackTrace();
		}

		// Click Scheduled Power On
		WebElement scheduledPowerOn = driver1.findElement(By.name("turnon_enable"));
		if(!scheduledPowerOn.isSelected()) {
			scheduledPowerOn.click();
			System.out.println("Click Scheduled Power On");
		}

		// Click Power on -> time hour (01)
		driver1.findElement(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div[2]/div/div/div/div/div/div/div/div/div/div/div/div/div[2]/form/fieldset[2]/div/div/div[3]/div/div/div/div/div/div/div/div/div/div/div/div/div/div/div/div/div/img")).click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			
			e1.printStackTrace();
		}
		driver1.findElement(By.xpath("//body/div[14]/div/div[2]")).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			
			e1.printStackTrace();
		}

		// Click Power on -> time minute (04)
		driver1.findElement(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div[2]/div/div/div/div/div/div/div/div/div/div/div/div/div[2]/form/fieldset[2]/div/div/div[3]/div/div/div/div/div/div/div/div/div/div/div/div[2]/div/div/div/div/div/img")).click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			
			e1.printStackTrace();
		}
		driver1.findElement(By.xpath("//body/div[15]/div/div[5]")).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			
			e1.printStackTrace();
		}

		// Click Scheduled Shutdown
		WebElement scheduledShutdown = driver1.findElement(By.name("shutdown_enable"));
		if(!scheduledShutdown.isSelected()) {
			scheduledShutdown.click();
			System.out.println("Click Scheduled Shutdown");
		}

		// Click Shutdown -> time hour (01)
		driver1.findElement(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div[2]/div/div/div/div/div/div/div/div/div/div/div/div/div[2]/form/fieldset[3]/div/div/div[3]/div/div/div/div/div/div/div/div/div/div/div/div/div/div/div/div/div/img")).click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			
			e1.printStackTrace();
		}
		driver1.findElement(By.xpath("//body/div[16]/div/div[2]")).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			
			e1.printStackTrace();
		}

		// Click Shutdown -> time minute (03)
		driver1.findElement(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div[2]/div/div/div/div/div/div/div/div/div/div/div/div/div[2]/form/fieldset[3]/div/div/div[3]/div/div/div/div/div/div/div/div/div/div/div/div[2]/div/div/div/div/div/img")).click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			
			e1.printStackTrace();
		}
		driver1.findElement(By.xpath("//body/div[17]/div/div[4]")).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			
			e1.printStackTrace();
		}

		// Click Confirm Button
		driver1.findElement(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div[2]/div/div/div/div/div/div/div/div/table/tbody/tr[2]/td[2]/em/button")).click();
		try {
			Thread.sleep(500);
		} catch (InterruptedException e1) {
			
			e1.printStackTrace();
		}
		driver1.findElement(By.xpath("//button[contains(text(), 'OK')]")).click();

		//Refresh
		System.out.println("Refresh Page");
		try{
			Thread.sleep(2000);
		} catch(Exception e) {}
		String url = driver1.getCurrentUrl();  
		driver1.navigate().to(url);  
		try{
			Thread.sleep(2000);
		} catch(Exception e) {}

		// Click Power menu
		driver1.findElement(By.xpath("//body/div/div[2]/div/div/div/div/ul/div/li[2]/ul/li[6]/div/a/span")).click();

		// get status
		wakeOnLAN = driver1.findElement(By.name("wol_enable"));
		scheduledPowerOn = driver1.findElement(By.name("turnon_enable"));
		scheduledShutdown = driver1.findElement(By.name("shutdown_enable"));

		boolean status_wakeOnLAN = false;
		boolean status_scheduledPowerOn = false;
		boolean status_scheduledShutdown = false;

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}

		// Check Wake on LAN
		if(wakeOnLAN.isSelected()) {
			status_wakeOnLAN = true;
			System.out.println("Wake on LAN is selected");			
		} else {
			System.out.println("isn't chosen");
		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
		String hour = "";
		String minute = "";

		// Check Scheduled Power On
		if(scheduledPowerOn.isSelected()) {
			status_scheduledPowerOn = true;
			System.out.println("Scheduled Power On is selected");
			hour = driver1.findElement(By.id("turnon_hour")).getText();
			minute = driver1.findElement(By.id("turnon_min")).getText();			
			System.out.println("System will be turned on at " + hour + ":" + minute);

		} else {
			System.out.println("isn't chosen");
		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}

		// Check Scheduled Shutdown
		if(scheduledShutdown.isSelected()) {
			status_scheduledShutdown = true;
			System.out.println("Scheduled Shutdown is selected");
			hour = driver1.findElement(By.id("shutdown_hour")).getText();
			minute = driver1.findElement(By.id("shutdown_min")).getText();
			System.out.println("System will be shutdown at " + hour + ":" + minute);
		} else {
			System.out.println("isn't chosen");
		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}

		if(status_wakeOnLAN && status_scheduledPowerOn && status_scheduledShutdown) {
			System.out.println("Power Option settings are stored successfully.");
		} else {
			System.out.println("Power Option settings are failed.");
		}
		
		pageRefresh1();
	}
	public void B027() {
		System.out.println("⊙ B027 - Power");
		System.out.println("예약켜기, 예약종료의 설정된 시간에 정상동작 하는가?\n");
		
		pageRefresh1();
	}
	public void B028() {
		System.out.println("⊙ B028 - Power");
		System.out.println("디스크 절전모드의 설정된 시간에 정상동작 하는가?\n");
		
		pageRefresh1();
	}
	public void B029() {
		System.out.println("⊙ B029 - Power");
		System.out.println("랜깨우기, 예약켜기는 시스템 설정에 따라 UI가 출력되는가?\n");
		
		pageRefresh1();
	}
	public void B030() {
		System.out.println("⊙ B030 - Smart Fan");
		System.out.println("스마트팬설정이 정상동작 하는가?\n");
		
		// Click Smart Fan menu
		driver.findElement(By.linkText("Smart Fan")).click();

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e1) {
			
			e1.printStackTrace();
		}

		// Smart Fan check
		driver.findElement(By.xpath("//*[@id='customenable']")).click();		

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e1) {
			
			e1.printStackTrace();
		}

		// ▽ Click
		driver.findElement(By.xpath("//img[@src='/extjs/resources/images/default/s.gif']")).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e1) {
			
			e1.printStackTrace();
		}

		// Low Select
		try {
			if (!isElementPresent(By.xpath("//body/div[14]/div/div[2]")))
				System.out.println("You cannot click combo box");
			else {
				driver.findElement(By.xpath("//body/div[14]/div/div[2]")).click();
				System.out.println("Select combo box");
				
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
					
					e1.printStackTrace();
				}

				// Click Confirm Button
				driver.findElement(By.xpath("//button[contains(text(), 'Confirm')]")).click();
				driver.findElement(By.xpath("//button[contains(text(), 'OK')]")).click();	

				//Refresh
				try{
					Thread.sleep(2000);
				} catch(Exception e) {}
				String url = driver.getCurrentUrl();  
				driver.navigate().to(url);  
				try{
					Thread.sleep(2000);
				} catch(Exception e) {} 

				// Click Smart Fan menu
				driver.findElement(By.linkText("Smart Fan")).click();

				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}

				// Check customenable radio button
				if(driver.findElement(By.xpath("//*[@id='customenable']")).isSelected()) {
					System.out.println("Smart Fan setting is completed succesfully.");			
				} else {
					System.out.println("Smart Fan setting is enable.");
				}
			}
					
		} catch (Exception e) {
		}
		

		
		
		pageRefresh();
	}
	public void B031() {
		System.out.println("⊙ B031 - FW Management");
		System.out.println("현재펌웨어의 정보가 정상 출력 되는가?\n");
		
		// Click Firmware Management menu
		driver.findElement(By.linkText("Firmware Management")).click();		

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}		

		if(isElementPresent(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/div/div/div/div/div/div[2]/div/div/div/div[2]/div/div/table/tbody/tr/td[2]/div"))) {			// get Model & Version & Firmware Date
			String model = driver.findElement(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/div/div/div/div/div/div[2]/div/div/div/div[2]/div/div/table/tbody/tr/td[2]/div")).getText();		
			String version = driver.findElement(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/div/div/div/div/div/div[2]/div/div/div/div[2]/div/div[2]/table/tbody/tr/td[2]/div")).getText();
			String firmwareDate = driver.findElement(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/div/div/div/div/div/div[2]/div/div/div/div[2]/div/div[3]/table/tbody/tr/td[2]/div")).getText();

			System.out.println("----------------------------------------");
			System.out.println("Firmware Management");
			System.out.println("----------------------------------------");
			System.out.println("Category \t Contents");
			System.out.println("========================================");
			System.out.println("model \t\t " + model);
			System.out.println("version \t " + version);
			System.out.println("firmwareDate \t " + firmwareDate);
		} else {
			System.out.println("Can't print Firmware Management");
		}
		pageRefresh();
	}
	public void B032() {
		System.out.println("⊙ B032 - FW Management");
		System.out.println("펌웨어 업그레이드는 정상적으로 동작하는가?\n" +
				"(업그레이드왼료후 로그인페이지로 이동)\n");
		
		pageRefresh();
	}
	public void B033() {
		System.out.println("⊙ B033 - FW Management");
		System.out.println("펌웨어 업그레이드시 예외처리는 정상동작 하는가?\n" +
				"(로컬아이피로 접근시에만 업그레이드 가능, 볼륨이 없어도 업그레이드 가능)\n");
		
		pageRefresh();
	}
	public void B034() {
		System.out.println("⊙ B034 - Reset Configuration");
		System.out.println("설정초기화는 정상적으로 설정 되는가?\n" +
				"(초기화 완료후 네트워크는 dhcp서버에서 새로운 주소를 받아 이동)\n");

		// Click Network menu
		System.out.println("Move Network menu");
		driver.findElement(By.linkText("Network"));

		// Network Device select
		System.out.println("select Network Device");
		driver.findElement(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/div/div/div[2]/div[2]/div/div/div[2]/div/div/table/tbody/tr/td/div")).click();

		// Click Modify Button
		System.out.println("Click Modify Button");
		driver.findElement(By.xpath("//button[contains(text(), 'Modify')]")).click();

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			
			e1.printStackTrace();
		}

		// Click 'STATIC' radio button
		System.out.println("Click 'STATIC' radio button");
		driver.findElement(By.xpath("//label[@for='wstatic']")).click();


		driver.findElement(By.xpath("//button[contains(text(), 'Confirm')]")).click();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e1) {
			
			e1.printStackTrace();
		}

		// get Address Assign
		String addressAssign = driver.findElement(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/div/div/div[2]/div[2]/div/div/div[2]/div/div/table/tbody/tr/td[3]/div")).getText();

		if(addressAssign.equals("static")) {
			System.out.println("static setting is completed successfully.");
		} else {	
			System.out.println("static setting is failed.");
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

		// Click Reset Configuration menu
		driver.findElement(By.xpath("//body/div/div[2]/div/div/div/div/ul/div/li[2]/ul/li[9]/div/a/span")).click();		

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e1) {
			
			e1.printStackTrace();
		}

		// Click Reset Configuration button		
		driver.findElement(By.xpath("//button[contains(text(), 'Reset Configuration')]")).click();

		driver.findElement(By.xpath("//button[contains(text(), 'Yes')]")).click();

		System.out.println("-----------------------------------------------------");
		System.out.println("Reboot");
		System.out.println("-----------------------------------------------------");
		for (int second = 0;; second++) {
			if (second >= 120) fail("timeout");
			try { if (isElementPresent(By.cssSelector("input.btn_login"))) break; } catch (Exception e) {}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}			
		}

		//Refresh
		try{
			Thread.sleep(2000);
		} catch(Exception e) {}
		url = driver.getCurrentUrl();  
		driver.navigate().to(url);  
		try{
			Thread.sleep(2000);
		} catch(Exception e) {}
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		// login
		System.out.println("Move storpia page");
		driver.get(baseUrl + "/");
		driver.findElement(By.id("login_userid")).clear();
		driver.findElement(By.id("login_userid")).sendKeys("admin");
		driver.findElement(By.id("login_password")).clear();
		driver.findElement(By.id("login_password")).sendKeys("admin");
		driver.findElement(By.cssSelector("input.btn_login")).click();

		// Input Setup information
		System.out.println("Input setup information");
		driver.findElement(By.id("nstep")).click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}

		// input information
		driver.findElement(By.id("email")).sendKeys("support@storpia.com");
		driver.findElement(By.id("password")).sendKeys("admin");
		driver.findElement(By.id("password1")).sendKeys("admin");

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//body/div[7]/div[2]/div/div/div/form/div[2]/div/div/table/tbody/tr/td/table/tbody/tr/td[2]/table/tbody/tr[2]/td/input[2]")).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}

		// Time setting --> failed
		driver.findElement(By.xpath("//button[contains(text(), 'OK')]")).click();

		driver.findElement(By.xpath("//body/div[7]/div[2]/div/div/div/form/div[3]/div/div/table/tbody/tr/td/table/tbody/tr/td[2]/table/tbody/tr[2]/td/input[5]")).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}

		driver.findElement(By.xpath("//button[contains(text(), 'OK')]")).click();

		driver.findElement(By.xpath("//body/div[7]/div[2]/div/div/div/form/div[4]/div/div/table/tbody/tr/td/table/tbody/tr/td[2]/table/tbody/tr[2]/td/input[2]")).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}

		driver.findElement(By.xpath("//body/div[7]/div[2]/div/div/div/form/div[5]/div/div/table/tbody/tr/td/table/tbody/tr/td[2]/table/tbody/tr[2]/td/input[2]")).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}

		driver.findElement(By.xpath("//body/div[7]/div[2]/div/div/div/form/div[9]/div/div/table/tbody/tr/td/table/tbody/tr/td[2]/table/tbody/tr[2]/td/input")).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//button[contains(text(), 'OK')]")).click();

		driver.findElement(By.xpath("//body/div[19]/div[2]/div/div/div/div/table/tbody/tr/td/img")).click();		

		driver.findElement(By.name("icon_esetup")).click();


		// Click Network menu
		driver.findElement(By.xpath("//body/div/div[2]/div/div/div/div/ul/div/li[2]/ul/li/div/a/span")).click();

		// get Address Assign
		addressAssign = driver.findElement(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/div/div/div[2]/div[2]/div/div/div[2]/div/div/table/tbody/tr/td[3]/div")).getText();

		if(addressAssign.equals("dhcp")) {
			System.out.println("Initializing the settings is completed successfully.");
		} else {
			System.out.println("Initializing the settings is failed.");			
		}

		pageRefresh();
	}
	public void B035() {
		System.out.println("⊙ B035 - System settings backup and restore");
		System.out.println("설정정보 백업은 정상적으로 동작하는가?\n");
		
		pageRefresh();
	}
	public void B036() {
		System.out.println("⊙ B036 - System settings backup and restore");
		System.out.println("설정정보 복구는 정상적으로 동작 하는가?\n");
		
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
	
	private void pageRefresh1() {
		//Refresh
		try{
			Thread.sleep(2000);
		} catch(Exception e) {}
		String url = driver1.getCurrentUrl();  
		driver1.navigate().to(url);  
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
