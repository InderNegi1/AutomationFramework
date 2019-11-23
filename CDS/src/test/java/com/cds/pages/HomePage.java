package com.cds.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {
	
	WebDriver driver;
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	@FindBy(id="btnLogOut") WebElement lnkLogout;
	@FindBy(xpath="//*[class='caret']") WebElement panlLogout;
	
	
	public void LogoutFromApp()
	{
		panlLogout.click();
		
		lnkLogout.click();
	}
	
	//lblDisplayName

}
