//The contents of the power option setting operates normally?
//전원옵션 설정의 내용이 정상적으로 동작 되는가?


package com.example.tests;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;


public class B026 extends System_Setting {
	private static String ScheduleOn = "", ScheduleOnDay = "", ScheduleOnHour = "", ScheduleOnMin = "", 
			ScheduleOff = "", ScheduleOffDay = "", ScheduleOffHour = "", ScheduleOffMin = "",
			day = "", hour = "", minute = "",
			CurrentStatus1 = "", CurrentStatus2 = "", CurrentStatus3 = "", CurrentStatus4 = "", 
			WOLStatus = "", PowerOnStatus = "", ShutdownStatus = "", HibernationStatus = "";
	
	//public static void main(String[] args) throws InterruptedException, IOException {
	public void B026() throws InterruptedException, IOException{
		System.out.println("*****************************************************************");
		System.out.println("*                          Power Setting                        *");
		System.out.println("*****************************************************************");
		System.out.println("Test B026 - System -> Power ");
		System.out.println("The contents of the power option setting operates normally? \n" +
				"전원옵션 설정의 내용이 정상적으로 동작 되는가? \n" + 
				"--------------------------------------------------------\n");
		
		WebElement wakeOnLAN;
		WebElement scheduledPowerOn;
		WebElement scheduledShutdown;
//		WebElement hibernation;
//		boolean status_scheduledPowerOn = false;
//		boolean status_scheduledShutdown = false;
//		boolean status_wakeOnLAN = false;
//		boolean status_hibernation = false;
		
		BufferedReader br = new BufferedReader(new FileReader("D:\\SystemConf.txt"));
		try {
	        for (int i=1; i<=17; i++){
	        	String line = br.readLine();
	        	if (i > 11){
		        	//System.out.println(line + "\n");
		        	String[] tokens = line.split("=");
	            	if (tokens[0].equals("ScheduleOn")){
	            		ScheduleOn = tokens[1];
		        	}else if (tokens[0].equals("ScheduleOnDay")){
		        		ScheduleOnDay = tokens[1];
		        	}else if (tokens[0].equals("ScheduleOnHour")){
		        		ScheduleOnHour = tokens[1];
		        	}else if (tokens[0].equals("ScheduleOnMin")){
		        		ScheduleOnMin = tokens[1];
		        	}else if (tokens[0].equals("ScheduleOff")){
		        		ScheduleOff = tokens[1];
		        	}else if (tokens[0].equals("ScheduleOffDay")){
		        		ScheduleOffDay = tokens[1];
		        	}else if (tokens[0].equals("ScheduleOffHour")){
		        		ScheduleOffHour = tokens[1];
		        	}else if (tokens[0].equals("ScheduleOffMin")){
		        		ScheduleOffMin = tokens[1];
		        	}
	        	}
	        }
	    } finally {
	        br.close();
	    }
		
		// Click Power menu
		driver.findElement(By.xpath("//body/div/div[2]/div/div/div/div/ul/div/li[2]/ul/li[6]/div/a/span")).click();
		System.out.println("Move Power menu");
		Thread.sleep(3000);

		// Click Wake on LAN	
		if (isElementVisible(By.name("wol_enable"))){
			wakeOnLAN = driver.findElement(By.name("wol_enable"));
			if(!wakeOnLAN.isSelected()) {
				wakeOnLAN.click();
				System.out.println("Click Wake on LAN");
			}
			Thread.sleep(2000);
		}else
			CurrentStatus1 = "WOL option is not present";
			
		System.out.println(CurrentStatus1);
			
		// Click Scheduled Power On
		if (isElementVisible(By.name("turnon_enable"))){
			scheduledPowerOn = driver.findElement(By.name("turnon_enable"));
			//ScheduleOn
			//if(!scheduledPowerOn.isSelected()) {
			//if(ScheduleOn.equals("Yes")) {
			if(!scheduledPowerOn.isSelected()) {
				//System.out.println("Schedule power on is not activated currently. We will activate it.");
				CurrentStatus2 = "Schedule power on is not activated currently. We will activate it.";
				scheduledPowerOn.click();
				System.out.println(CurrentStatus2 + "\nClick Scheduled Power On");
			}
				
				// Select Power on -> Day (everyday)
				driver.findElement(By.id("turnon_wday")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//body/div[14]/div/div[" + ScheduleOnDay + "]")).click();
				
				Thread.sleep(2000);
				// Select Power on -> time hour (01)
				driver.findElement(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div[2]/div/div/div/div/div/div/div/div/div/div/div/div/div[2]/form/fieldset[2]/div/div/div[3]/div/div/div/div/div/div/div/div/div/div/div/div/div/div/div/div/div/img")).click();
				Thread.sleep(1000);
				driver.findElement(By.xpath("//body/div[15]/div/div[" + ScheduleOnHour + "]")).click();
				Thread.sleep(2000);
				
				// Select Power on -> time minute (04)
				driver.findElement(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div[2]/div/div/div/div/div/div/div/div/div/div/div/div/div[2]/form/fieldset[2]/div/div/div[3]/div/div/div/div/div/div/div/div/div/div/div/div[2]/div/div/div/div/div/img")).click();
				Thread.sleep(1000);
				driver.findElement(By.xpath("//body/div[16]/div/div[" + ScheduleOnMin + "]")).click();
				Thread.sleep(2000);
//			}else if(ScheduleOn.equals("No")){
//				if(scheduledPowerOn.isSelected()) {
//					System.out.println("Schedule power on is activated currently. We will disable it.");
//					scheduledPowerOn.click();
//					System.out.println("Click Scheduled Power On");
//				}else
//					System.out.println("Schedule power on is disable.");
//			}
		}else
			CurrentStatus2 = "Schedule power on is not present";
		
		System.out.println(CurrentStatus2);

		// Click Scheduled Shutdown
		if (isElementVisible(By.name("shutdown_enable"))){
			scheduledShutdown = driver.findElement(By.name("shutdown_enable"));
			if(!scheduledShutdown.isSelected()) {
				CurrentStatus3 = "Schedule Shutdown is not activated currently. We will activate it.";
				scheduledShutdown.click();
				System.out.println(CurrentStatus3 + "\nClick Scheduled Shutdown");
			}
			
			// Select Power off -> Day (everyday)
			driver.findElement(By.id("shutdown_wday")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//body/div[17]/div/div[" + ScheduleOffDay + "]")).click();
			Thread.sleep(2000);
			// Click Shutdown -> time hour (01)
			driver.findElement(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div[2]/div/div/div/div/div/div/div/div/div/div/div/div/div[2]/form/fieldset[3]/div/div/div[3]/div/div/div/div/div/div/div/div/div/div/div/div/div/div/div/div/div/img")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//body/div[18]/div/div[" + ScheduleOffHour + "]")).click();
			Thread.sleep(2000);
	
			// Click Shutdown -> time minute (03)
			driver.findElement(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div[2]/div/div/div/div/div/div/div/div/div/div/div/div/div[2]/form/fieldset[3]/div/div/div[3]/div/div/div/div/div/div/div/div/div/div/div/div[2]/div/div/div/div/div/img")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//body/div[19]/div/div[" + ScheduleOffMin + "]")).click();
			Thread.sleep(2000);
		}else
			CurrentStatus3 = "Schedule Shutdown is not present";
			
		System.out.println(CurrentStatus3);

		// Disk Hibernation
		if (isElementVisible(By.id("sata_savemode"))){
			//hibernation = driver.findElement(By.id("sata_savemode"));
								
			// Select Hibernation -> Standby mode
			driver.findElement(By.id("sata_savemode")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//body/div[20]/div/div[2]")).click();
			Thread.sleep(3000);
			// Click waiting time -> 20 min
			driver.findElement(By.id("sata_wait_time")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//body/div[21]/div/div[2]")).click();
			Thread.sleep(2000);
		}else
			CurrentStatus4 = "Disk Hibernation is not present";
			
		System.out.println(CurrentStatus4);
		
		
		
		// Click Confirm Button
		driver.findElement(By.xpath("//body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div[2]/div/div/div/div/div/div/div/div/table/tbody/tr[2]/td[2]/em/button")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//button[contains(text(), 'OK')]")).click();

		//Refresh
		//System.out.println("Refresh Page");
		try{
			Thread.sleep(2000);
		} catch(Exception e) {}
		String url = driver.getCurrentUrl();  
		driver.navigate().to(url);  
		try{
			Thread.sleep(2000);
		} catch(Exception e) {}

		// Click Power menu
		driver.findElement(By.xpath("//body/div/div[2]/div/div/div/div/ul/div/li[2]/ul/li[6]/div/a/span")).click();

		Thread.sleep(1000);
		// get status
		if (isElementVisible(By.name("wol_enable"))){
			Thread.sleep(1000);
			wakeOnLAN = driver.findElement(By.name("wol_enable"));
			Thread.sleep(1000);
			// Check Wake on LAN
			if(wakeOnLAN.isSelected()) {
				//status_wakeOnLAN = true;
				//System.out.println("Wake on LAN is selected");
				WOLStatus =  "Wake on LAN is selected";
				System.out.println(WOLStatus);
			} else {
				//System.out.println("Wake on LAN isn't chosen");
				WOLStatus =  "Wake on LAN isn't chosen";
				System.out.println(WOLStatus);
			}
		}	
		
		Thread.sleep(1000);
		// Check Scheduled Power On
		if (isElementVisible(By.name("turnon_enable"))){
			scheduledPowerOn = driver.findElement(By.name("turnon_enable"));
				
			if(scheduledPowerOn.isSelected()) {
				//status_scheduledPowerOn = true;
				//System.out.println("Scheduled Power On is selected");
				day = driver.findElement(By.id("turnon_wday")).getAttribute("value");
				hour = driver.findElement(By.id("turnon_hour")).getAttribute("value");
				minute = driver.findElement(By.id("turnon_min")).getAttribute("value");			
				//System.out.println("System will be turned on at '" + day + "  " + hour + ":" + minute + "'");
				PowerOnStatus =  "Scheduled Power On is selected \r\n" +
						"System will be turned on at '" + day + "  " + hour + ":" + minute + "'";
				System.out.println(PowerOnStatus);
			} else {
				//System.out.println("Scheduled power on isn't chosen");
				PowerOnStatus =  "Scheduled power on isn't chosen";
				System.out.println(PowerOnStatus);
			}
		}
		
		Thread.sleep(1000);
		// Check Scheduled Shutdown
		if (isElementVisible(By.name("shutdown_enable"))){
			scheduledShutdown = driver.findElement(By.name("shutdown_enable"));
			
			if(scheduledShutdown.isSelected()) {
				//status_scheduledShutdown = true;
				//System.out.println("Scheduled Shutdown is selected");
				day = driver.findElement(By.id("shutdown_wday")).getAttribute("value");
				hour = driver.findElement(By.id("shutdown_hour")).getAttribute("value");
				minute = driver.findElement(By.id("shutdown_min")).getAttribute("value");
				//System.out.println("System will be shutdown at '" + day + "  "  + hour + ":" + minute + "'");
				ShutdownStatus =  "Scheduled Shutdown is selected \r\n" +
						"System will be shutdown at '" + day + "  "  + hour + ":" + minute + "'";
				System.out.println(ShutdownStatus);
			} else {
				//System.out.println("Scheduled Shutdown isn't chosen");
				ShutdownStatus =  "Scheduled Shutdown isn't chosen";
				System.out.println(ShutdownStatus);
			}
			Thread.sleep(1000);
		}
		
		Thread.sleep(1000);
		// Check Hibernation
		if (isElementVisible(By.id("sata_savemode"))){
			//hibernation = driver.findElement(By.id("sata_savemode"));
				//status_hibernation = true;
				//System.out.println("Scheduled Shutdown is selected");
				day = driver.findElement(By.id("sata_savemode")).getAttribute("value");
				minute = driver.findElement(By.id("sata_wait_time")).getAttribute("value");
				//System.out.println("HDD Hibernation(Power Save) = " + day + " : " + minute);
				HibernationStatus = "HDD Hibernation(Power Save) = " + day + " : " + minute;
				System.out.println(HibernationStatus);
			Thread.sleep(1000);
		}
		
		
//		if(status_wakeOnLAN && status_scheduledPowerOn && status_scheduledShutdown) {
//			System.out.println("Power Option settings are stored successfully.");
//		} else {
//			System.out.println("Power Option settings are failed.");
//		}

		
		try {
	        BufferedWriter out = new BufferedWriter(new FileWriter("D:\\System_Setting.txt", true));
	            out.write("\r\n*****************************************************************\r\n");
		        out.write("*                            Power Setting                          *\r\n");
		        out.write("*********************************************************************\r\n");
		        out.write("Test B026 - System -> Power \r\n");
		        out.write("The contents of the power option setting operates normally? \r\n" +
							"전원옵션 설정의 내용이 정상적으로 동작 되는가?\r\n");
		        out.write("=================================================================\r\n");
                out.write(CurrentStatus1 + "\r\n" + WOLStatus + "\r\n---------------------------------------\r\n" + 
                		CurrentStatus2 + "\r\n" + PowerOnStatus + "\r\n-------------------------------------\r\n" +
                		CurrentStatus3 + "\r\n" + ShutdownStatus + "\r\n------------------------------------\r\n" +
                		CurrentStatus4 + "\r\n" + HibernationStatus + "\r\n---------------------------------\r\n");
	            out.close();
	        } catch (IOException e) {}
		
		
		// After
		//driver.quit();
//		String verificationErrorString = verificationErrors.toString();
//		if (!"".equals(verificationErrorString)) {
//			fail(verificationErrorString);
//		}

	}	

	private static boolean isElementPresent(By by) {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}
	
	public static boolean isElementVisible(By by){
		return driver.findElement(by).isDisplayed();
	}
	
//	public static boolean isElementPresent(By by) {
//	    boolean flag = true;
//	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//	    if (!(driver.findElements(by).size() > 0)) {
//	        flag = false;
//	    } 
//	    driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
//	    return flag;
//	}

}
