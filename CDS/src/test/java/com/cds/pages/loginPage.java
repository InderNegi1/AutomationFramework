package com.cds.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class loginPage {
	WebDriver driver;
	
	public loginPage(WebDriver lDriver)
	{
		this.driver=lDriver;
	}
	
	@FindBy(name="txtUserName") 
	WebElement txtUsrName;
	
	@FindBy(name="txtPass") 
	WebElement txtPassword;
	
	@FindBy(id="btnLogin") 
	WebElement btnLogin;
	
	//@FindBy(xpath="//input[@value='login']") 
	//WebElement btnLogin;

	public void loginToApp(String usrName,String usrPassword) {
		
		txtUsrName.sendKeys(usrName);
		txtPassword.sendKeys(usrPassword);
		btnLogin.click();
	}
	
}
