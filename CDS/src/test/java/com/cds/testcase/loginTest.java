package com.cds.testcase;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.cds.pages.HomePage;
import com.cds.pages.baseClass;
import com.cds.pages.loginPage;

public class loginTest extends baseClass {
	
	@Test(priority=1)
	public void loginApp()
	{
		logger= reports.createTest("Login to CDS");
		
		loginPage objLogin= PageFactory.initElements(driver, loginPage.class);
		
		logger.info("Starting Application.");
		
		objLogin.loginToApp(objExcel.getStringData("Login", 1, 0), objExcel.getStringData("Login", 1, 1));
		
		logger.pass("Login Successfully in to the application.");
	}
	
	@Test(priority=2)
	public void logout()
	{
		HomePage objHome=PageFactory.initElements(driver, HomePage.class);
		
		logger=reports.createTest("Logout From CDS");
		
		objHome.LogoutFromApp();
		
		logger.pass("Logout Successfully.");
		
		logger.pass("Logout Successfully from the Application");
	}
}
