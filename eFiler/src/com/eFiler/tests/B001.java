package com.eFiler.tests;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import org.openqa.selenium.*;

public class B001 extends BaseTestLogic {
	
	private static String DirTree = "";
	
	public B001(WebDriver webDriver, File fileConf, File fileReport) {
		super(webDriver, fileConf, fileReport);
		// TODO Auto-generated constructor stub
		fConf = fileConf;
		driver = webDriver;
	}

	void startTest() throws InterruptedException  {
		System.out.println("*****************************************************************");
		System.out.println("*                            Directory Tree                     *");
		System.out.println("*****************************************************************");
		System.out.println("Test B001 - eFiler");
		System.out.println("Volume lists with directory tree appears while logged-in as Admin?\n" +
							"관리자(장비소유자)가 로그인 했을때 볼륨리스트가 디렉토리 트리로 구성되는가?\n"+
							"----------------------------------------------------------");

		if (isElementPresent(By.id("dir-tree-view"))){		//If Dir tree is present
			DirTree = "Can show Directory Tree successfully";
		}else
			DirTree = "Can't show Directory Tree";
		
		System.out.println(DirTree);
		
		try {
			StringBuilder builder = new StringBuilder();
	        BufferedWriter out = new BufferedWriter(new FileWriter(fReport, true));
	        
	        builder.append("\r\n*****************************************************************\r\n");
	        builder.append("*                            Directory Tree                     *\r\n");
	        builder.append("*****************************************************************\r\n");
	        builder.append("Test B001 - eFiler\r\n");
	        builder.append("Volume lists with directory tree appears while logged-in as Admin?\r\n" +
							"관리자(장비소유자)가 로그인 했을때 볼륨리스트가 디렉토리 트리로 구성되는가?\r\n");
	        builder.append("=================================================================\r\n");
	        builder.append(DirTree + "\r\n");
	        out.write(builder.toString());

			if(Lisenter != null){
				Lisenter.onReportLisenter(builder.toString());
			}
			
	        out.close();
	        } catch (IOException e) {}
	}
}

