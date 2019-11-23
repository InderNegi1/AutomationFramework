package com.cds.utility;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Helper {

	// Handling Screenshots, Alert, Window, javascriptExecutor, Frame, Sync Issue

	public static String  captureScreenshot(WebDriver driver) {
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String ScreenshotPath= System.getProperty("user.dir")+"/Screenshots/Login_"+getCurrentDateTime()+".png";

		try {
			FileHandler.copy(src, new File(ScreenshotPath));
			//FileHandler.copy(src, new File("./Screenshots/Login.png"));
		} catch (Exception e) {
			System.out.println("Unable to take screenshot....." + e.getMessage());
		}
		return ScreenshotPath;
	}
	
	public static String getCurrentDateTime()
	{
		DateFormat customFormat=new SimpleDateFormat("dd_MM_yyyy_HH_mm_ss");
		
		Date date=new Date();
		
	String	check=customFormat.format(date);
		System.out.println(check);
		
		return customFormat.format(date);
		
	}

}
