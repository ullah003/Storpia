package com.eFiler.tests;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.StringTokenizer;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

public class D043 extends BaseTestLogic {
	
	private static String file_type = "", successMsg = "", successMsg1 = "",
			album_art = "", Genre = "", Disk = "", Track = "", Year = "", Bit_Rate = "", Duration = "", Channel = "", Sample_Rate = "", File_Path = "", Size = "";
	int i = 0, j = 0; 
	
	public D043(WebDriver webDriver, File fileConf, File fileReport) {
		super(webDriver, fileConf, fileReport);
		fConf = fileConf;
		driver = webDriver;
	}

	void startTest() throws InterruptedException  {
		System.out.println("*****************************************************************");
		System.out.println("*                     ID3 Tag for MP3 files                     *");
		System.out.println("*****************************************************************");
		System.out.println("Test D043 - eFiler -> ID3 Tag for MP3 files");
		System.out.println("From (right mouse menu->information) option can it show album art image of mp3 file?\n" +
							"마우스 오른쪽의 Information 클릭시에도 앨범자켓 이미지가 있는 mp3파일일 경우 앨범자켓 이미지가 제대로 출력되는가?\n"+
							"----------------------------------------------------------");
		
		try {
			StringBuilder builder = new StringBuilder();
	        BufferedWriter out = new BufferedWriter(new FileWriter(fReport, true));
	        
	        builder.append("\r\n*****************************************************************\r\n");
	        builder.append("*                     ID3 Tag for MP3 files                     *\r\n");
	        builder.append("*****************************************************************\r\n");
	        builder.append("Test D043 - eFiler -> ID3 Tag for MP3 files\r\n");
	        builder.append("From (right mouse menu->information) option can it show album art image of mp3 file?\r\n" +
							"마우스 오른쪽의 Information 클릭시에도 앨범자켓 이미지가 있는 mp3파일일 경우 앨범자켓 이미지가 제대로 출력되는가?\r\n");
	        builder.append("=================================================================\r\n");
		
	    String winHandleBefore = driver.getWindowHandle(); // Store the current window handle    
	    
	    // go to eMedia folder
	    for (int k = 1; k <= 50; k++){
	    	//System.out.println("KKKKKKKKK" + k);
	    	if (isElementPresent(By.xpath("//div[@id='filelist_view']/table/tbody/tr[" +  k +  "]/td[2]/span/a")) && 
	    			driver.findElement(By.xpath("//div[@id='filelist_view']/table/tbody/tr[" +  k +  "]/td[2]/span/a")).getText().equals("eMedia")){
	    		
	    		driver.findElement(By.xpath("//div[@id='filelist_view']/table/tbody/tr[" +  k +  "]/td[2]/span/a")).click();
	    		Thread.sleep(3000);
	    		break;
	    	}
	    }
	    
	    // go to audio folder
	    for (int k = 1; k <= 3; k++){
	    	//System.out.println("KKKKKKKKK" + k);
	    	if (isElementPresent(By.xpath("//div[@id='filelist_view']/table/tbody/tr[" +  k +  "]/td[2]/span/a")) && 
	    			driver.findElement(By.xpath("//div[@id='filelist_view']/table/tbody/tr[" +  k +  "]/td[2]/span/a")).getText().equals("audio")){
	    		
	    		driver.findElement(By.xpath("//div[@id='filelist_view']/table/tbody/tr[" +  k +  "]/td[2]/span/a")).click();
	    		break;
	    	}
	    }
	    
	    Thread.sleep(2000);

	    if (isElementPresent(By.xpath("//div[@id='filelist_view']/table/tbody/tr/td[2]/span/a"))){
			//file/folder list
			WebElement list = driver.findElement(By.id("filelist_view"));
			
			Actions action = new Actions(driver);
			
			//get all items
			List<WebElement> allitems = list.findElements(By.className("container"));
			for (WebElement files : allitems) {

				file_type = files.findElement(By.xpath("span")).getAttribute("class");
				file_type = file_type.substring(file_type.length()-3, file_type.length());
				
				if (file_type.equals("mp3")){
					System.out.println("[File Name: ]" + files.getText());
					builder.append("[File Name: ]" + files.getText() + "\r\n");

					action.contextClick(files).perform();
				
					//right mouse menu list
					WebElement menulist = driver.findElement(By.xpath("//body"));
					
					if (isElementPresent(By.id("dropmenu"))){		//if right menu options exists
						//successMsg = "Can show right mouse menu successfully.";
						List<WebElement> allmenus = menulist.findElements(By.id("dropmenu"));
						
						for (WebElement menu : allmenus) {
							//menu = allmenus.get(allmenus.size()-1);
							System.out.println(menu.findElement(By.xpath("ul/li[5]/span")).getText() + " :");

							menu.findElement(By.xpath("ul/li[5]/span")).click();		//click Information option
							Thread.sleep(2000);
							
							driver.switchTo().frame("boxIframe");		//switch to popup window
							
							if (isElementPresent(By.xpath("//body/div/div[2]/div[2]/img"))){
								//album_art = "Can show album art successfully.";
								System.out.println("Can show album art successfully.");
								builder.append("Can show album art successfully." + "\r\n");
							}else{
								//album_art = "No album art available.";
								System.out.println("No album art available.");
								builder.append("No album art available." + "\r\n");
							}
							
							Genre = driver.findElement(By.xpath("//body/div/div[2]/div[3]/table/tbody/tr/td")).getText();
							System.out.println("Genre:\t" + Genre);
							builder.append("Genre:\t" + Genre + "\r\n");
							
							Disk = driver.findElement(By.xpath("//body/div/div[2]/div[3]/table/tbody/tr[2]/td")).getText();
							System.out.println("Disk:\t" + Disk);
							builder.append("Disk:\t" + Disk + "\r\n");
							
							Track = driver.findElement(By.xpath("//body/div/div[2]/div[3]/table/tbody/tr[3]/td")).getText();
							System.out.println("Track:\t" + Track);
							builder.append("Track:\t" + Track + "\r\n");
							
							Year = driver.findElement(By.xpath("//body/div/div[2]/div[3]/table/tbody/tr[4]/td")).getText();
							System.out.println("Year:\t" + Year);
							builder.append("Year:\t" + Year + "\r\n");
							
							Bit_Rate = driver.findElement(By.xpath("//body/div/div[2]/div[3]/table/tbody/tr[5]/td")).getText();
							System.out.println("Bit Rate:\t" + Bit_Rate);
							builder.append("Bit Rate:\t" + Bit_Rate + "\r\n");
							
							Duration = driver.findElement(By.xpath("//body/div/div[2]/div[3]/table/tbody/tr[6]/td")).getText();
							System.out.println("Duration:\t\t" + Duration);
							builder.append("Duration:\t" + Duration + "\r\n");
							
							Channel = driver.findElement(By.xpath("//body/div/div[2]/div[3]/table/tbody/tr[7]/td")).getText();
							System.out.println("Channel:\t" + Channel);
							builder.append("Channel:\t" + Channel + "\r\n");
							
							Sample_Rate = driver.findElement(By.xpath("//body/div/div[2]/div[3]/table/tbody/tr[8]/td")).getText();
							System.out.println("Sample Rate:\t" + Sample_Rate);
							builder.append("Sample Rate:\t" + Sample_Rate + "\r\n");
							
							File_Path = driver.findElement(By.xpath("//body/div/div[2]/div[3]/table/tbody/tr[9]/td")).getText();
							System.out.println("File Path:\t" + File_Path);
							builder.append("File Path:\t" + File_Path + "\r\n");
							
							Size = driver.findElement(By.xpath("//body/div/div[2]/div[3]/table/tbody/tr[10]/td")).getText();
							System.out.println("Size:\t" + Size);
							builder.append("Size:\t" + Size + "\r\n");
							
							System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
							builder.append("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~" + "\r\n");
							
							driver.findElement(By.className("popup-close")).click();
							
							driver.switchTo().window(winHandleBefore);		//switch back to previous window
						}
						System.out.println();
					}else{
						successMsg = "Can't show right mouse menu (FAIL)!";
						break;
					}
				}else
					successMsg1 = "No MP3 file available!";
			}
		}else
			successMsg = "File/Folder list doesn't exists to test!";
		
//		System.out.println("Total number of MP3 files: " + i);
//		System.out.println("Total number of Information dropdoun menu: " + j);
		
//		if (i == j)
//			successMsg = "Right mouse menu shows (Information) option only for mp3 files (Success)";
//		else
//			successMsg = "Right mouse menu shows (Information) option not only for mp3 files (FAIL)";
		
		
		System.out.println(successMsg);
		builder.append("\r\n" + successMsg + "\r\n");
		out.write(builder.toString());

		if(Lisenter != null){
			Lisenter.onReportLisenter(builder.toString());
		}
		
		out.close();
        } catch (IOException e) {}

	}
}

