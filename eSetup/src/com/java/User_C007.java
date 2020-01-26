package com.java;

import java.awt.event.ActionEvent;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.internal.seleniumemulation.*;
import org.openqa.selenium.interactions.Actions;
//import org.open

public class User_C007 {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver web = new FirefoxDriver();
		
		// Open login page
		//web.get("http://192.168.0.5:9000/index.php");
		web.get("http://gluesys01.relay5.storpia.com:54758/index.php");

		// Enter ID and Password
		WebElement element_id = web.findElement(By.id("login_userid"));
		element_id.sendKeys("admin");

		WebElement element_pass = web.findElement(By.id("login_password"));
		element_pass.sendKeys("admin");

		//Click login button
		web.findElement(By.cssSelector("input.btn_login")).click();

		//Print login success message to console
		System.out.println("Successfully logged in.");

		//Wait 10 sec for main page to be loaded
		web.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		//Click eSetup icon to go to eSetup page
		web.findElement(By.name("icon_esetup")).click();

		// Click Group menu
		web.findElement(By.xpath("//ul[@id='ext-gen121']/li/div/a/span")).click();
		web.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		// Search type
		WebElement element_search = web.findElement(By.id("ext-comp-1144"));
		element_search.sendKeys("user");
		web.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		// Search Button Click
		web.findElement(By.xpath("//*[@id=\"ext-gen234\"]")).click();
		Wait w = new WebDriverWait(web, 50);
		web.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
		
		// Search List
		String[] before = new String[25];
		
		before[0] = web.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/div[2]/div/div/div[2]/div/div/table/tbody/tr/td/div")).getText();
		before[1] = web.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/div[2]/div/div/div[2]/div/div[2]/table/tbody/tr/td/div")).getText();
		before[2] = web.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/div[2]/div/div/div[2]/div/div[3]/table/tbody/tr/td/div")).getText();
		before[3] = web.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/div[2]/div/div/div[2]/div/div[4]/table/tbody/tr/td/div")).getText();
		before[4] = web.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/div[2]/div/div/div[2]/div/div[5]/table/tbody/tr/td/div")).getText();
		before[5] = web.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/div[2]/div/div/div[2]/div/div[6]/table/tbody/tr/td/div")).getText();
		before[6] = web.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/div[2]/div/div/div[2]/div/div[7]/table/tbody/tr/td/div")).getText();
		before[7] = web.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/div[2]/div/div/div[2]/div/div[8]/table/tbody/tr/td/div")).getText();
		before[8] = web.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/div[2]/div/div/div[2]/div/div[9]/table/tbody/tr/td/div")).getText();
		before[9] = web.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/div[2]/div/div/div[2]/div/div[10]/table/tbody/tr/td/div")).getText();
		before[10] = web.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/div[2]/div/div/div[2]/div/div[11]/table/tbody/tr/td/div")).getText();
		before[11] = web.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/div[2]/div/div/div[2]/div/div[12]/table/tbody/tr/td/div")).getText();
		before[12] = web.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/div[2]/div/div/div[2]/div/div[13]/table/tbody/tr/td/div")).getText();
		before[13] = web.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/div[2]/div/div/div[2]/div/div[14]/table/tbody/tr/td/div")).getText();
		before[14] = web.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/div[2]/div/div/div[2]/div/div[15]/table/tbody/tr/td/div")).getText();
		before[15] = web.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/div[2]/div/div/div[2]/div/div[16]/table/tbody/tr/td/div")).getText();
		before[16] = web.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/div[2]/div/div/div[2]/div/div[17]/table/tbody/tr/td/div")).getText();
		before[17] = web.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/div[2]/div/div/div[2]/div/div[18]/table/tbody/tr/td/div")).getText();
		before[18] = web.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/div[2]/div/div/div[2]/div/div[19]/table/tbody/tr/td/div")).getText();
		before[19] = web.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/div[2]/div/div/div[2]/div/div[20]/table/tbody/tr/td/div")).getText();
		before[20] = web.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/div[2]/div/div/div[2]/div/div[21]/table/tbody/tr/td/div")).getText();
		before[21] = web.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/div[2]/div/div/div[2]/div/div[22]/table/tbody/tr/td/div")).getText();
		before[22] = web.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/div[2]/div/div/div[2]/div/div[23]/table/tbody/tr/td/div")).getText();
		before[23] = web.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/div[2]/div/div/div[2]/div/div[24]/table/tbody/tr/td/div")).getText();
		before[24] = web.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/div[2]/div/div/div[2]/div/div[25]/table/tbody/tr/td/div")).getText();
		
		
		// Search List Sort
		Arrays.sort(before);
		
		// Sort Userid Click
		web.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/div[2]/div/div/div/div/div/table/thead/tr/td/div")).click();
		web.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		int success = 0;
		String[] after = new String[25];
		
		after[0] = web.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/div[2]/div/div/div[2]/div/div/table/tbody/tr/td/div")).getText();
		after[1] = web.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/div[2]/div/div/div[2]/div/div[2]/table/tbody/tr/td/div")).getText();
		after[2] = web.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/div[2]/div/div/div[2]/div/div[3]/table/tbody/tr/td/div")).getText();
		after[3] = web.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/div[2]/div/div/div[2]/div/div[4]/table/tbody/tr/td/div")).getText();
		after[4] = web.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/div[2]/div/div/div[2]/div/div[5]/table/tbody/tr/td/div")).getText();
		after[5] = web.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/div[2]/div/div/div[2]/div/div[6]/table/tbody/tr/td/div")).getText();
		after[6] = web.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/div[2]/div/div/div[2]/div/div[7]/table/tbody/tr/td/div")).getText();
		after[7] = web.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/div[2]/div/div/div[2]/div/div[8]/table/tbody/tr/td/div")).getText();
		after[8] = web.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/div[2]/div/div/div[2]/div/div[9]/table/tbody/tr/td/div")).getText();
		after[9] = web.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/div[2]/div/div/div[2]/div/div[10]/table/tbody/tr/td/div")).getText();
		after[10] = web.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/div[2]/div/div/div[2]/div/div[11]/table/tbody/tr/td/div")).getText();
		after[11] = web.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/div[2]/div/div/div[2]/div/div[12]/table/tbody/tr/td/div")).getText();
		after[12] = web.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/div[2]/div/div/div[2]/div/div[13]/table/tbody/tr/td/div")).getText();
		after[13] = web.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/div[2]/div/div/div[2]/div/div[14]/table/tbody/tr/td/div")).getText();
		after[14] = web.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/div[2]/div/div/div[2]/div/div[15]/table/tbody/tr/td/div")).getText();
		after[15] = web.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/div[2]/div/div/div[2]/div/div[16]/table/tbody/tr/td/div")).getText();
		after[16] = web.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/div[2]/div/div/div[2]/div/div[17]/table/tbody/tr/td/div")).getText();
		after[17] = web.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/div[2]/div/div/div[2]/div/div[18]/table/tbody/tr/td/div")).getText();
		after[18] = web.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/div[2]/div/div/div[2]/div/div[19]/table/tbody/tr/td/div")).getText();
		after[19] = web.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/div[2]/div/div/div[2]/div/div[20]/table/tbody/tr/td/div")).getText();
		after[20] = web.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/div[2]/div/div/div[2]/div/div[21]/table/tbody/tr/td/div")).getText();
		after[21] = web.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/div[2]/div/div/div[2]/div/div[22]/table/tbody/tr/td/div")).getText();
		after[22] = web.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/div[2]/div/div/div[2]/div/div[23]/table/tbody/tr/td/div")).getText();
		after[23] = web.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/div[2]/div/div/div[2]/div/div[24]/table/tbody/tr/td/div")).getText();
		after[24] = web.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/div[2]/div/div/div[2]/div/div[25]/table/tbody/tr/td/div")).getText();

		// Compared
		for (int i = 0; i < 25; i++){
			if (after[i].equals(before[i])) {
				System.out.println(i + ": Like");
				success = 1;
			} else {
				success = 0;
				System.out.println(i + ": Sort Fail");
				break;
			}
		}
		if (success == 1)
			System.out.println("Sort Success");
		web.close();
	}
}