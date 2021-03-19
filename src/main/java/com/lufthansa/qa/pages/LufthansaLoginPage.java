package com.lufthansa.qa.pages;

import java.io.IOException;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.lufthansa.qa.base.TestBase;
import com.lufthansa.qa.util.TestUtil;

public class LufthansaLoginPage extends TestBase {

	



	
	@FindBy(xpath="//button[@class='btn-link btn-login mb-0 d-flex align-items-center']")
	WebElement loginButton;

	@FindBy(xpath="//img[@class='header-logo']")
	WebElement headerLogo;
	
	@FindBy(xpath="//input[@placeholder='E-Mail address']")
	WebElement emailAddress;
	
	
	@FindBy(xpath="//input[@placeholder='Password']")
	WebElement password;
	
	@FindBy(xpath="//button[@class='btn btn-primary mb-5' ]//span[text()='Login']")
	WebElement login;
	
	
	

	@FindBy(xpath="//div[text()='You are not authorized to access this resource.']")
	WebElement loginErrorMessage;
	
	
	
	public LufthansaLoginPage() throws IOException {
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}
	

	public String validateLufthansaLoginPageTitle()
	{
		return driver.getTitle();
	}
	
	public boolean validateLufthansaLogo()
	{
		return headerLogo.isDisplayed();
	}
	
	
	
	
	
	public String login() throws IOException, InterruptedException
	{
		
		TestUtil.explicitWaitUntilElementClickable(loginButton);
		Map<String, String> map = TestUtil.getLufthansaTestData();
		
		loginButton.click();
		emailAddress.sendKeys(map.get("User_ID"));
		password.sendKeys(map.get("Password"));
		login.click();
	
		String message="no error";
		
		if (loginErrorMessage.isDisplayed())
		{
			message=loginErrorMessage.getText();
		}
		return message;
			
		
	}
	


}
