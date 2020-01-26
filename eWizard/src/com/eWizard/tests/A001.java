package com.eWizard.tests;

import static org.junit.Assert.fail;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class A001 extends BaseTestLogic{

	private static StringBuffer verificationErrors = new StringBuffer();
	private static String shareInfo = "", fileManager = "", eApps = "", eMobile = "", MobileWeb = "", status = "";

	public A001(WebDriver webDriver, File fileConf, File fileReport) {
		super(webDriver, fileConf, fileReport);
		// TODO Auto-generated constructor stub
	}


	@Override
	void startTest() throws InterruptedException  {
		// TODO Auto-generated method stub

		System.out.println("*****************************************************************");
		System.out.println("*                             Quick Start                       *");
		System.out.println("*****************************************************************");
		System.out.println("Test A001 - Quick Setup -> Quick Start");
		System.out.println("Can it output UI normally without broken text and icons? \n" +
				"UI는 정상적으로 출력 되는가?\n" + 
				"각텝에 대한 설명은 정확한가?\n");
		System.out.println("-----------------------------------------------------------------");
		
		//Click Quick Start
		driver.findElement(By.name("Image2")).click();

		Thread.sleep(3000);

		if (isElementPresent(By.xpath("//div[@id='quickStartContent1']/div")) && isElementPresent(By.xpath("//div[@id='quickStartContent1']/div[2]"))){
			shareInfo = "Yes";
		}else
			shareInfo = "No";

		if (isElementPresent(By.xpath("//div[@id='quickStartContent2']/div"))){
			driver.findElement(By.xpath("//div[@id='quickStartContent2']/div")).click();
			Thread.sleep(2000);
			if (isElementPresent(By.xpath("//div[@id='quickStartContent2']/div[2]"))){
				fileManager = "Yes";
			}else{
				fileManager = "No";
			}
		}else
			fileManager = "No";

//		if (isElementPresent(By.xpath("//div[@id='quickStartContent3']/div"))){
//			driver.findElement(By.xpath("//div[@id='quickStartContent3']/div")).click();
//			Thread.sleep(2000);
//			if (isElementPresent(By.xpath("//div[@id='quickStartContent3']/div[2]"))){
//				eApps = "Yes";
//			}else{
//				eApps = "No";
//			}
//		}else
//			eApps = "No";

//		if (isElementPresent(By.xpath("//div[@id='quickStartContent4']/div"))){
//			driver.findElement(By.xpath("//div[@id='quickStartContent4']/div")).click();
//			Thread.sleep(2000);
//			if (isElementPresent(By.xpath("//div[@id='quickStartContent4']/div[2]"))){
//				eMobile = "Yes";
//			}else{
//				eMobile = "No";
//			}
//		}else
//			eMobile = "No";

		if (isElementPresent(By.xpath("//div[@id='quickStartContent5']/div"))){
			driver.findElement(By.xpath("//div[@id='quickStartContent5']/div")).click();
			Thread.sleep(2000);
			if (isElementPresent(By.xpath("//div[@id='quickStartContent5']/div[2]"))){
				MobileWeb = "Yes";
			}else{
				MobileWeb = "No";
			}
		}else
			MobileWeb = "No";

		driver.findElement(By.xpath("//input[@value='Close']")).click();

//		System.out.println("Share Information presents : " + shareInfo + "\n" + 
//				"File Manager presents : " + fileManager + "\n" +
//				"eApps presents : " + eApps + "\n" +
//				"eMobile presents : " + eMobile + "\n" +
//				"MobileWeb presents : " + MobileWeb + "\n");

		System.out.println("Share Information presents : " + shareInfo + "\n" + 
				"File Manager presents : " + fileManager + "\n" +
				"MobileWeb presents : " + MobileWeb + "\n");
		
		//if (shareInfo.equals("Yes") && fileManager.equals("Yes") && eApps.equals("Yes") && eMobile.equals("Yes") && MobileWeb.equals("Yes")){
		if (shareInfo.equals("Yes") && fileManager.equals("Yes") && MobileWeb.equals("Yes")){
			status = "Can show each items. Test Successful.";
		}else
			status = "Can't show each items. Test FAIL.";

		System.out.println(status);

		try {
			StringBuilder builder = new StringBuilder();
			BufferedWriter out = new BufferedWriter(new FileWriter(fReport));

			builder.append("\r\n*****************************************************************\r\n");
			builder.append("*                            Quick Start                        *\r\n");
			builder.append("*****************************************************************\r\n");
			builder.append("Test A001 - Quick Setup -> Quick Start\r\n");
			builder.append("Can it output UI normally without broken text and icons? \r\n" +
					"UI는 정상적으로 출력 되는가?\r\n" + 
					"각텝에 대한 설명은 정확한가?\r\n");
			builder.append("=================================================================\r\n");
			builder.append(status + "\r\n");
			out.write(builder.toString());

			if(Lisenter != null){
				Lisenter.onReportLisenter(builder.toString());
			}
			
			out.close();
		} catch (IOException e) {}


		// After
		// driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}

	}

}
