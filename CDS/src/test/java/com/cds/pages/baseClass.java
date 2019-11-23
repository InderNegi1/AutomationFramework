package com.cds.pages;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.cds.utility.BrowserFactory;
import com.cds.utility.ConfigDataProvider;
import com.cds.utility.ExcelDataProvider;
import com.cds.utility.Helper;

public class baseClass {
	public WebDriver driver;
	public ExcelDataProvider objExcel;
	public ConfigDataProvider objConfig;
	public ExtentReports reports;
	public ExtentTest logger;
	

	@BeforeSuite
	public void setUpSuite() {
		Reporter.log("Setting Up Reports,Excel and config in beforeSuite.",true);
		objExcel = new ExcelDataProvider();
		objConfig=new ConfigDataProvider();
		ExtentHtmlReporter extent=new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/Reports/CDS_"+Helper.getCurrentDateTime()+".HTML"));
		reports =new ExtentReports();
		reports.attachReporter(extent);
		Reporter.log("Setting done for Reports,Excel and config..", true);
	}

	@BeforeClass
	public void setUp() throws InterruptedException {
		Reporter.log("Setting up Browser Factory under Before Class.",true);
		//driver = BrowserFactory.startApplication(driver, "Chrome", "https://openinet.indiabulls.com/");
		driver = BrowserFactory.startApplication(driver, objConfig.getBrowser(), objConfig.getURL());
		Thread.sleep(5000);
		// System.out.println(driver.getTitle());
		Reporter.log("Browser has been start.", true);
	}

	@AfterClass
	public void tearDown() {
		BrowserFactory.quitBrowser(driver);
	}
	
	@AfterMethod
	public void tearDownMethod(ITestResult result) throws IOException
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			
			//try {
				logger.fail("Test Failed..", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
			//} catch (Exception e) {
				// TODO Auto-generated catch block
			//	System.out.println("unable to capture screenshot and attache it to report."+e.getMessage());
			//}
		}
		
		if(result.getStatus()==ITestResult.SUCCESS)
		{
			logger.pass("Test Passed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
		}
		
		if(result.getStatus()==ITestResult.SKIP)
		{
			Helper.captureScreenshot(driver);
		}
		reports.flush();
	}

}
